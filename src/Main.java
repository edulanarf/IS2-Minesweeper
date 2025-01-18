import Swing.MainFrame;
import model.MapPresenter;
import model.CreateMap;
import model.SquareMap;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        int numberOfSquares = 81; //Dificultad Facil
        new MapPresenter(frame.getMapDisplay(),new CreateMap(numberOfSquares)).execute();
        frame.setVisible(true);
    }
}
