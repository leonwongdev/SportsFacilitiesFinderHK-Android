package com.example.sportsfacilitiesfinderhk.ui;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.sportsfacilitiesfinderhk.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class BookmarksUITest {

    @Rule
    public ActivityTestRule<SplashScreen> mActivityTestRule = new ActivityTestRule<>(SplashScreen.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    @Test
    public void bookmarksUITest() {
        try {
            //Wait for downloading data
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.sports_type_rec_view),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                1)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.facilities_list_recycler_view),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                1)));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.add_bookmark), withText("Add bookmark"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        3),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.alertTitle), withText("Success"),
                        withParent(allOf(withId(R.id.title_template),
                                withParent(withId(R.id.topPanel)))),
                        isDisplayed()));
        textView.check(matches(withText("Success")));

        ViewInteraction textView2 = onView(
                allOf(withId(android.R.id.message), withText("Bookmarked Tuen Mun Recreation and Sports Centre Archery Range! You can view the bookmarked item by clicking the Bookmarks button on the home page!"),
                        withParent(withParent(withId(R.id.scrollView))),
                        isDisplayed()));
        textView2.check(matches(withText("Bookmarked Tuen Mun Recreation and Sports Centre Archery Range! You can view the bookmarked item by clicking the Bookmarks button on the home page!")));

        ViewInteraction button = onView(
                allOf(withId(android.R.id.button3), withText("OK"),
                        withParent(withParent(withId(R.id.buttonPanel))),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction materialButton2 = onView(
                allOf(withId(android.R.id.button3), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.buttonPanel),
                                        0),
                                0)));
        materialButton2.perform(scrollTo(), click());

        ViewInteraction button2 = onView(
                allOf(withId(R.id.add_bookmark), withText("BOOKMARKED"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));

        pressBack();

        pressBack();

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.bookmark_button), withText("Bookmarks"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction view = onView(
                allOf(withContentDescription("Google Map"),
                        withParent(withParent(withId(R.id.facilities_map_fragment))),
                        isDisplayed()));
        view.check(matches(isDisplayed()));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.facilities_list_item_name), withText("Tuen Mun Recreation and Sports Centre Archery Range(Archery)"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(androidx.cardview.widget.CardView.class))),
                        isDisplayed()));
        textView3.check(matches(withText("Tuen Mun Recreation and Sports Centre Archery Range(Archery)")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.facilities_list_item_name), withText("Tuen Mun Recreation and Sports Centre Archery Range(Archery)"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(androidx.cardview.widget.CardView.class))),
                        isDisplayed()));
        textView4.check(matches(withText("Tuen Mun Recreation and Sports Centre Archery Range(Archery)")));

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.facilities_list_recycler_view),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                1)));
        recyclerView3.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.name_tv), withText("Tuen Mun Recreation and Sports Centre Archery Range"),
                        withParent(withParent(withId(R.id.intro_card))),
                        isDisplayed()));
        textView5.check(matches(withText("Tuen Mun Recreation and Sports Centre Archery Range")));

        ViewInteraction button3 = onView(
                allOf(withId(R.id.add_bookmark), withText("BOOKMARKED"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        button3.check(matches(isDisplayed()));
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
