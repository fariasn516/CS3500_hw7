package cs3500.threetrios.view;

import cs3500.threetrios.controller.Controller;
import cs3500.threetrios.controller.PlayerController;
import cs3500.threetrios.model.player.Player;

/**
 * Represents the frame of the gui graphics, this is where all the actual graphics of the game will
 * be put onto.
 */
public interface ThreeTriosFrameView {
  /**
   * Refresh the view to reflect any changes in the game state.
   */
  void refresh();

  /**
   * Helps with handling of clicking onto the GUI.
   */
  void addClickListener(PlayerAction listener);

  /**
   * Make the view visible to start the game session.
   */
  void makeVisible();

  /**
   *
   * @param message
   */
  void showMessage(String message);
}
