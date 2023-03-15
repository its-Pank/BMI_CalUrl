package com.example.bmi_cal

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
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

        when(click!!.id) {
            R.id.dile -> {

                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9910733169"))
                startActivity(intent)

            }
            R.id.call -> {

                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
                {
                    val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:7080807811"))
                    startActivity(intent)
                } else {
                    ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.CALL_PHONE),1001)
                }
            }
                R.id.mail ->{

                    val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:pankaj.pal20301@gmail.com"))
                    startActivity(intent)
                }
            }
        }
    override fun onRequestPermissionsResult(requestCode: Int,permissions: Array<out String>,grantResults: IntArray)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1001)
        {
            if (grantResults.isNotEmpty() && permissions[0].equals(PackageManager.PERMISSION_GRANTED))
            {
                if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
                {
                    val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:9910733169"))
                    startActivity(intent)
                } else {
                    ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.CALL_PHONE),1001)
                }
            } else {
                Toast.makeText(this, "Please give the permission", Toast.LENGTH_SHORT).show()
            }
        }
    }


}


