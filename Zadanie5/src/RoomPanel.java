import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomPanel extends JPanel {
    private MazeGame mazeGame;
    private int[][] maze;
    private int x, y;

    public RoomPanel(MazeGame mazeGame, int[][] maze, int x, int y) {
        this.mazeGame = mazeGame;
        this.maze = maze;
        this.x = x;
        this.y = y;

        setLayout(new BorderLayout());
        JLabel label = new JLabel("Room (" + x + ", " + y + ")", JLabel.CENTER);
        add(label, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 3));
        add(buttonPanel, BorderLayout.SOUTH);

        JButton leftButton = new JButton("Left");
        JButton rightButton = new JButton("Right");
        JButton upButton = new JButton("Up");
        JButton downButton = new JButton("Down");

        leftButton.addActionListener(e -> moveLeft());
        rightButton.addActionListener(e -> moveRight());
        upButton.addActionListener(e -> moveUp());
        downButton.addActionListener(e -> moveDown());

        buttonPanel.add(new JLabel());
        buttonPanel.add(upButton);
        buttonPanel.add(new JLabel());
        buttonPanel.add(leftButton);
        buttonPanel.add(new JLabel());
        buttonPanel.add(rightButton);
        buttonPanel.add(new JLabel());
        buttonPanel.add(downButton);
        buttonPanel.add(new JLabel());

        updateButtons();
    }

    private void updateButtons() {
        int value = maze[x][y];
        Component[] components = ((JPanel) getComponent(1)).getComponents();
        components[1].setEnabled((value & 4) != 0); // Up
        components[3].setEnabled((value & 1) != 0); // Left
        components[5].setEnabled((value & 2) != 0); // Right
        components[7].setEnabled((value & 8) != 0); // Down
    }

    private void moveLeft() {
        if ((maze[x][y] & 1) != 0) {
            mazeGame.showRoomPanel(x, y - 1);
            checkForWin(x, y - 1);
        }
    }

    private void moveRight() {
        if ((maze[x][y] & 2) != 0) {
            mazeGame.showRoomPanel(x, y + 1);
            checkForWin(x, y + 1);
        }
    }

    private void moveUp() {
        if ((maze[x][y] & 4) != 0) {
            mazeGame.showRoomPanel(x - 1, y);
            checkForWin(x - 1, y);
        }
    }

    private void moveDown() {
        if ((maze[x][y] & 8) != 0) {
            mazeGame.showRoomPanel(x + 1, y);
            checkForWin(x + 1, y);
        }
    }

    private void checkForWin(int newX, int newY) {
        if (maze[newX][newY] == 0) {
            mazeGame.showEndScreen(true);
        }
    }
}
