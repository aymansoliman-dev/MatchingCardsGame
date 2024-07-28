import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CardClickListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        card clickedCard = (card) e.getSource();


        // Modify This Logic
        // Modified Logic
        if (game.firstClickedCard == null) {
            // First click
            game.firstClickedCard = clickedCard;
        }
        else if (game.firstClickedCard != clickedCard) {
            // Second click on a different card
            game.secondClickedCard = clickedCard;

            if (game.secondClickedCard.isFaceUp()) {
                // If the second card is face up, flip it
                clickedCard.flip();
            }

            // Check for a match
            card.checkMatch(game.firstClickedCard, game.secondClickedCard);

            // Reset clicked cards for the next pair of clicks
            game.firstClickedCard = null;
            game.secondClickedCard = null;

        }
        else {
            // Same card clicked again, do nothing and reset the firstClickedCard
            game.firstClickedCard = null;
        }

        // Modify This Logic
    }
}
