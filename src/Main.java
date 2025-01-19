import Swing.MainFrame;
import model.MapPresenter;
import model.CreateMap;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        int numberOfSquares = 81; //Dificultad Facil (en principio, no se debe cambiar)
        CreateMap map = new CreateMap(numberOfSquares);

        MapPresenter presenter = new MapPresenter(frame.getMapDisplay(), map);
        frame.setPresenter(presenter);

        presenter.execute();
        frame.setVisible(true);
    }
}
