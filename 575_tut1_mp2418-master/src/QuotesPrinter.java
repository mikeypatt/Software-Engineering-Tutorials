import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuotesPrinter {
  static final String quotesFile = "Quotes.txt";

  public static void main(String[] args) throws Exception {
    // read the file Quotes.txt using a BufferedReader
    // reformat the file
    try {
      BufferedReader reader = new BufferedReader(new FileReader(quotesFile));
      reformat(reader);
      reader.close();
    } catch (IOException ioe) {
      System.out.println("Oops something bad happened while reading the file.");
      ioe.printStackTrace();
    }
  }

  public static void reformat(BufferedReader input) throws IOException {
    // read lines from the input
    // reformat as appropriate
    // print to System.out
    String line;
    while ((line = input.readLine()) != null) {
      line = line.replace(';', '\n');
      System.out.println(line);
    }
  }
}
