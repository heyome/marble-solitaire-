package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.Grid;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

public class TriangleSolitaireModelImpl implements MarbleSolitaireModel {
  
  private Grid[][] grids;
  private int armThickness;
  
  private Grid[][] defaultGrids = Grid.getTriGrids(5);
  
  /**
   * default constructor to construct the TriangleSolitaireModel with thickness of 5. the empty
   * point is (0,0).
   */
  public TriangleSolitaireModelImpl() {
    armThickness = 5;
    grids = defaultGrids;
    grids[0][0] = Grid.empty;
  }
  
  /**
   * constructor to construct the TriangleSolitaireModel with given dimensions if the thickness is
   * legal.
   *
   * @param dimensions decides the size of the game board.
   */
  public TriangleSolitaireModelImpl(int dimensions) {
    if (dimensions < 2) {
      throw new IllegalArgumentException("Illegal thickness");
    } else {
      armThickness = dimensions;
      grids = Grid.getTriGrids(dimensions);
      grids[0][0] = Grid.empty;
    }
  }
  
  /**
   * construct the TriangleSolitaireModel with given empty point if it is legal.
   *
   * @param row is the row position of the empty point.
   * @param col is the column position of the empty point.
   */
  public TriangleSolitaireModelImpl(int row, int col) {
    if (row < 0 || col < 0 || row > 4 || col > 4 || col > row) {
      throw new IllegalArgumentException("Illegal thickness");
    } else {
      armThickness = 5;
      grids = defaultGrids;
      grids[row][col] = Grid.empty;
    }
  }
  
  /**
   * construct the TriangleSolitaireModel with given empty point and given dimensions if they are
   * legal.
   *
   * @param dimensions decides the size of th game board
   * @param row        is the row position of the empty point.
   * @param col        is the column position of the empty point.
   */
  public TriangleSolitaireModelImpl(int dimensions, int row, int col) {
    if (dimensions < 2) {
      throw new IllegalArgumentException("Illegal thickness");
    } else if (col < 0 || row > dimensions - 1
                   || col > dimensions - 1 || col > row) {
      throw new IllegalArgumentException("Illegal thickness");
    } else {
      armThickness = dimensions;
      grids = Grid.getTriGrids(dimensions);
      grids[row][col] = Grid.empty;
    }
  }
  
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol)
      throws IllegalArgumentException {
    if (! this.canMove(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("wrong move");
    } else {
      grids[fromRow][fromCol] = Grid.empty;
      grids[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = Grid.empty;
      grids[toRow][toCol] = Grid.marble;
    }
  }
  
  @Override
  public boolean isGameOver() {
    for (int i = 0; i < armThickness; i++) {
      for (int j = 0; j < armThickness; j++) {
        if (this.canMove(i, j, i - 2, j - 2)
                || this.canMove(i, j, i + 2, j + 2)
                || this.canMove(i, j, i - 2, j)
                || this.canMove(i, j, i + 2, j)
                || this.canMove(i, j, i, j + 2)
                || this.canMove(i, j, i, j - 2)) {
          return false;
        }
      }
    }
    return true;
  }
  
  @Override
  public String getGameState() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < armThickness; i++) {
      s.append(this.getBlanks(armThickness - i - 2));
      for (int j = 0; j < armThickness; j++) {
        if (j == 0 && i == armThickness - 1) {
          if (grids[i][j].equals(Grid.empty)) {
            s.append("_");
          } else if (grids[i][j].equals(Grid.marble)) {
            s.append("O");
          }
        } else {
          if (grids[i][j].equals(Grid.empty)) {
            s.append(" _");
          } else if (grids[i][j].equals(Grid.marble)) {
            s.append(" O");
          }
        }
      }
      if (i < armThickness - 1) {
        s.append("\n");
      }
    }
    return s.toString();
  }
  
  /**
   * to append n blanks " ".
   *
   * @param n is the number of the blanks.
   * @return a whole String of blanks.
   */
  private String getBlanks(int n) {
    String s = "";
    while (n > 0) {
      s += " ";
      n -= 1;
    }
    return s;
  }
  
  @Override
  public int getScore() {
    int score = 0;
    for (int i = 0; i < armThickness; i++) {
      for (int j = 0; j < armThickness; j++) {
        if (grids[i][j].equals(Grid.marble)) {
          score += 1;
        }
      }
    }
    return score;
  }
  
  /**
   * to know if a position can move to another position.
   *
   * @param fromRow the row of from position
   * @param fromCol the column of from position
   * @param toRow   the row of to postion
   * @param toCol   the column of to position
   * @return a boolean if the from-to postion is valid.
   */
  private boolean canMove(int fromRow, int fromCol, int toRow, int toCol) {
    
    return fromRow >= 0 && fromCol >= 0 && toRow >= 0 && toCol >= 0
               && fromRow < armThickness && fromCol < armThickness
               && toRow < armThickness && toCol < armThickness
               && fromCol <= fromRow && toCol <= toRow
               && ! (fromRow == toRow && fromCol == toCol)
               && ((fromRow == toRow && Math.abs(fromCol - toCol) == 2)
                       || (fromCol == toCol && Math.abs(fromRow - toRow) == 2)
                       || (fromRow - toRow == 2 && fromCol - toCol == 2)
                       || (fromRow - toRow == - 2 && fromCol - toCol == - 2))
               && grids[fromRow][fromCol].equals(Grid.marble)
               && grids[toRow][toCol].equals(Grid.empty)
               && grids[(fromRow + toRow) / 2][(fromCol + toCol) / 2].equals(Grid.marble);
  }
  
  
}
