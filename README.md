# NotRunningInBg

This project is a tool to snooze the "App is Running in the Background" notifications on Android Oreo.

Looking at the source code in AOSP, the [updateForegroundApps()](https://github.com/android/platform_frameworks_base/blob/b056324630b8adfeb38393bcab49f3b9c720f4fd/services/core/java/com/android/server/am/ActiveServices.java#L790) in ActiveServices, As long as many apps are not on top and not system apps, App developers can do nothing to remove this notification.

But we can use a [NotificationListenerService](https://developer.android.com/reference/android/service/notification/NotificationListenerService.html#snoozeNotification) to snooze this notification for a long time.

##What you should know
1. It Only works in en_US locale up to now.
2. I haven't find a way to un-snooze the notify yet, uninstall it didn't work. And i'm working on it. If you have any idea please open a new issue.

##How to use
1. Download and Install apk from [here](https://github.com/LvWind/NotRunningInBg/releases). (Will publish to Google Play soon)
2. Run the app and grant Notification Access permission in system settings.
3. Start the service and manually snooze the "Running in the background" notification for the first time, the app will keep it snoozed afterwards.
![](https://raw.githubusercontent.com/LvWind/NotRunningInBg/master/app/src/main/res/drawable/step1.png)
![](https://raw.githubusercontent.com/LvWind/NotRunningInBg/master/app/src/main/res/drawable/step2.png)