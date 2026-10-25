package com.example.pgm_11

import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun defaultLocation_isWithinValidLatLngRange() {
        assertTrue(MainActivity.BENGALURU_LAT in -90.0..90.0)
        assertTrue(MainActivity.BENGALURU_LNG in -180.0..180.0)
    }

    @Test
    fun defaultZoom_isWithinGoogleMapsRange() {
        assertTrue(MainActivity.DEFAULT_ZOOM in 2f..21f)
    }
}
