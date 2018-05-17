module.exports = {

  enableSocialLogin: function (numberOfPrompts, successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "Popdeem", "enableSocialLogin", [numberOfPrompts]);
  },
  pushPopdeemHome: function (successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "Popdeem", "pushPopdeemHome", []);
  }
  ,
  deliverThirdPartyToken: function (userToken, successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "Popdeem", "deliverThirdPartyToken", [userToken]);
  },
  logMoment: function (momentString, successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "Popdeem", "logMoment", [momentString]);
  }

};
