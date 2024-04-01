package com.example.android_cicd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_cicd.data.IVersionRepository
import com.example.android_cicd.data.VersionRepository
import com.example.android_cicd.databinding.ActivityMainBinding
import com.example.android_cicd.ui.util.getVersionCode
import com.example.android_cicd.ui.util.getVersionName

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var versionRepository: IVersionRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init();
        updateUI()
    }

    private fun init() {
        versionRepository = VersionRepository(this)
    }

    private fun updateUI() {
        binding.tvVersion.text = getAppVersion();
    }

    private fun getAppVersion(): String {
        val name = versionRepository?.getVersionName();
        val code = versionRepository?.getVersionCode();
        return "$name ($code)"
    }
}