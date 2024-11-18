package cs3500.threetrios.controller;

import cs3500.threetrios.model.Model;
import cs3500.threetrios.model.player.Player;
import cs3500.threetrios.view.ThreeTriosFrameView;

// NOTE: NORMALLY I WOULD IMPLEMENT INTERFACES, BUT IM KIND OF CONFUSED ON WHAT INTERFACE TO
// IMPLEMENT AS OF RIGHT NOW, SHALL LINK LATER
/**
 *
 */
public class ThreeTriosPlayerController {
  Model model; // represents the model where all the rules of ThreeTrios is being run
  Player player; // represent the player that is playing the game
  ThreeTriosFrameView view; // represents the view that shows the game state as a GUI

  /**
   *
   * @param model
   * @param player
   * @param view
   */
  public ThreeTriosPlayerController(Model model, Player player, ThreeTriosFrameView view) {
    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null.");
    }
    if (player == null) {
      throw new IllegalArgumentException("Player cannot be null.");
    }
    if (view == null) {
      throw new IllegalArgumentException("View cannot be null.");
    }
    this.model = model;
    this.player = player;
    this.view = view;

    // wishlist(?) methods that adds itself to the features interfaces
    this.model.addListener(this);
    this.view.addClickListener(this);
    this.player.addListener(this);
  }

  public void placeCard (int row, int col, int index) {
    try {
      this.model.takeTurn(player.getCardsInHand().get(index), row, col);
    }
    catch (IllegalArgumentException | IllegalStateException e) {
      this.view.showMessage(e.getMessage());
    }

    this.view.refresh();
  }

  public void turn() {
    if (this.model.isGameOver()) {
      if (this.model.winner().equals("Tie")) {
        this.view.showMessage("This game is a tie!");
      }
      else {
        this.view.showMessage(this.model.winner() + " has won!");
      }
    }
    // might need some more stuff here(?)
    this.view.refresh();
  }
}
