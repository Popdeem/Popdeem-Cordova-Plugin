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
      if ("enableSocialLogin".equals(action)) {
          this.enableSocialLogin(args.getInt(0), callbackContext);
          callbackContext.success();
          return true;
      }
      return false;  // Returning false results in a "MethodNotFound" error.
  }

  private void enableSocialLogin(int numberOfPrompts, CallbackContext callbackContext) {
      String message = "Popdeem WORKS";
    if (message != null && message.length() > 0) {
      CharSequence text = "Hello toast!";
      int duration = Toast.LENGTH_SHORT;
        Context context=this.cordova.getActivity().getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
      toast.show();
    } else {
        callbackContext.error("Expected one non-empty string argument.");
    }
  }

}
