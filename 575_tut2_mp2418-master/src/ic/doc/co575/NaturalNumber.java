package ic.doc.co575;

/** This class represents a natural number */
public class NaturalNumber extends AbstractExpression {

  private final int value;

  public NaturalNumber(int val) {
    if (val <= 0) {
      throw new IllegalArgumentException(val + " is not a natural number.");
    }
    value = val;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @Override
  public int evaluate() {
    return value;
  }

  @Override
  public int depth() {
    return 0;
  }
}
