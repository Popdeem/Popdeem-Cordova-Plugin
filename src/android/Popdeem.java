package com.popdeem.cordova.plugin;

import android.content.Context;
import android.widget.Toast;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

public class Popdeem extends CordovaPlugin {


  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    this.showComingSoon(callbackContext);
      // if ("enableSocialLogin".equals(action)) {
      //     this.enableSocialLogin(args.getInt(0), callbackContext);
      //     callbackContext.success();
      //     return true;
      // }
      return false;  // Returning false results in a "MethodNotFound" error.
  }

  private void showComingSoon(CallbackContext callbackContext) {
    String message = "Android Coming Soon";
    int duration = Toast.LENGTH_SHORT;
    Context context=this.cordova.getActivity().getApplicationContext();
    Toast toast = Toast.makeText(context, text, duration);
    toast.show();
  }

  private void enableSocialLogin(int numberOfPrompts, CallbackContext callbackContext) {
  }

  private void pushPopdeemHome(CallbackContext callbackContext) {
  }

}
