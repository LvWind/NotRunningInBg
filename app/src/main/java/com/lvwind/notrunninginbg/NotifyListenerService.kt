/*
 *
 *  * Copyright (c) 2017. Jason Shaw <lvwind.shaw@gmail.com>
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *    http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.lvwind.notrunninginbg


import android.app.Notification
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class NotifyListenerService : NotificationListenerService() {
    companion object {
        val TAG = "NotifyListenerService"
        val DURATION: Long = 86400000 //a day
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        super.onNotificationRemoved(sbn)
    }

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        val extras = sbn?.notification?.extras
        val notificationPkg = sbn?.packageName
        val notificationTitle = extras?.getString(Notification.EXTRA_TITLE)
        val notificationText = extras?.getString(Notification.EXTRA_TEXT)
        if (BuildConfig.DEBUG) {
            Log.i(TAG, "Notification posted $notificationPkg & $notificationTitle & $notificationText")
        }

        val enabled = PrefUtils.getBool(this, PrefUtils.KEY_ENABLED, false)

        val msg = getString(R.string.running_foreground_services_msg)
        //the Android System's package name is 'android'. weird!
        if (enabled and (notificationPkg == "android") and (msg == notificationText)) {
            this.snoozeNotification(sbn?.key, DURATION)
        } else {
            super.onNotificationPosted(sbn)
        }


    }
}
