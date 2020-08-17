package com.mcheru.notekeeper;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
public class NoteCreationTest {
    @Rule
    public ActivityTestRule<NoteListActivity> mNoteListActivityRule =
            new ActivityTestRule<>(NoteListActivity.class);
    @Test
    public void createNewNote(){
        //ViewInteraction viewInteraction = onView(withId(R.id.floatingActionButton)).perform(click());
        onView(withId(R.id.floatingActionButton)).perform(click());
        onView(withId(R.id.text_note_title)).perform(typeText("Auto type test title"));
        onView(withId(R.id.text_note_text)).perform(typeText("Auto type test body"),
                ViewActions.closeSoftKeyboard());
    }
}