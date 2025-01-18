package model;

import Swing.MapDisplay;

import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

public class MapPresenter {
    private final MapDisplay mapDisplay;
    private final List<Integer> map;

    public MapPresenter(MapDisplay mapDisplay, CreateMap createMap) {
        this.mapDisplay = mapDisplay;
        map = createMap.create();
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
        System.out.println(map);
        this.mapDisplay.drawMap(map);
    }
}
