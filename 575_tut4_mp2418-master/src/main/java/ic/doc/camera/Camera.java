package ic.doc.camera;

public class Camera implements WriteListener {
  private final Sensor sensor;
  private final MemoryCard memoryCard;
  private boolean waitingForData = false;
  private boolean poweredOn = false;

  public Camera(Sensor sensor, MemoryCard memoryCard) {
    this.sensor = sensor;
    this.memoryCard = memoryCard;
  }

  public void pressShutter() {
    if (poweredOn) {
      memoryCard.write(sensor.readData());
      waitingForData = true;
    }
  }

  public void powerOn() {
    sensor.powerUp();
    poweredOn = true;
  }

  public void powerOff() {
    if (!waitingForData) {
      sensor.powerDown();
      poweredOn = false;
    }
  }

  @Override
  public void writeComplete() {
    waitingForData = false;
    sensor.powerDown();
  }
}
