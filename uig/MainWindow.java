import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

  private CustomTextField1 textField1;
  private CustomTextField2 textField2;
  private CustomButton1 button3;
  private CustomLabel1 label4;

  public MainWindow() {
    setTitle("MainWindow");
    setSize(1024, 768);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);

    textField1 = new CustomTextField1();
    textField1.setBounds(95, 78, 180, 36);
    this.add(textField1);

    textField2 = new CustomTextField2();
    textField2.setBounds(95, 157, 180, 36);
    this.add(textField2);

    button3 = new CustomButton1();
    button3.setBounds(117, 285, 120, 36);
    button3.addActionListener(e -> handleClick());
    this.add(button3);

    label4 = new CustomLabel1();
    label4.setBounds(75, 22, 226, 39);
    this.add(label4);

    setLocationRelativeTo(null);
  }

  private void handleClick() {
    // TODO: implement
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      MainWindow frame = new MainWindow();
      frame.setVisible(true);
    });
  }
}
