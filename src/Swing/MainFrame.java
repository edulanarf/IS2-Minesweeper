package Swing;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private MapDisplay mapDisplay;
    public MainFrame(){
        this.setTitle("Mine Sweeper");
        this.setSize(1000,800);
        this.setLocationRelativeTo(null);
        this.add(createImageDisplayMap());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private Component createImageDisplayMap() {
        SwingMapDisplay display = new SwingMapDisplay();
        this.mapDisplay = display;
        return display;
    }

    public MapDisplay getMapDisplay(){
        return mapDisplay;
    }

}
