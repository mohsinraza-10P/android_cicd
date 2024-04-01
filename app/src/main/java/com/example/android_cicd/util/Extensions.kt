package com.example.android_cicd.ui.util

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build

fun Context.getPackageInfo(): PackageInfo {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(0))
    } else {
        packageManager.getPackageInfo(packageName, 0)
    }
}

fun Context.getVersionCode(): Int = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
    getPackageInfo().longVersionCode.toInt()
} else {
    getPackageInfo().versionCode
}

fun Context.getVersionName(): String = try {
    getPackageInfo().versionName
} catch (e: PackageManager.NameNotFoundException) {
    ""
}