package ic.doc.templatemethod;

public class FibonacciSequence extends Sequence {

  @Override
  protected int specificTerm(int i) {
    if (i < 2) {
      return 1;
    }
    return specificTerm(i - 1) + specificTerm(i - 2);
  }
}
