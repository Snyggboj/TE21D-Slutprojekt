import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButton extends JButton {
    String title;
    Color color;
    public ColorButton(Color color, String title, Settings picker, boolean background){
        this.setBackground(color);
        this.title = title;
        this.color = color;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (background){
                    picker.setBackgroundColor(color);
                    for (int i1 = 0; i1 < picker.canvases.size(); i1++){
                        for (int i2 = 0; i2 < picker.canvases.get(i1).canvasPixels.size(); i2++){
                            picker.canvases.get(i1).canvasPixels.get(i2).setBackgroundColor(color);
                        }
                    }
                    picker.colorShow.setBackground(color);
                } else {
                    picker.setPickedColor(color);
                    for (int i1 = 0; i1 < picker.canvases.size(); i1++){
                        picker.canvases.get(i1).colorShowcase.setBackground(color);
                        for (int i2 = 0; i2 < picker.canvases.get(i1).canvasPixels.size(); i2++){
                            picker.canvases.get(i1).canvasPixels.get(i2).setPickedColor(color);
                        }
                    }
                }
            }
        });
    }
}
