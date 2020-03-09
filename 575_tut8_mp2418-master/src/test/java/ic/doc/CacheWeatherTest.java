package ic.doc;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class CacheWeatherTest {

  private final CacheWeather cache = new CacheWeather(2, 2 / 3600);

  @Test
  public void cacheRemovesExpiredEntriesAfterTimeOut() throws InterruptedException {

    cache.add("MondayLondon", 26);
    Thread.sleep(3);
    cache.removeExpiredEntries();
    assertFalse("First added element should have been removed", cache.containsKey("MondayLondon"));
  }
}
