package cs3500.marblesolitaire.model.hw02;

/**
 * abstract class for MarbleSolitaireModel for implementation to represent different Marble models
 * for MarbleSolitaireModel(@link MarbleSolitaireModel).
 */
public abstract class MarbleSolitaireModelAbstract implements MarbleSolitaireModel {
  
  public Grid[][] board;
  public int armThickness;
  
  
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol)
      throws IllegalArgumentException {
    if ((fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0)
            || (fromRow >= board.length || fromCol >= board.length)
            || (toRow >= board.length || toCol >= board.length)
            || board[fromRow][fromCol] == Grid.noGrid
            || board[toRow][toCol] == Grid.noGrid) {
      throw new IllegalArgumentException("It is out of board!");
    } else if (fromRow != toRow && fromCol != toCol) {
      throw new IllegalArgumentException("cannot move this way!");
    } else if (board[fromRow][fromCol] == Grid.empty) {
      throw new IllegalArgumentException("Wrong grid selected!");
    } else if (board[toRow][toCol] == Grid.marble) {
      throw new IllegalArgumentException("Wrong grid forward!");
    } else if ((fromRow == toRow && Math.abs(fromCol - toCol) != 2)
                   || (fromCol == toCol && Math.abs(fromRow - toRow) != 2)) {
      throw new IllegalArgumentException("skip too much or too less");
    } else if (! (board[(fromRow + toRow) / 2][(fromCol + toCol) / 2]
                      .equals(Grid.marble))) {
      throw new IllegalArgumentException("No marble in the middle");
    } else {
      board[fromRow][fromCol] = Grid.empty;
      board[toRow][toCol] = Grid.marble;
      board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = Grid.empty;
    }
  }
  
  @Override
  public boolean isGameOver() {
    boolean b = true;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        Grid g = board[i][j];
        if (g.equals(Grid.marble)) {
          b = b && ! (i < board.length - 2
                          && board[i + 1][j].equals(Grid.marble)
                          && board[i + 2][j].equals(Grid.empty));
          b = b && ! (i > 1 && board[i - 1][j].equals(Grid.marble)
                          && board[i - 2][j].equals(Grid.empty));
          b = b && ! (j < board.length - 2
                          && board[i][j + 1].equals(Grid.marble)
                          && board[i][j + 2].equals(Grid.empty));
          b = b && ! (j > 1 && board[i][j - 1].equals(Grid.marble)
                          && board[i][j - 2].equals(Grid.empty));
          
        }
      }
    }
    return b;
  }
  
  @Override
  public String getGameState() {
    String result = "";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        Grid g = board[i][j];
        if (g.equals(Grid.marble)) {
          if (j == 0) {
            result += "O";
          } else {
            result += " O";
          }
        } else if (g.equals(Grid.empty)) {
          if (j == 0) {
            result += "_";
          } else {
            result += " _";
          }
        } else if (g.equals(Grid.noGrid)) {
          if (j == 0) {
            result += " ";
          } else if (j < (board.length + 2) / 3) {
            result += "  ";
          } else {
            result += "";
          }
        }
      }
      if (i < board.length - 1) {
        result += "\n";
      }
    }
    return result;
  }
  
  @Override
  public int getScore() {
    int n = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j].equals(Grid.marble)) {
          n += 1;
        }
      }
    }
    return n;
  }
  
}
