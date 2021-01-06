 package com.spexta.olasperm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.annotation.NonNull
import com.google.android.gms.ads.*
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdCallback
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

//const val AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712"
//const val REWARD_VIDEO_AD_UNIT_ID = "ca-app-pub-3940256099942544/5224354917"

//Real device show
const val AD_UNIT_ID = "ca-app-pub-9592335534395150/7514153622"
const val REWARD_VIDEO_AD_UNIT_ID = "ca-app-pub-3940256099942544/5224354917"

class SecondActivity : AppCompatActivity() {

    lateinit var mAdView : AdView
    lateinit var mAdView1 : AdView

    private lateinit var mInterstitialAd: InterstitialAd
    private lateinit var rewardedAd: RewardedAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        MobileAds.initialize(this) {}

        val BannerBtn = findViewById<Button>(R.id.banner)

        BannerBtn.setOnClickListener() {
            val intent = Intent(this, BannerActivity::class.java)
            startActivity(intent)
        }

//        Banner admob  codes
            mAdView = findViewById(R.id.adView)
            mAdView1 = findViewById(R.id.adView1)
            val adRequest = AdRequest.Builder().build()
            mAdView.loadAd(adRequest)
            mAdView1.loadAd(adRequest)

//            INTERSTITIALAD CODE BELOW
            MobileAds.initialize(this, AD_UNIT_ID)

            mInterstitialAd = InterstitialAd(this)
            mInterstitialAd.adUnitId = AD_UNIT_ID
            mInterstitialAd.adListener = object : AdListener() {
                override fun onAdClosed() {
                    mInterstitialAd.loadAd(AdRequest.Builder().build())
                }
            }
            mInterstitialAd.loadAd(AdRequest.Builder().build())
//            mInterstitialAd.loadAd(AdRequest.Builder()
//            .addTestDevice("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
//            .build())
//          SHOW THE ADS
            val mMybutton = findViewById<Button>(R.id.interst)
            mMybutton.setOnClickListener {
                if (mInterstitialAd.isLoaded) {
                    mInterstitialAd.show()
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.")
                }
            }
//      REWARD VIDEO ADS INITIALIZATION
        rewardedAd = RewardedAd(this, REWARD_VIDEO_AD_UNIT_ID)
//        LOAD AN ADS
        val adLoadCallback = object: RewardedAdLoadCallback() {
            override fun onRewardedAdLoaded() {
                // Ad successfully loaded.
            }
            override fun onRewardedAdFailedToLoad(adError: LoadAdError) {
                // Ad failed to load.
            }
        }
        rewardedAd.loadAd(AdRequest.Builder().build(), adLoadCallback)
//      SHOW THE ADS
        val myButton = findViewById<Button>(R.id.rvideo)
        myButton.setOnClickListener {
            if (rewardedAd.isLoaded) {
                val activityContext: Activity = this@SecondActivity
                val adCallback = object: RewardedAdCallback() {
                    override fun onRewardedAdOpened() {
                        // Ad opened.
                    }
                    override fun onRewardedAdClosed() {
                        // Ad closed.
                    }
                    override fun onUserEarnedReward(@NonNull reward: RewardItem) {
                        // User earned reward.
                    }
                    override fun onRewardedAdFailedToShow(adError: AdError) {
                        // Ad failed to display.
                    }
                }
                rewardedAd.show(activityContext, adCallback)
            }
            else {
                Log.d("TAG", "The rewarded ad wasn't loaded yet.")
            }
        }
//        To display next reward videos
        fun createAndLoadRewardedAd(): RewardedAd {
            val rewardedAd = RewardedAd(this, REWARD_VIDEO_AD_UNIT_ID)
            val adLoadCallback = object: RewardedAdLoadCallback() {
                override fun onRewardedAdLoaded() {
                    // Ad successfully loaded.
                }
                override fun onRewardedAdFailedToLoad(adError: LoadAdError) {
                    // Ad failed to load.
                }
            }
            rewardedAd.loadAd(AdRequest.Builder().build(), adLoadCallback)
            return rewardedAd
        }
                fun onRewardedAdClosed() {
                    this.rewardedAd = createAndLoadRewardedAd()
                }
    }
}