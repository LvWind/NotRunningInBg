# NotRunningInBg

This project is a tool to snooze the "App is Running in the Background" notifications on Android Oreo.

Looking at the source code in AOSP, the [updateForegroundApps()](https://github.com/android/platform_frameworks_base/blob/b056324630b8adfeb38393bcab49f3b9c720f4fd/services/core/java/com/android/server/am/ActiveServices.java#L790) in ActiveServices, As long as many apps are not on top and not system apps, App developers can do nothing to remove this notification.

But we can use a [NotificationListenerService](https://developer.android.com/reference/android/service/notification/NotificationListenerService.html#snoozeNotification) to snooze this notification for a long time.
