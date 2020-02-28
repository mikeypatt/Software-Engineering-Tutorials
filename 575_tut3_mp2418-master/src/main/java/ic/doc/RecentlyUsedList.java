package ic.doc;

import java.util.ArrayList;

public class RecentlyUsedList {

  private ArrayList<Object> myRecentList = new ArrayList();
  // private int length = 0 ;

  public int getLength() {
    return myRecentList.size();
  }

  public void add(Object value) {
    if (getLength() == 0) {
      myRecentList.add(0, value);
    } else if (getValueAt(0) != value) {
      myRecentList.remove(value);
      myRecentList.add(0, value);
    }
  }

  public Object getValueAt(int index) throws IndexOutOfBoundsException {
    return myRecentList.get(index);
  }
}
