package com.mcheru.notekeeper;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NoteListActivityTestAuto {

    @Rule
    public ActivityTestRule<NoteListActivity> mActivityTestRule = new ActivityTestRule<>(NoteListActivity.class);

    @Test
    public void noteListActivityTestAuto() {
        ViewInteraction imageButton = onView(
                allOf(withId(R.id.floatingActionButton),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        imageButton.check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(IsInstanceOf.<View>instanceOf(android.widget.TextView.class), withText("android_intents|Dynamic intent resolution|Wow, intents allow components to be resolved at runtime"),
                        childAtPosition(
                                allOf(withId(R.id.list_notes),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                0)),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("android_intents|Dynamic intent resolution|Wow, intents allow components to be resolved at runtime")));

        ViewInteraction textView2 = onView(
                allOf(IsInstanceOf.<View>instanceOf(android.widget.TextView.class), withText("android_intents|Dynamic intent resolution|Wow, intents allow components to be resolved at runtime"),
                        childAtPosition(
                                allOf(withId(R.id.list_notes),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                0)),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("android_intents|Dynamic intent resolution|Wow, intents allow components to be resolved at runtime")));

        DataInteraction appCompatTextView = onData(anything())
                .inAdapterView(allOf(withId(R.id.list_notes),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)))
                .atPosition(0);
        appCompatTextView.perform(click());

        DataInteraction appCompatTextView2 = onData(anything())
                .inAdapterView(allOf(withId(R.id.list_notes),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)))
                .atPosition(0);
        appCompatTextView2.perform(click());

        ViewInteraction overflowMenuButton = onView(
                allOf(withContentDescription("More options"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar),
                                        1),
                                0),
                        isDisplayed()));
        overflowMenuButton.perform(click());

        ViewInteraction appCompatTextView3 = onView(
                allOf(withId(R.id.title), withText("Send as email"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatTextView3.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.text_note_title), withText("Dynamic intent resolution"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("Dynamic intent resolution  ndgdd"));

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.text_note_title), withText("Dynamic intent resolution  ndgdd"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(closeSoftKeyboard());

        pressBack();

        pressBack();

        DataInteraction appCompatTextView4 = onData(anything())
                .inAdapterView(allOf(withId(R.id.list_notes),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)))
                .atPosition(7);
        appCompatTextView4.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.text_note_text), withText("Remember to include SerialVersionUID to assure version compatibility"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
                                        1),
                                2),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("Remember to include SerialVersionUID to assure version compatibility mddddj"));

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.text_note_text), withText("Remember to include SerialVersionUID to assure version compatibility mddddj"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
                                        1),
                                2),
                        isDisplayed()));
        appCompatEditText4.perform(closeSoftKeyboard());

        ViewInteraction overflowMenuButton2 = onView(
                allOf(withContentDescription("More options"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar),
                                        1),
                                0),
                        isDisplayed()));
        overflowMenuButton2.perform(click());

        ViewInteraction appCompatTextView5 = onView(
                allOf(withId(R.id.title), withText("Cancel"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatTextView5.perform(click());

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.floatingActionButton),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.appcompat.widget.ContentFrameLayout")),
                                        0),
                                1),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.text_note_title),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("ell"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.text_note_text),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
                                        1),
                                2),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("hello you"), closeSoftKeyboard());

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
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
