package com.example.proiectandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.proiectandroid.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var textViewSignIn: TextView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        textViewSignIn = findViewById(R.id.textViewSignIn)

        firebaseAuth = FirebaseAuth.getInstance()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewSignIn.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.buttonLogin.setOnClickListener{
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()


            if(email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        val intent = Intent(this, RecipeActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }}

//        override fun onStart(){
//            super.onStart()
//            if(firebaseAuth.currentUser != null){
//                val intent = Intent(this, RecipeActivity::class.java)
//                startActivity(intent)
//            }
//        }
}

//


