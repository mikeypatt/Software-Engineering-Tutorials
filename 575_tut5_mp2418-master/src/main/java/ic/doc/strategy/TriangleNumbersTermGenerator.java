package ic.doc.strategy;

public class TriangleNumbersTermGenerator implements TermGenerator {

  @Override
  public int specificTerm(int i) {
    if (i < 1) {
      return 1;
    }
    return (i + 1) * (i + 2) / 2;
  }
}
