package Swing;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class SwingMapDisplay extends JPanel implements MapDisplay {
    private final List<Paint> paints = new ArrayList<>();

    @Override
    public void drawSquare(Color color, int centerSquareX, int centerSquareY, int l) {
        synchronized (paints) {
            paints.add(new Paint(color, centerSquareX, centerSquareY, l));
        }
        repaint();
    }

    @Override
    public void clear() {
        synchronized (paints){
            paints.clear();
        }
        repaint();
    }

    private record Paint(Color color, int centerSquareX, int centerSquareY, int l){}
}
