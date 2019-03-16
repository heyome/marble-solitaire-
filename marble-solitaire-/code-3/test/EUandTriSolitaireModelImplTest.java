import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

public class EUandTriSolitaireModelImplTest {
  
  MarbleSolitaireModel euDefault = new EuropeanSolitaireModelImpl();
  MarbleSolitaireModel triDefault = new TriangleSolitaireModelImpl();
  
  //test for move up, down, left, and right.
  //also test for getScore and isGameover, getGameState
  @Test
  public void euTest() {
    assertEquals("    O O O\n" +
                     "  O O O O O\n" +
                     "O O O O O O O\n" +
                     "O O O _ O O O\n" +
                     "O O O O O O O\n" +
                     "  O O O O O\n" +
                     "    O O O", euDefault.getGameState());
    assertEquals(36, euDefault.getScore());
    assertEquals(false, euDefault.isGameOver());
    euDefault.move(3, 1, 3, 3);
    assertEquals("    O O O\n" +
                     "  O O O O O\n" +
                     "O O O O O O O\n" +
                     "O _ _ O O O O\n" +
                     "O O O O O O O\n" +
                     "  O O O O O\n" +
                     "    O O O", euDefault.getGameState());
    assertEquals(35, euDefault.getScore());
    assertEquals(false, euDefault.isGameOver());
    euDefault.move(3, 4, 3, 2);
    assertEquals("    O O O\n" +
                     "  O O O O O\n" +
                     "O O O O O O O\n" +
                     "O _ O _ _ O O\n" +
                     "O O O O O O O\n" +
                     "  O O O O O\n" +
                     "    O O O", euDefault.getGameState());
    assertEquals(34, euDefault.getScore());
    assertEquals(false, euDefault.isGameOver());
    euDefault.move(1, 1, 3, 1);
    assertEquals("    O O O\n" +
                     "  _ O O O O\n" +
                     "O _ O O O O O\n" +
                     "O O O _ _ O O\n" +
                     "O O O O O O O\n" +
                     "  O O O O O\n" +
                     "    O O O", euDefault.getGameState());
    assertEquals(33, euDefault.getScore());
    assertEquals(false, euDefault.isGameOver());
    euDefault.move(4, 1, 2, 1);
    assertEquals("    O O O\n" +
                     "  _ O O O O\n" +
                     "O O O O O O O\n" +
                     "O _ O _ _ O O\n" +
                     "O _ O O O O O\n" +
                     "  O O O O O\n" +
                     "    O O O", euDefault.getGameState());
    assertEquals(32, euDefault.getScore());
    assertEquals(false, euDefault.isGameOver());
  
    euDefault.move(1, 3, 1, 1);
    assertEquals("    O O O\n" +
                     "  O _ _ O O\n" +
                     "O O O O O O O\n" +
                     "O _ O _ _ O O\n" +
                     "O _ O O O O O\n" +
                     "  O O O O O\n" +
                     "    O O O", euDefault.getGameState());
    assertEquals(31, euDefault.getScore());
    assertEquals(false, euDefault.isGameOver());
  }
  
  //TEST for trigular game board to move, getGameState, isGameover, and getScore
  @Test
  public void triTest() {
    assertEquals("    _\n" +
                     "   O O\n" +
                     "  O O O\n" +
                     " O O O O\n" +
                     "O O O O O", triDefault.getGameState());
    assertEquals(14, triDefault.getScore());
    
    triDefault.move(2, 0, 0, 0);
    assertEquals(13, triDefault.getScore());
    assertEquals(false, triDefault.isGameOver());
    assertEquals("    O\n" +
                     "   _ O\n" +
                     "  _ O O\n" +
                     " O O O O\n" +
                     "O O O O O", triDefault.getGameState());
    
    triDefault.move(2, 2, 2, 0);
    assertEquals(12, triDefault.getScore());
    assertEquals("    O\n" +
                     "   _ O\n" +
                     "  O _ _\n" +
                     " O O O O\n" +
                     "O O O O O", triDefault.getGameState());
    assertEquals(false, triDefault.isGameOver());
    
    triDefault.move(0, 0, 2, 2);
    assertEquals(false, triDefault.isGameOver());
    assertEquals("    _\n" +
                     "   _ _\n" +
                     "  O _ O\n" +
                     " O O O O\n" +
                     "O O O O O", triDefault.getGameState());
    assertEquals(11, triDefault.getScore());
    
    triDefault.move(3, 3, 1, 1);
    assertEquals(false, triDefault.isGameOver());
    assertEquals("    _\n" +
                     "   _ O\n" +
                     "  O _ _\n" +
                     " O O O _\n" +
                     "O O O O O", triDefault.getGameState());
    assertEquals(10, triDefault.getScore());
    
    MarbleSolitaireModel m1 = new TriangleSolitaireModelImpl(5, 3, 3);
    m1.move(3, 1, 3, 3);
    assertEquals(false, m1.isGameOver());
    assertEquals("    O\n" +
                     "   O O\n" +
                     "  O O O\n" +
                     " O _ _ O\n" +
                     "O O O O O", m1.getGameState());
    assertEquals(13, m1.getScore());
    
    MarbleSolitaireModel m2 = new TriangleSolitaireModelImpl(4, 2);
    m2.move(2, 2, 4, 2);
    assertEquals(false, m2.isGameOver());
    assertEquals("    O\n" +
                     "   O O\n" +
                     "  O O _\n" +
                     " O O _ O\n" +
                     "O O O O O", m2.getGameState());
    assertEquals(13, m1.getScore());
    
    
    MarbleSolitaireModel m3 = new TriangleSolitaireModelImpl(2);
    assertEquals(true, m3.isGameOver());
  }
  
  //test for invalid constructor for eupean marble Solitaire Model
  @Test(expected = IllegalArgumentException.class)
  public void euConstructorTest1() {
    new EuropeanSolitaireModelImpl(4);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void euConstructorTest2() {
    new EuropeanSolitaireModelImpl(0, 0);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void euConstructorTest3() {
    new EuropeanSolitaireModelImpl(- 1, - 1);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void euConstructorTest4() {
    new EuropeanSolitaireModelImpl(4, - 1, - 1);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void euConstructorTest5() {
    new EuropeanSolitaireModelImpl(4, 3, 3);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void euConstructorTest6() {
    new EuropeanSolitaireModelImpl(5, 15, 18);
  }
  
  //test for invalid move in triangular model
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove() {
    triDefault.move(0, 2, 2, 2);
  }
  
  //test for invalid constructor for triangular model
  @Test(expected = IllegalArgumentException.class)
  public void triConstructorTest1() {
    new TriangleSolitaireModelImpl(1);
  }
  
  //test for invalid constructor for triangular model
  @Test(expected = IllegalArgumentException.class)
  public void triConstructorTest2() {
    new TriangleSolitaireModelImpl(0, 1);
  }
  
  //test for invalid constructor for triangular model
  @Test(expected = IllegalArgumentException.class)
  public void triConstructorTest3() {
    new TriangleSolitaireModelImpl(1, 0, 1);
  }
  
  //test for invalid constructor for triangular model
  @Test(expected = IllegalArgumentException.class)
  public void triConstructorTest4() {
    new TriangleSolitaireModelImpl(5, 0, 1);
  }
  
  //test for invalid constructor for triangular model
  @Test(expected = IllegalArgumentException.class)
  public void triConstructorTest5() {
    new TriangleSolitaireModelImpl(1, 0, 0);
  }
  
  //test for invalid move for triangular model
  @Test(expected = IllegalArgumentException.class)
  public void triInvalidMove1() {
    triDefault.move(0, 2, 0, 0);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void triInvalidMove2() {
    triDefault.move(2, 0, 0, 0);
    triDefault.move(2, 0, 2, 2);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void triInvalidMove3() {
    triDefault.move(2, 0, 0, 0);
    triDefault.move(2, 0, 2, 2);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void triInvalidMove4() {
    triDefault.move(2, 0, 0, 0);
    triDefault.move(0, 0, 2, 0);
  }
}
