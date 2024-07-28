import javax.swing.*;
import java.awt.*;

public class card extends JButton {

    private final String imageName;
    private boolean isFaceUp;
    private boolean isClickable;

    public card(String text, ImageIcon icon) {
        super(text, icon);
        this.imageName = text; // Assuming the text serves as the image name
        this.isFaceUp = false;
        this.isClickable = true;  // Initialize as clickable
        setForeground(new Color(255, 255, 255, 0));
        // Make the text component transparent
        setOpaque(false);
        addActionListener(e -> flip()); // ActionListener to flip the card on button click
    }

    { setText(""); }

    public boolean isMatch(card otherCard) {
        return this.imageName.equals(otherCard.imageName);
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        if (faceUp) {
            isFaceUp = false;
            updateAppearance();
        }
    }

    public void flip() {
        isFaceUp = !isFaceUp;
        updateAppearance();
    }

    public void updateAppearance() {
        if (isFaceUp) {
            setIcon(new ImageIcon(imageName)); // Display the front of the card
        } else {
            setIcon(new ImageIcon("images/unknown (Custom).png")); // Display the back of the card (null icon or set a default back image)
        }
    }

    public static void checkMatch(card card1, card card2) {
        card2.flip();
        if (!card1.isMatch(card2)) {
            // Cards do not match, show dialog and flip them back
            JOptionPane.showMessageDialog(null, "Cards do not match! Try again.");
            card1.flip();
            card1.setClickable(true);
            card2.setClickable(true);
        }
        else if (card1.isMatch(card2)) {
            game.score++;
            JOptionPane.showMessageDialog(null, "Match!");

            card2.setText(null);
            card2.setIcon(new ImageIcon(card2.imageName));
            card1.setEnabled(false);
            card2.setEnabled(false);
            card2.setFaceUp(true);

            pane.updatePoints();
        }
        else if (card1 == card2) {
            game.firstClickedCard = null;
            game.secondClickedCard = null;
            card1.flip();
            return;
        }
    }

    public void setClickable(boolean clickable) {
        this.isClickable = clickable;
    }

}
