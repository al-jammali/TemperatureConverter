package com.gaurav.user.temperatureconverter;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class toCelsius_MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction editText = onView(
                allOf(withId(R.id.inputValue), isDisplayed()));
        editText.perform(click());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.inputValue), isDisplayed()));
        editText2.perform(replaceText("212"), closeSoftKeyboard());

        ViewInteraction radioButton = onView(
                allOf(withId(R.id.radio0), withText("to Celsius"),
                        withParent(withId(R.id.radioGroup1)),
                        isDisplayed()));
        radioButton.perform(click());

        ViewInteraction button = onView(
                allOf(withId(R.id.button1), withText("Calculate"), isDisplayed()));
        button.perform(click());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.inputValue), withText("100.0"), isDisplayed()));
        editText3.perform(click());

    }

}
