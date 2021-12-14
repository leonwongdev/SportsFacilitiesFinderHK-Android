//# COMP 4521    #  TO, Kai Yuen 20410782 kytoac@connect.ust.hk
//# COMP 4521    #  WONG, Lap Wong 20602036 lwwongaf@connect.ust.hk

package com.example.sportsfacilitiesfinderhk.ui;


import android.view.View;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.sportsfacilitiesfinderhk.R;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityTestRule<SplashScreen> mActivityTestRule = new ActivityTestRule<>(SplashScreen.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    @Test
    public void mainActivityUITest() {
        try {
            //Wait for downloading data
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ViewInteraction textView = onView(
                allOf(withId(R.id.sport_title_tv), withText("Archery"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(androidx.cardview.widget.CardView.class))),
                        isDisplayed()));
        textView.check(matches(withText("Archery")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.sport_title_tv), withText("Beach Volleyball"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(androidx.cardview.widget.CardView.class))),
                        isDisplayed()));
        textView2.check(matches(withText("Beach Volleyball")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.sport_title_tv), withText("Cricket"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(androidx.cardview.widget.CardView.class))),
                        isDisplayed()));
        textView3.check(matches(withText("Cricket")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.sport_title_tv), withText("Gateball"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(androidx.cardview.widget.CardView.class))),
                        isDisplayed()));
        textView4.check(matches(withText("Gateball")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.sport_title_tv), withText("Handball"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(androidx.cardview.widget.CardView.class))),
                        isDisplayed()));
        textView5.check(matches(withText("Handball")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.sport_title_tv), withText("Netball"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(androidx.cardview.widget.CardView.class))),
                        isDisplayed()));
        textView6.check(matches(withText("Netball")));

        ViewInteraction sportTypeRecView = onView(withId(R.id.sports_type_rec_view)).perform(ViewActions.swipeUp());

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.sport_title_tv), withText("Roller Skating"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(androidx.cardview.widget.CardView.class))),
                        isDisplayed()));
        textView7.check(matches(withText("Roller Skating")));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.sport_title_tv), withText("Skateboarding"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(androidx.cardview.widget.CardView.class))),
                        isDisplayed()));
        textView8.check(matches(withText("Skateboarding")));

        ViewInteraction button = onView(
                allOf(withId(R.id.bookmark_button), withText("BOOKMARKS"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        button.check(matches(isDisplayed()));
    }
}
