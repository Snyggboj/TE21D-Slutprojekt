import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Settings extends Window{
    Color backgroundColor = Color.white;
    Color pickedColor;
    ArrayList<Canvas> canvases = new ArrayList<Canvas>();
    JPanel colorShow = new JPanel();
    boolean erase;

    public Settings(){
        super(250, 300, "Settings");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        createBackgroundPicker();
        createCanvas();
        createDrawModePicker();
        createColorPicker();
        this.setVisible(true);
    }

    private void createDrawModePicker() {
        JPanel drawModePicker = new JPanel();
        drawModePicker.setLayout(new GridLayout(1,3));

        JButton brushButton = new JButton("Brush");
        JButton eraseButton = new JButton("Erase");
        JButton clearButton = new JButton("Clear");

        brushButton.setEnabled(false);
        erase = false;
        brushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i1 = 0; i1 < canvases.size(); i1++){
                    for (int i2 = 0; i2 < canvases.get(i1).canvasPixels.size(); i2++){
                        canvases.get(i1).canvasPixels.get(i2).setErase(false);
                    }
                }
                brushButton.setEnabled(false);
                eraseButton.setEnabled(true);
                clearButton.setEnabled(true);
                erase = false;
            }
        });
        eraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i1 = 0; i1 < canvases.size(); i1++){
                    for (int i2 = 0; i2 < canvases.get(i1).canvasPixels.size(); i2++){
                        canvases.get(i1).canvasPixels.get(i2).setErase(true);
                    }
                }
                brushButton.setEnabled(true);
                eraseButton.setEnabled(false);
                clearButton.setEnabled(true);
                erase = true;
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i1 = 0; i1 < canvases.size(); i1++){
                    for (int i2 = 0; i2 < canvases.get(i1).canvasPixels.size(); i2++){
                        canvases.get(i1).canvasPixels.get(i2).setBackground(backgroundColor);
                    }
                }
            }
        });

        drawModePicker.add(brushButton);
        drawModePicker.add(eraseButton);
        drawModePicker.add(clearButton);
        this.add(drawModePicker);
    }

    private void createColorPicker() {

        JPanel backgroundPicker = new JPanel();

        JPanel colors = new JPanel();
        colors.setLayout(new GridLayout(2,4, 5, 5));
        colors.setPreferredSize(new Dimension(width - 40, 45));

        colors.add(new ColorButton(Color.black, "Black", this, false));
        colors.add(new ColorButton(Color.white, "White", this, false));
        colors.add(new ColorButton(Color.gray, "Gray", this, false));
        colors.add(new ColorButton(Color.blue, "Blue", this, false));
        colors.add(new ColorButton(Color.green, "Green", this, false));
        colors.add(new ColorButton(Color.red, "Red", this, false));
        colors.add(new ColorButton(Color.yellow, "Yellow", this, false));
        colors.add(new ColorButton(Color.orange, "Orange", this, false));
        this.add(colors);

        this.add(createRGBColorPicker(pickedColor));
    }

    private void createBackgroundPicker() {
        JPanel backgroundPicker = new JPanel();

        JPanel colors = new JPanel();
        colors.setLayout(new GridLayout(1,4, 5, 5));
        colors.setPreferredSize(new Dimension(width - 40, 20));

        colors.add(new ColorButton(Color.white, "White", this, true));
        colors.add(new ColorButton(Color.black, "Black", this, true));
        colors.add(new ColorButton(Color.gray, "Gray", this, true));
        colors.add(new ColorButton(new Color(225,198,153), "Beige", this, true));
        this.add(colors);

        this.add(createRGBColorPicker(backgroundColor));

        this.add(backgroundPicker);
    }

    private JPanel createRGBColorPicker(Color neededColor) {

        JPanel rgbPicker = new JPanel();
        rgbPicker.setLayout(new FlowLayout());
        rgbPicker.setSize(width, 50);

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
                    Color rgbColor = new Color(Integer.parseInt(r.getText()), Integer.parseInt(g.getText()), Integer.parseInt(b.getText()));
                    if (neededColor == backgroundColor){
                        backgroundColor = rgbColor;
                        for (int i1 = 0; i1 < canvases.size(); i1++){
                            for (int i2 = 0; i2 < canvases.get(i1).canvasPixels.size(); i2++){
                                canvases.get(i1).canvasPixels.get(i2).setBackgroundColor(rgbColor);
                            }
                        }
                        colorShow.setBackground(rgbColor);
                    } else {
                        pickedColor = rgbColor;
                        for (int i1 = 0; i1 < canvases.size(); i1++){
                            canvases.get(i1).colorShowcase.setBackground(rgbColor);
                            for (int i2 = 0; i2 < canvases.get(i1).canvasPixels.size(); i2++){
                                canvases.get(i1).canvasPixels.get(i2).setPickedColor(rgbColor);
                            }
                        }
                    }
                } catch (Exception a){
                    JOptionPane.showMessageDialog(null, "Not a color");
                }

                r.setText("");
                g.setText("");
                b.setText("");
            }
        });
        rgbPicker.add(chooseButton);
        return rgbPicker;
    }

    public void createCanvas(){
        JPanel create = new JPanel();
        create.setLayout(new FlowLayout());

        JButton createCanvasButton = new JButton("Create canvas");
        createCanvasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Canvas canvas = new Canvas(backgroundColor);
                for (int i = 0; i < canvas.canvasPixels.size(); i++){
                    canvas.canvasPixels.get(i).setErase(erase);
                }
                canvases.add(canvas);
            }
        });

        create.add(new JLabel("Color:"));
        colorShow.setPreferredSize(new Dimension(50, 20));
        create.add(colorShow);
        create.add(createCanvasButton);
        this.add(create);
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setPickedColor(Color pickedColor) {
        this.pickedColor = pickedColor;
    }
}
