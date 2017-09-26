#import <Cordova/CDV.h>

@interface Popdeem : CDVPlugin

- (void) enableSocialLogin:(CDVInvokedUrlCommand*)command;
- (void) pushPopdeemHome:(CDVInvokedUrlCommand*)command;

@end
