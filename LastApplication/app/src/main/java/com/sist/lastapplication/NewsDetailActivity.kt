package com.sist.lastapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val link=intent.getStringExtra("link")
        news_webview.apply {
            settings.javaScriptEnabled=true // 자바스크립트가 사용될 수 있게
            webViewClient= WebViewClient()
        }

        news_webview.loadUrl(link)

    }
}