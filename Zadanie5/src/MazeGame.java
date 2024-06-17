import javax.swing.*;
import java.awt.*;

public class MazeGame extends JFrame {
    private MazePanel mazePanel;
    
    public MazeGame() {
        setTitle("Maze Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mazePanel = new MazePanel(this);
        add(mazePanel);

        showStartScreen();
    }

    public void showStartScreen() {
        mazePanel.showStartScreen();
    }

    public void showRoomPanel(int x, int y) {
        mazePanel.showRoomPanel(x, y);
    }

    public void showEndScreen(boolean won) {
        mazePanel.showEndScreen(won);
    }
}
