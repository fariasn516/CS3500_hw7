package cs3500.threetrios.controller;

public interface PlayerAction {

  /**
   * Action to take once a card is selected.
   * @param index represents the index of the selected card
   */
  void onCardSelected(int index);

  /**
   * Action to take once a cell is selected.
   * @param row represents the row of the selected cell
   * @param col represents the column of the selected cell
   */
  void onCellSelected(int row, int col);
}
