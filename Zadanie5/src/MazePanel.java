import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazePanel extends JPanel {
    private CardLayout cardLayout;
    private MazeGame mazeGame;
    private JPanel startScreen;
    private JPanel endScreen;
    private RoomPanel[][] rooms;
    private Timer timer;
    private int timeLeft;
    private final int[][] maze = {
        {10, 8, 10, 9},
        {28, 1, 0, 12},
        {12, 10, 9, 13},
        {6, 5, 6, 5}
    };

    public MazePanel(MazeGame mazeGame) {
        this.mazeGame = mazeGame;
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        startScreen = createStartScreen();
        endScreen = createEndScreen();

        add(startScreen, "StartScreen");
        add(endScreen, "EndScreen");

        rooms = new RoomPanel[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                rooms[i][j] = new RoomPanel(mazeGame, maze, i, j);
                add(rooms[i][j], "Room" + i + "," + j);
            }
        }
    }

    private JPanel createStartScreen() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("Maze Game", JLabel.CENTER);
        panel.add(label, BorderLayout.CENTER);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            timeLeft = 15;
            startTimer();
            mazeGame.showRoomPanel(0, 0);
        });
        panel.add(startButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createEndScreen() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("", JLabel.CENTER);
        label.setName("EndLabel");
        panel.add(label, BorderLayout.CENTER);

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> mazeGame.showStartScreen());
        panel.add(restartButton, BorderLayout.SOUTH);

        return panel;
    }

    public void showStartScreen() {
        cardLayout.show(this, "StartScreen");
        if (timer != null) {
            timer.stop();
        }
    }

    public void showRoomPanel(int x, int y) {
        cardLayout.show(this, "Room" + x + "," + y);
    }

    public void showEndScreen(boolean won) {
        JLabel label = (JLabel) ((JPanel) endScreen).getComponent(0);
        label.setText(won ? "You Win!" : "Time's up! You Lose!");
        cardLayout.show(this, "EndScreen");
        if (timer != null) {
            timer.stop();
        }
    }

    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                if (timeLeft <= 0) {
                    timer.stop();
                    mazeGame.showEndScreen(false);
                }
            }
        });
        timer.start();
    }
}
