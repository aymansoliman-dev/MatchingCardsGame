import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class game extends JPanel implements ActionListener {

    public static card firstClickedCard; // Keep track of the first clicked card
    public static card secondClickedCard;
    public static int score;

    card card01, card02, card03, card04, card05, card06, card07, card08, card09, card10, card11, card12, card13, card14, card15, card16, card17, card18, card19, card20, card21, card22, card23, card24, card25, card26, card27, card28, card29, card30, card31, card32, card33, card34, card35, card36, card37, card38, card39, card40, card41, card42, card43, card44, card45, card46, card47, card48;


    // Buttons
    ImageIcon imageIcon01 = new ImageIcon("images/photo1.png");
    ImageIcon imageIcon02 = new ImageIcon("images/photo2.png");
    ImageIcon imageIcon03 = new ImageIcon("images/photo3.png");
    ImageIcon imageIcon04 = new ImageIcon("images/photo4.png");
    ImageIcon imageIcon05 = new ImageIcon("images/photo5.png");
    ImageIcon imageIcon06 = new ImageIcon("images/photo6.png");
    ImageIcon imageIcon07 = new ImageIcon("images/photo7.png");
    ImageIcon imageIcon08 = new ImageIcon("images/photo8.png");
    ImageIcon imageIcon09 = new ImageIcon("images/photo9.png");
    ImageIcon imageIcon10 = new ImageIcon("images/photo10.png");
    ImageIcon imageIcon11 = new ImageIcon("images/photo11.png");
    ImageIcon imageIcon12 = new ImageIcon("images/photo12.png");


    public game() {

        card01 = new card("images/photo1.png", imageIcon01);
        card02 = new card("images/photo2.png", imageIcon02);
        card03 = new card("images/photo3.png", imageIcon03);
        card04 = new card("images/photo4.png", imageIcon04);
        card05 = new card("images/photo5.png", imageIcon05);
        card06 = new card("images/photo6.png", imageIcon06);
        card07 = new card("images/photo7.png", imageIcon07);
        card08 = new card("images/photo8.png", imageIcon08);
        card09 = new card("images/photo9.png", imageIcon09);
        card10 = new card("images/photo10.png", imageIcon10);
        card11 = new card("images/photo11.png", imageIcon11);
        card12 = new card("images/photo12.png", imageIcon12);
        card13 = new card("images/photo1.png", imageIcon01);
        card14 = new card("images/photo2.png", imageIcon02);
        card15 = new card("images/photo3.png", imageIcon03);
        card16 = new card("images/photo4.png", imageIcon04);
        card17 = new card("images/photo5.png", imageIcon05);
        card18 = new card("images/photo6.png", imageIcon06);
        card19 = new card("images/photo7.png", imageIcon07);
        card20 = new card("images/photo8.png", imageIcon08);
        card21 = new card("images/photo9.png", imageIcon09);
        card22 = new card("images/photo10.png", imageIcon10);
        card23 = new card("images/photo11.png", imageIcon11);
        card24 = new card("images/photo12.png", imageIcon12);


        card[] cards = new card[]{card01, card02, card03, card04, card05, card06, card07, card08, card09, card10, card11, card12, card13, card14, card15, card16, card17, card18, card19, card20, card21, card22, card23, card24};

        List<JButton> list = Arrays.asList(cards);
        Collections.shuffle(list);

        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (card c: cards) {
                    c.updateAppearance();
                }
            }
        };

        Timer delay = new Timer(5000, taskPerformer);

        delay.start();


        for (JButton card : cards) {
            card.addActionListener(new CardClickListener());
        }

        setImage(list);


        /////////////////////////////////////////////////////////////

        setLayout(new GridLayout(4, 6, 3, 3));

        addd(list);

    }

    public void setImage(List<JButton> list) {
        for (JButton button : list) {
            button.setOpaque(false);
            button.setContentAreaFilled(false);
        }
    }

    public void addd(List<JButton> list) {
        for (JButton jButton : list) add(jButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
