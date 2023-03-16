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

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cdc.gov/healthyweight/assessing/bmi/index.html#:~:text=Body%20Mass%20Index%20(BMI)%20is,or%20health%20of%20an%20individual."))
            startActivity(intent)

        }
    }
}