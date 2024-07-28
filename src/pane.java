import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class pane extends JPanel implements ActionListener {

    private static final int INITIAL_SECONDS = 60;

    private static final JLabel pointsEarned = new JLabel("" + game.score);

    private static final JLabel separator = new JLabel("\\\\\\\\\\\\\\\\\\\\\\\\\\\t\t\t\t");

    private static final JLabel timeRemains = new JLabel();
    private int seconds = INITIAL_SECONDS;

    private final Timer timer = new Timer(1000, this);

    public pane() {
        JLabel points = new JLabel("Points: ");

        points.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        pointsEarned.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        timeRemains.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));

        add(points);
        add(pointsEarned);

        separator.setForeground(new Color(255, 255, 255, 0));
        add(separator);

        add(timeRemains);

        ActionListener delayer = e -> timer.start();
        Timer delay = new Timer(5000, delayer);
        delay.setRepeats(false);  // Execute only once
        delay.start();
    }

    static public void updatePoints() {
        pointsEarned.setText("" + game.score);
    }

    private void updateTimerLabel() {
        SwingUtilities.invokeLater(() -> timeRemains.setText(formatTime(seconds)));
    }

    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return String.format("Time: %02d:%02d", minutes, remainingSeconds);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (seconds > 0) {
            seconds--;
            updateTimerLabel();
        }
        else {
            timer.stop();
            JOptionPane.showMessageDialog(null, "Game Over!\n");
            System.exit(0);
        }
    }
}