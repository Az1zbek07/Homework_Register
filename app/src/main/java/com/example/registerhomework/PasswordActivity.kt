package com.example.registerhomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.registerhomework.databinding.ActivityPasswordBinding

class PasswordActivity : AppCompatActivity() {
    lateinit var binding: ActivityPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews(){
        send()
        binding.textRegisterForgot.setOnClickListener {
            signUp()
        }
    }

    private fun send(){
        binding.btnSend.setOnClickListener {
            if (binding.gmailForgot.text.length > 6){
                val alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("Password")
                alertDialog.setMessage("Your password is 123456")
                alertDialog.setPositiveButton("Ok", null)
                alertDialog.create().show()
            } else{
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signUp(){
        startActivity(Intent(this, SignUpActivity::class.java))
        finish()
    }
}