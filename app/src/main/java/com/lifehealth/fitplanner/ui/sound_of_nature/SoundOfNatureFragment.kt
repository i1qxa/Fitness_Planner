package com.lifehealth.fitplanner.ui.sound_of_nature

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lifehealth.fitplanner.R
import com.lifehealth.fitplanner.databinding.FragmentSoundOfNatureBinding


class SoundOfNatureFragment : Fragment() {

    private val binding by lazy { FragmentSoundOfNatureBinding.inflate(layoutInflater) }

    private var mediaPlayer:MediaPlayer? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBtnClickListeners()
        setupSoundLogo()
        setupSoundNames()
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    private fun setupBtnClickListeners(){
        setupBtnPlayClickListeners()
        setupBtnPauseClickListeners()
    }

    private fun setupBtnPlayClickListeners(){
        with(binding){
            inclBonfire.ivBtnPlay.setOnClickListener {
                playNewSound(R.raw.bonfire)
            }
            inclGrass.ivBtnPlay.setOnClickListener {
                playNewSound(R.raw.gras)
            }
            inclJungle.ivBtnPlay.setOnClickListener {
                playNewSound(R.raw.jungle)
            }
            inclLeaves.ivBtnPlay.setOnClickListener {
                playNewSound(R.raw.leaves)
            }
            inclOcean.ivBtnPlay.setOnClickListener {
                playNewSound(R.raw.ocean)
            }
            inclRiver.ivBtnPlay.setOnClickListener {
                playNewSound(R.raw.river)
            }
            inclWaterFall.ivBtnPlay.setOnClickListener {
                playNewSound(R.raw.waterfall)
            }
            inclWindInForest.ivBtnPlay.setOnClickListener {
                playNewSound(R.raw.wind_in_forest)
            }
        }
    }

    private fun setupBtnPauseClickListeners(){
        with(binding){
            inclBonfire.ivBtnPause.setOnClickListener {
                pausePlaying()
            }
            inclGrass.ivBtnPause.setOnClickListener {
                pausePlaying()
            }
            inclWaterFall.ivBtnPause.setOnClickListener {
                pausePlaying()
            }
            inclRiver.ivBtnPause.setOnClickListener {
                pausePlaying()
            }
            inclOcean.ivBtnPause.setOnClickListener {
                pausePlaying()
            }
            inclWindInForest.ivBtnPause.setOnClickListener {
                pausePlaying()
            }
            inclLeaves.ivBtnPause.setOnClickListener {
                pausePlaying()
            }
            inclJungle.ivBtnPause.setOnClickListener {
                pausePlaying()
            }
        }
    }

    private fun playNewSound(soundId:Int){
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(requireContext(), soundId)
        mediaPlayer?.start()
    }

    private fun pausePlaying(){
        mediaPlayer?.pause()
    }

    private fun setupSoundLogo(){

        with(binding){
            inclBonfire.ivSoundLogo.setImageResource(R.drawable.bonfire)
            inclJungle.ivSoundLogo.setImageResource(R.drawable.jungle)
            inclLeaves.ivSoundLogo.setImageResource(R.drawable.leaves)
            inclGrass.ivSoundLogo.setImageResource(R.drawable.grass)
            inclOcean.ivSoundLogo.setImageResource(R.drawable.ocean)
            inclWindInForest.ivSoundLogo.setImageResource(R.drawable.forest)
            inclRiver.ivSoundLogo.setImageResource(R.drawable.river)
            inclWaterFall.ivSoundLogo.setImageResource(R.drawable.waterfall)
        }

    }

    private fun setupSoundNames(){
        with(binding){
            inclBonfire.tvSoundName.text = "Костёр"
            inclRiver.tvSoundName.text = "Река"
            inclWaterFall.tvSoundName.text = "Водопад"
            inclOcean.tvSoundName.text = "Океан"
            inclGrass.tvSoundName.text = "Трава"
            inclWindInForest.tvSoundName.text = "Лес"
            inclLeaves.tvSoundName.text = "Листья"
            inclJungle.tvSoundName.text = "Джунгли"
        }
    }

}