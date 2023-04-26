package com.example.navigtionmaterial

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_acitivity)

    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_OK)
        finish()
    }
}