package yairvalbuena.android.aplicacion.Activities;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import yairvalbuena.android.aplicacion.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ExpressotestFuncion {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void expressotestFuncion() {
        ViewInteraction appCompatEditText = onView(
allOf(withId(R.id.email),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()));
        appCompatEditText.perform(replaceText("test@test.com"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText2 = onView(
allOf(withId(R.id.password),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        appCompatEditText2.perform(replaceText("1"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText3 = onView(
allOf(withId(R.id.password), withText("1"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        appCompatEditText3.perform(click());
        
        ViewInteraction appCompatEditText4 = onView(
allOf(withId(R.id.password), withText("1"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        appCompatEditText4.perform(replaceText("12345"));
        
        ViewInteraction appCompatEditText5 = onView(
allOf(withId(R.id.password), withText("12345"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        appCompatEditText5.perform(closeSoftKeyboard());
        
        ViewInteraction appCompatEditText6 = onView(
allOf(withId(R.id.password), withText("12345"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        appCompatEditText6.perform(click());
        
        ViewInteraction appCompatEditText7 = onView(
allOf(withId(R.id.password), withText("12345"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        appCompatEditText7.perform(replaceText("123456"));
        
        ViewInteraction appCompatEditText8 = onView(
allOf(withId(R.id.password), withText("123456"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        appCompatEditText8.perform(closeSoftKeyboard());
        
        ViewInteraction appCompatEditText9 = onView(
allOf(withId(R.id.password), withText("123456"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        appCompatEditText9.perform(pressImeActionButton());
        
        ViewInteraction appCompatButton = onView(
allOf(withId(R.id.InitBtn), withText("INICIAR"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        appCompatButton.perform(click());
        
        ViewInteraction recyclerView = onView(
allOf(withId(R.id.recyclerViewA),
childAtPosition(
withClassName(is("android.widget.FrameLayout")),
0)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));
        
        pressBack();
        
        ViewInteraction recyclerView2 = onView(
allOf(withId(R.id.recyclerViewT),
childAtPosition(
withClassName(is("android.widget.FrameLayout")),
0)));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));
        
        pressBack();
        
        ViewInteraction recyclerView3 = onView(
allOf(withId(R.id.recyclerViewT),
childAtPosition(
withClassName(is("android.widget.FrameLayout")),
0)));
        recyclerView3.perform(actionOnItemAtPosition(5, click()));
        
        pressBack();
        }
    
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup)parent).getChildAt(position));
            }
        };
    }
    }
