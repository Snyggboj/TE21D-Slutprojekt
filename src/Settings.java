import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Settings extends Window{
    Canvas canvas;
    Color backgroundColor;
    Color pickedColor;

    public Settings(){
        super(250, 300, "Settings");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        createBackgroundPicker();
        createColorPicker();
        createDrawModePicker();
        createCanvas();
        this.setVisible(true);
    }

    private void createDrawModePicker() {
    }

    private void createColorPicker() {

    }

    private void createBackgroundPicker() {
        this.add(new ColorButton(Color.white, "White", this));
        this.add(new ColorButton(Color.black, "Black", this));
        this.add(new ColorButton(Color.gray, "Gray", this));
        this.add(new ColorButton(new Color(225,198,153), "Beige", this));
        this.add(createRGBColorPicker());
    }

    private JPanel createRGBColorPicker() {
        JPanel rgbPicker = new JPanel();
        rgbPicker.setLayout(new FlowLayout());

        rgbPicker.add(new JLabel("R"));

        JTextField r = new JTextField(3);
        rgbPicker.add(r);

        rgbPicker.add(new JLabel("G"));

        JTextField g = new JTextField(3);
        rgbPicker.add(g);

        rgbPicker.add(new JLabel("B"));

        JTextField b = new JTextField(3);
        rgbPicker.add(b);

        JButton chooseButton = new JButton("Choose");
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    backgroundColor = new Color(Integer.parseInt(r.getText()), Integer.parseInt(g.getText()), Integer.parseInt(b.getText()));
                } catch (Exception a){
                    JOptionPane.showMessageDialog(null, "Not a color");

                }
            }
        });
        rgbPicker.add(chooseButton);
        return rgbPicker;
    }

    public void createCanvas(){
        JButton createCanvasButton = new JButton("Create canvas");
        createCanvasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas = new Canvas(backgroundColor);
            }
        });

        this.add(createCanvasButton);
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
