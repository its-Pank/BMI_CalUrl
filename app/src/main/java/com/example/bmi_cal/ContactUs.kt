package com.example.bmi_cal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.bmi_cal.databinding.ActivityContactUsBinding
import com.example.bmi_cal.databinding.ActivityMainBinding

class ContactUs : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityContactUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityContactUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dile.setOnClickListener(this)
        binding.call.setOnClickListener(this)
        binding.mail.setOnClickListener(this)

    }

    override fun onClick(click: View?) {

        when(click!!.id){
            R.id.dile ->{

                permi

            }
            R.id.call ->{

            }
            R.id.mail ->{

            }
        }

    }
}

