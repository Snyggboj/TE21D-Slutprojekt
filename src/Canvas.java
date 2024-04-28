import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Canvas extends Window implements MouseListener {
    // Attributes
    int border = 30;

    int canvasWidth;
    int canvasHeight;
    int rows;
    int columns;

    // Constructor
    public Canvas(){
        super(600, 400, "Canvas");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.gray);
        this.canvasWidth = 600 - (2 * border);
        this.canvasHeight = 400 - (2 * border);
        this.rows = canvasHeight/10;
        this.columns = canvasWidth/10;
        createCanvas();
        setVisible(true);
    }

    public void createCanvas(){
        JPanel canvasPanel = new JPanel();
        canvasPanel.setSize(canvasWidth, canvasHeight);
        canvasPanel.setLayout(new GridLayout(rows, columns));

        for(int i = 0; i < rows * columns; i++){
            canvasPanel.add(new Pixel(canvasHeight/rows));
        }
        this.add(canvasPanel);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
