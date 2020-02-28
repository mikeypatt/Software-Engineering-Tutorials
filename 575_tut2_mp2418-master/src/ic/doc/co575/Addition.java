package ic.doc.co575;

public class Addition extends BinaryExpression {
  public Addition(Expression left, Expression right) {
    super(left, right, '+');
  }

  @Override
  public int evaluate() {
    return getLeft().evaluate() + getRight().evaluate();
  }
}
