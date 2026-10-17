import javax.swing.*;
import java.awt.Color;
import helper_classes.*;

public class WindowBuilder {
  public static void main(String[] args) {

     JFrame frame = new JFrame("My Awesome Window");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(625, 338);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#1e1e1e"));

     JTextField nombre = new JTextField("");
     nombre.setBounds(47, 44, 106, 21);
     nombre.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     nombre.setBackground(Color.decode("#B2B2B2"));
     nombre.setForeground(Color.decode("#656565"));
     nombre.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
     OnFocusEventHelper.setOnFocusText(nombre, "ingresa el nombre", Color.decode("#353535"),   Color.decode("#656565"));
     panel.add(nombre);

     frame.add(panel);
     frame.setVisible(true);

  }
}