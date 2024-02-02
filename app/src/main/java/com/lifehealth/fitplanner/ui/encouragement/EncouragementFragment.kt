package com.lifehealth.fitplanner.ui.encouragement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.lifehealth.fitplanner.databinding.FragmentEncouragementBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class EncouragementFragment : Fragment() {

    private val binding by lazy { FragmentEncouragementBinding.inflate(layoutInflater) }
    private val ytPlayer by lazy { binding.wvMotivationVideo }
    private val width by lazy { binding.wvMotivationVideo.width }
    private val height by lazy { (width / 1.4).toInt() }
    private val listOfVideo by lazy {
        listOf(
            "PzlV2jYSLd4",
            "uQN-YOTvXVk",
            "fmZFSpBoGIQ",
            "yIV3rmvui7c",
            "K2kE5QcsPRA",
            "YOXc-TlX0lE",
            "xNPNj5JU_Pc"
        )
    }
    private var counter = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            delay(1000)
            setupPlayer(getHTMLData("PzlV2jYSLd4"))
        }
        setupBtnClickListeners()
        observeLoadingVideo()
    }

    private fun observeLoadingVideo(){

        ErrorLoadingVideo.errorLoadingVideoLD.observe(viewLifecycleOwner){
            if (it){
                binding.tvErrorLoadingVideo.visibility = View.VISIBLE
                binding.wvMotivationVideo.visibility = View.GONE
            }else{
                binding.tvErrorLoadingVideo.visibility = View.GONE
                binding.wvMotivationVideo.visibility = View.VISIBLE
            }
        }

    }

    private fun setupPlayer(htmlData: String) {
        ErrorLoadingVideo.errorLoadingVideoLD.value = false
        with(ytPlayer) {
            settings.javaScriptEnabled = true
            settings.loadWithOverviewMode = true
            settings.useWideViewPort = true
            webViewClient = YTWebClient()
            loadDataWithBaseURL(
                "https://www.youtube.com",
                htmlData,
                "text/html",
                "UTF-8",
                null
            )
        }
    }

    private fun setupBtnClickListeners() {
        binding.btnPlayVideo.setOnClickListener {
            ytPlayer.loadUrl("javascript:playVideo();")
        }
        binding.btnPauseVideo.setOnClickListener {
            ytPlayer.loadUrl("javascript:pauseVideo();")
        }
        binding.btnNextVideo.setOnClickListener {
            ytPlayer.loadDataWithBaseURL(
                "https://www.youtube.com",
                getHTMLData(listOfVideo[counter]),
                "text/html",
                "UTF-8",
                null
            )
            increaseCounter()
        }
    }

    private fun increaseCounter(){
        if (counter<listOfVideo.size) counter++
        else counter = 0
    }

    private fun getHTMLData(videoId: String): String {


        return """
        <html>
        
            <body style="margin:0px;padding:0px;">
               <div id="player"></div>
                <script>
                    var player;
                    function onYouTubeIframeAPIReady() {
                        player = new YT.Player('player', {
                            height: '${height}',
                            width: '$width',
                            videoId: '$videoId',
                            playerVars: {
                                'playsinline': 1
                            },
                            events: {
                                'onReady': onPlayerReady
                            }
                        });
                    }
                    function onPlayerReady(event) {
                     player.playVideo();
                        // Player is ready
                    }
                    function seekTo(time) {
                        player.seekTo(time, true);
                    }
                      function playVideo() {
                        player.playVideo();
                    }
                    function pauseVideo() {
                        player.pauseVideo();
                    }
                </script>
                <script src="https://www.youtube.com/iframe_api"></script>
            </body>
        </html>
    """.trimIndent()
    }

}