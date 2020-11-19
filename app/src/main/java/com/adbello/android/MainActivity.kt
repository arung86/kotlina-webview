package com.adbello.android

import android.content.pm.ApplicationInfo
import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private val webView: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (0 != applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) {
                WebView.setWebContentsDebuggingEnabled(true)
            }
        }
        setContentView(R.layout.activity_main)
        title = "Add Manager"
        val webView = findViewById<WebView>(R.id.webView)
        webView.webViewClient = WebViewClient()
        webView.loadUrl("http://spoorthiadsbucket.s3-website.ap-south-1.amazonaws.com/#/")
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

    }

    override fun onBackPressed() {
        // if your webview can go back it will go back
        if (webView!!.canGoBack())
            webView.goBack()
        // if your webview cannot go back
        // it will exit the application
        else
            super.onBackPressed()
    }
}