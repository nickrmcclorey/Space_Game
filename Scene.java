import java.util.ArrayList;
import java.util.List;


public class Scene {
    Sprite spaceShip;
    public List<Planet> planets;

    public Scene() {
        spaceShip = new Sprite(800, 400, 0, 0, 0);
        planets = new ArrayList<Planet>();
        planets.add(new Planet(100, 200, 100));
        planets.add(new Planet(500, 600, 200));
    }
}