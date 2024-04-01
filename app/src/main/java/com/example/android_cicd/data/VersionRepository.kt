package com.example.android_cicd.data

import android.content.Context
import com.example.android_cicd.ui.util.getVersionCode
import com.example.android_cicd.ui.util.getVersionName

interface IVersionRepository {
    fun getVersionCode(): Int?

    fun getVersionName(): String?
}

class VersionRepository(private val context: Context) : IVersionRepository {
    override fun getVersionCode() = context.getVersionCode()

    override fun getVersionName() = context.getVersionName()
}