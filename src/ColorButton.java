import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButton extends JButton {
    String title;
    Color color;
    public ColorButton(Color color, String title, Settings picker){
        this.setBackground(color);
        this.title = title;
        this.color = color;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                picker.setBackgroundColor(color);
            }
        });
    }
}
