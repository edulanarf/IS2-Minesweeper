package Swing;

import java.util.List;
import java.util.Set;

public interface MapDisplay {
    void drawMap(List<Integer> map, Set<Integer> invalidCells);
    void clear();
}
