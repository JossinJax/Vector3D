import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MonopolyTest {

  @Test
    //player class
  void movementTest() {
    Player myPlayer = new Player();
    myPlayer.movement(10);
    int result = myPlayer.money;
    assertEquals(0, result);//pass
  }

  @Test
    //player has enough to purchase a property
  void buyTest() {
    Player myPlayer = new Player();
    Player bank = new Player();
    bank.money = 100000000;
    myPlayer.money = 0;
    BoardSpot MediterraneanAvenue = new BoardSpot("Mediterranean Avenue", "brown", "property", myPlayer, 60, 30, 2, 10, 30, 90, 160, 250, 50, false, 0);
    Monopoly.buy(myPlayer, MediterraneanAvenue);
    Monopoly.sellPlayer(myPlayer, bank, MediterraneanAvenue, 60);
    assertEquals(myPlayer, MediterraneanAvenue.getOwner());

    myPlayer.money = 60;
    Monopoly.sellPlayer(myPlayer, bank, MediterraneanAvenue, 60);
    assertEquals(myPlayer, MediterraneanAvenue.getOwner());

    void jailTest(){

    }
  }
}