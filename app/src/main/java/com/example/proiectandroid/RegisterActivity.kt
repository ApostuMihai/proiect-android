package com.example.proiectandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proiectandroid.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
        private lateinit var firebaseAuth: FirebaseAuth
        private lateinit var binding:ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.textViewSignUp.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.buttonRegister.setOnClickListener{
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()


            if(email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }

}