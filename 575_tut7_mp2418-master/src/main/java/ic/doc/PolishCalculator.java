package ic.doc;

import java.util.Stack;

public class PolishCalculator {

  private Stack<Integer> numbers = new Stack<>();
  private UserInterface ui;

  public PolishCalculator(UserInterface ui) {
    this.ui = ui;
  }

  public void addToStack(Integer i) {
    numbers.add(i);
    ui.setResultText(String.valueOf(i));
  }

  public void add() {
    if (numbers.size() > 1) {
      int sum = numbers.pop() + numbers.pop();
      numbers.add(sum);
      ui.setResultText(String.valueOf(sum));
    }
  }

  public void subtract() {
    if (numbers.size() > 1) {
      int difference = numbers.pop() - numbers.pop();
      numbers.add(difference);
      ui.setResultText(String.valueOf(difference));
    }
  }
}
