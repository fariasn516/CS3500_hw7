package cs3500.threetrios.view;

import cs3500.threetrios.controller.Controller;

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
  void addClickListener(Controller listener);

  /**
   * Make the view visible to start the game session.
   */
  void makeVisible();
}
