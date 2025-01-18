package model;

import Swing.MapDisplay;

import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

public class MapPresenter {
    private final MapDisplay mapDisplay;
    private final CreateMap createMap;
    private List<Integer> map;
    private boolean firstClick=true;

    public MapPresenter(MapDisplay mapDisplay, CreateMap createMap) {
        this.mapDisplay = mapDisplay;
        this.createMap = createMap;
        map = createMap.createMapEmpty();
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

    private void simulate() {;
        this.mapDisplay.clear();
        this.mapDisplay.drawMap(map);
    }

    public void handleClick(int x, int y) {
        if (firstClick) {
            map = createMap.createMapWithBombs(map, x, y);
            firstClick = false;
        }
    }
}
