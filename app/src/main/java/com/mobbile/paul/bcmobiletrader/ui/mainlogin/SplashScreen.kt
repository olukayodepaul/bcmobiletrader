package com.mobbile.paul.bcmobiletrader.ui.mainlogin

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.mobbile.paul.bcmobiletrader.R
import kotlinx.android.synthetic.main.activity_splash_screen.*
import android.os.Handler
import android.util.Pair as UtilPair

class SplashScreen : AppCompatActivity() {

    lateinit var animation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        animation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        logo_aplash.startAnimation(animation)

        //Pairing animation in Kotlin
        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            val options = ActivityOptions.makeSceneTransitionAnimation(
                this,
                UtilPair.create(logo_aplash, "logo_image")
            )
            startActivity(intent, options.toBundle())
            finish()
        }, 2000)

    }
}