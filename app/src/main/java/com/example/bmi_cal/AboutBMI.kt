package com.example.bmi_cal

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmi_cal.databinding.ActivityAboutBmiBinding

class AboutBMI : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBmiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityAboutBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.web.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmicalc.htm"))
            startActivity(intent)

        }
    }
}