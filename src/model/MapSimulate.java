package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapSimulate {
    private final int numberOfSquares;

    public MapSimulate(int numberOfSquares) {
        this.numberOfSquares = numberOfSquares;
    }


    public void Simulate(){
        List<Integer> map = createMapOf(numberOfSquares);
        System.out.println(map);

    }

    private List<Integer> createMapOf(int numberOfSquares) {
        List<Integer> map = new ArrayList<>();
        if (numberOfSquares == 81) {
            int totalBombs = 10;
            for (int i = 0; i < numberOfSquares; i++) {
                map.add(0);
            }
            Random rand = new Random();
            int bombsPlaced = 0;
            while (bombsPlaced < totalBombs) {
                int index = rand.nextInt(numberOfSquares);
                if (map.get(index) == 0) {
                    map.set(index, -1);
                    bombsPlaced++;
                }
            }
        }
        return map;
    }


}
