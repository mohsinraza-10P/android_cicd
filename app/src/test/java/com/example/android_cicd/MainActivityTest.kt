package com.example.android_cicd

import com.example.android_cicd.data.FakeVersionRepository
import com.example.android_cicd.data.IVersionRepository
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MainActivityTest {
    private var versionRepository: IVersionRepository? = null;

    @Before
    fun setup() {
        versionRepository = FakeVersionRepository();
        assert(versionRepository != null)
    }

    @Test
    fun getVersionCode_Valid_ReturnsDefault() {
        assertEquals(versionRepository?.getVersionCode(), 1)
    }

    @Test
    fun getVersionCode_Invalid_ReturnsNull() {
        (versionRepository as? FakeVersionRepository)?.code = null;
        assertEquals(versionRepository?.getVersionCode(), null)
    }

    @Test
    fun getVersionName_Valid_ReturnsDefault() {
        assertEquals(versionRepository?.getVersionName(), "1.0.0")
    }

    @Test
    fun getVersionName_Invalid_ReturnsNull() {
        (versionRepository as? FakeVersionRepository)?.name = null;
        assertEquals(versionRepository?.getVersionName(), null)
    }

    @After
    fun tearDown() {
        versionRepository = null
    }
}