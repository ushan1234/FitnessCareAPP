package comtechnobyte.example.fitnesscareapp;

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

public class RegisterTest {

    @Rule
    public ActivityTestRule<Register> mRegister=new ActivityTestRule<Register>(Register.class);

    private Register mActivity=null;

    @Before
    public void setUp() throws Exception {
        mActivity=mRegister.getActivity();
    }
    @Test
    public void clickAddNoteButton_opensAddNoteUi() throws Exception
    {
        onView(withId(R.id.Rbtn)).perform(click());
        onView(withId(R.id.Email)).check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
        mActivity=null;
    }
}