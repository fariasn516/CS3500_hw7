package cs3500.threetrios.controller;

import java.io.IOException;
import java.util.List;

import cs3500.threetrios.model.Card;
import cs3500.threetrios.model.CardFileParser;
import cs3500.threetrios.model.Color;
import cs3500.threetrios.model.Grid;
import cs3500.threetrios.model.GridFileParser;
import cs3500.threetrios.model.Model;
import cs3500.threetrios.model.player.Player;
import cs3500.threetrios.view.ThreeTriosFrameView;

/**
 *
 */
public class ThreeTriosPlayerController implements PlayerController {
  Model model; // represents the model where all the rules of ThreeTrios is being run
  Player player; // represent the player that is playing the game
  ThreeTriosFrameView view; // represents the view that shows the game state as a GUI
  Card selectedCard; // represents the card that is currently selected

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

  @Override
  public void placeCard (int row, int col) {
    if (this.selectedCard != null) {
      try {
        this.model.takeTurn(this.selectedCard, row, col);
      }
      catch (IllegalArgumentException | IllegalStateException e) {
        this.view.showMessage(e.getMessage());
      }
    }

    this.view.refresh();
  }

  @Override
  public void onCardSelected(Card card, boolean selected) {
    if (this.selectedCard != card) {
      this.selectedCard = card;
    }
    else {
      this.selectedCard = null;
    }
    view.refresh();
  }

  @Override
  public void notifyStatus() {
    if (this.model.isGameOver()) {
      if (this.model.winner().equals("Tie")) {
        this.view.showMessage("This game is a tie!");
      }
      else {
        if (this.model.winner().equals("Red Player")) {
          this.view.showMessage(this.model.winner() + " has won!\n" + "Score: " +
                  this.model.currentScore(Color.RED));
        }
        this.view.showMessage(this.model.winner() + " has won!\n" + "Score: " +
                this.model.currentScore(Color.BLUE));
      }
    }
    // might need some more stuff here(?)
    this.view.refresh();
  }

  @Override
  public void startGame(String gridPath, String deckPath, boolean shuffle) {
    Grid grid;
    List<Card> deck;
    if (!model.hasStarted()) {
      try {
        grid = new GridFileParser(gridPath).createGridFromFile();
        deck = new CardFileParser(deckPath).createDeck();
      }
      catch (IOException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
      model.startGame(deck, shuffle, grid);
    }
    view.refresh();
    view.makeVisible();
  }
}
