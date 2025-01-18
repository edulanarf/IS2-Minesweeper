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

                    int row = index / 9;
                    int col = index % 9;

                    updateAdjacentCells(map, row, col);
                    bombsPlaced++;
                }
            }
        }

        for (int i = 0; i < map.size(); i++) {
            System.out.printf("%3d", map.get(i));
            if ((i + 1) % 9 == 0) {
                System.out.println();
            }
        }
        return map;
    }

    private void updateAdjacentCells(List<Integer> map, int row, int col) {
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                int newRow = row + dr;
                int newCol = col + dc;
                if (newRow >= 0 && newRow < 9 && newCol >= 0 && newCol < 9) {
                    int neighborIndex = newRow * 9 + newCol;
                    if (map.get(neighborIndex) != -1) {
                        map.set(neighborIndex, map.get(neighborIndex) + 1);
                    }
                }
            }
        }
    }


}
