# Popdeem Cordova Plugin
The Popdeem Cordova plugin allows you to use the Popdeem native iOS and Android SDKs inside your Cordova cross-platform application. Currently iOS and Android are supported

# Usage
## Add the plugin to your project
`cordova plugin add popdeem-cordova-plugin`

## Build the projects
`cordova build ios` \
`cordova build android`

This will result in the PopdeemSDK pod being pulled into your iOS project, and the PopdeemSDK maven library being pulled into your Android project.

## Configuration

### iOS
#### Adding item to info.plist
Configuration items must be added to the `info.plist`  file of the iOS project. To do this, you can use the hook file from this gist: [update_platform_config](https://gist.github.com/NQuinn27/4df500ca185b5a9a76b61b73d1e72a6c) and add items in the `config.xml` file of your project.

#### Add the hook
Add the file `update_platform_config.js` to `hooks/after_prepare` directory (create if needed).
Add the following line to `config.xml`:
`<hook src="hooks/after_prepare/update_platform_config.js" type="after_prepare" />`

Add the following inside the `<platform name=“ios”>` tags:
```
<config-file parent="PopdeemApiKey" target="*-Info.plist">
<string>POPDEEM_API_KEY</string>
</config-file>
<config-file parent="PopdeemThemeFileName" target="*-Info.plist">
<string>theme</string>
</config-file>
<config-file parent="FacebookAppID" target="*-Info.plist">
<string>FACEBOOK_APP_ID</string>
</config-file>
<config-file parent="FacebookDisplayName" target="*-Info.plist">
<string>Popdeem</string>
</config-file>
<config-file parent="FacebookNamespace" target="*-Info.plist">
<string>popdeemrewards</string>
</config-file>
<config-file parent="FacebookUrlSchemeSuffix" target="*-Info.plist">
<string>ribsburgers</string>
</config-file>
<config-file parent="TwitterAppConsumerKey" target="*-Info.plist">
<string>TWITTER_CONSUMER_KEY</string>
</config-file>
<config-file parent="TwitterAppConsumerSecret" target="*-Info.plist">
<string>TWITTER_CONSUMER_SECRET</string>
</config-file>
<config-file parent="TwitterCallbackScheme" target="*-Info.plist">
<string>TWITTER_CALLBACK</string>
</config-file>
<config-file parent="InstagramClientId" target="*-Info.plist">
<string>INSTAGRAM_CLIENT_ID</string>
</config-file>
<config-file parent="InstagramClientSecret" target="*-Info.plist">
<string>INSTAGRAM_CLIENT_SECRET</string>
</config-file>
<config-file parent="InstagramCallback" target="*-Info.plist">
<string>https://www.popdeem.com/igredirect</string>
</config-file>
<config-file parent="CFBundleURLTypes" target="*-Info.plist">
<array>
<dict>
<key>CFBundleURLSchemes</key>
<array>
<string>FACEBOOK_APP_ID</string>

<string>TWITTER_CALLBACK</string>
</array>
</dict>
</array>
</config-file>
<config-file parent="NSLocationWhenInUseUsageDescription" target="*-
Info.plist">
<string>We use your location to deliver local rewards.</string>
</config-file>
<config-file parent="NSCameraUsageDescription" target="*-Info.plist">
<string>We need access to your camera when you decide to share a
photo.</string>
</config-file>
<config-file parent="NSPhotoLibraryUsageDescription" target="*-
Info.plist">
<string>We access your photo gallery when you decide to share a
photo.</string>
</config-file>
<config-file parent="LSApplicationQueriesSchemes" target="*-
Info.plist">
<array>
<string>instagram</string>
<string>fbapi</string>
<string>fbapi20130214</string>
<string>fbapi20130410</string>
<string>fbapi20130702</string>
<string>fbapi20131010</string>
<string>fbapi20131219</string>
<string>fbapi20140410</string>
<string>fbapi20140116</string>
<string>fbapi20150313</string>
<string>fbapi20150629</string>
<string>fbauth</string>
<string>fbauth2</string>
<string>fb-messenger-api20140430</string>
</array>
</config-file>
```

### Add image and json Assets
Add the images and `theme.json` in your project, for example in a folder named `Popdeem` . Add the following entries to `config.xml` inside the `<platform name=“ios”>` tags.

```
<resource-file src="Popdeem/theme.json" target="Resources/theme.json" />
<resource-file src="Popdeem/Ribs&Burgers_Header.png" target="Resources/
FarmBoy_Header.png" />
<resource-file src="Popdeem/Ribs&Burgers_Header@2x.png" target="Resources/
FarmBoy_Header@2x.png" />
<resource-file src="Popdeem/Ribs&Burgers_Header@3x.png" target="Resources/
FarmBoy_Header@3x.png" />
```

## Android
Inside the `hooks/android` folder, add the hook in this gist named `beforePluginInstall.js`: [beforePluginInstall.js](https://gist.github.com/NQuinn27/4ae6d9fad4147cd5796f9fb8bab97c33)

In `config.xml`, add the following inside the `<platform name=“android”>` tags:
```
<hook src="hooks/android/beforePluginInstall.js" type="after_prepare" />
<allow-intent href="market:*" />
<config-file parent="/*" target="AndroidManifest.xml">
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
</config-file>
<config-file parent="./application" target="AndroidManifest.xml">
<meta-data android:name="com.popdeem.sdk.ApiKey" android:value="POPDEEM_API_KEY" />
<meta-data android:name="com.facebook.sdk.ApplicationId" android:value="@string/facebook_application_id" />
<meta-data android:name="TwitterConsumerKey" android:value="TWIITER_CONSUMER_KEY" />
<meta-data android:name="TwitterConsumerSecret" android:value="TWITTER_CONSUMER_SECRET" />
<meta-data android:name="InstagramClientId" android:value="INSRAGRAM_CLIENT_D" />
<meta-data android:name="InstagramClientSecret" android:value="INSTAGRAM_CLIENT_SECRET" />
<meta-data android:name="InstagramCallbackUrl" android:value="https://www.popdeem.com/igredirect" />
</config-file>
<config-file parent="./application" target="AndroidManifest.xml">
<activity android:configChanges="keyboard|keyboardHidden|screenLayout|screenSize|orientation" android:label="@string/app_name" android:name="com.facebook.FacebookActivity" android:theme="@android:style/Theme.Translucent.NoTitleBar" />
</config-file>
<config-file parent="/*" target="res/values/strings.xml">
<string name="facebook_application_id">FACEBOOK_APP_ID</string>
<string name="pd_wallet_title">History</string>
<string name="pd_home_banner_text">Share your experience on social networks to earn more rewards.</string>
</config-file>
<resource-file src="Popdeem/colors.xml" target="res/values/colors.xml" />
<resource-file src="Popdeem/drawable/hdpi/pd_home_banner.png" target="res/drawable-port-hdpi/pd_home_banner.png" />
<resource-file src="Popdeem/drawable/mdpi/pd_home_banner.png" target="res/drawable-port-mdpi/pd_home_banner.png" />
<resource-file src="Popdeem/drawable/xhdpi/pd_home_banner.png" target="res/drawable-port-xhdpi/pd_home_banner.png" />
<resource-file src="Popdeem/drawable/xxhdpi/pd_home_banner.png" target="res/drawable-port-xxhdpi/pd_home_banner.png" />
<resource-file src="Popdeem/drawable/xxxhdpi/pd_home_banner.png" target="res/drawable-port-xxxhdpi/pd_home_banner.png" />
```


## Social Login
To launch the social login popover from javascript, use the following:
`popdeem.enableSocialLogin(3, function() {}, function() {});`
The first parameter is the _numberOfPrompts_ argument. The popover is dismissible by the user - this argument denotes the maximum number of times a user can see this popover.


## Popdeem Home
To show the Popdeem Home flow from javascript, use the following:
`popdeem.pushPopdeemHome(function() {}, function() {});`. Popdeem Home encapsulates all of Popdeem’s functionality.


## Deliver Third Party Token
We may need you to deliver a user token. If so, you can do this by using this method:
`popdeem.deliverThirdPartyToken(“ThirdPartyToken", function() {}, function() {});`.

