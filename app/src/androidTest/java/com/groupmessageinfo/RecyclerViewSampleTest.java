package com.groupmessageinfo;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.groupmessageinfo.ui.MessageInfoDetailActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Test class showcasing some {@link RecyclerViewActions} from Espresso.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class RecyclerViewSampleTest {

  private static final int ITEM_BELOW_THE_FOLD = 40;

  @Rule
  public ActivityTestRule<MessageInfoDetailActivity> mActivityRule = new ActivityTestRule<>(
      MessageInfoDetailActivity.class);

  @Test
  public void scrollToItemBelowFold_checkItsText() {
    // First scroll to the position that needs to be matched and click on it.
    onView(ViewMatchers.withId(R.id.collapsing_toolbar_recycler_view))
        .perform(RecyclerViewActions.actionOnItemAtPosition(ITEM_BELOW_THE_FOLD, click()));

    // Match the text in an item below the fold and check that it's displayed.
    String itemElementText = mActivityRule.getActivity().getResources().getString(
        R.string.msg_txt) + String.valueOf(ITEM_BELOW_THE_FOLD);
    onView(withText(itemElementText)).check(matches(isDisplayed()));
  }
}
