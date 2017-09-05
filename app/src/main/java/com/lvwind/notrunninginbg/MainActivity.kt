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

import android.app.Activity
import android.app.AlertDialog
import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.support.customtabs.CustomTabsIntent
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.lvwind.kashi.getColorById
import com.lvwind.kashi.hide
import com.lvwind.kashi.show
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        switchButton.isChecked = PrefUtils.getBool(this, PrefUtils.KEY_ENABLED, false)
        if (switchButton.isChecked) {
            switchText.text = getString(R.string.toggle_enabled)
        } else {
            switchText.text = getString(R.string.toggle_disabled)
        }

        switchButton!!.setOnCheckedChangeListener { _, isChecked ->
            PrefUtils.putBool(this, PrefUtils.KEY_ENABLED, isChecked)
            if (isChecked) {
                switchText.text = getString(R.string.toggle_enabled)
            } else {
                disable()
            }

        }
        initAd()

    }

    override fun onResume() {
        super.onResume()
        getPermission()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_about) {
            val url = "https://github.com/LvWind/NotRunningInBg/blob/master/README.md#notrunninginbg"
            val builder = CustomTabsIntent.Builder()
                    .setToolbarColor(getColorById(R.color.colorPrimary))
            val customTabsIntent = builder.build()
            customTabsIntent.launchUrl(this, Uri.parse(url))

            return true
        }

        return super.onOptionsItemSelected(item)
    }

    // check permissions
    private fun isEnabled(): Boolean {
        val pkgName = packageName
        val flat = Settings.Secure.getString(contentResolver, "enabled_notification_listeners")
        if (!TextUtils.isEmpty(flat)) {
            val names = flat.split(":")

            names.forEach {
                val cn = ComponentName.unflattenFromString(it)
                if (cn != null) {
                    if (TextUtils.equals(pkgName, cn.packageName)) {
                        return true
                    }
                }
            }
        }
        return false
    }

    private fun getPermission() {
        if (!isEnabled()) {
            startActivity(Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"))
            Toast.makeText(this, R.string.toast_enable_access, Toast.LENGTH_LONG).show()
        }
    }

    private fun disable() {
        switchText.text = getString(R.string.toggle_disabled)

        val dialogBuilder = AlertDialog.Builder(this)
        val dialog = dialogBuilder.setTitle(R.string.disable_dialog_title)
                .setMessage(R.string.disable_dialog_message)
                .setPositiveButton(android.R.string.ok, null)
                .create()
        dialog.show()
    }

    private fun initAd() {
        // Load an ad into the AdMob banner view.
        adView.hide()
        adView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                adView.show()
                super.onAdLoaded()
            }
        }
        val adRequest = AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .setRequestAgent("android_studio:ad_template").build()
        adView.loadAd(adRequest)
    }


}
