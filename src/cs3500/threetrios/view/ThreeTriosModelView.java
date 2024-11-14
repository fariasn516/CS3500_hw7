package cs3500.threetrios.view;

import javax.swing.JFrame;

import cs3500.threetrios.controller.Controller;
import cs3500.threetrios.model.ReadOnlyModel;

/**
 * The frame of the Three Trios game. This is the general frame and graphics will be placed on it
 * through the panel.
 */
public class ThreeTriosModelView extends JFrame implements ThreeTriosFrameView {
  private final ThreeTriosPanel panel; // represents the actual images to be placed on the frame

  /**
   * Constructor for the ThreeTriosModelView. Takes in a model whose game state will be represented
   * through the graphics.
   * @param model represents the model whose game state is to be represented through the GUI
   */
  public ThreeTriosModelView(ReadOnlyModel model) {
    this.panel = new ThreeTriosPanel(model);
    // represents the model whose game state is to be represented
    this.setSize(1000, 1000);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.add(panel);
  }

  @Override
  public void refresh() {
    this.setTitle(panel.getName());
    this.repaint();
  }

  @Override
  public void addClickListener(Controller listener) {
    panel.addClickListener(listener);
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }
}
