import java.util.ArrayList;
import java.util.List;
import java.awt.Point;
import java.awt.Color;


public abstract class Scene {
    public double gravity = 80000;
    public Sprite spaceShip;
    public List<Planet> planets;
    public List<Point> stars;
    public abstract void reset();
    public Scene () {
        reset();
    }

    public static Scene[] allScenes() {
        Scene[] scenes = { new Level1(), new Level2() };
        return scenes;
    }
}

class Level1 extends Scene {
    public void reset() {
        spaceShip = new Sprite(300, 300, 0);
        planets = new ArrayList<Planet>();
        planets.add(new Planet(0, 0, 200, Color.green));
        planets.add(new Planet(740, 500, 50, Color.red));
        planets.add(new Planet(900, 500, 100));
        planets.add(new Planet(300, 600, 100));
        stars = new ArrayList<Point>();
        stars.add(new Point(400, 500));
        stars.add(new Point(550, 530));
        stars.add(new Point(700, 230));
        stars.add(new Point(1300, 430));
    }
}

class Level2 extends Scene {
    public void reset() {
        // spaceShip = new Sprite(500, 500, 0);
        // planets = new ArrayList<Planet>();
        // planets.add(new Planet(900, 900, 50));
        spaceShip = new Sprite(300, 300, 0);
        planets = new ArrayList<Planet>();
        planets.add(new Planet(670, 500, 50, Color.red));
        planets.add(new Planet(900, 500, 100));
        planets.add(new Planet(20, 40, 30));
        planets.add(new Planet(900, 900, 50));
        planets.add(new Planet(650, 850, 70));
        planets.add(new Planet(1200, 700, 50));
        stars = new ArrayList<Point>();
        stars.add(new Point(200, 200));
        stars.add(new Point(700, 560));
        stars.add(new Point(800, 700));
        stars.add(new Point(1000, 760));
    }
}