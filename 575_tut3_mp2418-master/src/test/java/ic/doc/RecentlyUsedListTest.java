package ic.doc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class RecentlyUsedListTest {
  @Test
  public void isListEmptyWhenInitialised() {
    assertThat(new RecentlyUsedList().getLength(), is(0));
  }

  @Test
  public void canThingsBeAddedToList() {
    int value = 1;
    RecentlyUsedList myRecentList = new RecentlyUsedList();
    myRecentList.add(value);
    assertThat(myRecentList.getLength(), is(1));
  }

  @Test
  public void canRetrieveItem() {
    int checkValue = 1;
    RecentlyUsedList myRecentList = new RecentlyUsedList();
    myRecentList.add(checkValue);

    Object value = myRecentList.getValueAt(0);
    assertThat(value, is(notNullValue()));
  }

  @Test
  public void isTheMostRecentItemFirst() {
    RecentlyUsedList myRecentList = new RecentlyUsedList();
    int value = 4;
    myRecentList.add(value);
    assertEquals(value, myRecentList.getValueAt(0));
  }

  @Test
  public void checkThatItemsInTheListAreUnique() {
    int value1 = 4;
    int value2 = 6;
    int duplicate = 4;
    RecentlyUsedList myRecentList = new RecentlyUsedList();

    myRecentList.add(value1);
    myRecentList.add(value2);
    myRecentList.add(duplicate);

    assertThat(myRecentList.getLength(), is(2));
  }

  @Test
  public void checkThatAddingDuplicateMovesItToBeginning() {
    int value1 = 4;
    int value2 = 6;
    int duplicate = 4;
    RecentlyUsedList myRecentList = new RecentlyUsedList();

    myRecentList.add(value1);
    myRecentList.add(value2);
    myRecentList.add(duplicate);

    assertThat(myRecentList.getValueAt(0), is(value1));
  }

  @Test
  public void checkThatGetValueAtNegativeIndexThrows() {
    int index = -1;
    RecentlyUsedList myRecentList = new RecentlyUsedList();
    myRecentList.add(33);
    try {
      myRecentList.getValueAt(index);
      fail("add did not throw an exception");
    } catch (IndexOutOfBoundsException iob) {
      //
    }
  }

  @Test
  public void checkThatGetValueAtThrowsIfIndexBeyondLength() {
    int index = 1;
    RecentlyUsedList myRecentList = new RecentlyUsedList();
    try {
      myRecentList.getValueAt(index);
      fail("add did not throw an exception");
    } catch (IndexOutOfBoundsException iob) {
      //
    }
  }
}
