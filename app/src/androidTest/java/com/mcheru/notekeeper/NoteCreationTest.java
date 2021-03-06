package com.mcheru.notekeeper;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static org.hamcrest.Matchers.*;


@RunWith(AndroidJUnit4.class)
public class NoteCreationTest {
    static DataManager sDataManager;
    @BeforeClass
    public static void classSetUp(){
        sDataManager = DataManager.getInstance();
    }
    @Rule
    public ActivityTestRule<NoteListActivity> mNoteListActivityRule =
            new ActivityTestRule<>(NoteListActivity.class);
    @Test
    public void createNewNote(){
        final CourseInfo course = sDataManager.getCourse("java_lang");
        final  String noteTitle = "Auto type test title";
        final  String noteText = "Auto type test text";
        //ViewInteraction viewInteraction = onView(withId(R.id.floatingActionButton)).perform(click());
        onView(withId(R.id.floatingActionButton)).perform(click());
        onView(withId(R.id.spinner_courses)).perform(click());
        onData(allOf(instanceOf(CourseInfo.class), equalTo(course))).perform(click());
        onView(withId(R.id.spinner_courses)).check(matches(withSpinnerText(
                containsString(course.getTitle())
        )));
        onView(withId(R.id.text_note_title)).perform(typeText(noteTitle))
                .check(matches(withText(noteTitle)));
        onView(withId(R.id.text_note_text)).perform(typeText(noteText),
                ViewActions.closeSoftKeyboard());

        onView(withId(R.id.text_note_text)).check(matches(withText(noteText)));
        Espresso.pressBack();

        int index = sDataManager.getNotes().size() - 1;
        NoteInfo note = sDataManager.getNotes().get(index);

        assertEquals(course, note.getCourse());
        assertEquals(noteTitle, note.getTitle());
        assertEquals(noteText, note.getText());
    }
}