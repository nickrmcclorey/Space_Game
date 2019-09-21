import java.util.ArrayList;
import java.util.List;
import java.awt.Color;


public class Scene {
    public double gravity = 80000;
    public Sprite spaceShip;
    public List<Planet> planets;

    public Scene(Sprite ship, List<Planet> planetList) {
        spaceShip = ship;
        planets = planetList;
    }

    public static Scene scene1() {
        Sprite spaceShip = new Sprite(300, 300, 0);
        List<Planet> planets = new ArrayList<Planet>();
        planets.add(new Planet(0, 0, 200, Color.green));
        planets.add(new Planet(800, 500, 50, Color.red));
        planets.add(new Planet(900, 500, 100));
        planets.add(new Planet(300, 600, 100));
        return new Scene(spaceShip, planets);
    }
}