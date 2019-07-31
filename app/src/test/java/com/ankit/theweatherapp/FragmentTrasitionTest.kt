package com.ankit.theweatherapp


import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule

import com.ankit.theweatherapp.ui.weather.WeatherActivity
import com.ankit.theweatherapp.ui.weather.WeatherFragment

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FragmentTrasitionTest {

    @Rule
    var activityRule = ActivityTestRule(WeatherActivity::class.java)



    @Test
    fun testFragmentRun() {
        val scenario = launchFragmentInContainer<WeatherFragment>()
        scenario.recreate()

        onView(withId(R.id.tv_temp))
                .perform(click()).check(matches(isDisplayed()))


    }

}

