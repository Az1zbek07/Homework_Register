package com.example.registerhomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registerhomework.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews(){
        signUp()
        binding.textSignIn.setOnClickListener {
            signIn()
        }
    }

    private fun signUp(){
        binding.btnSignUp.setOnClickListener {
            if (binding.username2.text.isNotEmpty() && binding.gmail.text.isNotEmpty() && binding.password2.text.isNotEmpty() && binding.passwordAgain.text.isNotEmpty()
                && binding.password2.text.toString() == binding.passwordAgain.text.toString()){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("name", binding.username2.text.toString().trim())
                intent.putExtra("password", binding.password2.text.toString().trim())
                startActivity(intent)
                finish()
            } else{
                Toast.makeText(this, "Please enter your datas!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signIn(){
        startActivity(Intent(this, SignInActivity::class.java))
        finish()
    }
}