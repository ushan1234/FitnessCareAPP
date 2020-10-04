package comtechnobyte.example.fitnesscareapp;

import android.view.View;

import androidx.annotation.ContentView;
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

public class LoginTest {



        @Rule
        public ActivityTestRule<Login> mLogin=new ActivityTestRule<Login>(Login.class);

        private Login mActivity=null;

    @Before
    public void setUp() throws Exception {
        mActivity=mLogin.getActivity();
    }

    @Test
    public void clickAddNoteButton_opensAddNoteUi() throws Exception
    {
        onView(withId(R.id.Lbtn)).perform(click());
        onView(withId(R.id.Lemail)).check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
        mActivity=null;
    }
}