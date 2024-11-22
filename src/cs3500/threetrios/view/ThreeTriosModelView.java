package cs3500.threetrios.view;

import javax.swing.*;

import cs3500.threetrios.controller.Controller;
import cs3500.threetrios.controller.PlayerController;
import cs3500.threetrios.model.Color;
import cs3500.threetrios.model.ReadOnlyModel;
import cs3500.threetrios.model.ThreeTriosModel;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * The frame of the Three Trios game. This is the general frame and graphics will be placed on it
 * through the panel.
 */
public class ThreeTriosModelView extends JFrame implements ThreeTriosFrameView {
  private final ThreeTriosPanel panel; // represents the actual images to be placed on the frame
  private final ReadOnlyModel model;
  private final Color color;

  /**
   * Constructor for the ThreeTriosModelView. Takes in a model whose game state will be represented
   * through the graphics.
   * @param model represents the model whose game state is to be represented through the GUI
   */
  public ThreeTriosModelView(ReadOnlyModel model, Color color) {
    this.panel = new ThreeTriosPanel(model, color.toString());
    // represents the model whose game state is to be represented
    this.setSize(1000, 1000);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.add(panel);
    this.model = model;
    this.color = color;
  }

  @Override
  public void refresh() {
    this.setTitle(color.toString() + " " + panel.getName());
    this.repaint();
  }

  @Override
  public void addClickListener(PlayerAction listener) {
    panel.addClickListener(listener);
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
    this.setTitle(color.toString() + " " + panel.getName());
  }

  @Override
  public void showMessage(String message) {
    if (this.model.isGameOver()) {
      JOptionPane.showMessageDialog(
              this, message, "Game Over!", JOptionPane.PLAIN_MESSAGE);
    }
    else {
      JOptionPane.showMessageDialog(
              this, message, "Alert", JOptionPane.ERROR_MESSAGE);
    }
  }
}
