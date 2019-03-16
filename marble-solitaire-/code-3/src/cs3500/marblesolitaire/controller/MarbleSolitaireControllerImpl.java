package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Controller for the Marble Solitaire Model to read a readable string to play the game
 * by given certain game model.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  
  private final Readable rd;
  private final Appendable ap;
  
  /**
   * Constructor for the controller, takes in a readable and an appendable
   * to get the readable and appendable.
   *
   * @param rd is a readable as input which cannot be null.
   * @param ap is an appendable as output which cannot be null.
   */
  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("readable or appendable cannot be null");
    } else {
      this.rd = rd;
      this.ap = ap;
    }
  }
  
  /**
   * play the game.
   *
   * @param model input the Marble Solitaire Model to play.
   */
  @Override
  public void playGame(MarbleSolitaireModel model) throws IllegalStateException {
    
    //model cannot be null.
    if (model == null) {
      throw new IllegalArgumentException("model cannot be null");
    }
    
    //scan the readable.
    Scanner scan = new Scanner(rd);
    //keep track of the certain number in readable.
    Accumulator acc = Accumulator.fromRow;
    
    //default int for the move.
    int fromRow = 0;
    int fromCol = 0;
    int toRow = 0;
    int toCol;
    
    while (! model.isGameOver()) {
      while (scan.hasNext()) {
        String s = scan.next();
        //quit case
        if (s.equals("q") || s.equals("Q")) {
          try {
            ap.append("Game quit!\n" + "State of game when quit:" + "\n");
            ap.append(model.getGameState()).append("\n");
            ap.append("Score: ").append(String.valueOf(model.getScore()));
          } catch (IOException e) {
            throw new IllegalStateException("Illegal transmit");
          }
          return;
        } else { //move case. to catch if the input string is a number
          int x = 0;
          int y = 1;
          try {
            x = Integer.parseInt(s);
          } catch (IllegalArgumentException e) {
            try {
              //if the input is a string not q or Q.
              ap.append("Invalid input.\n" + e.getMessage() + "\n");
              y = 0;
            } catch (IOException e1) {
              throw new IllegalStateException("Illegal transmit");
            }
          }
          //if the input is not positive.
          if (x <= 0 && y != 0) {
            try {
              ap.append("Invalid input.\n" + "For input string: "
                            + "\"" + x + "\"" + "\n");
            } catch (IOException e1) {
              throw new IllegalStateException("Illegal transmit");
            }
          } else if (y != 0) {
            if (acc == Accumulator.fromRow) {
              fromRow = x - 1;
              acc = Accumulator.fromCol;
            } else if (acc == Accumulator.fromCol) {
              fromCol = x - 1;
              acc = Accumulator.toRow;
            } else if (acc == Accumulator.toRow) {
              toRow = x - 1;
              acc = Accumulator.toCol;
            } else {
              toCol = x - 1;
              acc = Accumulator.fromRow;
              try {
                model.move(fromRow, fromCol, toRow, toCol);
              } catch (IllegalArgumentException e) {
                try {
                  ap.append("Invalid move. Play again. " + e.getMessage() + "\n");
                } catch (IOException e1) {
                  throw new IllegalStateException("Illegal transmit");
                }
              }
            }
          }
        }
      }
      
      //if there is no more input.
      if (! model.isGameOver()) {
        throw new IllegalStateException("no more input");
      }
    }
    
    //game over case.
    try {
      ap.append("Game over!\n");
      ap.append(model.getGameState()).append("\n");
      ap.append("Score: ").append(String.valueOf(model.getScore()));
    } catch (IOException e) {
      throw new IllegalStateException("Illegal transmit");
    }
  }
}
