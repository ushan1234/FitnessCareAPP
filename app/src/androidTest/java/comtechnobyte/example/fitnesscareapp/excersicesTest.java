package comtechnobyte.example.fitnesscareapp;

import android.app.Activity;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class excersicesTest {

    @Rule
    public ActivityTestRule<excersices> mexcersices=new ActivityTestRule<excersices>(excersices.class);

    private excersices mActivity=null;

    @Before
    public void setUp() throws Exception {
        mActivity=mexcersices.getActivity();
    }

    @Test
    public void clckAddNoteButton_opensAddNoteUi() throws Exception
    {
        onView(withId(R.id.button8)).perform(click());
        onView(withId(R.id.editTextNumber)).check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
    }
}