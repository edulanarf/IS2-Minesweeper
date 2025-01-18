package Swing;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SwingMapDisplay extends JPanel implements MapDisplay {
    private final List<Paint> paints = new ArrayList<>();


    @Override
    public void drawMap(List<Integer> map) {
        synchronized (paints) {
            paints.clear();
            int numRows = 9;
            int numCols = 9;
            int cellWidth = 70;
            int cellHeight = 70;

            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    int index = i * numCols + j;
                    int position = map.get(index);
                    int centerX = j * cellWidth + cellWidth / 2;
                    int centerY = (i * cellHeight + cellHeight / 2);
                    if (position == -1) {
                        paints.add(new Paint(Color.RED, centerX, centerY, cellWidth));
                    } else {
                        paints.add(new Paint(Color.GREEN, centerX, centerY, cellWidth));
                    }
                }
            }
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        synchronized (paints) {
            for (Paint paint : paints) {
                int xPosition = paint.centerSquareX() - paint.l() / 2;
                int yPosition = paint.centerSquareY() - paint.l() / 2;

                g.setColor(paint.color());
                g.fillRect(xPosition, yPosition, paint.l(), paint.l());
                g.setColor(Color.BLACK);
                g.drawRect(xPosition, yPosition, paint.l(), paint.l());
            }
        }
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
