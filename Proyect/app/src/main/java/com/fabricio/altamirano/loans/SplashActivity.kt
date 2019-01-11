package com.fabricio.altamirano.loans

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.fabricio.altamirano.loans.activities.ListLoansActivity



class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val intent = Intent(this, ListLoansActivity::class.java)
        startActivity(intent)

    }


}
