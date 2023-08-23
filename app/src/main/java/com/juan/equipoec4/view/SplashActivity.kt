package com.juan.equipoec4.view

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.juan.equipoec4.R
import com.juan.equipoec4.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
            setContentView(binding.root)

        sharedPreferences = getSharedPreferences(LoginActivity.SESSION_PREFERENCE, MODE_PRIVATE)
            Handler().postDelayed({
                val email: String = sharedPreferences.getString(LoginActivity.EMAIL,"")?:""

               val intent =  if (email.isNotEmpty()){
                    Intent(this,MainActivity::class.java)
                }else{
                      Intent(this,LoginActivity::class.java)
                }

                startActivity(intent)
                finish()
            }, 2000)

        }
}