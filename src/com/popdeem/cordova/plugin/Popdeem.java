package com.popdeem.cordova.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

public class Popdeem extends CordovaPlugin {


  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
      if ("enableSocialLogin".equals(action)) {
          this.enableSocialLogin(args.getInteger(0));
          callbackContext.success();
          return true;
      }
      return false;  // Returning false results in a "MethodNotFound" error.
  }

  private void enableSocialLogin(int numberOfPrompts, CallbackContext callbackContext) {
    if (message != null && message.length() > 0) {
      CharSequence text = "Hello toast!";
      int duration = Toast.LENGTH_SHORT;

      Toast toast = Toast.makeText(callbackContext, text, duration);
      toast.show();
    } else {
        callbackContext.error("Expected one non-empty string argument.");
    }
}

}
