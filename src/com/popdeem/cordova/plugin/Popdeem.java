package com.popdeem.cordova.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

public class Popdeem extends CordovaPlugin {

  private void enableSocialLogin(String message, CallbackContext callbackContext) {
    if (message != null && message.length() > 0) {
        //TODO Push Popdeem Social Login
    } else {
        callbackContext.error("Expected one non-empty string argument.");
    }
}

}
