package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.Grid;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelAbstract;

/**
 * to represent the EuropeanSolitaireModel which is another model of Marble Solitaire.
 */
public class EuropeanSolitaireModelImpl extends MarbleSolitaireModelAbstract {
  
  /**
   * constructor for the default European Solitaire model with the thickness of 3.
   */
  public EuropeanSolitaireModelImpl() {
    super.armThickness = 3;
    super.board = Grid.getEUGrids(3);
  }
  
  /**
   * constructor the European Solitaire model with a thickness. if the thickness is an even number,
   * throw an exception.
   *
   * @param thickness is the thickness of the board.
   */
  public EuropeanSolitaireModelImpl(int thickness) {
    if (thickness % 2 == 0 || thickness < 2) {
      throw new IllegalArgumentException("invalid arm thickness");
    } else {
      super.armThickness = thickness;
      super.board = Grid.getEUGrids(thickness);
    }
  }
  
  /**
   * constructor the European Solitaire model with a thickness of 3 with specifying the specific
   * empty location. if the position is an illegal position, throw an exception.
   *
   * @param row the row of the location of the empty.
   * @param col the column of the location of the empty.
   */
  public EuropeanSolitaireModelImpl(int row, int col) {
    Grid[][] grids = Grid.getEUGrids(3);
    if (row < 0 || col < 0 || row > 6 || col > 6
            || grids[row][col].equals(Grid.noGrid)) {
      throw new IllegalArgumentException("Illegal empty grid");
    } else {
      super.armThickness = 3;
      super.board = Grid.getEUGrids(3);
      board[3][3] = Grid.marble;
      board[row][col] = Grid.empty;
    }
  }
  
  /**
   * to initialize the the EuropeanSolitaireModel by given size n, and given.
   * emtpty point (row,col)
   * @param n is the size of the model board
   * @param row is the row of the empty position
   * @param col is the column of the empty position
   */
  public EuropeanSolitaireModelImpl(int n, int row, int col) {
    Grid[][] grids = Grid.getEUGrids(n);
    if (n % 2 == 0 || n < 2) {
      throw new IllegalArgumentException("invalid arm thickness2");
    } else if (row < 0 || col < 0 || row > 3 * n - 3 || col > 3 * n - 3
                   || grids[row][col].equals(Grid.noGrid)) {
      throw new IllegalArgumentException("Illegal empty grid");
    } else {
      super.armThickness = n;
      grids[(3 * armThickness - 3) / 2][(3 * armThickness - 3) / 2] = Grid.marble;
      grids[row][col] = Grid.empty;
      super.board = grids;
    }
  }
}
