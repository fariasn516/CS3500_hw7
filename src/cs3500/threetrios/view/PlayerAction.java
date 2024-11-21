package cs3500.threetrios.view;

import cs3500.threetrios.model.Card;

/**
 * Represents the possible actions a player can take.
 */
public interface PlayerAction {

  /**
   * Action to take once a card is selected.
   * @param index represents the index of the selected card
   */
  void onCardSelected(Card card, boolean selected);

  /**
   *
   * @param row
   * @param col
   */
  void placeCard(int row, int col);
}
