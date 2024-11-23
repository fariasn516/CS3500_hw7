package cs3500.threetrios;

import java.util.List;

import cs3500.threetrios.controller.Controller;
import cs3500.threetrios.controller.PlayerController;
import cs3500.threetrios.controller.ThreeTriosPlayerController;
import cs3500.threetrios.controller.ThreeTriosSwingController;
import cs3500.threetrios.model.Card;
import cs3500.threetrios.model.Color;
import cs3500.threetrios.model.GameGrid;
import cs3500.threetrios.model.Grid;
import cs3500.threetrios.model.Model;
import cs3500.threetrios.model.SimpleCard;
import cs3500.threetrios.model.ThreeTriosModel;
import cs3500.threetrios.model.Value;
import cs3500.threetrios.model.player.AIPlayer;
import cs3500.threetrios.model.player.HumanPlayer;
import cs3500.threetrios.model.player.Player;
import cs3500.threetrios.strategy.CornerCardStrat;
import cs3500.threetrios.strategy.GameStrategy;
import cs3500.threetrios.strategy.MaxFlippedCardsStrat;
import cs3500.threetrios.view.PlayerAction;
import cs3500.threetrios.view.ThreeTriosFrameView;
import cs3500.threetrios.view.ThreeTriosModelView;

/**
 * Main class where once run, the game ThreeTrios can be played.
 */
public class Main {

  /**
   * Method where the game can be run.
   * @param args represents a String of inputs from the console
   */
  public static void main(String[] args) {
    Model model = new ThreeTriosModel();
    ThreeTriosFrameView viewPlayer1 = new ThreeTriosModelView(model, Color.RED);
    ThreeTriosFrameView viewPlayer2 = new ThreeTriosModelView(model, Color.BLUE);
    Player player1 = new HumanPlayer(model, Color.RED);
    Player player2 = new AIPlayer(model, Color.BLUE, new MaxFlippedCardsStrat());
    PlayerController controller1 = new ThreeTriosPlayerController(model, player1, viewPlayer1);
    controller1.startGame("configurationFiles/GridConfiguration/HasHoles",
            "configurationFiles/CardConfiguration/MaxCards", false);
    PlayerController controller2 = new ThreeTriosPlayerController(model, player2, viewPlayer2);
    controller2.startGame("configurationFiles/GridConfiguration/HasHoles",
            "configurationFiles/CardConfiguration/MaxCards", false);
  }

}
