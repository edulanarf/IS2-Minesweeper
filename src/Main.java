import Swing.MainFrame;
import model.MapPresenter;
import model.MapSimulate;
import model.SquareMap;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        int numberOfSquares = 81; //Dificultad Facil
        SquareMap square = new SquareMap(Color.GREEN,200,-200, 20);
        new MapPresenter(square, frame.getMapDisplay(),new MapSimulate(numberOfSquares)).execute();
        frame.setVisible(true);
    }
}
