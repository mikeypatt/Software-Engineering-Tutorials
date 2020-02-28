package ic.doc.co575;

public abstract class BinaryExpression extends AbstractExpression {
  private final Expression left;
  private final Expression right;
  private char operationSign;

  public BinaryExpression(Expression left, Expression right, char operationSign) {
    this.left = left;
    this.right = right;
    this.operationSign = operationSign;
  }

  public Expression getLeft() {
    return left;
  }

  public Expression getRight() {
    return right;
  }

  @Override
  public String toString() {
    String leftString = (left.depth() > 0) ? "( " + left.toString() + " )" : left.toString();
    String rightString = (right.depth() > 0) ? "( " + right.toString() + " )" : right.toString();

    return leftString + operationSign + rightString;
  }

  @Override
  public int depth() {
    return (left.depth() >= right.depth()) ? left.depth() + 1 : right.depth() + 1;
  }
}
