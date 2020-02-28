package ic.doc.co575;

public abstract class AbstractExpression implements Expression {
  @Override
  public int compareTo(Expression other) {
    if (equals(other)) {
      return 0;
    }

    if (evaluate() > other.evaluate()) {
      return 1;
    }

    return -1;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (!(o instanceof Expression)) {
      return false;
    }
    Expression exp = (Expression) o;

    return exp.evaluate() == evaluate();
  }
}
