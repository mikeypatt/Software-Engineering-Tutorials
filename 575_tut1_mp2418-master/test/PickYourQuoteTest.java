import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import org.junit.Test;

public class PickYourQuoteTest {

  @Test
  public void exampleText() throws Exception {

    String input =
        String.join(
            "\n", "What a test!;Anonymous", "Another test!;Anonymous", "The last test!;Anonymous");

    ByteArrayOutputStream outstream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outstream));

    PickYourQuote.reformat(2, new BufferedReader(new StringReader(input)));

    String output = outstream.toString();
    assertThat(
        "Selected line 2 but got a different line.",
        output,
        containsString("Another test!" + "\n" + "Anonymous"));
  }

  @Test
  public void emptyText() throws Exception {

    String input = "";

    ByteArrayOutputStream outstream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outstream));

    PickYourQuote.reformat(2, new BufferedReader(new StringReader(input)));

    String output = outstream.toString();
    assertEquals("", output);
  }

  @Test
  public void invalidQuoteNumberNegative() throws Exception {

    String input =
        String.join(
            "\n", "What a test!;Anonymous", "Another test!;Anonymous", "The last test!;Anonymous");

    ByteArrayOutputStream outstream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outstream));

    PickYourQuote.reformat(-1, new BufferedReader(new StringReader(input)));

    String output = outstream.toString();
    assertEquals("", output);
  }

  @Test
  public void invalidQuoteNumberTooBig() throws Exception {

    String input =
        String.join(
            "\n", "What a test!;Anonymous", "Another test!;Anonymous", "The last test!;Anonymous");

    ByteArrayOutputStream outstream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outstream));

    PickYourQuote.reformat(4, new BufferedReader(new StringReader(input)));

    String output = outstream.toString();
    assertEquals("", output);
  }
}
