package com.geo.album.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.geo.album.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by George Thomas on 29/9/21
 */
@AndroidEntryPoint
class SplashActivity:AppCompatActivity() {

    private lateinit var mBinder: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinder = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(mBinder.root)
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToMain()
        }, DISMISS_DURATION)
    }

    private fun navigateToMain() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    companion object {
        //SPLASH DURATION
        const val DISMISS_DURATION: Long = 3000
    }
}