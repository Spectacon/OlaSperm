package com.spexta.olasperm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

const val BANNER_UNIT_ID = "ca-app-pub-3940256099942544/6300978111"

class BannerActivity : AppCompatActivity() {

    lateinit var mAdView : AdView
    lateinit var mAdView1 : AdView
    lateinit var mAdView2 : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.banner)

        MobileAds.initialize(this) {}

// TODO: Add adView to your view hierarchy.
        mAdView = findViewById(R.id.adView)
        mAdView1 = findViewById(R.id.adView1)
        mAdView2 = findViewById(R.id.adView2)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        mAdView1.loadAd(adRequest)
        mAdView2.loadAd(adRequest)

// Creating a programatical code of banner


    }
}