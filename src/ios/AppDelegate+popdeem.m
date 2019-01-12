//
//  AppDelegate+popdeem.m
//  pushtest
//
//  Created by Niall Quinn on 9/10/17.
//
//

#import "AppDelegate+popdeem.h"
#import "PopdeemSDK.h"
#import "PDUtils.h"
#import <FBSDKCoreKit/FBSDKCoreKit.h>
#import <objc/runtime.h>

@implementation AppDelegate (popdeem)
// its dangerous to override a method from within a category.
// Instead we will use method swizzling. we set this up in the load call.
+ (void) load
{
    Method original, swizzled;

    original = class_getInstanceMethod(self, @selector(application: didFinishLaunchingWithOptions:));
    swizzled = class_getInstanceMethod(self, @selector(swizzled_application: didFinishLaunchingWithOptions:));
    method_exchangeImplementations(original, swizzled);

    original = class_getInstanceMethod(self, @selector(application: openURL: options:));
    swizzled = class_getInstanceMethod(self, @selector(swizzled_application: openURL: options:));
    method_exchangeImplementations(original, swizzled);

    original = class_getInstanceMethod(self, @selector(applicationDidBecomeActive:));
    swizzled = class_getInstanceMethod(self, @selector(swizzled_applicationDidBecomeActive:));
    method_exchangeImplementations(original, swizzled);

}

- (BOOL) swizzled_application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
  // This actually calls the original method over in AppDelegate. Equivilent to calling super
	// on an overrided method, this is not recursive, although it appears that way?
  BOOL result = [self swizzled_application:application didFinishLaunchingWithOptions:launchOptions];

  //Facebook setup
  [[FBSDKApplicationDelegate sharedInstance] application:application
                             didFinishLaunchingWithOptions:launchOptions];

  //Popdeem Setup
  NSError *keyError;
  NSString *popdeemApiKey = [PDUtils getPopdeemApiKey:&keyError];

  if (popdeemApiKey != nil) {
    [PopdeemSDK withAPIKey:popdeemApiKey];
    NSString *popdeemThemeName = [PDUtils getThemeFileName];
    if (popdeemThemeName == nil) {
      NSLog(@"Popdeem Theme not specified in info.plist");
    } else {
      [PopdeemSDK setUpThemeFile:popdeemThemeName];
    }
  }

  return result;
}

- (BOOL) swizzled_application:(UIApplication *)app openURL:(NSURL *)url options:(NSDictionary<NSString *, id> *)options
{
  BOOL result = [self swizzled_application:app openURL:url options:options];
  if (result) return result;

  BOOL handled = [[FBSDKApplicationDelegate sharedInstance] application:app openURL:url options:options
                  ];
  // Add any custom logic here.
  if (handled) {
    return handled;
  }
  
  if ([PopdeemSDK application:app canOpenUrl:url options:options]) {
    return [PopdeemSDK application:app openURL:url options:options];
  }
  
  return NO;
}

- (BOOL)application:(UIApplication*)app openURL:(NSURL*)url sourceApplication:(NSString*)sourceApplication annotation:(id)annotation
{
  [self swizzled_application:app openURL:url sourceApplication:sourceApplication annotation:annotation];

  BOOL handled = [[FBSDKApplicationDelegate sharedInstance] application:app openURL:url sourceApplication:sourceApplication annotation:annotation
                  ];
  // Add any custom logic here.
  if (handled) {
    return handled;
  }
  
  if ([PopdeemSDK application:app canOpenUrl:url sourceApplication:sourceApplication annotation:annotation]) {
    return [PopdeemSDK application:app openURL:url sourceApplication:sourceApplication annotation:annotation];
  }
  
  return NO;
}

- (void) swizzled_applicationDidBecomeActive:(UIApplication *)application {
  [self swizzled_applicationDidBecomeActive: application];
  [FBSDKAppEvents activateApp];
}

@end
