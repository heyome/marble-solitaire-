package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * to represent the interface for controller.
 */

public interface MarbleSolitaireController {
  
  /**
   * run the Marble Solitaire game and play it.
   *
   * @param model input the Marble Solitaire Model to play.
   */
  void playGame(MarbleSolitaireModel model) throws IllegalStateException;
  
}
