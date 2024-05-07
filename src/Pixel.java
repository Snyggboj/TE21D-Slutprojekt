import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// Class for each pixel in the canvas, implements mouselistener to be able to know when each pixel is clicked
public class Pixel extends JPanel implements MouseListener{
    // Attributes
    private boolean painted = false;
    private boolean erase;
    private Color pickedColor;
    private Color backgroundColor;

    // Constructor
    public Pixel(int panelsize, Color backgroundColor, Color pickedColor){
        this.setBounds(0,0,panelsize,panelsize);
        this.addMouseListener(this);
        this.pickedColor = pickedColor;
        this.backgroundColor = backgroundColor;
        this.setBackground(backgroundColor);
    }

    // Method for when mouse is clicked
    @Override
    public void mouseClicked(MouseEvent e) {
        // Checks if erase mode is turned on and if the pixel that is clicked is painted
        // If both are true it will erase the painted pixel
        if (painted && erase){
            setBackground(backgroundColor);
            painted = false;
        // If erase is false the pixel will be painted
        } else if(!erase) {
            setBackground(pickedColor);
            painted = true;
        }
    }

    // Method for when mouse is pressed
    @Override
    public void mousePressed(MouseEvent e) {

    }

    // Method for when mouse is released
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    // Method for when mouse has entered
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    // Method for when mouse has exited
    @Override
    public void mouseExited(MouseEvent e) {

    }

    // Getters and setters
    public void setPickedColor(Color pickedColor) {
        this.pickedColor = pickedColor;
    }

    public void setErase(boolean erase) {
        this.erase = erase;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
