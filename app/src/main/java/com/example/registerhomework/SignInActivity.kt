package com.example.registerhomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registerhomework.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews(){
        signIn()
        binding.textRegister.setOnClickListener {
            signUp()
        }
        binding.textForgot.setOnClickListener {
            forgot()
        }
    }

    private fun signIn(){
        binding.btnSignIn.setOnClickListener {
            if (binding.username1.text.isNotEmpty() && binding.password1.text.isNotEmpty()){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("name", binding.username1.text.toString().trim())
                intent.putExtra("password", binding.password1.text.toString().trim())
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Please enter your datas!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signUp(){
        startActivity(Intent(this, SignUpActivity::class.java))
        finish()
    }

    private fun forgot(){
        val intent = Intent(this, PasswordActivity::class.java)
        startActivity(intent)
        finish()
    }
}