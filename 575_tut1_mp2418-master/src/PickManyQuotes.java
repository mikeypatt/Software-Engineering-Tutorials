import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PickManyQuotes {

  public static void main(String[] args) throws Exception {

    final String quotesFile = args[0];
    int[] choices = new int[args.length - 1];

    for (int i = 1; i < args.length; i++) {
      choices[i - 1] = Integer.parseInt(args[i]);
    }

    try {
      BufferedReader reader = new BufferedReader(new FileReader(quotesFile));
      List<Quote> quotes = loadQuotes(reader);
      reformat(quotes, choices);
      reader.close();
    } catch (IOException ioe) {
      System.out.println("Something wrong happened while reading the file");
    }

    // Use file name and quote numbers in args
    // to first create a list of quotes using loadQuotes
    // and then print to System.out the chosen quotes.

  }

  public static List<Quote> loadQuotes(BufferedReader in) throws IOException {
    List<Quote> quotes = new ArrayList<Quote>();

    String line;
    while ((line = in.readLine()) != null) {
      quotes.add(new Quote(line));
    }
    return quotes;
  }

  public static void reformat(List<Quote> quotes, int[] choices) {

    String line;
    for (int i = 0; i < choices.length; i++) {
      line = quotes.get(choices[i] - 1).toString();
      System.out.println(line);
    }
  }
}
