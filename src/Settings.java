import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Class for settings window, subclass to Window
public class Settings extends Window{
    // Attributes
    private Color backgroundColor = Color.white;
    private Color pickedColor;
    private ArrayList<Canvas> canvases = new ArrayList<Canvas>();
    private JPanel colorShow = new JPanel();
    private boolean erase;

    // Constructor
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

    // Creates a selector for which draw mode to use
    private void createDrawModePicker() {
        // Creates JPanel and sets layout to grid with three columns, one for every button
        JPanel drawModePicker = new JPanel();
        drawModePicker.setLayout(new GridLayout(1,3));

        // Creates three buttons
        JButton brushButton = new JButton("Brush");
        JButton eraseButton = new JButton("Erase");
        JButton clearButton = new JButton("Clear");

        // Disables Brushbutton as it is the picked mode from the beginning and sets the boolean erase to false
        brushButton.setEnabled(false);
        erase = false;

        // Adds actionlisteners to all buttons to be able to do an action when clicked
        buttonActions(brushButton, eraseButton, clearButton);

        // Adds buttons to JPanel and add Panel to window
        drawModePicker.add(brushButton);
        drawModePicker.add(eraseButton);
        drawModePicker.add(clearButton);
        this.add(drawModePicker);
    }

    private void buttonActions(JButton brushButton, JButton eraseButton, JButton clearButton){
        brushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brushPressed(brushButton, eraseButton, clearButton);
            }
        });
        eraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                erasePressed(brushButton, eraseButton, clearButton);
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearPressed();
            }
        });
    }

    // Method that sets draw mode to brush
    private void brushPressed(JButton brushButton, JButton eraseButton, JButton clearButton){
        // Sets erase to false on each pixel in all canvases
        for (int i1 = 0; i1 < canvases.size(); i1++){
            for (int i2 = 0; i2 < canvases.get(i1).getCanvasPixels().size(); i2++){
                canvases.get(i1).getCanvasPixels().get(i2).setErase(false);
            }
        }
        // Disable button and enable all other buttons and set erase in this class to false
        brushButton.setEnabled(false);
        eraseButton.setEnabled(true);
        clearButton.setEnabled(true);
        erase = false;
    }

    // Method that sets draw mode to erase
    private void erasePressed(JButton brushButton, JButton eraseButton, JButton clearButton){
        // Sets erase to true on each pixel in all canvases
        for (int i1 = 0; i1 < canvases.size(); i1++){
            for (int i2 = 0; i2 < canvases.get(i1).getCanvasPixels().size(); i2++){
                canvases.get(i1).getCanvasPixels().get(i2).setErase(true);
            }
        }
        // Disable button and enable all other buttons and set erase in this class to true
        brushButton.setEnabled(true);
        eraseButton.setEnabled(false);
        clearButton.setEnabled(true);
        erase = true;
    }

    // Method that clears the entire canvas
    private void clearPressed(){
        // Sets each pixels background color back to the canvases background color
        for (int i1 = 0; i1 < canvases.size(); i1++){
            for (int i2 = 0; i2 < canvases.get(i1).getCanvasPixels().size(); i2++){
                canvases.get(i1).getCanvasPixels().get(i2).setBackground(canvases.get(i1).getBackgroundColor());
            }
        }
    }

    // Method that creates a color picker for brush color
    private void createColorPicker() {
        // Create panel for the different colorbuttons with gridlayout
        JPanel colors = new JPanel();
        colors.setLayout(new GridLayout(2,4, 5, 5));
        colors.setPreferredSize(new Dimension(width - 40, 45));

        // Create ColorButtons for every color
        colors.add(new ColorButton(Color.black, "Black", this, false));
        colors.add(new ColorButton(Color.white, "White", this, false));
        colors.add(new ColorButton(Color.gray, "Gray", this, false));
        colors.add(new ColorButton(Color.blue, "Blue", this, false));
        colors.add(new ColorButton(Color.green, "Green", this, false));
        colors.add(new ColorButton(Color.red, "Red", this, false));
        colors.add(new ColorButton(Color.yellow, "Yellow", this, false));
        colors.add(new ColorButton(Color.orange, "Orange", this, false));
        this.add(colors);

        // Create a color picker where the user can decide the color based on rgb inputs
        this.add(createRGBColorPicker(pickedColor));
    }

    // Creates a color picker for the background color of the canvas
    private void createBackgroundPicker() {
        // Create panel for the different colorbuttons with gridlayout
        JPanel colors = new JPanel();
        colors.setLayout(new GridLayout(1,4, 5, 5));
        colors.setPreferredSize(new Dimension(width - 40, 20));

        // Create ColorButtons for every color and sets background to true since it is a background color
        colors.add(new ColorButton(Color.white, "White", this, true));
        colors.add(new ColorButton(Color.black, "Black", this, true));
        colors.add(new ColorButton(Color.gray, "Gray", this, true));
        colors.add(new ColorButton(new Color(225,198,153), "Beige", this, true));
        this.add(colors);

        // Create a color picker where the user can decide the color based on rgb inputs
        this.add(createRGBColorPicker(backgroundColor));
    }

    // Method that returns a JPanel with inputs so that the user can input color through rgb
    private JPanel createRGBColorPicker(Color neededColor) {
        JPanel rgbPicker = new JPanel();
        rgbPicker.setLayout(new FlowLayout());
        rgbPicker.setSize(width, 50);

        // Creates three input fields for R, G and B
        rgbPicker.add(new JLabel("R"));
        JTextField r = new JTextField(3);
        rgbPicker.add(r);
        rgbPicker.add(new JLabel("G"));
        JTextField g = new JTextField(3);
        rgbPicker.add(g);
        rgbPicker.add(new JLabel("B"));
        JTextField b = new JTextField(3);
        rgbPicker.add(b);

        // Creates a button and adds an actionlistener
        JButton chooseButton = new JButton("Choose");
        chooseButton.addActionListener(new ActionListener() {
            // Methods that takes inputs from input fields and creates a color from them when button is pressed
            // Then assigns them to needed colors
            @Override
            public void actionPerformed(ActionEvent e) {
                assignRGB(neededColor, r, g, b);
            }
        });
        rgbPicker.add(chooseButton);
        return rgbPicker;
    }

    private void assignRGB(Color neededColor, JTextField r, JTextField g, JTextField b){
        try{
            Color rgbColor = new Color(Integer.parseInt(r.getText()), Integer.parseInt(g.getText()), Integer.parseInt(b.getText()));
            if (neededColor == backgroundColor){
                backgroundColor = rgbColor;
                for (int i1 = 0; i1 < canvases.size(); i1++){
                    for (int i2 = 0; i2 < canvases.get(i1).getCanvasPixels().size(); i2++){
                        canvases.get(i1).getCanvasPixels().get(i2).setBackgroundColor(rgbColor);
                    }
                }
                colorShow.setBackground(rgbColor);
            } else {
                pickedColor = rgbColor;
                for (int i1 = 0; i1 < canvases.size(); i1++){
                    canvases.get(i1).getColorShowcase().setBackground(rgbColor);
                    for (int i2 = 0; i2 < canvases.get(i1).getCanvasPixels().size(); i2++){
                        canvases.get(i1).getCanvasPixels().get(i2).setPickedColor(rgbColor);
                    }
                }
            }
        } catch (Exception a){
            // If inputs are invalid it messages the user
            JOptionPane.showMessageDialog(null, "Not a color");
        }

        // Resets input fields
        r.setText("");
        g.setText("");
        b.setText("");
    }

    // Creates the canvas window
    private void createCanvas(){
        JPanel create = new JPanel();
        create.setLayout(new FlowLayout());

        // Adds button to create a new canvas and an actionlistener to the button
        JButton createCanvasButton = new JButton("Create canvas");
        createCanvasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCanvasWindow();
            }
        });

        // Creates a JPanel with same background as canvas background to show what color is picked
        create.add(new JLabel("Color:"));
        colorShow.setPreferredSize(new Dimension(50, 20));

        // Adds button and JPanel to window
        create.add(colorShow);
        create.add(createCanvasButton);
        this.add(create);
    }

    // Methods that creates an instance of the class Canvas
    private void createCanvasWindow(){
        Canvas canvas = new Canvas(backgroundColor);
        // Sets all the pictures to the same erase as the window erase
        for (int i = 0; i < canvas.getCanvasPixels().size(); i++){
            canvas.getCanvasPixels().get(i).setErase(erase);
        }
        // Adds the new canvas to Arraylist canvas
        canvases.add(canvas);
    }

    // Getters and Setters
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setPickedColor(Color pickedColor) {
        this.pickedColor = pickedColor;
    }

    public ArrayList<Canvas> getCanvases() {
        return canvases;
    }

    public JPanel getColorShow() {
        return colorShow;
    }
}
