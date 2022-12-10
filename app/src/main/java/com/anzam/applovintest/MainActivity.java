package com.anzam.applovintest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;

public class MainActivity extends AppCompatActivity implements MaxAdListener {
    private MaxAdView adView;
    private MaxInterstitialAd interstitialAd;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onAdLoaded(MaxAd ad) {

        AppLovinSdk.getInstance( MainActivity.this).setMediationProvider( "max" );
        AppLovinSdk.initializeSdk( MainActivity.this, new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration)
            {
                // AppLovin SDK is initialized, start loading ads
            }
        } );
        adView= findViewById(R.id.adView);
        back= findViewById(R.id.button);
        adView.loadAd();
        interstitialAd = new MaxInterstitialAd( "YOUR_AD_UNIT_ID", this );
        interstitialAd.setListener( this );
        // Load the first ad
        interstitialAd.loadAd();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if ( interstitialAd.isReady() )
                {
                    interstitialAd.showAd();
                }

            }
        });

    }

    @Override
    public void onAdDisplayed(MaxAd ad) {

    }

    @Override
    public void onAdHidden(MaxAd ad) {

    }

    @Override
    public void onAdClicked(MaxAd ad) {

    }

    @Override
    public void onAdLoadFailed(String adUnitId, MaxError error) {

    }

    @Override
    public void onAdDisplayFailed(MaxAd ad, MaxError error) {

    }
}