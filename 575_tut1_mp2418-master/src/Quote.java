public class Quote {

  private String quote;
  private String context;

  public Quote(String unparsed) {
    String[] parsed = unparsed.split(";");
    if (parsed.length < 2) {
      quote = "";
      context = "";
      return;
    }
    quote = parsed[0];
    context = parsed[1];
  }

  public String getQuote() {
    return quote;
  }

  public String getContext() {
    return context;
  }

  @Override
  public String toString() {
    return String.format("`" + getQuote() + "'" + " by " + getContext());
  }
}

