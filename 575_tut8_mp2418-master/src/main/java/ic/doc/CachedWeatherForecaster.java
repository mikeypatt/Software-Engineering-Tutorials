package ic.doc;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedHashMap;

public class CachedWeatherForecaster implements ClimateForecaster {

  private final CacheWeather cache;
  private final ClimateForecaster forecaster;

  public CachedWeatherForecaster(ClimateForecaster forecaster, int cacheSize) {
    this.forecaster = forecaster;
    this.cache = new CacheWeather(cacheSize, 1);
  }

  @Override
  public Integer getTemperature(String day, String city) {
    String key = day + city;
    int temperature;

    if (cache.containsKey(key)) {
      temperature = cache.get(key);
    } else {
      temperature = forecaster.getTemperature(day, city);
      cache.add(key, temperature);
    }

    cache.removeExpiredEntries();

    return temperature;
  }

  public Boolean contains(String day, String city) {
    return cache.containsKey(day + city);
  }
}
