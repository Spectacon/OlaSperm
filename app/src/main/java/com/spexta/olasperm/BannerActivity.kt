package com.spexta.olasperm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class BannerActivity : AppCompatActivity() {

    lateinit var mAdView : AdView
    lateinit var mAdView1 : AdView
    lateinit var mAdView2 : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.banner)

        MobileAds.initialize(this) {}
// programmatically create your own code
        val adView1 = AdView(this)

        adView1.adSize = AdSize.LARGE_BANNER

        adView1.adUnitId = "ca-app-pub-3940256099942544/6300978111"
// TODO: Add adView to your view hierarchy.
        mAdView = findViewById(R.id.adView)
        mAdView1 = findViewById(R.id.adView1)
        mAdView2 = findViewById(R.id.adView2)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        mAdView1.loadAd(adRequest)




    }
}