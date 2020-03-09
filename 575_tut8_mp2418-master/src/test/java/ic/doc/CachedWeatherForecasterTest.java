package ic.doc;

import static org.junit.Assert.assertFalse;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class CachedWeatherForecasterTest {
  @Rule public JUnitRuleMockery context = new JUnitRuleMockery();
  final ClimateForecaster mockForecaster = context.mock(ClimateForecaster.class);
  final CachedWeatherForecaster cachedForecaster = new CachedWeatherForecaster(mockForecaster, 2);

  @Test
  public void requestingWeatherForTheFirstTimeAddsToTheCache() {
    context.checking(
        new Expectations() {
          {
            exactly(1).of(mockForecaster).getTemperature("monday", "london");
          }
        });
    cachedForecaster.getTemperature("monday", "london");
  }

  @Test
  public void requestingSameWeatherUpdateUsesTheCache() {
    context.checking(
        new Expectations() {
          {
            exactly(1).of(mockForecaster).getTemperature("monday", "london");
          }
        });
    cachedForecaster.getTemperature("monday", "london");
    cachedForecaster.getTemperature("monday", "london");
  }

  @Test
  public void requestingWeatherUpdateBeyondLimitDeletesOldestElement() {
    context.checking(
        new Expectations() {
          {
            exactly(1).of(mockForecaster).getTemperature("monday", "london");
            exactly(1).of(mockForecaster).getTemperature("tuesday", "london");
            exactly(1).of(mockForecaster).getTemperature("friday", "london");
          }
        });
    cachedForecaster.getTemperature("monday", "london");
    cachedForecaster.getTemperature("tuesday", "london");
    cachedForecaster.getTemperature("friday", "london");
    assertFalse(
        "First added element should have been removed",
        cachedForecaster.contains("monday", "london"));
  }
}
