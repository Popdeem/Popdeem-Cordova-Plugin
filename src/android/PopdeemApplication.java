package com.popdeem.cordova.plugin;
import android.app.Application;

import com.popdeem.sdk.core.PopdeemSDK;

public class PopdeemApplication extends Application {

	public void onCreate() {
		super.onCreate();
		PopdeemSDK.initializeSDK(this);
	}

}