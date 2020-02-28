package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp implements ActionListener {
  private static final String MAIN_TITLE = "Polish Calculator";
  private static final int NUM_DIGITS = 9;
  private static final int TEXT_WIDTH = 10;
  private static final int WINDOW_WIDTH = 300;
  private static final int WINDOW_HEIGHT = 200;
  private PolishCalculator model;

  public static void main(String[] args) {
    PolishUi ui =
        new PolishUi(
            CalculatorApp.MAIN_TITLE, CalculatorApp.TEXT_WIDTH, WINDOW_HEIGHT, WINDOW_WIDTH);
    PolishCalculator model = new PolishCalculator(ui);
    CalculatorApp calculator = new CalculatorApp(model);
    ui.makeButtons(NUM_DIGITS, calculator);
    ui.makeVisible();
  }

  public CalculatorApp(PolishCalculator model) {
    this.model = model;
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    String identifier = actionEvent.getActionCommand();
    try {
      int number = Integer.parseInt(identifier);
      addToStack(number);
    } catch (NumberFormatException nfe) {
      operation(identifier);
    }
  }

  private void addToStack(Integer number) {
    model.addToStack(number);
  }

  private void operation(String operation) {
    if (operation == "+") {
      model.add();
    } else {
      model.subtract();
    }
  }
}
