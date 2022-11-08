package com.example.dokkatestapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dokkatestapplication.model.Car

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val car1 = Car("BMW", "320i", "white")
        val car2 = Car("VW", "New Beetle", "Black")
    }
}