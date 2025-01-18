package model;

import java.util.*;

public class CreateMap {
    private final int numberOfSquares;

    public CreateMap(int numberOfSquares) {
        this.numberOfSquares = numberOfSquares;
    }


    public List<Integer> createMapWithBombs(List<Integer> mapEmpty, int x, int y){
        List<Integer> map = createMapWithBombsOf(mapEmpty, getMapIndex(x,y));
        return map;

    }

    public List<Integer> createMapEmpty(){
        List<Integer> map = new ArrayList<>();
        if (numberOfSquares==81){
            for (int i = 0; i < numberOfSquares; i++) {
                map.add(0);
            }

        }
        return map;
    }

    private List<Integer> createMapWithBombsOf(List<Integer> map, int i) {
        if (numberOfSquares == 81) {
            int totalBombs = 10;
            Random rand = new Random();
            int bombsPlaced = 0;


            placeBombs(numberOfSquares, bombsPlaced, totalBombs, rand, map, i);
        }

        onConsoleShow(map);
        return map;
    }

    private void placeBombs(int numberOfSquares, int bombsPlaced, int totalBombs, Random rand, List<Integer> map, int selectedIndex) {
        int row = selectedIndex / 9;
        int col = selectedIndex % 9;
        int minExclusionSize = rand.nextInt(2) + 3;
        int maxExclusionSize = rand.nextInt(2) + 5;
        int exclusionSize = rand.nextInt(maxExclusionSize - minExclusionSize + 1) + minExclusionSize;
        Set<Integer> invalidCells = new HashSet<>();
        exclusionRange(exclusionSize, row, col, invalidCells);

        placeAllBombs(numberOfSquares, bombsPlaced, totalBombs, rand, map, invalidCells);
    }

    private static void exclusionRange(int exclusionSize, int row, int col, Set<Integer> invalidCells) {
        for (int dr = -exclusionSize / 2; dr <= exclusionSize / 2; dr++) {
            for (int dc = -exclusionSize / 2; dc <= exclusionSize / 2; dc++) {
                int newRow = row + dr;
                int newCol = col + dc;
                if (newRow >= 0 && newRow < 9 && newCol >= 0 && newCol < 9) {
                    int neighborIndex = newRow * 9 + newCol;
                    invalidCells.add(neighborIndex);
                }
            }
        }
    }

    private void placeAllBombs(int numberOfSquares, int bombsPlaced, int totalBombs, Random rand, List<Integer> map, Set<Integer> invalidCells) {
        while (bombsPlaced < totalBombs) {
            int index = rand.nextInt(numberOfSquares);
            if (map.get(index) == 0 && !invalidCells.contains(index)) {
                map.set(index, -1);
                int bombRow = index / 9;
                int bombCol = index % 9;

                updateAdjacentCells(map, bombRow, bombCol);
                bombsPlaced++;
            }
        }
    }

    private static void onConsoleShow(List<Integer> map) {
        for (int i = 0; i < map.size(); i++) {
            System.out.printf("%3d", map.get(i));
            if ((i + 1) % 9 == 0) {
                System.out.println();
            }
        }
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

    public int getMapIndex(int x, int y) {
        int cellWidth = 70;
        int cellHeight = 70;
        int numCols = 9;
        int j = x / cellWidth;
        int i = y / cellHeight;

        if (i < 0 || i >= numCols || j < 0 || j >= numCols) {
            return -1;
        }
        return i * numCols + j;
    }


}
