import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class MatchingCardsGame extends JFrame {


    public MatchingCardsGame() {

        pane statistics = new pane();
        statistics.setBorder(new TitledBorder("Game Panel"));
        game gamePlayground = new game();

        setLayout(new BorderLayout());
        add(statistics, BorderLayout.NORTH);
        add(gamePlayground, BorderLayout.CENTER);

    }


    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "You got 5 seconds to memorize cards. Good Luck!");
        
        MatchingCardsGame Game = new MatchingCardsGame();

        Game.setTitle("Memory Cards Game");
        Game.setSize(1000, 750);
        Game.setResizable(false);
        Game.setLocationRelativeTo(null);
        Game.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Game.setVisible(true);

    }

}
