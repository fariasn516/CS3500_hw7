package cs3500.threetrios;

import java.util.List;

import cs3500.threetrios.controller.Controller;
import cs3500.threetrios.controller.PlayerController;
import cs3500.threetrios.controller.ThreeTriosPlayerController;
import cs3500.threetrios.controller.ThreeTriosSwingController;
import cs3500.threetrios.model.Card;
import cs3500.threetrios.model.GameGrid;
import cs3500.threetrios.model.Grid;
import cs3500.threetrios.model.Model;
import cs3500.threetrios.model.SimpleCard;
import cs3500.threetrios.model.ThreeTriosModel;
import cs3500.threetrios.model.Value;
import cs3500.threetrios.model.player.HumanPlayer;
import cs3500.threetrios.model.player.Player;
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
    Card ratCard = new SimpleCard("rat", Value.ACE, Value.ONE, Value.TWO, Value.THREE);
    Card oxCard = new SimpleCard("ox", Value.ACE, Value.ONE, Value.TWO, Value.THREE);
    Card tigerCard = new SimpleCard("tiger", Value.TWO, Value.ONE, Value.FIVE, Value.SIX);
    Card rabbitCard = new SimpleCard("rabbit", Value.FOUR, Value.NINE, Value.ACE, Value.THREE);
    Card dragonCard = new SimpleCard("dragon", Value.ACE, Value.ACE, Value.TWO, Value.ONE);
    Card horseCard = new SimpleCard("horse", Value.TWO, Value.EIGHT, Value.TWO, Value.THREE);
    Card goatCard = new SimpleCard("goat", Value.ACE, Value.SIX, Value.FOUR, Value.SEVEN);
    Card monkeyCard = new SimpleCard("monkey", Value.ACE, Value.ACE, Value.ACE, Value.ACE);

    List<Card> deck = List.of(ratCard, oxCard, tigerCard, rabbitCard, dragonCard, horseCard,
            goatCard, monkeyCard);

    //Model model = new ThreeTriosModel();

    boolean[][] hasAHole = {
            {false, false, false},
            {false, true, true},
            {false, false, false}
    };
    Grid gridWithNoHoles = new GameGrid(3, 3, hasAHole);

    /*ThreeTriosFrameView view = new ThreeTriosModelView(model);
    Controller controller = new ThreeTriosSwingController(view);
    controller.playGame(model, deck, gridWithNoHoles, false);
    model.takeTurn(ratCard, 0, 0);
    model.takeTurn(oxCard, 1, 0);
    model.takeTurn(tigerCard, 2, 2);*/

    Model model = new ThreeTriosModel();
    ThreeTriosFrameView viewPlayer1 = new ThreeTriosModelView(model);
    ThreeTriosFrameView viewPlayer2 = new ThreeTriosModelView(model);
    Player player1 = new HumanPlayer(model);
    Player player2 = new HumanPlayer(model);
    PlayerController controller1 = new ThreeTriosPlayerController(model, player1, viewPlayer1);
    controller1.startGame("configurationFiles/GridConfiguration/HasHoles",
            "configurationFiles/CardConfiguration/MaxCards", false);
    PlayerController controller2 = new ThreeTriosPlayerController(model, player2, viewPlayer2);
    controller2.startGame("configurationFiles/GridConfiguration/HasHoles",
            "configurationFiles/CardConfiguration/MaxCards", false);
  }
}
