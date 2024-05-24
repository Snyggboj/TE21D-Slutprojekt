import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButton extends JButton {
    // Attributes
    private String title;
    private Color color;

    // Constructor
    public ColorButton(Color color, String title, Settings picker, boolean background){
        this.setBackground(color);
        this.title = title;
        this.color = color;
        this.addActionListener(new ActionListener() {
            // Method that sets needed color to buttons color when button is clicked
             @Override
            public void actionPerformed(ActionEvent e) {
                colorButtonAction(picker, background);
            }
        });
    }

    private void colorButtonAction(Settings picker, boolean background){
        // Check if background color is needed or brushcolor
        if (background){
            // Gets every canvas from settings window
            // Sets every canvases pixels background color to color
            // Sets settings background color attribute to color
            picker.setBackgroundColor(color);
            for (int i1 = 0; i1 < picker.getCanvases().size(); i1++){
                for (int i2 = 0; i2 < picker.getCanvases().get(i1).getCanvasPixels().size(); i2++){
                    picker.getCanvases().get(i1).getCanvasPixels().get(i2).setBackgroundColor(color);
                }
            }
            // Sets color shows background to color
            picker.getColorShow().setBackground(color);
        } else {
            // Gets every canvas from settings window
            // Sets every canvases pixels picked color to color
            // Sets settings picked color attribute to color
            picker.setPickedColor(color);
            for (int i1 = 0; i1 < picker.getCanvases().size(); i1++){
                picker.getCanvases().get(i1).getColorShowcase().setBackground(color);
                for (int i2 = 0; i2 < picker.getCanvases().get(i1).getCanvasPixels().size(); i2++){
                    picker.getCanvases().get(i1).getCanvasPixels().get(i2).setPickedColor(color);
                }
            }
        }
    }
}
