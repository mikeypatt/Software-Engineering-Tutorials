package ic.doc;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class CacheWeather  {
  private final LinkedHashMap<String, Integer> temperatures;
  private final LinkedHashMap<String, Instant> timestamps;
  private final Integer maxSize;
  private final Integer timeout;
  private Instant referenceTime;

  public CacheWeather(Integer maxSize, Integer timeoutInHours) {
    this.temperatures = new LinkedHashMap<>(maxSize);
    this.timestamps = new LinkedHashMap<>(maxSize);
    this.referenceTime = Instant.now();
    this.maxSize = maxSize;
    this.timeout = timeoutInHours;
  }

  public void add(String key, Integer temperature) {
    temperatures.put(key, temperature);
    timestamps.put(key, Instant.now());
    if (temperatures.size() >= maxSize) {
      removeOldest();
    }
  }

  public void remove(String key) {
    temperatures.remove(key);
    timestamps.remove(key);
  }

  public void removeOldest() {
    String oldestKey = temperatures.entrySet().iterator().next().getKey();
    temperatures.remove(oldestKey);
  }

  public void removeExpiredEntries() {
    ArrayList<String> keysToDelete = new ArrayList<>();

    timestamps.forEach(
        (key, timestamp) -> {
          if (Duration.between(referenceTime, timestamp).toHours() >= timeout) {
            keysToDelete.add(key);
            referenceTime = Instant.now();
          }
        });

    keysToDelete.forEach(
        key -> {
          temperatures.remove(key);
          timestamps.remove(key);
        });
  }

  public boolean containsKey(String key) {
    return temperatures.containsKey(key);
  }

  public Integer get(String key) {
    return temperatures.get(key);
  }
}
