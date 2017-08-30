# NotRunningInBg
<img src="https://raw.githubusercontent.com/LvWind/NotRunningInBg/master/art/logo.png" width="150" height="150"/>

This is a tool that snoozes the "App is Running in the Background" notifications on Android Oreo.

Judging by the relevent AOSP code ([updateForegroundApps()](https://github.com/android/platform_frameworks_base/blob/b056324630b8adfeb38393bcab49f3b9c720f4fd/services/core/java/com/android/server/am/ActiveServices.java#L790) in ActiveServices.java), there is no way for non-system app developers to suppress this notification when their apps are not on top. 

However, a [NotificationListenerService](https://developer.android.com/reference/android/service/notification/NotificationListenerService.html#snoozeNotification) can be used to snooze this notification for an extended period of time.


## What you should know
I haven't find a way to un-snooze the notification yet. Uninstalling this app does not make the snoozing period expire. I'm working on it. If you have any idea please open a new issue.

**In other words, you might never see this notification again.**


## How to use
1. Download and install the APK from [here](https://github.com/LvWind/NotRunningInBg/releases). (Will publish to Google Play soon)
2. Run the app and grant Notification Access permission in system settings.
3. Start the service and manually snooze the "Running in the background" notification once. The app will keep it snoozed afterwards.
![](https://raw.githubusercontent.com/LvWind/NotRunningInBg/master/app/src/main/res/drawable/step1.png)
![](https://raw.githubusercontent.com/LvWind/NotRunningInBg/master/app/src/main/res/drawable/step2.png)
