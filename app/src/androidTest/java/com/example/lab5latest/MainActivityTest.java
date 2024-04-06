package com.example.lab5latest;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatEditText = onView(withId(R.id.edittext));
        appCompatEditText.perform(replaceText("1234"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.login));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.pswd));
        textView.check(matches(withText("You shall not pass!")));
    }
@Test
    public void FindMissingUpperLetter(){
        //find the view
        ViewInteraction appcompactEditText= onView(withId(R.id.edittext));
        //type the password manjot@1234
        appcompactEditText.perform(replaceText("manjot@1234"));
        //find the Button
        ViewInteraction button= onView(withId(R.id.login));
        //click the Button
        button.perform(click());

        //find the TextView
        ViewInteraction textview =onView(withId(R.id.pswd));
        //check the text
        textview.check(matches(withText("You Shall not Pass")));
    }
    @Test
    public void FindMissingLowerLetter(){
        //find the view
        ViewInteraction AppcompactEditText= onView(withId(R.id.edittext));
        //type the password MANJOT@1234
        AppcompactEditText.perform(replaceText("MANJOT@1234"));
        //find the Button
        ViewInteraction button= onView(withId(R.id.login));
        //click the Button
        button.perform(click());

        //find the TextView
        ViewInteraction textview =onView(withId(R.id.pswd));
        //check the text
        textview.check(matches(withText("You Shall not Pass")));
    }
@Test
    public void FindMissingNumber(){
        //find the view
        ViewInteraction appcompactEditText= onView(withId(R.id.edittext));
        //type the password Manjot@#
        appcompactEditText.perform(replaceText("Manjot@#"));
        //find the Button
        ViewInteraction button= onView(withId(R.id.login));
        //click the Button
        button.perform(click());

        //find the TextView
        ViewInteraction textview =onView(withId(R.id.pswd));
        //check the text
        textview.check(matches(withText("You Shall not Pass")));
    }
    @Test
    public void FindMissingSpecialLetter(){
        //find the view
        ViewInteraction appcompactEditText= onView(withId(R.id.edittext));
        //type the password Manjot1234
        appcompactEditText.perform(replaceText("Manjot1234"));
        //find the Button
        ViewInteraction button= onView(withId(R.id.login));
        //click the Button
        button.perform(click());

        //find the TextView
        ViewInteraction textview =onView(withId(R.id.pswd));
        //check the text
        textview.check(matches(withText("You Shall not Pass")));
    }
}
