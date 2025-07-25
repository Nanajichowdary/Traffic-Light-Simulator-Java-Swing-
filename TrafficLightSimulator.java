import javax.swing.*;
import java.awt.*;

public class TrafficLightSimulator extends JFrame {

    private Color redColor = Color.GRAY;
    private Color yellowColor = Color.GRAY;
    private Color greenColor = Color.GRAY;

    public TrafficLightSimulator() {
        setTitle("Traffic Light Simulator");
        setSize(300, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Start the traffic light thread
        new Thread(this::startSimulation).start();
    }

    private void startSimulation() {
        while (true) {
            try {
                redColor = Color.RED;
                yellowColor = Color.GRAY;
                greenColor = Color.GRAY;
                repaint();
                Thread.sleep(30000);

                redColor = Color.GRAY;
                yellowColor = Color.YELLOW;
                greenColor = Color.GRAY;
                repaint();
                Thread.sleep(10000);

                redColor = Color.GRAY;
                yellowColor = Color.GRAY;
                greenColor = Color.GREEN;
                repaint();
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(100, 100, 100, 300);

        g.setColor(redColor);
        g.fillOval(125, 120, 50, 50);

        g.setColor(yellowColor);
        g.fillOval(125, 200, 50, 50);

        g.setColor(greenColor);
        g.fillOval(125, 280, 50, 50);
    }

    public static void main(String[] args) {
        new TrafficLightSimulator();
    }
}
