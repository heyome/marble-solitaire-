import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.Grid;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * tests for methods and constructors for Marble Solitaire Model implements and Grids.
 */

public class MarbleSolitaireModelTests {
  
  
  private MarbleSolitaireModelImpl ms;
  
  /**
   * to test getGrids method for {@link Grid}s.
   */
  @Test
  public void getGridsTest() {
    assertEquals(Grid.getGrids(3), new Grid[][]{
        {Grid.noGrid, Grid.noGrid, Grid.marble, Grid.marble,
            Grid.marble, Grid.noGrid, Grid.noGrid},
        {Grid.noGrid, Grid.noGrid, Grid.marble, Grid.marble,
            Grid.marble, Grid.noGrid, Grid.noGrid},
        {Grid.marble, Grid.marble, Grid.marble, Grid.marble,
            Grid.marble, Grid.marble, Grid.marble},
        {Grid.marble, Grid.marble, Grid.marble, Grid.empty,
            Grid.marble, Grid.marble, Grid.marble},
        {Grid.marble, Grid.marble, Grid.marble, Grid.marble,
            Grid.marble, Grid.marble, Grid.marble},
        {Grid.noGrid, Grid.noGrid, Grid.marble, Grid.marble,
            Grid.marble, Grid.noGrid, Grid.noGrid},
        {Grid.noGrid, Grid.noGrid, Grid.marble, Grid.marble,
            Grid.marble, Grid.noGrid, Grid.noGrid}
    });
    assertEquals(Grid.getGrids(5), new Grid[][]{
        {Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.marble,
            Grid.marble, Grid.marble, Grid.marble, Grid.marble,
            Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.noGrid},
        {Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.marble,
            Grid.marble, Grid.marble, Grid.marble, Grid.marble,
            Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.noGrid},
        {Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.marble,
            Grid.marble, Grid.marble, Grid.marble, Grid.marble,
            Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.noGrid},
        {Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.marble,
            Grid.marble, Grid.marble, Grid.marble, Grid.marble,
            Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.noGrid},
        {Grid.marble, Grid.marble, Grid.marble, Grid.marble, Grid.marble,
            Grid.marble, Grid.marble, Grid.marble, Grid.marble,
            Grid.marble, Grid.marble, Grid.marble, Grid.marble},
        {Grid.marble, Grid.marble, Grid.marble, Grid.marble, Grid.marble,
            Grid.empty, Grid.marble, Grid.marble, Grid.marble,
            Grid.marble, Grid.marble, Grid.marble, Grid.marble},
        {Grid.marble, Grid.marble, Grid.marble, Grid.marble, Grid.marble,
            Grid.marble, Grid.marble, Grid.marble, Grid.marble,
            Grid.marble, Grid.marble, Grid.marble, Grid.marble},
        {Grid.marble, Grid.marble, Grid.marble, Grid.marble, Grid.marble,
            Grid.marble, Grid.marble, Grid.marble, Grid.marble,
            Grid.marble, Grid.marble, Grid.marble, Grid.marble},
        {Grid.marble, Grid.marble, Grid.marble, Grid.marble, Grid.marble,
            Grid.marble, Grid.marble, Grid.marble, Grid.marble,
            Grid.marble, Grid.marble, Grid.marble, Grid.marble},
        {Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.marble,
            Grid.marble, Grid.marble, Grid.marble, Grid.marble,
            Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.noGrid},
        {Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.marble,
            Grid.marble, Grid.marble, Grid.marble, Grid.marble,
            Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.noGrid},
        {Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.marble,
            Grid.marble, Grid.marble, Grid.marble, Grid.marble,
            Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.noGrid},
        {Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.marble,
            Grid.marble, Grid.marble, Grid.marble, Grid.marble,
            Grid.noGrid, Grid.noGrid, Grid.noGrid, Grid.noGrid}
    });
  }
  
  /**
   * tests for {@link MarbleSolitaireModel}.
   */
  @Test
  public void getGameStateTest1() {
    ms = new MarbleSolitaireModelImpl();
    assertEquals(ms.getGameState(),
        "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O");
  }
  
  @Test
  public void getGameStateTest2() {
    ms = new MarbleSolitaireModelImpl(4, 2);
    assertEquals(ms.getGameState(),
        "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O _ O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O");
  }
  
  @Test
  public void getGameStateTest3() {
    ms = new MarbleSolitaireModelImpl(3);
    assertEquals(ms.getGameState(),
        "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O");
  }
  
  @Test
  public void getGameStateTest4() {
    ms = new MarbleSolitaireModelImpl(5, 4, 4);
    assertEquals(ms.getGameState(),
        "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "O O O O _ O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O");
    
    ms.board = new Grid[][]{
        {Grid.noGrid, Grid.noGrid, Grid.marble,
            Grid.empty, Grid.marble, Grid.noGrid, Grid.noGrid},
        {Grid.noGrid, Grid.noGrid, Grid.marble,
            Grid.empty, Grid.marble, Grid.noGrid, Grid.noGrid},
        {Grid.marble, Grid.empty, Grid.marble,
            Grid.empty, Grid.marble, Grid.empty, Grid.marble},
        {Grid.marble, Grid.empty, Grid.marble,
            Grid.empty, Grid.marble, Grid.empty, Grid.marble},
        {Grid.marble, Grid.empty, Grid.marble,
            Grid.empty, Grid.marble, Grid.empty, Grid.marble},
        {Grid.noGrid, Grid.noGrid, Grid.marble,
            Grid.empty, Grid.marble, Grid.noGrid, Grid.noGrid},
        {Grid.noGrid, Grid.noGrid, Grid.marble,
            Grid.empty, Grid.marble, Grid.noGrid, Grid.noGrid}};
    assertEquals(ms.getGameState(),
        "    O _ O" + "\n"
            + "    O _ O" + "\n"
            + "O _ O _ O _ O" + "\n"
            + "O _ O _ O _ O" + "\n"
            + "O _ O _ O _ O" + "\n"
            + "    O _ O" + "\n"
            + "    O _ O");
  }
  
  @Test
  public void moveTest1() {
    ms = new MarbleSolitaireModelImpl();
    assertEquals(ms.board[3][2], Grid.marble);
    ms.move(3, 1, 3, 3);
    assertEquals(ms.board[3][2], Grid.empty);
    assertEquals(ms.getGameState(), "    O O O" + "\n"
                                        + "    O O O" + "\n"
                                        + "O O O O O O O" + "\n"
                                        + "O _ _ O O O O" + "\n"
                                        + "O O O O O O O" + "\n"
                                        + "    O O O" + "\n"
                                        + "    O O O");
  }
  
  @Test
  public void moveTest2() {
    ms = new MarbleSolitaireModelImpl(5, 6, 7);
    ms.move(6, 9, 6, 7);
    assertEquals(ms.getGameState(),
        "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O _ _ O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O");
  }
  
  
  @Test
  public void isGameOverTest() {
    ms = new MarbleSolitaireModelImpl();
    assertEquals(ms.isGameOver(), false);
    ms.board[3][3] = Grid.marble;
    assertEquals(ms.isGameOver(), true);
    ms.board = new Grid[][]{
        {Grid.noGrid, Grid.noGrid, Grid.marble,
            Grid.empty, Grid.marble, Grid.noGrid, Grid.noGrid},
        {Grid.noGrid, Grid.noGrid, Grid.marble,
            Grid.empty, Grid.marble, Grid.noGrid, Grid.noGrid},
        {Grid.marble, Grid.empty, Grid.marble,
            Grid.empty, Grid.marble, Grid.empty, Grid.marble},
        {Grid.marble, Grid.empty, Grid.marble,
            Grid.empty, Grid.marble, Grid.empty, Grid.marble},
        {Grid.marble, Grid.empty, Grid.marble,
            Grid.empty, Grid.marble, Grid.empty, Grid.marble},
        {Grid.noGrid, Grid.noGrid, Grid.marble,
            Grid.empty, Grid.marble, Grid.noGrid, Grid.noGrid},
        {Grid.noGrid, Grid.noGrid, Grid.marble,
            Grid.empty, Grid.marble, Grid.noGrid, Grid.noGrid}};
    assertEquals(ms.isGameOver(), true);
    
    
  }
  
  @Test
  public void isGameOverTest2() {
    ms = new MarbleSolitaireModelImpl();
    ms.move(3, 1, 3, 3);
    assertEquals(ms.isGameOver(), false);
  }
  
  @Test
  public void getScoreTest1() {
    ms = new MarbleSolitaireModelImpl();
    assertEquals(ms.getScore(), 32);
    ms.move(3, 1, 3, 3);
    assertEquals(ms.getScore(), 31);
    ms.move(1, 2, 3, 2);
    assertEquals(ms.getScore(), 30);
  }
  
  @Test
  public void getScoreTest2() {
    ms = new MarbleSolitaireModelImpl(5);
    assertEquals(ms.getScore(), 104);
    ms.move(3, 5, 5, 5);
    assertEquals(ms.getScore(), 103);
    ms.move(1, 5, 3, 5);
    assertEquals(ms.getScore(), 102);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void moveException1() {
    ms = new MarbleSolitaireModelImpl();
    ms.move(1, 1, 1, 3);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void moveException2() {
    ms = new MarbleSolitaireModelImpl();
    ms.move(1, - 1, 1, 3);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void moveException3() {
    ms = new MarbleSolitaireModelImpl();
    ms.move(- 1, 1, 1, 3);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void moveException4() {
    ms = new MarbleSolitaireModelImpl();
    ms.move(1, 1, - 1, 3);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void moveException5() {
    ms = new MarbleSolitaireModelImpl();
    ms.move(1, 1, 1, - 3);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void moveException6() {
    ms = new MarbleSolitaireModelImpl();
    ms.move(3, 5, 1, 5);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void moveException7() {
    ms = new MarbleSolitaireModelImpl();
    ms.move(3, 8, 1, 5);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void moveException8() {
    ms = new MarbleSolitaireModelImpl();
    ms.move(8, 2, 1, 5);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void moveException9() {
    ms = new MarbleSolitaireModelImpl();
    ms.move(3, 2, 8, 5);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void moveException10() {
    ms = new MarbleSolitaireModelImpl();
    ms.move(3, 2, 3, 8);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void moveException11() {
    ms = new MarbleSolitaireModelImpl();
    ms.move(3, 2, 3, 4);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void moveException12() {
    ms = new MarbleSolitaireModelImpl();
    ms.move(3, 3, 3, 5);
  }
  
  
  /**
   * to test getGrids method for {@link Grid}s.
   */
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest1() {
    ms = new MarbleSolitaireModelImpl(1, 1);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest2() {
    ms = new MarbleSolitaireModelImpl(5, 5);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest3() {
    ms = new MarbleSolitaireModelImpl(1, 5);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest4() {
    ms = new MarbleSolitaireModelImpl(5, 1);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest5() {
    ms = new MarbleSolitaireModelImpl(9, 9);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest6() {
    ms = new MarbleSolitaireModelImpl(- 1, 3);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest8() {
    ms = new MarbleSolitaireModelImpl(- 1);
  }
  
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest9() {
    ms = new MarbleSolitaireModelImpl(1);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest10() {
    ms = new MarbleSolitaireModelImpl(4);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest11() {
    ms = new MarbleSolitaireModelImpl(8);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest12() {
    ms = new MarbleSolitaireModelImpl(- 1, 3, 3);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest13() {
    ms = new MarbleSolitaireModelImpl(3, - 1, 3);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest14() {
    ms = new MarbleSolitaireModelImpl(3, 3, - 1);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest15() {
    ms = new MarbleSolitaireModelImpl(5, 3, 3);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest16() {
    ms = new MarbleSolitaireModelImpl(5, 10, 10);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest17() {
    ms = new MarbleSolitaireModelImpl(5, 3, 10);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest18() {
    ms = new MarbleSolitaireModelImpl(5, 10, 3);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest19() {
    ms = new MarbleSolitaireModelImpl(5, 3, 20);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest20() {
    ms = new MarbleSolitaireModelImpl(5, 30, 6);
  }
}
