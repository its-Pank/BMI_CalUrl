package com.example.bmi_cal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.bmi_cal.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnId.setOnClickListener {

            if (binding.weightId.editText!!.text.toString().isEmpty() && binding.heightId.editText!!.text.toString().isEmpty())
            {
                Toast.makeText(this, "Enter Height and Weight", Toast.LENGTH_SHORT).show()
            }else {
                if (binding.weightId.editText!!.text.toString().isNotEmpty()) {
                    val weight = binding.weightId.editText!!.text.toString().toFloat()

                    if (binding.heightId.editText!!.text.toString().isNotEmpty()) {
                        val height = binding.heightId.editText!!.text.toString().toFloat()

                        val bmi = weight / (height / 100).pow(2)

                        val intent = Intent(this, ResultBMI::class.java)
                        intent.putExtra("bmi", bmi)
                        intent.putExtra("weight", weight)
                        intent.putExtra("height", height)
                        startActivity(intent)

                    } else {
                        Toast.makeText(this, "Please enter height", Toast.LENGTH_SHORT).show()
                        binding.heightId.requestFocus()
                    }
                } else {
                    Toast.makeText(this, "Please enter weight ", Toast.LENGTH_SHORT).show()
                    binding.weightId.requestFocus()
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
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
            R.id.item_3 ->
            {
                var intent = Intent(this, AboutDeveloper::class.java)
                startActivity(intent)

            }
            R.id.item_4-> {
                var intent = Intent(this, ContactUs::class.java)
                startActivity(intent)
            }

            R.id.item_5-> {
                finish()
                exitProcess(0)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.app_name)
        builder.setMessage("Do You want to Exit")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        builder.setPositiveButton("Yes")
        { dialogInterface, which ->
            finish()
        }
        builder.setNegativeButton("No"){dialogInterface, which ->
            Toast.makeText(applicationContext,"clicked No",Toast.LENGTH_SHORT).show()
        }
        builder.setNeutralButton("Cancel"){dialogInterface , which ->
            Toast.makeText(applicationContext,"operation cancel",Toast.LENGTH_SHORT).show()
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()

    }
}