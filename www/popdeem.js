module.exports = {

  // pushPopdeemHome: function (successCallback, errorCallback) {
  //   cordova.exec(successCallback, errorCallback, "Popdeem", "pushPopdeemHome", []);
  // };

  enableSocialLogin: function (numberOfPrompts, successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "Popdeem", "enableSocialLogin", [numberOfPrompts]);
  };

};
