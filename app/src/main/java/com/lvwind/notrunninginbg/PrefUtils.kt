/*
 * Copyright (c) 2017. Jason Shaw <lvwind.shaw@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */

package com.lvwind.notrunninginbg

import android.content.Context
import android.preference.PreferenceManager


object PrefUtils {
    val KEY_ENABLED = "enabled"

    fun getString(context: Context, key: String, defValue: String): String {
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        return pref.getString(key, defValue)
    }

    fun putString(context: Context, key: String, value: String) {
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = pref.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getLong(context: Context, key: String, defValue: Long): Long {
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        return pref.getLong(key, defValue)
    }

    fun putLong(context: Context, key: String, value: Long) {
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = pref.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    fun getBool(context: Context, key: String, defValue: Boolean): Boolean {
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        return pref.getBoolean(key, defValue)
    }

    fun putBool(context: Context, key: String, value: Boolean) {
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = pref.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun exists(context: Context, key: String): Boolean {
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        return pref.contains(key)
    }

    fun remove(context: Context, key: String) {
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = pref.edit()
        editor.remove(key)
        editor.apply()
    }
}