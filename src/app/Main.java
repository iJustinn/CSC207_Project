package app;
import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        // Create a frame
        JFrame frame = new JFrame("Swing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        frame.getContentPane().setBackground(Color.GRAY);

        // Create a button and add it to the frame
        JButton button = new JButton("Click Me!");
        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Button was clicked!"));
        frame.getContentPane().add(button);

        button.setPreferredSize(new Dimension(100, 50));

        frame.setLayout(new FlowLayout());

        // Display the frame
        frame.setVisible(true);
    }
}