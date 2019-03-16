package cs3500.marblesolitaire.model.hw02;

/**
 * to represent a Grid of noGrid, marble, or empty.
 */
public enum Grid {
  noGrid, marble, empty;
  
  /**
   * to draw a square board.
   *
   * @param n is the how many rows and columns in the list.
   * @return a list of list of grids.
   */
  public static Grid[][] getGrids(int n) {
    
    Grid[][] grids = new Grid[n * 3 - 2][n * 3 - 2];
    
    for (int i = 0; i < (n * 3) - 2; i++) {
      for (int j = 0; j < (n * 3) - 2; j++) {
        if ((i < n - 1 || i > (n * 2) - 2)
                && (j < n - 1 || j > (n * 2) - 2)) {
          grids[i][j] = noGrid;
        } else if (i == (n * 3 - 3) / 2 && j == (n * 3 - 3) / 2) {
          grids[i][j] = empty;
        } else {
          grids[i][j] = marble;
        }
      }
    }
    return grids;
  }
  
  /**
   * To get the game board of European Solitaire Model.
   *
   * @param n is the size the board
   * @return a list of list of Grids which represents the European Solitaire Model board
   */
  public static Grid[][] getEUGrids(int n) {
    Grid[][] grids = Grid.getGrids(n);
    for (int i = 0; i < (n * 3) - 2; i++) {
      for (int j = 0; j < (n * 3) - 2; j++) {
        if (grids[i][j] == Grid.noGrid
                && Grid.isMarble(i, j, n)) {
          grids[i][j] = Grid.marble;
        }
      }
    }
    return grids;
  }
  
  /**
   * to know if the position should be a marble.
   *
   * @param i the row of the position
   * @param j the column of the position
   * @param n the board size
   * @return a boolean if the position is a marble
   */
  static boolean isMarble(int i, int j, int n) {
    if (i < n && j < n) {
      return i + j >= n - 1;
    } else if ((i > n && j < n) || (i < n && j > n)) {
      return Math.abs(i - j) <= n * 2 - 2;
    } else {
      return i + j <= 5 * n - 5;
    }
  }
  
  /**
   * initialize the Triangle Game board from the given size n.
   * @param n is the game board size.
   * @return a list of list of grids to represent the game board.
   */
  public static Grid[][] getTriGrids(int n) {
    Grid[][] grids = new Grid[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i >= j) {
          grids[i][j] = Grid.marble;
        } else {
          grids[i][j] = Grid.noGrid;
        }
      }
    }
    return grids;
  }
}