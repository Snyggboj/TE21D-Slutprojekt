import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.ArrayList;

// Class for the canvas window, subclass to Window
public class Canvas extends Window{
    // Attributes
    private final int border = 30;
    private int canvasWidth;
    private int canvasHeight;
    private int rows;
    private int columns;
    private Color pickedColor = Color.black;
    private Color backgroundColor;
    private ArrayList<Pixel> canvasPixels = new ArrayList<Pixel>();
    private JPanel colorShowcase = new JPanel();

    // Constructor
    public Canvas(Color backgroundColor){
        super(600, 420, "Canvas");
        this.getContentPane().setBackground(new Color(220,220,220));
        this.canvasWidth = 600 - (2 * border);
        this.canvasHeight = 400 - (2 * border);
        this.rows = canvasHeight/10;
        this.columns = canvasWidth/10;
        this.backgroundColor = backgroundColor;
        createColorShowcase();
        createCanvas();
        setVisible(true);
    }

    // Methods
    // Method that creates a canvas by creating a JPanel with a grid of Pixels
    public void createCanvas(){
        // Create JPanel and set size and layout
        JPanel canvasPanel = new JPanel();
        canvasPanel.setSize(canvasWidth, canvasHeight);
        canvasPanel.setLayout(new GridLayout(rows, columns));

        // Create instance of class Pixel for every grid slot
        for(int i = 0; i < rows * columns; i++){
            // Create pixel and add to grid and to an arraylist full of all pixels
            Pixel canvasPixel = new Pixel(canvasHeight/rows, backgroundColor, pickedColor);
            canvasPixels.add(canvasPixel);
            canvasPanel.add(canvasPixel);
        }
        // Add canvas to window
        this.add(canvasPanel);
    }

    // Method that creates a little box to see what color the user is drawing with
    public void createColorShowcase(){
        // Adds JLabel and JPanel with the selected brush color as the background color to the window
        this.add(new JLabel("Color:"));
        colorShowcase.setPreferredSize(new Dimension(50, 20));
        colorShowcase.setBackground(pickedColor);
        this.add(colorShowcase);
    }

    // Getters and setters
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public ArrayList<Pixel> getCanvasPixels() {
        return canvasPixels;
    }

    public JPanel getColorShowcase() {
        return colorShowcase;
    }
}
