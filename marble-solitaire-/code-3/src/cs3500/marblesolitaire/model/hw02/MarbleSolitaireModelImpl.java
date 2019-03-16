package cs3500.marblesolitaire.model.hw02;

/**
 * to represent MarbleSolitaireModel which is the classical Marble SolitaireModel
 * extends the abstract class MarbleSolitaireModelAbstract.
 */
public class MarbleSolitaireModelImpl extends MarbleSolitaireModelAbstract {
  
  //to represent the default array of grids
  private Grid[][] gridDefaultArray = Grid.getGrids(3);
  
  /**
   * construct a default game board with armThickness = 3 empty slot in the center.
   */
  public MarbleSolitaireModelImpl() {
    super.armThickness = 3;
    super.board = gridDefaultArray;
  }
  
  /**
   * construct the game board with arm thickness of 3 and the initial empty slot is[sRow][sCol].
   *
   * @param sRow is the row of initial empty slot.
   * @param sCol is the column of initial empty slot.
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    if (sRow < 0 || sCol < 0 || sRow > 6 || sCol > 6
            || gridDefaultArray[sRow][sCol].equals(Grid.noGrid)) {
      throw new IllegalArgumentException("Invalid empty cell position ("
                                             + sRow + "," + sCol + ")");
    } else {
      super.armThickness = 3;
      gridDefaultArray[3][3] = Grid.marble;
      gridDefaultArray[sRow][sCol] = Grid.empty;
      super.board = gridDefaultArray;
    }
  }
  
  /**
   * construct game board with arm thickness of given thickness and empty slot in the center.
   *
   * @param thickness is the arm thickness of the game board.
   */
  public MarbleSolitaireModelImpl(int thickness) {
    if (thickness % 2 == 0 || thickness < 2) {
      throw new IllegalArgumentException("invalid arm thickness");
    } else {
      super.armThickness = thickness;
      super.board = Grid.getGrids(thickness);
    }
  }
  
  /**
   * construct game board with arm thickness of given thickness and empty slot with given
   * [sRow][sCol].
   *
   * @param thickness is the arm thickness of the game board.
   * @param sRow      is the row of initial empty slot.
   * @param sCol      is the column of initial empty slot.
   */
  public MarbleSolitaireModelImpl(int thickness, int sRow, int sCol) {
    if (thickness % 2 == 0 || thickness < 2) {
      throw new IllegalArgumentException("invalid arm thickness");
    } else {
      Grid[][] grids = Grid.getGrids(thickness);
      if (sRow < 0 || sCol < 0 || sRow > thickness * 3 - 3
               || sCol > thickness * 3 - 3
               || grids[sRow][sCol].equals(Grid.noGrid)) {
        throw new IllegalArgumentException("invalid empty position");
      } else {
        super.armThickness = thickness;
        grids[(thickness * 3 - 1) / 2 - 1][(thickness * 3 - 1) / 2 - 1] = Grid.marble;
        grids[sRow][sCol] = Grid.empty;
        super.board = grids;
      }
    }
  }
  
  
}
