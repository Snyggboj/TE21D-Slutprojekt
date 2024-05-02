import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.ArrayList;

public class Canvas extends Window{
    // Attributes
    int border = 30;
    int canvasWidth;
    int canvasHeight;
    int rows;
    int columns;
    private Color pickedColor = Color.black;
    private Color backgroundColor;
    ArrayList<Pixel> canvasPixels = new ArrayList<Pixel>();
    JPanel colorShowcase = new JPanel();

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

    public void createCanvas(){
        JPanel canvasPanel = new JPanel();
        canvasPanel.setSize(canvasWidth, canvasHeight);
        canvasPanel.setLayout(new GridLayout(rows, columns));

        for(int i = 0; i < rows * columns; i++){
            Pixel canvasPixel = new Pixel(canvasHeight/rows, backgroundColor, pickedColor);
            canvasPixels.add(canvasPixel);
            canvasPanel.add(canvasPixel);
        }
        this.add(canvasPanel);
    }

    public void createColorShowcase(){
        this.add(new JLabel("Color:"));
        colorShowcase.setPreferredSize(new Dimension(50, 20));
        colorShowcase.setBackground(pickedColor);
        this.add(colorShowcase);
    }

    public void setPickedColor(Color pickedColor) {
        this.pickedColor = pickedColor;
    }
}
