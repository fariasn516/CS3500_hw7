package cs3500.threetrios.controller;

import cs3500.threetrios.model.ModelStatus;
import cs3500.threetrios.view.PlayerAction;

/**
 *
 */
public interface PlayerController extends PlayerAction, ModelStatus {
  /**
   *
   * @param gridPath
   * @param deckPath
   * @param shuffle
   */
  void startGame(String gridPath, String deckPath, boolean shuffle);
}
