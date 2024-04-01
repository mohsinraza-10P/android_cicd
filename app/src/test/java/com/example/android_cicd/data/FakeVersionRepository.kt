package com.example.android_cicd.data

import com.example.android_cicd.data.IVersionRepository

class FakeVersionRepository : IVersionRepository {
    var code: Int? = 1
    var name: String? = "1.0.0"

    override fun getVersionCode() = code

    override fun getVersionName() = name
}