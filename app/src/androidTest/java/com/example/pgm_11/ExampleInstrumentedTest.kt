package com.example.pgm_11

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

/** Run on an emulator/device with Google Play services; take a screenshot of each scenario. */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    // TC1: map screen loads and shows the name/USN banner
    @Test
    fun tc1_mapAndStudentInfoDisplayed() {
        ActivityScenario.launch(MainActivity::class.java).use {
            onView(withId(R.id.map)).check(matches(isDisplayed()))
            onView(withId(R.id.studentInfo)).check(matches(isDisplayed()))
        }
    }

    // TC2: switching to Satellite view selects that option
    @Test
    fun tc2_switchToSatellite() {
        ActivityScenario.launch(MainActivity::class.java).use {
            onView(withId(R.id.typeSatellite)).perform(click())
            onView(withId(R.id.typeSatellite)).check(matches(isChecked()))
        }
    }

    // TC3: switching to Terrain view selects that option
    @Test
    fun tc3_switchToTerrain() {
        ActivityScenario.launch(MainActivity::class.java).use {
            onView(withText(R.string.map_terrain)).perform(click())
            onView(withId(R.id.typeTerrain)).check(matches(isChecked()))
        }
    }
}
