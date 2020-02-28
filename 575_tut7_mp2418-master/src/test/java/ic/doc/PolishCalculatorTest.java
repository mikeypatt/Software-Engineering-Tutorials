package ic.doc;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class PolishCalculatorTest {

  @Rule public JUnitRuleMockery context = new JUnitRuleMockery();
  final UserInterface ui = context.mock(UserInterface.class);
  PolishCalculator model = new PolishCalculator(ui);

  @Test
  public void addingToStackWritesToTextField() {
    context.checking(
        new Expectations() {
          {
            exactly(1).of(ui).setResultText("1");
          }
        });
    model.addToStack(1);
  }

  @Test
  public void additionWithEmptyStackDoesNothing() {
    context.checking(
        new Expectations() {
          {
            never(ui).setResultText(with(any(String.class)));
          }
        });
    model.add();
  }

  @Test
  public void subtractionWithEmptyStackDoesNothing() {
    context.checking(
        new Expectations() {
          {
            never(ui).setResultText(with(any(String.class)));
          }
        });
    model.subtract();
  }

  @Test
  public void additionIsDoneInReversePolishNotationOrder() {
    context.checking(
        new Expectations() {
          {
            exactly(1).of(ui).setResultText("1");
            exactly(1).of(ui).setResultText("2");
            exactly(1).of(ui).setResultText("3");
            // answers
            exactly(1).of(ui).setResultText("5");
            exactly(1).of(ui).setResultText("6");
          }
        });
    model.addToStack(1);
    model.addToStack(2);
    model.addToStack(3);
    model.add();
    model.add();
  }

  @Test
  public void subtractionIsDoneInReversePolishNotationOrder() {
    context.checking(
        new Expectations() {
          {
            exactly(1).of(ui).setResultText("1");
            exactly(1).of(ui).setResultText("2");
            exactly(1).of(ui).setResultText("3");
            // answers
            exactly(1).of(ui).setResultText("1");
            exactly(1).of(ui).setResultText("0");
          }
        });
    model.addToStack(1);
    model.addToStack(2);
    model.addToStack(3);
    model.subtract();
    model.subtract();
  }
}
