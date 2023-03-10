package com.example.bmi_cal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.bmi_cal.databinding.ActivityResultBmiBinding
import kotlin.system.exitProcess

class ResultBMI : AppCompatActivity() {

    private lateinit var binding:ActivityResultBmiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bmi = intent.getFloatExtra("bmi", 0F)
        val height = intent.getFloatExtra("height", 0F)
        val weight = intent.getFloatExtra("weight", 0F)

        binding.resultBmi.setText("Your BMI : "+String.format("%.2f", bmi))
        binding.resultWeight.setText("Your Weight : " +weight)
        binding.resultHeight.setText("Your Height : " +height)

        if (bmi <= 18.5) {
            binding.aboutBmi.setText("You are under weight")
        }
        if (bmi in 18.5..24.9) {
            binding.aboutBmi.setText("You are Normal")
        }
        if (bmi in 25.0..29.9) {
            binding.aboutBmi.setText("You are Overweight ")
        }
        if (bmi >= 30) {
            binding.aboutBmi.setText("You are Obesity ")
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item:MenuItem): Boolean {
        when (item.itemId){
            R.id.item_1 ->
            {
                var intent = Intent(this,AboutBMI::class.java)
                startActivity(intent)
            }
            R.id.item_2 ->
            {
                var intent = Intent(this, BMIChart::class.java)
                startActivity(intent)

            }

            R.id.item_3-> {
                var intent = Intent(this, AboutDeveloper::class.java)
                startActivity(intent)
            }

            R.id.item_4-> {
                finish()
                exitProcess(0)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}