package ic.doc.strategy;

public class FibonacciTermGenerator implements TermGenerator {

  @Override
  public int specificTerm(int i) {
    if (i < 2) {
      return 1;
    }
    return specificTerm(i - 1) + specificTerm(i - 2);
  }
}


