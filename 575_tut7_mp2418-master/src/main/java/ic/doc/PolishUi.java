package ic.doc;

//google style said to import the below individually
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PolishUi implements UserInterface {
  private final JFrame frame;
  private final JTextField resultField;
  private final JPanel panel;

  public PolishUi(String title, int textWidth, int windowHeight, int windowWidth) {
    frame = new JFrame(title);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel = new JPanel();

    resultField = new JTextField(textWidth);
    resultField.setEditable(false);
    panel.add(resultField);

    frame.setSize(windowWidth, windowHeight);
  }

  public void setResultText(String text) {
    resultField.setText(text);
  }

  public void makeButtons(int numButtons, CalculatorApp controller) {
    for (int i = 0; i <= numButtons; i++) {
      JButton button = new JButton(String.valueOf(i));
      button.setActionCommand(String.valueOf(i));
      button.addActionListener(controller);
      panel.add(button);
    }

    JButton addition = new JButton("+");
    addition.setActionCommand("+");
    addition.addActionListener(controller);
    panel.add(addition);

    JButton subtraction = new JButton("-");
    subtraction.setActionCommand("-");
    subtraction.addActionListener(controller);
    panel.add(subtraction);

    frame.add(panel);
  }

  public void makeVisible() {
    frame.setVisible(true);
  }
}
