# Not "Running in the backgound"

<a href='https://play.google.com/store/apps/details?id=com.lvwind.notrunninginbg&pcampaignid=MKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png' width="150"/></a>

<img src='https://raw.githubusercontent.com/LvWind/NotRunningInBg/master/art/screenshot.png' width="300"/>


This is a tool that snoozes the "App is Running in the Background" notifications on Android Oreo.

Judging by the relevent AOSP code ([updateForegroundApps()](https://github.com/android/platform_frameworks_base/blob/b056324630b8adfeb38393bcab49f3b9c720f4fd/services/core/java/com/android/server/am/ActiveServices.java#L790) in ActiveServices.java), there is no way for non-system app developers to suppress this notification when their apps are not on top. 

However, [NotificationListenerService](https://developer.android.com/reference/android/service/notification/NotificationListenerService.html#snoozeNotification) can be used to snooze this notification for an extended period of time.



## How to use
1. Install from [Google Play](https://play.google.com/store/apps/details?id=com.lvwind.notrunninginbg), or download and install the APK from [here](https://github.com/LvWind/NotRunningInBg/releases).
2. Run the app and grant Notification Access permission in system settings.
3. Start the service and manually snooze the "Running in the background" notification once. The app will keep it snoozed afterwards.
![](https://raw.githubusercontent.com/LvWind/NotRunningInBg/master/app/src/main/res/drawable/step1.png)
![](https://raw.githubusercontent.com/LvWind/NotRunningInBg/master/app/src/main/res/drawable/step2.png)
