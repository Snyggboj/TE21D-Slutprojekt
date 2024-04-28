import javax.swing.*;
import java.awt.*;
import java.awt.Color;


public class Window extends JFrame{
    // Attributes
    String title;
    int width;
    int height;
    public Window(int width, int height, String title){
        this.title = title;
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setTitle(title);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
    }
}
