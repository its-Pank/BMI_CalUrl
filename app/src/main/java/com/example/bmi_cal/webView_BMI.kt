package com.example.bmi_cal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.view.isGone
import com.example.bmi_cal.databinding.ActivityWebViewBmiBinding

class webView_BMI : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBmiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebViewBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webView.webViewClient = MyView()

        binding.webView.loadUrl("https://www.calculator.net/bmi-calculator.html")

    }
   inner class MyView : WebViewClient()
    {
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            binding.progressBar.visibility= View.GONE
        }
    }
}