#import "Popdeem.h"

@implementation Popdeem

- (void) enableSocialLogin:(CDVInvokedUrlCommand*)command {
  NSInteger* numberOfPrompts = [[[command arguments] objectAtIndex:0] integerValue];

  // [PopdeemSDK enableSocialLoginWithNumberOfPrompts:numberOfPrompts];

  CDVPluginResult* result = [CDVPluginResult
                            resultWithStatus:CDVCommandStatus_OK
                            messageAsString:"Presented Social Login"];

  [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
}

@end
