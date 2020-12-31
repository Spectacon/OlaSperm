package com.spexta.olasperm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class SecondActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        MobileAds.initialize(this) {}

        val BannerBtn = findViewById<Button>(R.id.banner)

        BannerBtn.setOnClickListener() {
            val intent = Intent(this, BannerActivity::class.java)
            startActivity(intent)

//        Banner admob  codes
            mAdView = findViewById(R.id.adView)
            val adRequest = AdRequest.Builder().build()
            mAdView.loadAd(adRequest)

        }
    }
}