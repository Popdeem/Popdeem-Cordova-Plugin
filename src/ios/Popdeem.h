#import <Cordova/CDV.h>

@interface Popdeem : CDVPlugin

- (void) enableSocialLogin:(CDVInvokedUrlCommand*)command;
- (void) pushPopdeemHome:(CDVInvokedUrlCommand*)command;
- (void) deliverThirdPartyToken:(CDVInvokedUrlCommand*)command;
- (void) logMoment:(CDVInvokedUrlCommand*)command;

@end
