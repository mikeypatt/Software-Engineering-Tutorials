import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PickYourQuote {

  public static void main(String[] args) throws Exception {
    // read the file Quotes.txt using a BufferedReader
    // reformat the file
    final String quotesFile = args[0];
    int quoteNumber = Integer.parseInt(args[1]);

    try {

      BufferedReader reader = new BufferedReader((new FileReader(quotesFile)));
      reformat(quoteNumber, reader);
      reader.close();
    } catch (IOException ioe) {
      System.out.println("Oops something went very wrong while reading the file");
      ioe.printStackTrace();
    }
  }

  public static void reformat(int quoteNumber, BufferedReader input) throws IOException {
    // read lines from the input
    // reformat as appropriate
    // print to System.out
    if (quoteNumber < 1) {
      return;
    }

    int count = 0;
    String line;
    while ((line = input.readLine()) != null) {
      line = line.replace(';', '\n');
      if (line.length() > 1 && ++count == quoteNumber) {
        System.out.println(line);
      }
    }
  }
}
