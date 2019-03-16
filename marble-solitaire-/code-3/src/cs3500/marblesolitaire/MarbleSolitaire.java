package cs3500.marblesolitaire;

import java.io.IOException;
import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

public class MarbleSolitaire {
  
  /**
   * use controller to play the MarbleSolitaire model.
   *
   * @param args strings as input for playing MarbleSolitaire model.
   * @throws IOException no.
   */
  public static void main(String[] args) throws IOException {
    
    //Start the game with the string "Game start: ".
    System.out.println("Game start:");
    
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(
        new InputStreamReader(System.in),
        System.out);
    
    
    boolean hasSize = false;
    boolean hasEmpty = false;
    int size = 0;
    int row = 0;
    int col = 0;
    
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-size")) {
        hasSize = true;
        try {
          size = Integer.parseInt(args[i + 1]);
        } catch (NumberFormatException e) {
          System.exit(1);
        }
      }
      if (args[i].equals("-hole")) {
        hasEmpty = true;
        try {
          row = Integer.parseInt(args[i + 1]);
          col = Integer.parseInt(args[i + 2]);
        } catch (NumberFormatException e) {
          System.exit(1);
        }
      }
    }
    
    for (String s : args) {
      if (s.equals("english")) {
        if (hasSize && hasEmpty) {
          c.playGame(new MarbleSolitaireModelImpl(size, row, col));
        } else if (hasEmpty) {
          c.playGame(new MarbleSolitaireModelImpl(row, col));
        } else if (hasSize) {
          c.playGame(new MarbleSolitaireModelImpl(size));
        } else {
          c.playGame(new MarbleSolitaireModelImpl());
        }
      }
      if (s.equals("triangular")) {
        if (hasSize && hasEmpty) {
          c.playGame(new TriangleSolitaireModelImpl(size, row, col));
        } else if (hasEmpty) {
          c.playGame(new TriangleSolitaireModelImpl(row, col));
        } else if (hasSize) {
          c.playGame(new TriangleSolitaireModelImpl(size));
        } else {
          c.playGame(new TriangleSolitaireModelImpl());
        }
      }
      if (s.equals("european")) {
        if (hasSize && hasEmpty) {
          c.playGame(new EuropeanSolitaireModelImpl(size, row, col));
        } else if (hasEmpty) {
          c.playGame(new EuropeanSolitaireModelImpl(row, col));
        } else if (hasSize) {
          c.playGame(new EuropeanSolitaireModelImpl(size));
        } else {
          c.playGame(new EuropeanSolitaireModelImpl());
        }
      }
    }
  }
}
