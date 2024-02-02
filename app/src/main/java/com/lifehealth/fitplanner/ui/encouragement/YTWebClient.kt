package com.lifehealth.fitplanner.ui.encouragement

import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class YTWebClient:WebViewClient() {

    override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        super.onReceivedError(view, request, error)
        ErrorLoadingVideo.errorLoadingVideoLD.value = true
    }


}