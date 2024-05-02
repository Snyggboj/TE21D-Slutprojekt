import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Pixel extends JPanel implements MouseListener{
    private boolean painted = false;
    private boolean erase;
    private Color pickedColor;
    private Color backgroundColor;
    public Pixel(int panelsize, Color backgroundColor, Color pickedColor){
        this.setBounds(0,0,panelsize,panelsize);
        this.addMouseListener(this);
        this.pickedColor = pickedColor;
        this.backgroundColor = backgroundColor;
        this.setBackground(backgroundColor);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("click");
        if (painted && erase){
            setBackground(backgroundColor);
            painted = false;
        } else if(!erase) {
            setBackground(pickedColor);
            painted = true;
        }
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
