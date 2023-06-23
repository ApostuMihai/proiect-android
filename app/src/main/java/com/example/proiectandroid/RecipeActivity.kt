package com.example.proiectandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

class RecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
//        val button = findViewById<Button>(R.id.button)



//        button.setOnClickListener{
//            goToLoginActivity()
//        }
    }
    private fun goToLoginActivity(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}