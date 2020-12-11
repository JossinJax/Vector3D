package cen4010.pa4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class MonopolyTest extends Monopoly{
	protected boolean ai;
	protected int pnum;
	protected String tok;
	protected int move;
	protected Player bank;
	protected Player nex;
	protected BoardSpot test;
	protected BoardSpot test2;
	protected Reminder remind;
	protected ArrayList<BoardSpot> array;
	
	@Before
	protected void setup() {
		ai = false;
		pnum = 1;
		tok = "monkey";
		move = 12;
		bank = new Player();
		nex = new Player();
		test = new BoardSpot("test", "brown", "property", bank, 60, 30, 2, 10, 30, 90, 160, 250, 50, false, 0);
		test2 = new BoardSpot("test2", "brown", "property", bank, 60, 30, 2, 10, 30, 90, 160, 250, 50, false, 0);
		remind = new Reminder();
		array = new ArrayList<BoardSpot>();
		array.add(test);
		array.add(test2);
		
	}
	//Player
	@Test
	public void testPlayerMake() {
		setup();
		Player player = new Player(ai, pnum);
		Player emp = new Player();
		assertEquals(emp.money, 1500);
		Player comp = new Player(tok, ai);
		assertEquals(1, player.getNum());
		assertEquals(false, player.AI);
		assertEquals("monkey", comp.token);
		assertEquals(false, comp.AI);
	}

	@Test
	public void testMove() {
		setup();
		Player tes = new Player(false, 2);
		tes.location = 0;
		tes.movement(move);
		assertEquals(tes.location, move);

		Player tes3 = new Player(false, 1);
		int mon = tes3.money;
		int place = tes3.location;
		tes3.movement(40);
		assertEquals(mon + 200, tes3.money);
		assertEquals(place, tes3.location);
	}
	
	@Test
	public void testTokens() {
		setup();
		Player player = new Player(tok, true);
		assertEquals(tok, player.getToken());
		player.setToken("dog");
		assertEquals("dog", player.getToken());
	}

	@Test
	public void testAI() {
		setup();
		Player player = new Player();
		player.setAI(false);
		assertEquals(player.isAI(), false);
	}
	
	@Test
	public void testJail() {
		setup();
		Player player = new Player();
		player.setJail(true);
		assertEquals(player.inJail, true);
	}
	//BoardSpot
	@Test
	public void testSpace() {
		setup();
		assertEquals(test.getName(), "test");
		assertEquals(test.getColor(), "brown");
		assertEquals(test.getType(), "property");
	}
	
	@Test
	public void testOwner() {
		setup();
		test.setOwner(nex);
		assertEquals(test.getOwner(), nex);
	}
	
	@Test
	public void testHouseHotel() {
		setup();
		assertEquals(test.getCost(), 60);
		assertEquals(test.getHouse0(), 2);
		assertEquals(test.getHouse1(), 10);
		assertEquals(test.getHouse2(), 30);
		assertEquals(test.getHouse3(), 90);
		assertEquals(test.getHouse4(), 160);
		assertEquals(test.getHotel(), 250);
		assertEquals(test.getHouseHotelPrice(), 50);
		test.setNumHouse(1);
		assertEquals(test.getNumHouse(), 1);
	}
	
	@Test
	public void testMortgages() {
		setup();
		test.setMortF();
		assertEquals(test.isMortaged(), false);
		test.setMortT();
		assertEquals(test.isMortaged(), true);
		assertEquals(test.getMort(), 30);
	}
	//Reminder
	@Test
	public void testReminder() {
		setup();
		assertEquals(remind.timeRem, true);
		remind.timeRem = false;
		assertEquals(remind.timeRem, false);
	}
	//Monopoly
	@Test
	public void testIndex() {
		setup();
		assertEquals(findInd(array, "test"), 0);
		assertEquals(findInd(array, "test2"), 1);
		assertEquals(findInd(array, "test3"), -1);
	}

	@Test
	public void testBuy() {
		setup();
		nex.money = 1500;
		buy(nex, test);
		int rem = 1500 - test.getCost();
		assertEquals(test.getOwner(), nex);
		assertEquals(test.isMortaged(), false);
		assertEquals(rem, nex.money);
	}
	
	@Test
	public void testMorts() {
		setup();
		buy(nex, test);
		nex.money = 1500;
		mortgage(nex, test);
		int rem = 1500 + test.getMort();
		assertEquals(test.isMortaged(), true);
		assertEquals(rem, nex.money);
	}
	
	@Test
	public void testPayBank() {
		setup();
		nex.money = 1500;
		payBank(nex, 100);
		assertEquals(nex.money, 1400);
	}
	
	@Test
	public void testIsInt() {
		setup();
		String num = "1";
		assertEquals(true, isInt(num));
		num = "a";
		assertEquals(false, isInt(num));
		assertEquals(getText(num), "a");
	}
	
	@Test
	public void testSell() {
		setup();
		buy(nex, test);
		nex.money = 1500;
		sellBank(nex, bank, test);
		assertEquals(nex.money, 1500 + test.getCost());
		assertEquals(test.getOwner(), bank);
		test.setOwner(nex);
		buy(nex, test);
		nex.money = 1500;
		bank.money = 1500;
		sellPlayer(nex, bank, test, 100);
		assertEquals(nex.money, 1500 + 100);
		assertEquals(bank.money, 1500 - 100);
		assertEquals(bank, test.getOwner());
	}
	
	@Test
	public void testRent() {
		setup();
		test.setOwner(bank);
		test.setNumHouse(0);
		nex.money = 1500;
		rent(nex, test);
		assertEquals(nex.money, 1500 - test.getHouse0());
		test.setNumHouse(1);
		nex.money = 1500;
		rent(nex, test);
		assertEquals(nex.money, 1500 - test.getHouse1());
		test.setNumHouse(2);
		nex.money = 1500;
		rent(nex, test);
		assertEquals(nex.money, 1500 - test.getHouse2());
		test.setNumHouse(3);
		nex.money = 1500;
		rent(nex, test);
		assertEquals(nex.money, 1500 - test.getHouse3());
		test.setNumHouse(4);
		nex.money = 1500;
		rent(nex, test);
		assertEquals(nex.money, 1500 - test.getHouse4());
		test.setNumHouse(5);
		nex.money = 1500;
		rent(nex, test);
		assertEquals(nex.money, 1500 - test.getHotel());
	}
	
	@Test
	public void testHouseBuy() {
		setup();
		test.setOwner(nex);
		test.setNumHouse(3);
		nex.money = 1500;
		buyHouse(test, 10, 1);
		assertEquals(nex.money, 1500 - test.getHouseHotelPrice());
		assertEquals(test.getNumHouse(), 4);
		nex.money = 1500;
		buyHouse(test, 10, 1);
		assertEquals(nex.money, 1500 - test.getHouseHotelPrice());
		assertEquals(test.getNumHouse(), 5);
		nex.money = 1500;
		buyHouse(test, 10, 1);
		assertEquals(nex.money, 1500);
		assertEquals(test.getNumHouse(), 5);
		test.setNumHouse(3);
		nex.money = 0;
		buyHouse(test, 10, 1);
		assertEquals(nex.money, 0);
	}
	
	@Test
	public void testHouseSell() {
		setup();
		test.setOwner(nex);
		test.setNumHouse(5);
		nex.money = 1500;
		sellHouse(test, 10, 1);
		assertEquals(nex.money, 1500 + test.getHouseHotelPrice());
		assertEquals(test.getNumHouse(), 4);
		nex.money = 1500;
		sellHouse(test, 10, 1);
		assertEquals(nex.money, 1500 + test.getHouseHotelPrice());
		assertEquals(test.getNumHouse(), 3);
		test.setNumHouse(0);
		nex.money = 1500;
		sellHouse(test, 10, 1);
		assertEquals(nex.money, 1500);
		assertEquals(test.getNumHouse(), 0);
	}
	//GUI
	@Test
	public void testGui() {
		GUI gui = new GUI();
		gui.label.setText("");
		gui.playerMon.setText("");
		gui.playerNum.setText("");
		assertEquals(getText(gui.label.getText()), "");
		assertEquals(gui.playerMon.getText(), "");
		assertEquals(gui.playerNum.getText(), "");
	}
}
