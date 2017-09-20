#import "Popdeem.h"

@implementation Popdeem

- (void) enableSocialLogin:(CDVInvokedUrlCommand*)command {

  CDVPluginResult* result = [CDVPluginResult
                            resultWithStatus:CDVCommandStatus_OK
                            messageAsString:@"Presented Social Login"];

  [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
}

@end
