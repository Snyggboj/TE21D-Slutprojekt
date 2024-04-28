import java.awt.*;

public class Settings extends Window{


    public Settings(){
        super(200, 300, "Settings");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        createBackgroundPicker();
        createColorPicker();
        createDrawModePicker();
        createCanvas();
    }

    private void createDrawModePicker() {
    }

    private void createColorPicker() {

    }

    private void createBackgroundPicker() {
        this.add(new ColorButton());
    }

    public void createCanvas(){
        new Canvas();
    }
}
