import org.junit.Test;

import java.io.PipedReader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.Grid;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;


public class MarbleSolitaireControllerImplTest {
  
  
  Readable rd;
  Appendable ap;
  MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
  
  //test for constructor
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest1() {
    new MarbleSolitaireControllerImpl(null, null);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest2() {
    rd = new StringReader("1 1 1 1");
    new MarbleSolitaireControllerImpl(rd, null);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void constructorTest3() {
    ap = new StringBuffer();
    new MarbleSolitaireControllerImpl(null, ap);
  }
  
  //test for there is no more string to input
  @Test(expected = IllegalStateException.class)
  public void noMoreStringTest() {
    rd = new StringReader("");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    c.playGame(model);
  }
  
  //test for model is null
  @Test(expected = IllegalArgumentException.class)
  public void noModel() {
    rd = new StringReader("");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    c.playGame(null);
  }
  
  //test for invalid input
  @Test(expected = IllegalStateException.class)
  public void invalidInput1() {
    rd = new StringReader("abd");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    c.playGame(model);
  }
  
  @Test(expected = IllegalStateException.class)
  public void invalidInput2() {
    rd = new StringReader("1 2 3");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    c.playGame(model);
  }
  
  @Test(expected = IllegalStateException.class)
  public void invalidInput3() {
    rd = new StringReader("1 2 app");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    c.playGame(model);
  }
  
  //if rd is not a StringReader
  @Test(expected = IllegalStateException.class)
  public void invalidInput4() {
    rd = new PipedReader();
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    c.playGame(model);
  }
  
  @Test(expected = IllegalStateException.class)
  public void invalidInput5() {
    rd = new StringReader("11 12 13 14");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    c.playGame(model);
  }
  
  @Test(expected = IllegalStateException.class)
  public void invalidInput6() {
    rd = new StringReader("-1 -2 -3 -4");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    c.playGame(model);
  }
  
  //tests for valid inputs for play game
  @Test
  public void playGameTest1() {
    rd = new StringReader("4 2 4 4 q");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    c.playGame(model);
    assertEquals("Game quit!\n" +
                     "State of game when quit:\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "O O O O O O O\n" +
                     "O _ _ O O O O\n" +
                     "O O O O O O O\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "Score: 31", ap.toString());
    
  }
  
  @Test
  public void playGameTest2() {
    rd = new StringReader("q");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    c.playGame(model);
    assertEquals("Game quit!\n" +
                     "State of game when quit:\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "O O O O O O O\n" +
                     "O O O _ O O O\n" +
                     "O O O O O O O\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "Score: 32", ap.toString());
    
  }
  
  @Test
  public void playGameTest3() {
    rd = new StringReader("4 3 3 4 q");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    c.playGame(model);
    assertEquals("Invalid move. Play again. cannot move this way!\n" +
                     "Game quit!\n" +
                     "State of game when quit:\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "O O O O O O O\n" +
                     "O O O _ O O O\n" +
                     "O O O O O O O\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "Score: 32", ap.toString());
    
  }
  
  @Test
  public void playGameTest4() {
    rd = new StringReader("4 4 q");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    c.playGame(model);
    assertEquals("Game quit!\n" +
                     "State of game when quit:\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "O O O O O O O\n" +
                     "O O O _ O O O\n" +
                     "O O O O O O O\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "Score: 32", ap.toString());
    
  }
  
  @Test
  public void playGameTest5() {
    rd = new StringReader("Q");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    c.playGame(model);
    assertEquals("Game quit!\n" +
                     "State of game when quit:\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "O O O O O O O\n" +
                     "O O O _ O O O\n" +
                     "O O O O O O O\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "Score: 32", ap.toString());
    
  }
  
  @Test
  public void playGameTest6() {
    rd = new StringReader("6 4 6 6 Q");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    model = new MarbleSolitaireModelImpl(5);
    c.playGame(model);
    assertEquals("Invalid move. Play again. Wrong grid forward!\n" +
                     "Game quit!\n" +
                     "State of game when quit:\n" +
                     "        O O O O O\n" +
                     "        O O O O O\n" +
                     "        O O O O O\n" +
                     "        O O O O O\n" +
                     "O O O O O O O O O O O O O\n" +
                     "O O O O O O O O O O O O O\n" +
                     "O O O O O O _ O O O O O O\n" +
                     "O O O O O O O O O O O O O\n" +
                     "O O O O O O O O O O O O O\n" +
                     "        O O O O O\n" +
                     "        O O O O O\n" +
                     "        O O O O O\n" +
                     "        O O O O O\n" +
                     "Score: 104", ap.toString());
    
  }
  
  @Test
  public void playGameTest7() {
    rd = new StringReader("6 4 6 6 Q");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    model = new MarbleSolitaireModelImpl(5);
    c.playGame(model);
    assertEquals("Invalid move. Play again. Wrong grid forward!\n" +
                     "Game quit!\n" +
                     "State of game when quit:\n" +
                     "        O O O O O\n" +
                     "        O O O O O\n" +
                     "        O O O O O\n" +
                     "        O O O O O\n" +
                     "O O O O O O O O O O O O O\n" +
                     "O O O O O O O O O O O O O\n" +
                     "O O O O O O _ O O O O O O\n" +
                     "O O O O O O O O O O O O O\n" +
                     "O O O O O O O O O O O O O\n" +
                     "        O O O O O\n" +
                     "        O O O O O\n" +
                     "        O O O O O\n" +
                     "        O O O O O\n" +
                     "Score: 104", ap.toString());
    
  }
  
  @Test
  public void playGameTest8() {
    rd = new StringReader("-1 a Q");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    model = new MarbleSolitaireModelImpl();
    c.playGame(model);
    assertEquals("Invalid input.\n" +
                     "For input string: \"-1\"\n" +
                     "Invalid input.\n" +
                     "For input string: \"a\"\n" +
                     "Game quit!\n" +
                     "State of game when quit:\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "O O O O O O O\n" +
                     "O O O _ O O O\n" +
                     "O O O O O O O\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "Score: 32", ap.toString());
    
  }
  
  @Test
  public void playGameTest9() {
    rd = new StringReader("-1 a 4 2 4 4 Q");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    model = new MarbleSolitaireModelImpl();
    c.playGame(model);
    assertEquals("Invalid input.\n" +
                     "For input string: \"-1\"\n" +
                     "Invalid input.\n" +
                     "For input string: \"a\"\n" +
                     "Game quit!\n" +
                     "State of game when quit:\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "O O O O O O O\n" +
                     "O _ _ O O O O\n" +
                     "O O O O O O O\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "Score: 31", ap.toString());
    
  }
  
  @Test
  public void playGameTest10() {
    rd = new StringReader("1 1 1 1 4 2 4 4 Q");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    model = new MarbleSolitaireModelImpl();
    c.playGame(model);
    assertEquals("Invalid move. Play again. It is out of board!\n" +
                     "Game quit!\n" +
                     "State of game when quit:\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "O O O O O O O\n" +
                     "O _ _ O O O O\n" +
                     "O O O O O O O\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "Score: 31", ap.toString());
    
  }
  
  @Test
  public void playGameTest11() {
    rd = new StringReader("4 2 4 4 q Q");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    model = new MarbleSolitaireModelImpl();
    c.playGame(model);
    assertEquals("Game quit!\n" +
                     "State of game when quit:\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "O O O O O O O\n" +
                     "O _ _ O O O O\n" +
                     "O O O O O O O\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "Score: 31", ap.toString());
    
  }
  
  @Test
  public void playGameTest12() {
    rd = new StringReader("1 2 Q 1");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    model = new MarbleSolitaireModelImpl();
    c.playGame(model);
    assertEquals("Game quit!\n" +
                     "State of game when quit:\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "O O O O O O O\n" +
                     "O O O _ O O O\n" +
                     "O O O O O O O\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "Score: 32", ap.toString());
    
  }
  
  @Test
  public void playGameTest13() {
    rd = new StringReader("4 2 q 4 4 Q");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    model = new MarbleSolitaireModelImpl();
    c.playGame(model);
    assertEquals("Game quit!\n" +
                     "State of game when quit:\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "O O O O O O O\n" +
                     "O O O _ O O O\n" +
                     "O O O O O O O\n" +
                     "    O O O\n" +
                     "    O O O\n" +
                     "Score: 32", ap.toString());
    
  }
  
  
  //test for game over
  @Test
  public void gameOver() {
    rd = new StringReader("-1 a 4 2 4 4 Q");
    ap = new StringBuffer();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(rd, ap);
    model = new MarbleSolitaireModelImpl();
    ((MarbleSolitaireModelImpl) model).board = new Grid[][]{
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
    c.playGame(model);
    assertEquals("Game over!\n" +
                     "    O _ O\n" +
                     "    O _ O\n" +
                     "O _ O _ O _ O\n" +
                     "O _ O _ O _ O\n" +
                     "O _ O _ O _ O\n" +
                     "    O _ O\n" +
                     "    O _ O\n" +
                     "Score: 20", ap.toString());
    
  }
  
  
}
