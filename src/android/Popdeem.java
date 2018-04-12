package com.popdeem.cordova.plugin;
import com.popdeem.sdk.core.PopdeemSDK;

import android.content.Context;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

public class Popdeem extends CordovaPlugin {

  private static final int LOGIN_VIEW_ID = 10101010;

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

       if ("enableSocialLogin".equals(action)) {
           this.enableSocialLogin(args.getInt(0), callbackContext);
           callbackContext.success();
           return true;
       }
       if ("pushPopdeemHome".equals(action)){
          this.pushPopdeemHome(callbackContext);
          callbackContext.success();
           return true;
        }
      if ("deliverThirdPartyToken".equals(action)){
          this.deliverThirdPartyToken(args.getString(0), callbackContext);
          callbackContext.success();
           return true;
        }
      return false;  // Returning false results in a "MethodNotFound" error.
  }

  private void enableSocialLogin(int numberOfPrompts, CallbackContext callbackContext) {
      PopdeemSDK.enableSocialMultiLogin(this.cordova.getActivity().getClass(), numberOfPrompts);
  }

  private void pushPopdeemHome(CallbackContext callbackContext) {
      PopdeemSDK.showHomeFlow(this.cordova.getActivity());
  }

  private void deliverThirdPartyToken(String userToken, CallbackContext callbackContext) {
      PopdeemSDK.setThirdPartyToken(userToken);
  }

}
