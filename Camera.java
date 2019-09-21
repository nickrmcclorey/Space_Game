import java.awt.Graphics;
import javax.swing.JPanel;

public class Camera extends JPanel {
    int xOffset = 0;
    int yOffset = 0;
    int zoom = 1;
    Scene scene;


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int k = 0; k < scene.planets.size(); k++) {
            Planet planet = scene.planets.get(k);
            int x = planet.xPosition + xOffset;
            int y = planet.yPosition + yOffset;
            int radius = planet.radius * zoom;
            g.fillOval(x, y, radius, radius);
        }

        g.drawPolygon(scene.spaceShip.polygon());
    }

    public Camera(Scene scene) {
        this.scene = scene;
    }
}