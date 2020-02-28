package ic.doc.camera;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class CameraTest {
  @Rule public JUnitRuleMockery context = new JUnitRuleMockery();

  final Sensor sensor = context.mock(Sensor.class);
  final MemoryCard memoryCard = context.mock(MemoryCard.class);
  final Camera camera = new Camera(sensor, memoryCard);

  public void setExpectationPowerUpAndWrite(Sensor sensor, MemoryCard memoryCard) {
    context.checking(
        new Expectations() {
          {
            exactly(1).of(sensor).powerUp();
            exactly(1).of(memoryCard).write(exactly(1).of(sensor).readData());
          }
        });
  }

  @Test
  public void switchingTheCameraOnPowersUpTheSensor() {
    context.checking(
        new Expectations() {
          {
            exactly(1).of(sensor).powerUp();
          }
        });
    camera.powerOn();
  }

  @Test
  public void switchingTheCameraOffPowersDownTheSensor() {
    context.checking(
        new Expectations() {
          {
            exactly(1).of(sensor).powerDown();
          }
        });
    camera.powerOff();
  }

  @Test
  public void pressingTheShutterWithThePowerOffDoesNothing() {
    context.checking(
        new Expectations() {
          {
            // do nothing
          }
        });

    camera.pressShutter();
  }

  @Test
  public void pressingTheShutterWithThePowerOnCopiesDataFromSensorToMemoryCard() {
    setExpectationPowerUpAndWrite(sensor, memoryCard);
    camera.powerOn();
    camera.pressShutter();
  }

  @Test
  public void switchingTheCameraOffDoesNotPowerDownTheSensorIfDataIsCurrentlyBeingWritten() {
    setExpectationPowerUpAndWrite(sensor, memoryCard);
    camera.powerOn();
    camera.pressShutter();
    camera.powerOff();
  }

  @Test
  public void whenWritingIsCompleteTheCameraPowersDownTheSensor() {

    setExpectationPowerUpAndWrite(sensor, memoryCard);
    context.checking(
        new Expectations() {
          {
            exactly(1).of(sensor).powerDown();
          }
        });
    camera.powerOn();
    camera.pressShutter();
    camera.writeComplete();
  }
}
