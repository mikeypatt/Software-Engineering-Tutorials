package ic.doc.co575;

public class Product extends BinaryExpression {
  public Product(Expression left, Expression right) {
    super(left, right, '*');
  }

  @Override
  public int evaluate() {
    return getLeft().evaluate() * getRight().evaluate();
  }
}
