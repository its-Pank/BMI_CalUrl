package com.example.bmi_cal

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.bmi_cal.databinding.ActivityCustomeDialogBinding
import com.example.bmi_cal.databinding.ActivityMainBinding
import com.example.bmi_cal.databinding.RatingusBinding
import kotlin.math.pow
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        binding.btnId.setOnClickListener {


            if (binding.weightId.editText!!.text.toString().isEmpty() && binding.heightId.editText!!.text.toString().isEmpty())
            {
                Toast.makeText(this, "Enter Height and Weight", Toast.LENGTH_SHORT).show()
            }else {
                if (binding.weightId.editText!!.text.toString().isNotEmpty()) {
                    var weight = binding.weightId.editText!!.text.toString().toFloat()

                    if (binding.heightId.editText!!.text.toString().isNotEmpty()) {
                        var height = binding.heightId.editText!!.text.toString().toFloat()

                        val bmi = weight / (height / 100).pow(2)

                        var str : String? =null

                        if (bmi <= 18.5) {
                           str="You are under weight"
                        }
                        if (bmi in 18.5..24.9) {
                            str="You are Normal"
                        }
                        if (bmi in 25.0..29.9) {
                            str="You are Overweight "
                        }
                        if (bmi >= 30) {
                            str="You are Obesity "
                        }

                        val customBinding = ActivityCustomeDialogBinding.inflate(layoutInflater)
                        val dialog = Dialog(this)
                        dialog.setContentView(customBinding.root)

                        customBinding.weight.setText("Your Weight : " +weight)
                        customBinding.height.setText("Your Height : $height")
                        customBinding.bmi.setText("Your BMI : "+String.format("%.2f", bmi))
                        customBinding.category.setText(str)
                        dialog.setCancelable(false)
                        val windowManager = WindowManager.LayoutParams()
                        windowManager.width = WindowManager.LayoutParams.MATCH_PARENT
                        windowManager.height = WindowManager.LayoutParams.WRAP_CONTENT
                        dialog.window?.attributes = windowManager
                        dialog.show()

                        customBinding.cancel.setOnClickListener{
                            dialog.dismiss()
                            binding.weightId.editText!!.text.clear()
                            binding.heightId.editText!!.text.clear()
                            binding.weightId.requestFocus()
                        }

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
                var intent = Intent(this, webView_BMI::class.java)
                startActivity(intent)
            }

            R.id.item_6-> {

                val rating = RatingusBinding.inflate(layoutInflater)
                val dialog = Dialog(this)
                dialog.setContentView(rating.root)
                dialog.setCancelable(false)
                val windowManager = WindowManager.LayoutParams()
                windowManager.width = WindowManager.LayoutParams.MATCH_PARENT
                windowManager.height = WindowManager.LayoutParams.WRAP_CONTENT
                dialog.window?.attributes = windowManager
                dialog.show()



                rating.button.setOnClickListener {

                    dialog.dismiss()
                }

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

//https://stackoverflow.com/questions/38618885/error-rpc-failed-curl-transfer-closed-with-outstanding-read-data-remaining
