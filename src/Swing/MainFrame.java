package Swing;

import model.MapPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame{
    private MapDisplay mapDisplay;
    private MapPresenter presenter;
    public MainFrame(){
        this.setTitle("Mine Sweeper");
        this.setSize(650,675);
        this.setLocationRelativeTo(null);
        this.add(createImageDisplayMap());


        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleClick(e);
            }
        });
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void handleClick(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        presenter.handleClick(x, y);
    }

    private Component createImageDisplayMap() {
        SwingMapDisplay display = new SwingMapDisplay();
        this.mapDisplay = display;
        return display;
    }

    public MapDisplay getMapDisplay(){
        return mapDisplay;
    }


    public void setPresenter(MapPresenter presenter) {
        this.presenter = presenter;
    }
}
