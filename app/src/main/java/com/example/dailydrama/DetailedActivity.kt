package com.example.dailydrama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_detailed.*

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        supportActionBar!!.hide()

        val url=intent.getStringExtra("URL")
        if(url!=null)
        {
            detailedWebview.settings.javaScriptEnabled=true
            detailedWebview.settings.builtInZoomControls=true

// detailedWebview.settings.userAgentString=""
//code to get the mobile website

            detailedWebview.webViewClient=object:WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)

                    progressBar2.visibility=View.GONE
                    detailedWebview.visibility=View.VISIBLE
                }
            }

            detailedWebview.loadUrl(url)


        }
    }


}

