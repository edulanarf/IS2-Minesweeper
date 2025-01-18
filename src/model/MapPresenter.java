package model;

import Swing.MapDisplay;

import java.util.Timer;
import java.util.TimerTask;

public class MapPresenter {
    private SquareMap square;
    private final MapDisplay mapDisplay;
    private final MapSimulate mapSimulate;

    public MapPresenter(SquareMap square, MapDisplay mapDisplay, MapSimulate mapSimulate) {
        this.square = square;
        this.mapDisplay = mapDisplay;
        this.mapSimulate = mapSimulate;
    }

    public void execute(){
        new Timer().schedule(simulateTask(),1,1);
    }

    private TimerTask simulateTask() {
        return new TimerTask() {
            @Override
            public void run() {
                simulate();
            }
        };
    }

    private void simulate() {
        this.mapDisplay.clear();
        mapSimulate.Simulate();
        this.mapDisplay.drawSquare(square.color(),square.centerSquareX(),square.centerSquareY(),square.l());
    }
}
