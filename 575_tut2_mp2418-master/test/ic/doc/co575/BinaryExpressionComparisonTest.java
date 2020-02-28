package ic.doc.co575;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class BinaryExpressionComparisonTest {
  @Test
  public void checkEquality() {
    Product a = new Product(new NaturalNumber(3), new NaturalNumber(4));
    Product b = new Product(new NaturalNumber(6), new NaturalNumber(2));

    final String errorMsg =
        String.format("Problem comparing two equal expressions %s and %s.", a, b);
    assertThat(errorMsg, a.equals(b), equalTo(true));
  }

  @Test
  public void checkGreaterThan() {
    Product a = new Product(new NaturalNumber(70), new NaturalNumber(4));
    Product b = new Product(new NaturalNumber(6), new NaturalNumber(2));

    final String errorMsg =
        String.format("Problem comparing two equal expressions %s and %s.", a, b);
    assertThat(errorMsg, a.compareTo(b), equalTo(1));
  }

  @Test
  public void checkLessThan() {
    Product a = new Product(new NaturalNumber(2), new NaturalNumber(4));
    Product b = new Product(new NaturalNumber(6), new NaturalNumber(2));

    final String errorMsg =
        String.format("Problem comparing two equal expressions %s and %s.", a, b);
    assertThat(errorMsg, a.compareTo(b), equalTo(-1));
  }
}
