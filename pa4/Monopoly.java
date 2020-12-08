package cen4010.pa4;
import java.awt.EventQueue;
import java.lang.Thread;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;  
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.lang.Runnable;

public class Monopoly{
	static Thread tread = new Thread();
	static boolean waiting = false;
	
	static String in = " ";
	public static void main(String args[]) throws InterruptedException {
		int houses = 32;
		int hotels = 12;
		Player bank = new Player();
		Player NA = new Player();
		GUI gui = new GUI();
		gui.setVisible(true);
		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI gui = new GUI();
//					gui.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		
		gui.button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				waiting = false;
				in = gui.textField.getText();
			}
		});
		

		BoardSpot MediterraneanAvenue = new BoardSpot("Mediterranean Avenue", "brown", "property", bank, 60, 30, 2, 10, 30, 90, 160, 250, 50, false, 0);
		BoardSpot CommunityChest1 = new BoardSpot("CommunityChest", "none", "special", NA, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0);
		BoardSpot BalticAvenue = new BoardSpot("Baltic Avenue", "brown", "property", bank, 60, 30, 4, 20, 60, 180, 320, 450, 50, false, 0);
		BoardSpot IncomeTax = new BoardSpot("Income Tax", "none", "tax", NA, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0);
		BoardSpot ReadingRailroad = new BoardSpot("Reading Railroad", "none", "railroad", bank, 200, 100, 0, 0, 0, 0, 0, 0, 0, false, 0);
		BoardSpot OrientalAvenue = new BoardSpot("Oriental Avenue", "l_blue", "property", bank, 100, 50, 6, 30, 90, 270, 400, 550, 50, false, 0);
		BoardSpot Chance1 = new BoardSpot("Chance", "none", "special", NA, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0);
		BoardSpot VermontAvenue = new BoardSpot("Vermont Avenue", "l_blue", "property", bank, 100, 50, 6, 30, 90, 270, 400, 550, 50, false, 0);
		BoardSpot ConneticutAvenue = new BoardSpot("Conneticut Avenue", "l_blue", "property", bank, 120, 60, 8, 40, 100, 300, 450, 600, 50, false, 0);
		BoardSpot Jail = new BoardSpot("Jail", "none", "jail", NA, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0);
		BoardSpot StCharlesPlace = new BoardSpot("St. Charles Place", "pink", "property", bank, 140, 70, 10, 50, 150, 450, 625, 750, 100, false, 0);
		BoardSpot ElectricCompany = new BoardSpot("Electric Company", "none", "utility", bank, 150, 75, 0, 0, 0, 0, 0, 0, 0, false, 0);
		BoardSpot StatesAvenue = new BoardSpot("States Avenue", "pink", "property", bank, 140, 70, 10, 50, 150, 450, 625, 750, 100, false, 0);
		BoardSpot VirginiaAvenue = new BoardSpot("Virginia Avenue", "pink", "property", bank, 160, 80, 12, 60, 180, 500, 700, 900, 100, false, 0);
		BoardSpot PennsylvaniaRailroad = new BoardSpot("Pennsylvania Railroad", "none", "railroad", bank, 200, 100, 0, 0, 0, 0, 0, 0, 0, false, 0);
		BoardSpot StJamesPlace = new BoardSpot("St. James Place", "orange", "property", bank, 180, 90, 14, 70, 200, 550, 750, 950, 100, false, 0);
		BoardSpot CommunityChest2 = new BoardSpot("CommunityChest", "none", "special", NA, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0);
		BoardSpot TennesseeAvenue = new BoardSpot("Tennessee Avenue", "orange", "property", bank, 180, 90, 14, 70, 200, 550, 750, 950, 100, false, 0);
		BoardSpot NewYorkAvenue = new BoardSpot("New York Avenue", "orange", "property", bank, 200, 100, 16, 80, 220, 600, 800, 1000, 100, false, 0);
		BoardSpot FreeParking = new BoardSpot("Free Parking", "none", "special", NA, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0);
		BoardSpot KentuckyAvenue = new BoardSpot("Kentucky Avenue", "red", "property", bank, 220, 110, 18, 90, 250, 700, 875, 1050, 150, false, 0);
		BoardSpot Chance2 = new BoardSpot("Chance", "none", "special", NA, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0);
		BoardSpot IndianaAvenue = new BoardSpot("Indiana Avenue", "red", "property", bank, 220, 110, 18, 90, 250, 700, 875, 1050, 150, false, 0);
		BoardSpot IllinoisAvenue = new BoardSpot("Illinois Avenue", "red", "property", bank, 240, 120, 20, 100, 300, 750, 925, 1100, 150, false, 0);
		BoardSpot BORailroad = new BoardSpot("B. & O. Railroad", "none", "railroad", bank, 200, 100, 0, 0, 0, 0, 0, 0, 0, false, 0);
		BoardSpot AtlanticAvenue = new BoardSpot("Atlantic Avenue", "yellow", "property", bank, 260, 130, 22, 110, 330, 800, 975, 1150, 130, false, 0);
		BoardSpot VentorAvenue = new BoardSpot("Ventor Avenue", "yellow", "property", bank, 260, 130, 22, 110, 330, 800, 975, 1150, 130, false, 0);
		BoardSpot WaterWorks = new BoardSpot("Water Works", "none", "utility", bank, 150, 75, 0, 0, 0, 0, 0, 0, 0, false, 0);
		BoardSpot MarvinGardens = new BoardSpot("Marvin Gardens", "yellow", "property", bank, 280, 140, 24, 120, 360, 850, 1035, 1200, 150, false, 0);
		BoardSpot GoToJail = new BoardSpot("Go to Jail", "none", "GoToJail", NA, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0);
		BoardSpot PacificAvenue = new BoardSpot("Pacific Avenue", "green", "property", bank, 300, 150, 26, 130, 390, 900, 1100, 1275, 200, false, 0);
		BoardSpot NorthCarolinaAvenue = new BoardSpot("North Carolina Avenue", "green", "property", bank, 300, 150, 26, 130, 390, 900, 1100, 1275, 200, false, 0);
		BoardSpot CommunityChest3 = new BoardSpot("CommunityChest", "none", "special", NA, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0);
		BoardSpot PennsylvaniaAvenue = new BoardSpot("Pennsylvania Avenue", "green", "property", bank, 320, 160, 28, 150, 450, 1000, 1200, 1400, 200, false, 0);
		BoardSpot ShortLine = new BoardSpot("Short Line", "none", "railroad", bank, 200, 100, 0, 0, 0, 0, 0, 0, 0, false, 0);
		BoardSpot Chance3 = new BoardSpot("Chance", "none", "special", NA, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0);
		BoardSpot ParkPlace = new BoardSpot("Park Place", "d_blue", "property", bank, 350, 175, 35, 175, 500, 1100, 1300, 1500, 200, false, 0);
		BoardSpot LuxuryTax = new BoardSpot("Luxury Tax", "none", "tax", NA, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0);
		BoardSpot Boardwalk = new BoardSpot("Boardwalk", "d_blue", "property", bank, 400, 200, 50, 200, 600, 1400, 1700, 2000, 200, false, 0);
		BoardSpot Go = new BoardSpot("Go", "none", "go", NA, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0);
		BoardSpot[] spaces = {Go, MediterraneanAvenue, CommunityChest1, BalticAvenue, IncomeTax, ReadingRailroad, OrientalAvenue, Chance1, VermontAvenue, ConneticutAvenue, Jail, StCharlesPlace, ElectricCompany, StatesAvenue, VirginiaAvenue, PennsylvaniaRailroad, StJamesPlace, CommunityChest2, TennesseeAvenue, NewYorkAvenue, FreeParking, KentuckyAvenue, Chance2, IllinoisAvenue, IndianaAvenue, BORailroad, AtlanticAvenue, VentorAvenue, WaterWorks, MarvinGardens, GoToJail, PacificAvenue, NorthCarolinaAvenue, CommunityChest3, PennsylvaniaAvenue, ShortLine, Chance3, ParkPlace, LuxuryTax, Boardwalk};

		
		//Determine Number of Players
		
		gui.label.setText("Welcome to Monopoly! How many people are playing?");
		//Scanner in = new Scanner(System.in);
		waiting = true;
		while(waiting) {
			TimeUnit.SECONDS.sleep(1);
		}
		int humanPlayers;
		int aiPlayers = 0;
		while(true) {
			if(isInt(in) == false) {
				gui.label.setText("Invalid entry. Please input a number");
				gui.textField.setText("");
			}else {
				int entry = Integer.parseInt(in);
				if(entry > 8) {
					gui.label.setText("Too many players! Enter a new player count.");
					gui.textField.setText("");
				}else if(entry < 1) {
					gui.label.setText("Invalid number. Enter a new player count.");
					gui.textField.setText("");
				}else {
					humanPlayers = entry;
					gui.textField.setText("");
					gui.label.setText(humanPlayers + " people are playing!");
					TimeUnit.SECONDS.sleep(3);
					break;
				}
			}
			waiting = true;
			while(waiting) {
				TimeUnit.SECONDS.sleep(1);
			}
		}
		if(humanPlayers == 8) {
			gui.label.setText("No room for AI! Continuing...");
			gui.textField.setText("");
			TimeUnit.SECONDS.sleep(1);
		}else {
			gui.label.setText("How many AI Players would you like?");
			gui.textField.setText("");
			while(true) {
				waiting = true;
				while(waiting) {
					TimeUnit.SECONDS.sleep(1);
				}
				int entry = Integer.parseInt(in);
				if(entry  < 0) {
					gui.label.setText("Invalid number. Enter a new player count.");
					gui.textField.setText("");
				}else if(entry  < 1 && humanPlayers < 2) {
					gui.label.setText("You can't play alone. Add an AI player.");
					gui.textField.setText("");
				}else if(humanPlayers + entry > 8){
					gui.label.setText("Too many AI! Input a smaller number.");
					gui.textField.setText("");
				}else{
					aiPlayers = entry;
					gui.textField.setText("");
					gui.label.setText("Added " + aiPlayers +" AI player(s).");
					TimeUnit.SECONDS.sleep(4);
					break;
				}
			}
		}
		
		
		int totalPlayers = humanPlayers + aiPlayers;
		gui.label.setText("There are " + totalPlayers + " total players!");
		TimeUnit.SECONDS.sleep(4);
		
		Integer[] turnNumber = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		Player[] playerOrder = new Player[12];
		Random dieOne = new Random();
		Random dieTwo = new Random();
		
		//Assigning Turn Order
		
		for(int i = 0; i < humanPlayers; i++) {
			int pppp = i + 1;
			gui.label.setText("Rolling play order for Player " + pppp);
			TimeUnit.SECONDS.sleep(3);
			while(true) {
				int diceRoll = dieOne.nextInt(7) + dieTwo.nextInt(7);
				if(turnNumber[diceRoll] != diceRoll && turnNumber[diceRoll] != null) {
					turnNumber[diceRoll] = diceRoll - 1;
					Player p = new Player(false, i);
					playerOrder[diceRoll] = p;
					gui.label.setText("Player " + pppp + " got " + diceRoll);
					TimeUnit.SECONDS.sleep(3);
					break;
				}else {
					continue;
				}
			}
		}
		for(int i = 0; i < aiPlayers; i++) {
			int llll = i + humanPlayers + 1;
			gui.label.setText("Rolling play order for Player (AI) " + llll);
			TimeUnit.SECONDS.sleep(3);
			while(true) {
				int diceRoll = dieOne.nextInt(7) + dieTwo.nextInt(7);
				if(turnNumber[diceRoll] != diceRoll && turnNumber[diceRoll] != null) {
					turnNumber[diceRoll] = diceRoll - 1;
					Player c = new Player(true, humanPlayers + i);
					playerOrder[diceRoll] = c;
					gui.label.setText("Player (AI) " + llll + " got " + diceRoll);
					TimeUnit.SECONDS.sleep(3);
					break;
				}else {
					continue;
				}
			}
			if(i >= aiPlayers) {
				break;
			}
		}
		
		ArrayList<Player> players = new ArrayList<Player>();
		for(int i = 11; i >= 0; i--) {
			if(playerOrder[i] != null) {
				players.add(playerOrder[i]);
			}
		}
		
		String mm = "Turn Order: ";
		for(int i = 0; i < players.size(); i++) {
			if(i == players.size() - 1) {
				mm += "Player " + players.get(i).getNum();
			}else {
				mm += "Player " + players.get(i).getNum() + ", ";
			}
		}
		gui.label.setText(mm);
		TimeUnit.SECONDS.sleep(3);
		//Setting Tokens
		
		ArrayList<String> tokens = new ArrayList<String>();
		tokens.add("Boot");
		tokens.add("Cat");
		tokens.add("Dog");
		tokens.add("Duck");
		tokens.add("Iron");
		tokens.add("Hat");
		tokens.add("Thimble");
		tokens.add("Wheel");
		
		for(int i = 0 ; i < players.size(); i++) {
			if(!(players.get(i).isAI())) {
				String too = "";
				for(int p = 0; p < tokens.size(); p++) {
					too += "  " + tokens.get(p);
				}
				gui.label.setText("Player " + players.get(i).getNum() + ", please pick your token from the list: \n" + too);
				while(true) {
					waiting = true;
					while(waiting) {
						TimeUnit.SECONDS.sleep(1);
					}
					String choice = in;
					choice = choice.trim();
					if(tokens.contains(choice)) {
						players.get(i).setToken(choice);
						tokens.remove(tokens.indexOf(choice));
						gui.label.setText("Player " + players.get(i).getNum() + "selected " + choice);
						gui.textField.setText("");
						TimeUnit.SECONDS.sleep(3);
						break;
					}else {
						gui.label.setText("Please enter a valid choice. " + "Player " + players.get(i).getNum() + ", please pick your token from the list: \n" + too);
						gui.textField.setText("");
					}
				}
			}
		}
		for(int i = 0; i < players.size(); i++) {
			if(players.get(i).isAI()) {
				players.get(i).setToken(tokens.get(0));
				gui.textField.setText("");
				gui.label.setText("Player(AI) " + players.get(i).getNum() + "assigned " + tokens.get(0));
				TimeUnit.SECONDS.sleep(3);
				tokens.remove(0);
			}
		}
		Reminder reminder = new Reminder();
		//Gameplay
		while(players.size() > 1) {
			if(reminder.timeRem == false) {
				int winner = -1; 
				int winningMon = 0;
				for(int j = 0; j < players.size(); j++) {
					if(players.get(j).money > winningMon) {
						winner = j;
						winningMon = players.get(j).money;
					}
				}
				gui.label.setText("The winner is Player " + players.get(winner).getNum() + " with " + winningMon + "! Click Submit to close the game.");
				gui.textField.setText("");
				//in.close();waiting = true;
				while(waiting) {
					TimeUnit.SECONDS.sleep(1);
				}
				System.exit(0);
			}
			for(int i = 0; i < players.size(); i++) {
				//If in jail
				if(players.get(i).inJail) {
					gui.textField.setText("");
					gui.label.setText("You are in jail. Pay $50 to free yourself or roll to be freed. 'pay' or 'roll'");
					String j = in;
					waiting = true;
					while(waiting) {
						TimeUnit.SECONDS.sleep(1);
					}
					switch(j) {
						case "pay":
							players.get(i).money -= 50;
							players.get(i).setJail(false);
							players.get(i).jailTime = 0; 
							gui.textField.setText("");
							gui.label.setText("Fine paid. You are free!");

							TimeUnit.SECONDS.sleep(3);
							break;
						case "roll":
							gui.textField.setText("");
							break;
						default:
							gui.label.setText("Invalid option. Please try again. You are in jail. Pay $50 to free yourself or roll to be freed. 'pay' or 'roll'");
							gui.textField.setText("");
					}
				}
				//Rolling movement
				if(players.get(i).isAI()) {
					gui.label.setText("AI " + players.get(i).getNum() + "'s turn. Rolling dice...");
					gui.textField.setText("");
					TimeUnit.SECONDS.sleep(3);
				}else {
					gui.label.setText("Player " + players.get(i).getNum() + "'s turn. Rolling dice...");
					gui.textField.setText("");
					TimeUnit.SECONDS.sleep(3);
				}
				boolean doubles = false;
				Random die = new Random();
				int d1 = die.nextInt(7);
				int d2 = die.nextInt(7);
				if(d1 == d2) {
					doubles = true;
					players.get(i).doubleCounter += 1;
					if(players.get(i).doubleCounter == 3) {
						gui.label.setText("Speeding! Go to Jail!");
						TimeUnit.SECONDS.sleep(3);
						players.get(i).inJail = true;
						players.get(i).doubleCounter = 0;
						continue;
					}
				}else {
					players.get(i).doubleCounter = 0;
				}
				boolean bankr = false;
				int move = d1 + d2;
				if(players.get(i).inJail == true && doubles == false) {
					if(players.get(i).jailTime == 3) {
						if(players.get(i).money >= 50) {
							gui.label.setText("Fine paid. You are free to go.");
							gui.textField.setText("");
							TimeUnit.SECONDS.sleep(3);
							players.get(i).money -= 50;
							players.get(i).jailTime = 0;
							players.get(i).setJail(false);
						}else {
							gui.label.setText("You need " + ((players.get(i).money - 50) * -1) + " to pay your fine. Sell houses, properties, mortage, or declare bankrupt. /n'house', 'prop', 'mort', 'bankrupt'");
							gui.textField.setText("");
							waiting = true;
							while(waiting) {
								TimeUnit.SECONDS.sleep(1);
							}
							boolean debt = true;
							while(debt) {
								waiting = true;
								while(waiting) {
									TimeUnit.SECONDS.sleep(1);
								}
								String dec = in;
								switch(dec){
									case "house":
										gui.label.setText("Select the property of the house you'd like to sell or type 'cancel' to cancel");
										waiting = true;
										while(waiting) {
											TimeUnit.SECONDS.sleep(1);
										}
										ArrayList<BoardSpot> owne = new ArrayList<BoardSpot>();
										//displays properties
										for(int q = 0; q < spaces.length; q++) {
											if(spaces[q].getOwner() == players.get(i) && spaces[q].getType() == "property") {
												owne.add(spaces[q]);
												System.out.println("  " + spaces[q].getName());
											}
										}
										boolean con = false;
										boolean can = false;
										while(can == false) {
											String pr = in.trim();
											
											for(int y = 0; y < owne.size(); y++) {
												if(pr == "cancel") {
													can = true;
													break;
												}
												if(owne.get(y).getName() == pr) {
													con = true;
													break;
												}else if(y == owne.size() -1) {
													gui.label.setText("Invalid choice. Please select another");
													TimeUnit.SECONDS.sleep(3);
												}
											}
											if(con == true) {
												int hopr = owne.get(findInd(owne, pr)).getHouseHotelPrice();
												for(int h = 0; h < spaces.length; h++) {
													if(owne.get(findInd(owne, pr)).equals(spaces[h])) {
														spaces[h].setNumHouse(spaces[h].getNumHouse()-1);
														houses++;
														spaces[h].getOwner().money += hopr;
														break;
													}
												}
												if(players.get(i).money - 50 >= 0) {
													can = true;
													debt = false;
												}
											}
										}
										break;
									case "prop":
										
										ArrayList<BoardSpot> owned = new ArrayList<BoardSpot>();
										//displays properties
										String pp = "";
										for(int q = 0; q < spaces.length; q++) {
											if(spaces[q].getOwner() == players.get(i)) {
												owned.add(spaces[q]);
												pp += "  " + spaces[q].getName();
											}
										}
										gui.label.setText("Select the property you'd like to sell or type 'cancel' to cancel: " + pp);
										gui.textField.setText("");
										
										boolean cont = false;

										boolean cant = false;
										while(cant == false) {
											waiting = true;
											while(waiting) {
												TimeUnit.SECONDS.sleep(1);
											}
											String pri = in.trim();
											for(int y = 0; y < owned.size(); y++) {
												if(pri == "cancel") {
													can = true;
													break;
												}
												if(owned.get(y).getName() == pri) {
													cont = true;
													break;
												}else if(y == owned.size() -1) {
													gui.label.setText("Invalid choice. Please select another." + " Select the property you'd like to sell or type 'cancel' to cancel: " + pp);

													gui.textField.setText("");
												}
											
											}
											if(cont == true) {
												int hope = owned.get(findInd(owned, pri)).getCost();
												for(int h = 0; h < spaces.length; h++) {
													if(owned.get(findInd(owned, pri)).equals(spaces[h])) {
														spaces[h].setOwner(bank);
														spaces[h].getOwner().money += hope;
														break;
													}
												}
												if(players.get(i).money - 50 >= 0) {
													cant = true;
													debt = false;
												}
											}
										}
										break;
									case "mort":
										gui.label.setText("Select the property you'd like to mortage or type 'cancel' to cancel");
										gui.textField.setText("");
										ArrayList<BoardSpot> ownedq = new ArrayList<BoardSpot>();
										//displays properties
										String rr = "";
										for(int q = 0; q < spaces.length; q++) {
											if(spaces[q].getOwner() == players.get(i) && (spaces[q].getType() == "property" || spaces[q].getType() == "property")) {
												ownedq.add(spaces[q]);
												rr += "  " + spaces[q].getName();
											}
										}
										gui.label.setText(rr);
										TimeUnit.SECONDS.sleep(3);
										boolean conq = false;

										boolean canq = false;
										while(canq == false) {
											waiting = true;
											while(waiting) {
												TimeUnit.SECONDS.sleep(1);
											}
											String priq = in.trim();
											for(int y = 0; y < ownedq.size(); y++) {
												if(priq == "cancel") {
													canq = true;
													break;
												}
												if(ownedq.get(y).getName() == priq) {
													conq = true;
													break;
												}else if(y == ownedq.size() -1) {
													gui.label.setText("Invalid choice. Please select another");
													gui.textField.setText("");
													TimeUnit.SECONDS.sleep(3);
												}
											
											}
											if(conq == true) {
												int hopeq = ownedq.get(findInd(ownedq, priq)).getCost()/2;
												for(int h = 0; h < spaces.length; h++) {
													if(ownedq.get(findInd(ownedq, priq)).equals(spaces[h])) {
														spaces[h].setMortT();
														spaces[h].getOwner().money += hopeq;
														break;
													}
												}
												if(players.get(i).money - 50 >= 0) {
													cant = true;
													debt = false;
												}
											}
										}
										break;
									case "bankrupt":
										gui.label.setText("Are you sure you would like to declare bankrupt? 'y' or 'n'");
										gui.textField.setText("");
										boolean quit = true;
										while(quit == true) {
											waiting = true;
											while(waiting) {
												TimeUnit.SECONDS.sleep(1);
											}
											String finale = in;
											switch(finale) {
												case "y": 
													for(int k = 0; k < spaces.length; k++) {
														if(spaces[k].getOwner() == players.get(i)) {
															spaces[k].setOwner(bank);
														}
													}
													players.remove(i);
													i--;
													bankr = true;
													debt = false;
													quit = false;
													break;
												case "n":
													quit = false;
													break;
												default:
													gui.label.setText("Invalid option. Please try again. 'y' or 'n'");
													gui.textField.setText("");
											}
										}
										break;
									default:
										gui.label.setText("Invalid option. Please try again.");
										gui.textField.setText("");
								}
							}
							if(bankr == false) {
								gui.label.setText("Fine paid. You are free to go.");
								TimeUnit.SECONDS.sleep(3);
								players.get(i).money -= 50;
								players.get(i).jailTime = 0;
								players.get(i).setJail(false);
							}
						}
					}
					gui.label.setText("In jail. Turn skipped.");
					TimeUnit.SECONDS.sleep(3);
					continue;
				}else if(players.get(i).inJail == true && doubles == true) {
					gui.label.setText("Freed from jail!.");
					TimeUnit.SECONDS.sleep(3);
					players.get(i).setJail(false);
				}
				if(bankr = true) {
					continue;
				}
				
				//Adding houses
				gui.label.setText("Would you like to add any houses to any properties? 'y'  for yes or 'n' for no");
				while(true) {	
					waiting = true;
					while(waiting) {
						TimeUnit.SECONDS.sleep(1);
					}
					String hous = in;
					switch(hous) {
						case "y":
							ArrayList<BoardSpot> ownerr = new ArrayList<BoardSpot>();
							//displays properties
							String ss = "";
							for(int q = 0; q < spaces.length; q++) {
								if(spaces[q].getOwner() == players.get(i) && spaces[q].getType() == "property") {
									ownerr.add(spaces[q]);
									ss += "  " + spaces[q].getName();
								}
							}

							gui.label.setText("Select the property you would like to add a house or hotel to or type 'done' to continue. " + ss);
							while(true) {
								gui.textField.setText("");
								waiting = true;
								while(waiting) {
									TimeUnit.SECONDS.sleep(1);
								}
								String hp = in;
								if(hp == "done") {
									break;
								}
								for(int u = 0; u < spaces.length; u++) {
									if(ownerr.get(findInd(ownerr, hp)).equals(spaces[u])){
										buyHouse(spaces[u], houses, hotels);
										break;
									}else if(u == spaces.length - 1) {
										gui.label.setText("Invalid entry. Please try again.");
									}
								}
							}
							break;
						case "n":
							break;
						default:
							gui.label.setText("Invalid option. Please try again." + " Would you like to add any houses to any properties? 'y'  for yes or 'n' for no");
					}
					break;
				}
				players.get(i).movement(move);
				gui.label.setText("Player moving...");
				TimeUnit.SECONDS.sleep(3);
				String type = spaces[players.get(i).location].getType();
				switch(type) {
					case "property":
						if(spaces[players.get(i).location].getOwner() != bank || spaces[players.get(i).location].getOwner() != NA) {
							int nuHou = spaces[players.get(i).location].getNumHouse();
							int price = 0;
							switch (nuHou){
								case 0:
									price = spaces[players.get(i).location].getHouse0();
									break;
								case 1:
									price = spaces[players.get(i).location].getHouse1();
									break;
								case 2:
									price = spaces[players.get(i).location].getHouse2();
									break;
								case 3:
									price = spaces[players.get(i).location].getHouse3();
									break;
								case 4:
									price = spaces[players.get(i).location].getHouse4();
									break;
								case 5:
									price = spaces[players.get(i).location].getHotel();
									break;
							}
							if(players.get(i).money - price < 0 && players.get(i).isAI() == true) {
								ArrayList<BoardSpot> o = new ArrayList<BoardSpot>();
								for(int q = 0; q < spaces.length; q++) {
									if(spaces[q].getOwner() == players.get(i) && (spaces[q].getType() == "property" || spaces[q].getType() == "utilities" || spaces[q].getType() == "railroad")) {
										o.add(spaces[q]);
									}
								}
								if(o.size() == 0) {
									players.remove(i);
									gui.label.setText("AI has declared bankrupt");
									TimeUnit.SECONDS.sleep(3);
									i--;
									continue;
								}else {
									while(players.get(i).money - price < 0 && o.size() != 0) {
										sellBank(players.get(i), bank, o.get(0));
										o.remove(0);
									}
									if(o.size() == 0) {
										players.remove(i);
										gui.label.setText("AI has declared bankrupt");
										TimeUnit.SECONDS.sleep(3);
										i--;
										continue;
									}else {
										players.get(i).money -= price;
										
									}
								}
								
							}else if(players.get(i).money - price < 0 && players.get(i).isAI() == false) {
								
								boolean debt = true;
								while(debt) {
									String dec = in;
									gui.label.setText("You need " + ((players.get(i).money - price) * -1) + " to pay rent. Sell houses, properties, mortage, or declare bankrupt. /n'house', 'prop', 'mort', 'bankrupt'");
									gui.textField.setText("");
									waiting = true;
									while(waiting) {
										TimeUnit.SECONDS.sleep(1);
									}
									switch(dec){
										case "house":
											gui.label.setText("Select the property of the house you'd like to sell or type 'cancel' to cancel");
											ArrayList<BoardSpot> owne = new ArrayList<BoardSpot>();
											//displays properties
											for(int q = 0; q < spaces.length; q++) {
												if(spaces[q].getOwner() == players.get(i) && spaces[q].getType() == "property") {
													owne.add(spaces[q]);
													System.out.println("  " + spaces[q].getName());
												}
											}
											boolean con = false;

											boolean can = false;
											while(can == false) {
												String pr = in.trim();
												
												for(int y = 0; y < owne.size(); y++) {
													if(pr == "cancel") {
														can = true;
														break;
													}
													if(owne.get(y).getName() == pr) {
														con = true;
														break;
													}else if(y == owne.size() -1) {
														gui.label.setText("Invalid choice. Please select another. Select the property you'd like to mortage or type 'cancel' to cancel");
													}
												}
												if(con == true) {
													int hopr = owne.get(findInd(owne, pr)).getHouseHotelPrice();
													for(int h = 0; h < spaces.length; h++) {
														if(owne.get(findInd(owne, pr)).equals(spaces[h])) {
															spaces[h].setNumHouse(spaces[h].getNumHouse()-1);
															houses++;
															spaces[h].getOwner().money += hopr;
															break;
														}
													}
													if(players.get(i).money - price >= 0) {
														can = true;
														debt = false;
													}
												}
											}
											break;
										case "prop":
											ArrayList<BoardSpot> owned = new ArrayList<BoardSpot>();
											//displays properties
											String hhh = "";
											for(int q = 0; q < spaces.length; q++) {
												if(spaces[q].getOwner() == players.get(i)) {
													owned.add(spaces[q]);
													hhh += "  " + spaces[q].getName();
												}
											}
											gui.label.setText("Select the property you'd like to sell or type 'cancel' to cancel. " + hhh);
											boolean cont = false;

											boolean cant = false;
											while(cant == false) {
												gui.textField.setText("");
												waiting = true;
												while(waiting) {
													TimeUnit.SECONDS.sleep(1);
												}
												String pri = in.trim();
												for(int y = 0; y < owned.size(); y++) {
													if(pri == "cancel") {
														can = true;
														break;
													}
													if(owned.get(y).getName() == pri) {
														cont = true;
														break;
													}else if(y == owned.size() -1) {
														gui.label.setText("Invalid choice. Please select another. Select the property you'd like to mortage or type 'cancel' to cancel");
													}
												
												}
												if(cont == true) {
													int hope = owned.get(findInd(owned, pri)).getCost();
													for(int h = 0; h < spaces.length; h++) {
														if(owned.get(findInd(owned, pri)).equals(spaces[h])) {
															spaces[h].setOwner(bank);
															spaces[h].getOwner().money += hope;
															break;
														}
													}
													if(players.get(i).money - price >= 0) {
														cant = true;
														debt = false;
													}
												}
											}
											break;
										case "mort":
											gui.label.setText("Select the property you'd like to mortage or type 'cancel' to cancel");
											ArrayList<BoardSpot> ownedq = new ArrayList<BoardSpot>();
											//displays properties
											for(int q = 0; q < spaces.length; q++) {
												if(spaces[q].getOwner() == players.get(i) && spaces[q].getType() == "property") {
													ownedq.add(spaces[q]);
													System.out.println("  " + spaces[q].getName());
												}
											}
											boolean conq = false;

											boolean canq = false;
											while(canq == false) {
												gui.textField.setText("");
												waiting = true;
												while(waiting) {
													TimeUnit.SECONDS.sleep(1);
												}
												String priq = in.trim();
												for(int y = 0; y < ownedq.size(); y++) {
													if(priq == "cancel") {
														canq = true;
														break;
													}
													if(ownedq.get(y).getName() == priq) {
														conq = true;
														break;
													}else if(y == ownedq.size() -1) {
														gui.label.setText("Invalid choice. Please select another. Select the property you'd like to mortage or type 'cancel' to cancel");
													}
												
												}
												if(conq == true) {
													int hopeq = ownedq.get(findInd(ownedq, priq)).getCost()/2;
													for(int h = 0; h < spaces.length; h++) {
														if(ownedq.get(findInd(ownedq, priq)).equals(spaces[h])) {
															spaces[h].setMortT();
															spaces[h].getOwner().money += hopeq;
															break;
														}
													}
													if(players.get(i).money - price >= 0) {
														cant = true;
														debt = false;
													}
												}
											}
											break;
										case "bankrupt":
											gui.label.setText("Are you sure you would like to declare bankrupt? 'y' or 'n'");
											boolean quit = true;
											while(quit == true) {
												gui.textField.setText("");
												waiting = true;
												while(waiting) {
													TimeUnit.SECONDS.sleep(1);
												}
												String finale = in;
												switch(finale) {
													case "y": 
														for(int k = 0; k < spaces.length; k++) {
															if(spaces[k].getOwner() == players.get(i)) {
																spaces[k].setOwner(bank);
															}
														}
														players.remove(i);
														i--;
														quit = false;
														debt = false;
														bankr = true;
														break;
													case "n":
														quit = false;
														break;
													default:
														gui.label.setText("Invalid option. Please try again.");
												}
											}
											break;
										default:
											gui.label.setText("Invalid option. Please try again.");
									}
								}
							}
							if(bankr == false) {
								gui.label.setText("Property owned. Paying rent...");
								TimeUnit.SECONDS.sleep(3);
								rent(players.get(i), spaces[players.get(i).location]);
							}
						}else if(spaces[players.get(i).location].getOwner() == bank || spaces[players.get(i).location].getOwner() != NA){
							if(players.get(i).isAI() || players.get(i).money > spaces[players.get(i).location].getCost()) {
								gui.label.setText("AI " + players.get(i).getNum() + " purchased " + spaces[players.get(i).location].getName());
								TimeUnit.SECONDS.sleep(3);
								buy(players.get(i), spaces[players.get(i).location]);
							}else if(!(players.get(i).isAI())){
								if(players.get(i).money > spaces[players.get(i).location].getCost()) {
									gui.label.setText("Player " + players.get(i).getNum() + "has landed on " + spaces[players.get(i).location].getName() + "Would you like to purchase this property? Enter 'y' for yes or 'n' for no. You currently have $" + players.get(i).money);
									//System.out.println("Would you like to purchase this property? Enter 'y' for yes or 'n' for no. You currently have $" + players.get(i).money);
									TimeUnit.SECONDS.sleep(3);
									boolean buying = true;
									while(buying) {
										gui.textField.setText("");
										waiting = true;
										while(waiting) {
											TimeUnit.SECONDS.sleep(1);
										}
										String pur = in;
										switch(pur) {
											case "y":
												buy(players.get(i), spaces[players.get(i).location]);
												gui.label.setText("Player " + players.get(i).getNum() + " purchased " + spaces[players.get(i).location].getName() + "and has $" + players.get(i).money + " remaining.");
												TimeUnit.SECONDS.sleep(3);
												buying = false;
												break;
											case "n": 
												gui.label.setText("Purchase declined.");
												TimeUnit.SECONDS.sleep(3);
												buying = false;
												break;
											default:
												gui.label.setText("Invalid option. Please enter either 'y' for yes or 'n' for no.");
										}
									}
								}else {
									gui.label.setText("Player " + players.get(i).getNum() + ", you don't have enough money to purchase this property...");
								}
							}
						}
						break;
					case "railroad": 
						if(spaces[players.get(i).location].getOwner() != bank || spaces[players.get(i).location].getOwner() != NA && players.get(i).isAI() == false) {
							int price = 0;
							ArrayList<BoardSpot> rrs = new ArrayList<BoardSpot>();
							for(int p = 0; p < spaces.length; p++) {
								if(spaces[p].getType() == "railroad") {
									rrs.add(spaces[p]);
								}
							}
							int numOfRRs = 0;
							
							Player o = spaces[players.get(i).location].getOwner();
							
							for(int p = 0; p < rrs.size(); p++) {
								if(o == rrs.get(p).getOwner()) {
									numOfRRs++;
								}
							}
							
							switch(numOfRRs) {
								case 1:
									price = 25;
									break;
								case 2:
									price = 50;
									break;
								case 3:
									price = 100;
									break;
								case 4:
									price = 200;
									break;
							}
							
							
							if(players.get(i).money - price < 0 && players.get(i).isAI() == false) {
								gui.label.setText("You need " + ((players.get(i).money - price) * -1) + " to pay rent. Sell houses, properties, mortage, or declare bankrupt. /n'house', 'mort', 'prop', 'bankrupt'");
								boolean debt = true;
								while(debt) {
									gui.textField.setText("");
									waiting = true;
									while(waiting) {
										TimeUnit.SECONDS.sleep(1);
									}
									String dec = in;
									switch(dec){
										case "house":
											
											ArrayList<BoardSpot> owne = new ArrayList<BoardSpot>();
											//displays properties
											String lll = "";
											for(int q = 0; q < spaces.length; q++) {
												if(spaces[players.get(i).location].getOwner() == players.get(i)) {
													owne.add(spaces[q]);
													lll += "  " + spaces[q].getName();
												}
											}
											gui.label.setText("Select the property of the house you'd like to sell or type 'cancel' to cancel: " + lll);
											boolean con = false;
											boolean can = false;
											while(can == false) {
												String pr = in.trim();
												
												for(int y = 0; y < owne.size(); y++) {
													if(pr == "cancel") {
														can = true;
														break;
													}
													if(owne.get(y).getName() == pr) {
														con = true;
														break;
													}else if(y == owne.size() -1) {
														gui.label.setText("Invalid choice. Please select another or type 'cancel'.");
													}
												}
												if(con == true) {
													int hopr = owne.get(findInd(owne, pr)).getHouseHotelPrice();
													for(int h = 0; h < spaces.length; h++) {
														if(owne.get(findInd(owne, pr)).equals(spaces[h])) {
															spaces[h].setNumHouse(spaces[h].getNumHouse()-1);
															houses++;
															spaces[h].getOwner().money += hopr;
															break;
														}
													}
													if(players.get(i).money - price >= 0) {
														can = true;
														debt = false;
													}
												}
											}
											break;
										case "prop":
											gui.label.setText("Select the property you'd like to sell or type 'cancel' to cancel");
											ArrayList<BoardSpot> owned = new ArrayList<BoardSpot>();
											//displays properties
											for(int q = 0; q < spaces.length; q++) {
												if(spaces[players.get(i).location].getOwner() == players.get(i)) {
													owned.add(spaces[q]);
													gui.label.setText("  " + spaces[q].getName());
												}
											}
											boolean cont = false;

											boolean cant = false;
											while(cant == false) {
												gui.textField.setText("");
												waiting = true;
												while(waiting) {
													TimeUnit.SECONDS.sleep(1);
												}
												String pri = in.trim();
												for(int y = 0; y < owned.size(); y++) {
													if(pri == "cancel") {
														can = true;
														break;
													}
													if(owned.get(y).getName() == pri) {
														cont = true;
														break;
													}else if(y == owned.size() -1) {
														gui.label.setText("Invalid choice. Please select another");
													}
												
												}
												if(cont == true) {
													int hope = owned.get(findInd(owned, pri)).getCost();
													for(int h = 0; h < spaces.length; h++) {
														if(owned.get(findInd(owned, pri)).equals(spaces[h])) {
															spaces[h].setOwner(bank);
															spaces[h].getOwner().money += hope;
															break;
														}
													}
													if(players.get(i).money - price >= 0) {
														cant = true;
														debt = false;
													}
												}
											}
											
										case "mort":
											gui.label.setText("Select the property you'd like to mortage or type 'cancel' to cancel");
											ArrayList<BoardSpot> ownedq = new ArrayList<BoardSpot>();
											//displays properties
											for(int q = 0; q < spaces.length; q++) {
												if(spaces[q].getOwner() == players.get(i) && (spaces[q].getType() == "property" || spaces[q].getType() == "utility")) {
													ownedq.add(spaces[q]);
													System.out.println("  " + spaces[q].getName());
												}
											}
											boolean conq = false;

											boolean canq = false;
											while(canq == false) {
												gui.textField.setText("");
												waiting = true;
												while(waiting) {
													TimeUnit.SECONDS.sleep(1);
												}
												String priq = in.trim();
												for(int y = 0; y < ownedq.size(); y++) {
													if(priq == "cancel") {
														canq = true;
														break;
													}
													if(ownedq.get(y).getName() == priq) {
														conq = true;
														break;
													}else if(y == ownedq.size() -1) {
														gui.label.setText("Invalid choice. Please select another");
													}
												
												}
												if(conq == true) {
													int hopeq = ownedq.get(findInd(ownedq, priq)).getCost() / 2;
													for(int h = 0; h < spaces.length; h++) {
														if(ownedq.get(findInd(ownedq, priq)).equals(spaces[h])) {
															spaces[h].setMortT();
															spaces[h].getOwner().money += hopeq;
															break;
														}
													}
													if(players.get(i).money - price >= 0) {
														cant = true;
														debt = false;
													}
												}
											}
											break;
											
										case "bankrupt":
											gui.label.setText("Are you sure you would like to declare bankrupt? 'y' or 'n'");
											boolean quit = true;
											while(quit == true) {
												gui.textField.setText("");
												waiting = true;
												while(waiting) {
													TimeUnit.SECONDS.sleep(1);
												}
												String finale = in;
												switch(finale) {
													case "y": 
														for(int k = 0; k < spaces.length; k++) {
															if(spaces[k].getOwner() == players.get(i)) {
																spaces[k].setOwner(bank);
															}
														}
														players.remove(i);
														i--;
														bankr = true;
														quit = false;
														debt = false;
														break;
													case "n":
														quit = false;
														break;
													default:
														gui.label.setText("Invalid option. Please try again.");
												}
											}
											break;
										default:
											gui.label.setText("Invalid option. Please try again.");
									}
								}
							}
							if(players.get(i).money - price < 0 && players.get(i).isAI() == true) {
								ArrayList<BoardSpot> eww = new ArrayList<BoardSpot>();
								for(int q = 0; q < spaces.length; q++) {
									if(spaces[q].getOwner() == players.get(i) && spaces[q].getType() == "property") {
										eww.add(spaces[q]);
									}
								}
								if(eww.size() == 0) {
									players.remove(i);
									gui.label.setText("AI has declared bankrupt");
									TimeUnit.SECONDS.sleep(3);
									i--;
									continue;
								}else {
									while(players.get(i).money - price < 0 && eww.size() != 0) {
										sellBank(players.get(i), bank, eww.get(0));
										eww.remove(0);
									}
									if(eww.size() == 0) {
										players.remove(i);
										gui.label.setText("AI has declared bankrupt");
										TimeUnit.SECONDS.sleep(3);
										i--;
										continue;
									}else {
										players.get(i).money -= price;
										
									}
								}
								break;
							}
							if(bankr == false) {
								gui.label.setText("Railroad owned. Paying rent...");
								TimeUnit.SECONDS.sleep(3);
								players.get(i).money -= price;
							}
						}else if(spaces[players.get(i).location].getOwner() == bank || spaces[players.get(i).location].getOwner() != NA){
							if(players.get(i).isAI() || players.get(i).money > spaces[players.get(i).location].getCost()) {
								gui.label.setText("AI " + players.get(i).getNum() + " purchased " + spaces[players.get(i).location].getName());
								TimeUnit.SECONDS.sleep(3);
								buy(players.get(i), spaces[players.get(i).location]);
							}else if(!(players.get(i).isAI())){
								if(players.get(i).money > spaces[players.get(i).location].getCost()) {
									gui.label.setText("Player " + players.get(i).getNum() + "has landed on " + spaces[players.get(i).location].getName() + "Would you like to purchase this property? Enter 'y' for yes or 'n' for no. You currently have $" + players.get(i).money);
									TimeUnit.SECONDS.sleep(3);
									boolean buying = true;
									while(buying) {
										String pur = in;
										switch(pur) {
											case "y":
												buy(players.get(i), spaces[players.get(i).location]);
												gui.label.setText("Player " + players.get(i).getNum() + " purchased " + spaces[players.get(i).location].getName() + "and has $" + players.get(i).money + " remaining.");
												buying = false;
												break;
											case "n": 
												gui.label.setText("Purchase declined.");
												TimeUnit.SECONDS.sleep(3);
												buying = false;
												break;
											default:
												gui.label.setText("Invalid option. Please enter either 'y' for yes or 'n' for no.");
										}
									}
								}else {
									gui.label.setText("Player " + players.get(i).getNum() + ", you don't have enough money to purchase this property...");
									TimeUnit.SECONDS.sleep(3);
								}
							}
						}
						break;
					case "GoToJail":
						gui.label.setText("Player " + players.get(i).getNum() + " has been sent to jail.");
						TimeUnit.SECONDS.sleep(3);
						players.get(i).location = 10;
						players.get(i).setJail(true);
						break;
					case "utility":
						int utilPrice = 0;
						if(spaces[11].getOwner() == spaces[27].getOwner()) {
							utilPrice = move * 10;
						}else {
							utilPrice = move * 4;
						}
						
						if(players.get(i).money - utilPrice < 0) {
							gui.label.setText("You need " + ((players.get(i).money - utilPrice) * -1) + " to pay rent. Sell houses, properties, mortage, or declare bankrupt. /n'house', 'mort', 'prop', 'bankrupt'");
							boolean debt = true;
							while(debt) {
								gui.textField.setText("");
								waiting = true;
								while(waiting) {
									TimeUnit.SECONDS.sleep(1);
								}
								String dec = in;
								switch(dec){
									case "house":
										ArrayList<BoardSpot> owne = new ArrayList<BoardSpot>();
										//displays properties
										String rr = "";
										for(int q = 0; q < spaces.length; q++) {
											if(spaces[players.get(i).location].getOwner() == players.get(i)) {
												owne.add(spaces[q]);
												rr += "  " + spaces[q].getName();
											}
										}
										gui.label.setText("Select the property of the house you'd like to sell or type 'cancel' to cancel. " + rr);
										boolean con = false;
										boolean can = false;
										while(can == false) {
											gui.textField.setText("");
											waiting = true;
											while(waiting) {
												TimeUnit.SECONDS.sleep(1);
											}
											String pr = in.trim();
											
											for(int y = 0; y < owne.size(); y++) {
												if(pr == "cancel") {
													can = true;
													break;
												}
												if(owne.get(y).getName() == pr) {
													con = true;
													break;
												}else if(y == owne.size() -1) {
													gui.label.setText("Invalid choice. Please select another");
												}
											}
											if(con == true) {
												int hopr = owne.get(findInd(owne, pr)).getHouseHotelPrice();
												for(int h = 0; h < spaces.length; h++) {
													if(owne.get(findInd(owne, pr)).equals(spaces[h])) {
														spaces[h].setNumHouse(spaces[h].getNumHouse()-1);
														houses++;
														spaces[h].getOwner().money += hopr;
														break;
													}
												}
												if(players.get(i).money - utilPrice >= 0) {
													can = true;
													debt = false;
												}
											}
										}
										break;
									case "prop":
										ArrayList<BoardSpot> owned = new ArrayList<BoardSpot>();
										//displays properties
										String dd = "";
										for(int q = 0; q < spaces.length; q++) {
											if(spaces[players.get(i).location].getOwner() == players.get(i)) {
												owned.add(spaces[q]);
												dd += "  " + spaces[q].getName();
											}
										}
										gui.label.setText("Select the property you'd like to sell or type 'cancel' to cancel. " + dd);
										boolean cont = false;

										boolean cant = false;
										while(cant == false) {
											gui.textField.setText("");
											waiting = true;
											while(waiting) {
												TimeUnit.SECONDS.sleep(1);
											}
											String pri = in.trim();
											for(int y = 0; y < owned.size(); y++) {
												if(pri == "cancel") {
													can = true;
													break;
												}
												if(owned.get(y).getName() == pri) {
													cont = true;
													break;
												}else if(y == owned.size() -1) {
													gui.label.setText("Invalid choice. Please select another");
													continue;
												}
											
											}
											if(cont == true) {
												int hope = owned.get(findInd(owned, pri)).getCost();
												for(int h = 0; h < spaces.length; h++) {
													if(owned.get(findInd(owned, pri)).equals(spaces[h])) {
														spaces[h].setOwner(bank);
														spaces[h].getOwner().money += hope;
														break;
													}
												}
												if(players.get(i).money - utilPrice >= 0) {
													cant = true;
													debt = false;
												}
											}
										}
										
									case "mort":
										ArrayList<BoardSpot> ownedq = new ArrayList<BoardSpot>();
										//displays properties
										String deedee = "";
										for(int q = 0; q < spaces.length; q++) {
											if(spaces[q].getOwner() == players.get(i) && (spaces[q].getType() == "property" || spaces[q].getType() == "utility")) {
												ownedq.add(spaces[q]);
												deedee += "  " + spaces[q].getName();
											}
										}
										gui.label.setText("Select the property you'd like to mortage or type 'cancel' to cancel. " + deedee);
										boolean conq = false;

										boolean canq = false;
										while(canq == false) {
											gui.textField.setText("");
											waiting = true;
											while(waiting) {
												TimeUnit.SECONDS.sleep(1);
											}
											String priq = in.trim();
											for(int y = 0; y < ownedq.size(); y++) {
												if(priq == "cancel") {
													canq = true;
													break;
												}
												if(ownedq.get(y).getName() == priq) {
													conq = true;
													break;
												}else if(y == ownedq.size() -1) {
													gui.label.setText("Invalid choice. Please select another");
													continue;
												}
											
											}
											if(conq == true) {
												int hopeq = ownedq.get(findInd(ownedq, priq)).getCost() / 2;
												for(int h = 0; h < spaces.length; h++) {
													if(ownedq.get(findInd(ownedq, priq)).equals(spaces[h])) {
														spaces[h].setMortT();
														spaces[h].getOwner().money += hopeq;
														break;
													}
												}
												if(players.get(i).money - utilPrice >= 0) {
													cant = true;
													debt = false;
												}
											}
										}
										break;
										
									case "bankrupt":
										gui.label.setText("Are you sure you would like to declare bankrupt? 'y' or 'n'");
										boolean quit = true;
										while(quit == true) {
											gui.textField.setText("");
											waiting = true;
											while(waiting) {
												TimeUnit.SECONDS.sleep(1);
											}
											String finale = in;
											switch(finale) {
												case "y": 
													for(int k = 0; k < spaces.length; k++) {
														if(spaces[k].getOwner() == players.get(i)) {
															spaces[k].setOwner(bank);
														}
													}
													players.remove(i);
													i--;
													bankr = true;
													quit = false;
													debt = false;
													break;
												case "n":
													quit = false;
													break;
												default:
													gui.label.setText("Invalid option. Please try again.");
											}
										}
										break;
									default:
										gui.label.setText("Invalid option. Please try again.");
								}
							}
						}
						if(players.get(i).money - utilPrice < 0 && players.get(i).isAI() == true) {
							ArrayList<BoardSpot> ewww = new ArrayList<BoardSpot>();
							for(int q = 0; q < spaces.length; q++) {
								if(spaces[q].getOwner() == players.get(i) && spaces[q].getType() == "property") {
									ewww.add(spaces[q]);
								}
							}
							if(ewww.size() == 0) {
								gui.label.setText("AI has declared bankrupt");
								i--;
								continue;
							}else {
								while(players.get(i).money - utilPrice < 0 && ewww.size() != 0) {
									sellBank(players.get(i), bank, ewww.get(0));
									ewww.remove(0);
								}
								if(ewww.size() == 0) {
									gui.label.setText("AI has declared bankrupt");
									i--;
									continue;
								}else {
									players.get(i).money -= utilPrice;
									
								}
							}
							break;
						}
						if(bankr == false) {
							gui.label.setText("Utility owned. Paying rent...");

							TimeUnit.SECONDS.sleep(3);
							players.get(i).money -= utilPrice;
						}
						break;
					case "tax":
						int taxPrice = 0;
						if(players.get(i).location == 4) {
							gui.label.setText("Choose to pay either $200 or 10% of all assets. '200' or '10%'");
							while(true) {
								gui.textField.setText("");
								waiting = true;
								while(waiting) {
									TimeUnit.SECONDS.sleep(1);
								}
								String cho = in;
								switch(cho) {
									case "200":
										taxPrice = 200;
										break;
									case "10%":
										taxPrice += players.get(i).money;
										for(int q = 0; q < spaces.length; q++) {
											if(spaces[q].getOwner() == players.get(i) || spaces[q].isMortaged() == false) {
												taxPrice += spaces[q].getCost();
											}
										}
										for(int q = 0; q < spaces.length; q++) {
											if(spaces[q].getOwner() == players.get(i) || spaces[q].isMortaged() == true) {
												taxPrice += spaces[q].getMort();
											}
										}
										for(int q = 0; q < spaces.length; q++) {
											if(spaces[q].getOwner() == players.get(i)) {
												taxPrice += spaces[q].getNumHouse() * spaces[q].getHouseHotelPrice();
											}
										}
										taxPrice = taxPrice / 10;
										break;
									default:
										gui.label.setText("Invaild choice. Please try again.");
								}
								if(taxPrice > 0) {
									break;
								}
							}
						}else {
							taxPrice = 75;
						}
						
						if(players.get(i).money - taxPrice < 0) {
							gui.label.setText("You need " + ((players.get(i).money - taxPrice) * -1) + " to pay taxes. Sell houses, properties, mortage, or declare bankrupt. /n'house', 'mort', 'prop', 'bankrupt'");
							boolean debt = true;
							while(debt) {
								gui.textField.setText("");
								waiting = true;
								while(waiting) {
									TimeUnit.SECONDS.sleep(1);
								}
								String dec = in;
								switch(dec){
									case "house":
										ArrayList<BoardSpot> owne = new ArrayList<BoardSpot>();
										//displays properties
										String qqq = "";
										for(int q = 0; q < spaces.length; q++) {
											if(spaces[players.get(i).location].getOwner() == players.get(i)) {
												owne.add(spaces[q]);
												qqq += "  " + spaces[q].getName();
											}
										}
										gui.label.setText("Select the property of the house you'd like to sell or type 'cancel' to cancel. " + qqq);
										boolean con = false;
										boolean can = false;
										while(can == false) {
											gui.textField.setText("");
											waiting = true;
											while(waiting) {
												TimeUnit.SECONDS.sleep(1);
											}
											String pr = in.trim();
											
											for(int y = 0; y < owne.size(); y++) {
												if(pr == "cancel") {
													can = true;
													break;
												}
												if(owne.get(y).getName() == pr) {
													con = true;
													break;
												}else if(y == owne.size() -1) {
													gui.label.setText("Invalid choice. Please select another");
												}
											}
											if(con == true) {
												int hopr = owne.get(findInd(owne, pr)).getHouseHotelPrice();
												for(int h = 0; h < spaces.length; h++) {
													if(owne.get(findInd(owne, pr)).equals(spaces[h])) {
														spaces[h].setNumHouse(spaces[h].getNumHouse()-1);
														houses++;
														spaces[h].getOwner().money += hopr;
														break;
													}
												}
												if(players.get(i).money - taxPrice >= 0) {
													can = true;
													debt = false;
												}
											}
										}
										break;
									case "prop":
										gui.label.setText("Select the property you'd like to sell or type 'cancel' to cancel");
										ArrayList<BoardSpot> owned = new ArrayList<BoardSpot>();
										//displays properties
										for(int q = 0; q < spaces.length; q++) {
											if(spaces[players.get(i).location].getOwner() == players.get(i)) {
												owned.add(spaces[q]);
												System.out.println("  " + spaces[q].getName());
											}
										}
										boolean cont = false;

										boolean cant = false;
										while(cant == false) {
											gui.textField.setText("");
											waiting = true;
											while(waiting) {
												TimeUnit.SECONDS.sleep(1);
											}
											String pri = in.trim();
											for(int y = 0; y < owned.size(); y++) {
												if(pri == "cancel") {
													can = true;
													break;
												}
												if(owned.get(y).getName() == pri) {
													cont = true;
													break;
												}else if(y == owned.size() -1) {
													gui.label.setText("Invalid choice. Please select another");
												}
											
											}
											if(cont == true) {
												int hope = owned.get(findInd(owned, pri)).getCost();
												for(int h = 0; h < spaces.length; h++) {
													if(owned.get(findInd(owned, pri)).equals(spaces[h])) {
														spaces[h].setOwner(bank);
														spaces[h].getOwner().money += hope;
														break;
													}
												}
												if(players.get(i).money - taxPrice >= 0) {
													cant = true;
													debt = false;
												}
											}
										}
										
									case "mort":
										ArrayList<BoardSpot> ownedq = new ArrayList<BoardSpot>();
										//displays properties
										String fff = "";
										for(int q = 0; q < spaces.length; q++) {
											if(spaces[q].getOwner() == players.get(i) && (spaces[q].getType() == "property" || spaces[q].getType() == "utility")) {
												ownedq.add(spaces[q]);
												fff += "  " + spaces[q].getName();
											}
										}
										gui.label.setText("Select the property you'd like to mortage or type 'cancel' to cancel. " + fff);
										boolean conq = false;

										boolean canq = false;
										while(canq == false) {
											gui.textField.setText("");
											waiting = true;
											while(waiting) {
												TimeUnit.SECONDS.sleep(1);
											}
											String priq = in.trim();
											for(int y = 0; y < ownedq.size(); y++) {
												if(priq == "cancel") {
													canq = true;
													break;
												}
												if(ownedq.get(y).getName() == priq) {
													conq = true;
													break;
												}else if(y == ownedq.size() -1) {
													gui.label.setText("Invalid choice. Please select another");
												}
											
											}
											if(conq == true) {
												int hopeq = ownedq.get(findInd(ownedq, priq)).getCost() / 2;
												for(int h = 0; h < spaces.length; h++) {
													if(ownedq.get(findInd(ownedq, priq)).equals(spaces[h])) {
														spaces[h].setMortT();
														spaces[h].getOwner().money += hopeq;
														break;
													}
												}
												if(players.get(i).money - taxPrice >= 0) {
													cant = true;
													debt = false;
												}
											}
										}
										break;
										
									case "bankrupt":
										gui.label.setText("Are you sure you would like to declare bankrupt? 'y' or 'n'");
										boolean quit = true;
										while(quit == true) {
											gui.textField.setText("");
											waiting = true;
											while(waiting) {
												TimeUnit.SECONDS.sleep(1);
											}
											String finale = in;
											switch(finale) {
												case "y": 
													for(int k = 0; k < spaces.length; k++) {
														if(spaces[k].getOwner() == players.get(i)) {
															spaces[k].setOwner(bank);
														}
													}
													players.remove(i);
													i--;
													bankr = true;
													quit = false;
													debt = false;
													break;
												case "n":
													quit = false;
													break;
												default:
													System.out.println("Invalid option. Please try again.");
											}
										}
										break;
									default:
										System.out.println("Invalid option. Please try again.");
								}
							}
						}
						if(players.get(i).money - taxPrice < 0 && players.get(i).isAI() == true) {
							ArrayList<BoardSpot> ewww = new ArrayList<BoardSpot>();
							for(int q = 0; q < spaces.length; q++) {
								if(spaces[q].getOwner() == players.get(i) && spaces[q].getType() == "property") {
									ewww.add(spaces[q]);
								}
							}
							if(ewww.size() == 0) {
								System.out.println("AI has declared bankrupt");
								TimeUnit.SECONDS.sleep(3);
								i--;
								continue;
							}else {
								while(players.get(i).money - taxPrice < 0 && ewww.size() != 0) {
									sellBank(players.get(i), bank, ewww.get(0));
									ewww.remove(0);
								}
								if(ewww.size() == 0) {
									System.out.println("AI has declared bankrupt");
									TimeUnit.SECONDS.sleep(3);
									i--;
									continue;
								}else {
									players.get(i).money -= taxPrice;
									
								}
							}
							break;
						}
						if(bankr == false) {
							System.out.println("Paying taxes...");
							TimeUnit.SECONDS.sleep(3);
							players.get(i).money -= taxPrice;
						}
						break;
					default:
						break;
				}
				
				if(doubles == true) {
					i--;
					continue;
				}
			}
			
		}
		
	}
	
	public static int findInd(ArrayList<BoardSpot> array, String name) {
		for(int y = 0; y < array.size(); y++) {
			if(name == array.get(y).getName()) {
				return y;
			}
		}
		
		return -1;
	}
		
	public static void buy (Player buyer, BoardSpot property ) {
		buyer.money -= property.getCost();
		property.setOwner(buyer);
		property.setMortF();
	}
	
	public static void mortgage(Player owner, BoardSpot property) {
		owner.money+=property.getMort();
		property.setMortT();
	}
	
	public static void sellPlayer (Player seller, Player buyer, BoardSpot property, int price) {
		buyer.money-=price;
		seller.money+=price;
		property.setOwner(buyer);
	}
	
	public static void sellBank (Player seller, Player bank, BoardSpot property) {
		seller.money+=property.getCost();
		property.setOwner(bank);
	}
	
	public static void rent (Player renter, BoardSpot property) {
		switch (property.getNumHouse()){
		case 0:
			property.getOwner().money += property.getHouse0();
			renter.money -= property.getHouse0();
			break;
		case 1:
			property.getOwner().money += property.getHouse1();
			renter.money -= property.getHouse1();
			break;
		case 2:
			property.getOwner().money += property.getHouse2();
			renter.money -= property.getHouse2();
			break;
		case 3:
			property.getOwner().money += property.getHouse3();
			renter.money -= property.getHouse3();
			break;
		case 4:
			property.getOwner().money += property.getHouse4();
			renter.money -= property.getHouse4();
			break;
		case 5:
			property.getOwner().money += property.getHotel();
			renter.money -= property.getHotel();
			break;
		}
	}

	public static void buyHouse (BoardSpot property, int houses, int hotels) {
		if (property.getNumHouse()<5) {
			if(property.getOwner().money >= property.getHouseHotelPrice()) {
				property.getOwner().money -= property.getHouseHotelPrice();
				property.setNumHouse(property.getNumHouse()+1);
				if(property.getNumHouse() == 5) {
					hotels--;
					System.out.println("Hotel placed.");
				}else {
					houses--;
					System.out.println("House placed.");
				}
			}else {
				System.out.println("You can't afford a house/hotel.");
				return;
			}
		} else {
			System.out.println("You already have a hotel. You can't build anymore on this property.");
		}
	}

	public static void sellHouse (BoardSpot property, int houses, int hotels) {
		if (property.getNumHouse()>0) {
			property.getOwner().money += property.getHouseHotelPrice();
			property.setNumHouse(property.getNumHouse()-1);
			if(property.getNumHouse() == 4) {
				hotels++;
			}else {
				houses++;
			}
		} else {
			System.out.println("There are no houses to sell on this property.");
		}
	}
	
	public static void payBank (Player player, int cost) {
		player.money -= cost;
	}

//gives players options when they don't have cash
//returns true when they do
//needs further actions
	public static Boolean enoughCash (Player player, int cost) {
		if(player.money >= cost) {
			return true;
		}
		while (player.money < cost){
			System.out.println(player.token + " doesn't have enough money.");
			System.out.println("What would you like to do?");
			System.out.println("Sell property");
			System.out.println("Mortgage property");
			System.out.println("Declare Bankruptcy");
			Scanner decision = new Scanner(System.in);
			String decide = decision.next();
			decision.close();
			switch (decide) {
			case "Sell property":
				if (enoughCash(player,cost)) {
					return true;
				}else {
					continue;
				}
			case "Mortgage property":
				if (enoughCash(player, cost)) {
					return true;
				}else {
					continue;
				}
			case "Declare Bankruptcy":
				return false;
			default:
				
			}
		}
		return false;
	}
	
	public static boolean isInt(String s){
	    try{
	        Integer.parseInt(s);
	        return true;
	    }catch (NumberFormatException ex){
	        return false;
	    }
	}
	
	public static String getText(String text) {
		return text;
	}
}

