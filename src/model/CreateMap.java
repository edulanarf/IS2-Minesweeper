package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateMap {
    private final int numberOfSquares;

    public CreateMap(int numberOfSquares) {
        this.numberOfSquares = numberOfSquares;
    }


    public List<Integer> create(){
        List<Integer> map = createMapOf(numberOfSquares);
        return map;

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
        for (int i = 0; i < map.size(); i++) {
            System.out.printf("%3d", map.get(i)); // Cada número ocupa 3 caracteres
            if ((i + 1) % 9 == 0) { // Cada 9 números, cambia de línea
                System.out.println();
            }
        }
        return map;
    }


}
