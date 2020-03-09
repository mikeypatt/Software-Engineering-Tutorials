package ic.doc;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;

public class WeatherForecaster implements ClimateForecaster {

  private final Forecaster forecaster = new Forecaster();

  @Override
  public Integer getTemperature(String day, String city) {
    Forecast forecast =
        forecaster.forecastFor(Region.valueOf(city.toUpperCase()), Day.valueOf(day.toUpperCase()));
    return forecast.temperature();
  }
}
