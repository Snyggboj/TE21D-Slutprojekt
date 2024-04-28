import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Pixel extends JPanel implements MouseListener{
    boolean painted = false;
    public Pixel(int panelsize){
        this.setBounds(0,0,panelsize,panelsize);
        this.addMouseListener(this);
        this.setBackground(Color.white);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("click");
        painted = !painted;

        if (painted){
            setBackground(Color.black);
        } else {
            setBackground(Color.white);
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
}
