import javax.swing.*;
import java.awt.*;

// A Superclass for all windows in program, is a JFrame
// Creates window and sets basic settings
public class Window extends JFrame{
    // Attributes
    String title;
    int width;
    int height;

    //Constructor
    public Window(int width, int height, String title){
        this.title = title;
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle(title);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
    }
}
