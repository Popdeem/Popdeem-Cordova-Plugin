package com.popdeem.cordova.plugin;
import com.popdeem.sdk.core.PopdeemSDK;

import android.content.Context;

import android.app.Activity;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import android.util.Log;
import com.popdeem.sdk.core.utils.PDLog;
import com.popdeem.sdk.core.api.PDAPICallback;
import com.popdeem.sdk.core.api.PDAPIClient;
import com.popdeem.sdk.core.api.response.PDBasicResponse;

public class Popdeem extends CordovaPlugin {

  private static final int LOGIN_VIEW_ID = 10101010;

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

       if ("enableSocialLogin".equals(action)) {
           Activity context =this.cordova.getActivity(); 
           Log.i("enableSocialLogin", "enableSocialMultiLogin: ");
           this.enableSocialLogin(args.getInt(0), callbackContext);
           callbackContext.success();
           return true;
       }

       if ("pushSocialLogin".equals(action)) {
           Activity context =this.cordova.getActivity(); 
           Log.i("enableSocialLogin", "enableSocialMultiLogin: ");
           this.enableSocialLogin(args.getInt(0), callbackContext);
           callbackContext.success();
           return true;
       }
       if ("pushPopdeemHome".equals(action)){
          Log.i("pushPopdeemHome", "pushPopdeemHome: ");
          this.pushPopdeemHome(callbackContext);
          callbackContext.success();
           return true;
        }
      if ("deliverThirdPartyToken".equals(action)){
          this.deliverThirdPartyToken(args.getString(0), callbackContext);
          callbackContext.success();
           return true;
        }
        if ("logMoment".equals(action)){
          this.logMoment(args.getString(0), callbackContext);
          callbackContext.success();
           return true;
        }
      return false;  // Returning false results in a "MethodNotFound" error.
  }

  private void enableSocialLogin(int numberOfPrompts, CallbackContext callbackContext) {
      PopdeemSDK.enableSocialMultiLogin(this.cordova.getActivity().getClass(), numberOfPrompts);
      PopdeemSDK.pushCordovaLogin(this.cordova.getActivity(), numberOfPrompts);
  }

  private void pushSocialLogin(int numberOfPrompts, CallbackContext callbackContext) {
      PopdeemSDK.enableSocialMultiLogin(this.cordova.getActivity().getClass(), numberOfPrompts);
  }

  private void pushPopdeemHome(CallbackContext callbackContext) {
      PopdeemSDK.showHomeFlow(this.cordova.getActivity());
  }

  private void deliverThirdPartyToken(String userToken, CallbackContext callbackContext) {
      PopdeemSDK.setThirdPartyToken(userToken);
  }

  private void logMoment(String momentString, CallbackContext callbackContext) {
      PopdeemSDK.logMoment(momentString, new PDAPICallback<PDBasicResponse>() {
            @Override
            public void success(PDBasicResponse response) {
                PDLog.d(PDAPIClient.class, response.toString());
            }

            @Override
            public void failure(int statusCode, Exception e) {
                PDLog.w(PDAPIClient.class, "code=" + statusCode + ", message=" + e.getMessage());
            }
        });
  }

}
