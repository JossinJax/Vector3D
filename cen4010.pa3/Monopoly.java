package cen4010.pa2;
import java.util.*;  
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;



class Player {
	public int money;
	public String token;
	public int location = 0;
	public boolean AI;
	public int pNumber;
	public boolean inJail = false;
	public int jailTime = 0;
	public int doubleCounter = 0;
	
	public Player() {
	}
	public Player(boolean comp, int num) {
		this.money = 1500;
		this.AI = comp;
		this.pNumber = num;
	}
	
	public Player(String token, boolean comp) {
		this.money = 1500;
		this.token = token;
		this.AI = comp;
	}
	
	public void setToken(String tok) {
		this.token = tok;
	}
	
	public boolean isAI() {
		return this.AI;
	}
	
	public void setAI(boolean temp) {
		this.AI = temp;
	}
	
	public String getToken() {
		return this.token;
	}
	
	public int getNum() {
		return this.pNumber;
	}
	
	public void setJail(boolean inJ) {
		this.inJail = inJ;
	}
	
	public void movement(int move) {
		this.location += move;
//adds 200 to cash if lands on or passes go
		if (this.location>=39) {
			this.money+=200;
		}
//when location goes outside of the board, reduce by 40 to bring it back to the first BoardSpot
		if (this.location>39) {
			this.location-=40;
		}
	}
}



class BoardSpot {
	private String nameOfSpace;
	private String spaceColor;
	private String spotType;
	private Player owner;
	private int cost;
	private int mort;
	private int house0;
	private int house1;
	private int house2;
	private int house3;
	private int house4;
	private int hotel;
	private int houseHotelCost;
	private boolean mortaged;
	private int numHouse;
	
	
	public BoardSpot() {
		
	}
	public BoardSpot(String spot, String color, String bSpot, Player whoOwn, int spotCost, int mortage, int ho0, int ho1, int ho2, int ho3, int ho4, int hot, int pri, boolean m, int n) {
		this.nameOfSpace = spot;
		this.spaceColor = color;
		this.spotType = bSpot;
		this.owner = whoOwn;
		this.cost = spotCost;
		this.mort = mortage;
		this.house0 = ho0;
		this.house1 = ho1;
		this.house2 = ho2;
		this.house3 = ho3;
		this.house4 = ho4;
		this.hotel = hot;
		this.houseHotelCost = pri;
		this.mortaged = m;
		this.numHouse = n;
	}
	public String getName() {
		return this.nameOfSpace;
	}
	public String getColor() {
		return this.spaceColor;
	}
	public String getType() {
		return this.spotType;
	}
	public Player getOwner() {
		return this.owner;
	}
	public int getCost() {
		return this.cost;
	}
	public int getMort() {
		return this.mort;
	}
	public int getHouse0() {
		return this.house0;
	}
	public int getHouse1() {
		return this.house1;
	}
	public int getHouse2() {
		return this.house2;
	}
	public int getHouse3() {
		return this.house3;
	}
	public int getHouse4() {
		return this.house4;
	}
	public int getHotel() {
		return this.hotel;
	}
	public int getHouseHotelPrice() {
		return this.houseHotelCost;
	}
	public void setOwner(Player newOwner) {
		this.owner = newOwner;
	}
	public void setMortT() {
		this.mortaged = true;
	}
	public void setMortF() {
		this.mortaged = false;
	}
	public int getNumHouse() {
		return this.numHouse;
	}
	public void setNumHouse(int num) {
		this.numHouse = num;
	}
	public boolean isMortaged() {
		return this.mortaged;
	}
}

class Reminder{
	Timer timer;
	public boolean timeRem = true;
	
	public Reminder() {
		timer = new Timer();
		timer.schedule(new RemindTask(), 600 * 1000);
	}
	class RemindTask extends TimerTask{
		public void run() {
			timeRem = false;
		}
	}
	
}

public class Monopoly{
	
	public static void main(String args[]) {
		int houses = 32;
		int hotels = 12;
		Player bank = new Player();
		Player NA = new Player();

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
		
		System.out.println("Welcome to Monopoly! How many people are playing?");
		Scanner in = new Scanner(System.in);
		int humanPlayers;
		int aiPlayers = 0;
		while(true) {
			int entry = in.nextInt();
			if(entry > 8) {
				System.out.println("Too many players! Enter a new player count.");
			}else if(entry < 1) {
				System.out.println("Invalid number. Enter a new player count.");
			}else {
				humanPlayers = entry;
				System.out.println(humanPlayers + " people are playing!");
				break;
			}
		}
		while(true) {
			if(humanPlayers < 8) {
				System.out.println("How many AI Players would you like?");
				int entry = in.nextInt();
				if(entry  < 0) {
					System.out.println("Invalid number. Enter a new player count.");
				}else if(entry  < 1 && humanPlayers < 2) {
					System.out.println("You can't play alone. Add an AI player.");
				}else {
					aiPlayers = entry;
					System.out.println("Added " + aiPlayers +" AI players.");
					break;
				}
			}else {
				break;
			}
		}
		
		int totalPlayers = humanPlayers + aiPlayers;
		System.out.println("There are " + totalPlayers + " total players!");
		
		Integer[] turnNumber = new Integer[12];
		Player[] playerOrder = new Player[12];
		Random dieOne = new Random();
		Random dieTwo = new Random();
		
		//Assigning Turn Order
		
		for(int i = 0; i < humanPlayers; i++) {
			System.out.println("Rolling play order for Player " + i+1);
			while(true) {
				int diceRoll = dieOne.nextInt(7) + dieTwo.nextInt(7);
				if(turnNumber[diceRoll] != diceRoll) {
					turnNumber[diceRoll] = diceRoll;
					Player p = new Player(false, i);
					playerOrder[diceRoll] = p;
					break;
				}else {
					continue;
				}
			}
		}
		for(int i = 0; i < aiPlayers; i++) {
			System.out.println("Rolling play order for Player(AI) " + i+1+humanPlayers);
			while(true) {
				int diceRoll = dieOne.nextInt(7) + dieTwo.nextInt(7);
				if(turnNumber[diceRoll] != diceRoll) {
					turnNumber[diceRoll] = diceRoll;
					Player c = new Player(true, humanPlayers + i);
					playerOrder[diceRoll] = c;
					break;
				}else {
					continue;
				}
			}
		}
		
		ArrayList<Player> players = new ArrayList<Player>();
		for(int i = 12; i > 0; i--) {
			if(turnNumber[i] != null) {
				players.add(playerOrder[i]);
			}
		}
		System.out.println();
		System.out.print("Turn Order: ");
		for(int i = 0; i < players.size(); i++) {
			if(i == players.size() - 1) {
				System.out.print("Player " + players.get(i).getNum());
			}else {
				System.out.print("Player " + players.get(i).getNum() + ", ");
			}
		}
		System.out.println();
		
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
				System.out.println("Player " + players.get(i).getNum() + ", please pick your token from the list");
				for(int p = 0; p < tokens.size(); p++) {
					System.out.println("  " + tokens.get(p));
				}
				while(true) {
					String choice = in.nextLine();
					choice = choice.trim();
					if(tokens.contains(choice)) {
						players.get(i).setToken(choice);
						tokens.remove(tokens.indexOf(choice));
						System.out.println("Player " + players.get(i).getNum() + "selected " + choice);
						break;
					}else {

						System.out.println("Please enter a valid choice");
					}
				}
			}
		}
		for(int i = 0; i < players.size(); i++) {
			if(players.get(i).isAI()) {
				players.get(i).setToken(tokens.get(0));
				System.out.println("Player(AI) " + players.get(i).getNum() + "assigned " + tokens.get(0));
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
				System.out.println("The winner is Player " + players.get(winner).getNum() + " with " + winningMon + "!");
				in.close();
				System.exit(0);
			}
			for(int i = 0; i < players.size(); i++) {
				//If in jail
				if(players.get(i).inJail) {
					System.out.println("You are in jail. Pay $50 to free yourself or roll to be freed. 'pay' or 'roll'");
					String j = in.nextLine();
					switch(j) {
						case "pay":
							players.get(i).money -= 50;
							players.get(i).setJail(false);
							players.get(i).jailTime = 0; 
							System.out.println("Fine paid. You are free!");
							break;
						case "roll":
							break;
						default:
							System.out.println("Invalid option. Please try again.");
					}
				}
				//Rolling movement
				if(players.get(i).isAI()) {
					System.out.println("AI " + players.get(i).getNum() + "'s turn");
					System.out.println("Rolling dice...");
				}else {
					System.out.println("Player " + players.get(i).getNum() + "'s turn");
					System.out.println("Rolling dice...");
				}
				boolean doubles = false;
				Random die = new Random();
				int d1 = die.nextInt(7);
				int d2 = die.nextInt(7);
				if(d1 == d2) {
					doubles = true;
					players.get(i).doubleCounter += 1;
					if(players.get(i).doubleCounter == 4) {
						System.out.println("Speeding! Go to Jail!");
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
							System.out.println("Fine paid. You are free to go.");
							players.get(i).money -= 50;
							players.get(i).jailTime = 0;
							players.get(i).setJail(false);
						}else {
							System.out.println("You need " + ((players.get(i).money - 50) * -1) + " to pay your fine. Sell houses, properties, mortage, or declare bankrupt. /n'house', 'prop', 'mort', 'bankrupt'");
							boolean debt = true;
							while(debt) {
								String dec = in.nextLine();
								switch(dec){
									case "house":
										System.out.println("Select the property of the house you'd like to sell or type 'cancel' to cancel");
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
											String pr = in.nextLine().trim();
											
											for(int y = 0; y < owne.size(); y++) {
												if(pr == "cancel") {
													can = true;
													break;
												}
												if(owne.get(y).getName() == pr) {
													con = true;
													break;
												}else if(y == owne.size() -1) {
													System.out.println("Invalid choice. Please select another");
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
										System.out.println("Select the property you'd like to sell or type 'cancel' to cancel");
										ArrayList<BoardSpot> owned = new ArrayList<BoardSpot>();
										//displays properties
										for(int q = 0; q < spaces.length; q++) {
											if(spaces[q].getOwner() == players.get(i)) {
												owned.add(spaces[q]);
												System.out.println("  " + spaces[q].getName());
											}
										}
										boolean cont = false;

										boolean cant = false;
										while(cant == false) {
											String pri = in.nextLine().trim();
											for(int y = 0; y < owned.size(); y++) {
												if(pri == "cancel") {
													can = true;
													break;
												}
												if(owned.get(y).getName() == pri) {
													cont = true;
													break;
												}else if(y == owned.size() -1) {
													System.out.println("Invalid choice. Please select another");
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
										System.out.println("Select the property you'd like to mortage or type 'cancel' to cancel");
										ArrayList<BoardSpot> ownedq = new ArrayList<BoardSpot>();
										//displays properties
										for(int q = 0; q < spaces.length; q++) {
											if(spaces[q].getOwner() == players.get(i) && (spaces[q].getType() == "property" || spaces[q].getType() == "property")) {
												ownedq.add(spaces[q]);
												System.out.println("  " + spaces[q].getName());
											}
										}
										boolean conq = false;

										boolean canq = false;
										while(canq == false) {
											String priq = in.nextLine().trim();
											for(int y = 0; y < ownedq.size(); y++) {
												if(priq == "cancel") {
													canq = true;
													break;
												}
												if(ownedq.get(y).getName() == priq) {
													conq = true;
													break;
												}else if(y == ownedq.size() -1) {
													System.out.println("Invalid choice. Please select another");
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
										System.out.println("Are you sure you would like to declare bankrupt? 'y' or 'n'");
										boolean quit = true;
										while(quit == true) {
											String finale = in.nextLine();
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
													System.out.println("Invalid option. Please try again.");
											}
										}
										break;
									default:
										System.out.println("Invalid option. Please try again.");
								}
							}
							if(bankr == false) {
								System.out.println("Fine paid. You are free to go.");
								players.get(i).money -= 50;
								players.get(i).jailTime = 0;
								players.get(i).setJail(false);
							}
						}
					}
					System.out.println("In jail. Turn skipped.");
					continue;
				}else if(players.get(i).inJail == true && doubles == true) {
					System.out.println("Freed from jail!.");
					players.get(i).setJail(false);
				}
				if(bankr = true) {
					continue;
				}
				
				//Adding houses
				System.out.println("Would you like to add any houses to any properties? 'y'  for yes or 'n' for no");
				while(true) {	
					String hous = in.nextLine();
					switch(hous) {
						case "y":
							System.out.println("Select the property you would like to add a house or hotel to or type 'done' to continue.");
							ArrayList<BoardSpot> ownerr = new ArrayList<BoardSpot>();
							//displays properties
							for(int q = 0; q < spaces.length; q++) {
								if(spaces[q].getOwner() == players.get(i) && spaces[q].getType() == "property") {
									ownerr.add(spaces[q]);
									System.out.println("  " + spaces[q].getName());
								}
							}
							while(true) {
								String hp = in.nextLine();
								if(hp == "done") {
									break;
								}
								for(int u = 0; u < spaces.length; u++) {
									if(ownerr.get(findInd(ownerr, hp)).equals(spaces[u])){
										buyHouse(spaces[u], houses, hotels);
										break;
									}else if(u == spaces.length - 1) {
										System.out.println("Invalid entry. Please try again.");
									}
								}
							}
							break;
						case "n":
							break;
						default:
							System.out.println("Invalid option. Please try again.");
					}
					break;
				}
				players.get(i).movement(move);
				
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
									if(spaces[q].getOwner() == players.get(i) && spaces[q].getType() == "property") {
										o.add(spaces[q]);
									}
								}
								if(o.size() == 0) {
									System.out.println("AI has declared bankrupt");
									i--;
									continue;
								}else {
									while(players.get(i).money - price < 0 && o.size() != 0) {
										sellBank(players.get(i), bank, o.get(0));
									}
									if(o.size() == 0) {
										System.out.println("AI has declared bankrupt");
										i--;
										continue;
									}else {
										players.get(i).money -= price;
										
									}
								}
							}else if(players.get(i).money - price < 0 && players.get(i).isAI() == false) {
								System.out.println("You need " + ((players.get(i).money - price) * -1) + " to pay rent. Sell houses, properties, mortage, or declare bankrupt. /n'house', 'prop', 'mort', 'bankrupt'");
								boolean debt = true;
								while(debt) {
									String dec = in.nextLine();
									switch(dec){
										case "house":
											System.out.println("Select the property of the house you'd like to sell or type 'cancel' to cancel");
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
												String pr = in.nextLine().trim();
												
												for(int y = 0; y < owne.size(); y++) {
													if(pr == "cancel") {
														can = true;
														break;
													}
													if(owne.get(y).getName() == pr) {
														con = true;
														break;
													}else if(y == owne.size() -1) {
														System.out.println("Invalid choice. Please select another");
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
											System.out.println("Select the property you'd like to sell or type 'cancel' to cancel");
											ArrayList<BoardSpot> owned = new ArrayList<BoardSpot>();
											//displays properties
											for(int q = 0; q < spaces.length; q++) {
												if(spaces[q].getOwner() == players.get(i)) {
													owned.add(spaces[q]);
													System.out.println("  " + spaces[q].getName());
												}
											}
											boolean cont = false;

											boolean cant = false;
											while(cant == false) {
												String pri = in.nextLine().trim();
												for(int y = 0; y < owned.size(); y++) {
													if(pri == "cancel") {
														can = true;
														break;
													}
													if(owned.get(y).getName() == pri) {
														cont = true;
														break;
													}else if(y == owned.size() -1) {
														System.out.println("Invalid choice. Please select another");
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
											System.out.println("Select the property you'd like to mortage or type 'cancel' to cancel");
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
												String priq = in.nextLine().trim();
												for(int y = 0; y < ownedq.size(); y++) {
													if(priq == "cancel") {
														canq = true;
														break;
													}
													if(ownedq.get(y).getName() == priq) {
														conq = true;
														break;
													}else if(y == ownedq.size() -1) {
														System.out.println("Invalid choice. Please select another");
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
											System.out.println("Are you sure you would like to declare bankrupt? 'y' or 'n'");
											boolean quit = true;
											while(quit == true) {
												String finale = in.nextLine();
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
														System.out.println("Invalid option. Please try again.");
												}
											}
											break;
										default:
											System.out.println("Invalid option. Please try again.");
									}
								}
							}
							if(bankr == false) {
								System.out.println("Property owned. Paying rent...");
								rent(players.get(i), spaces[players.get(i).location]);
							}
						}else if(spaces[players.get(i).location].getOwner() == bank || spaces[players.get(i).location].getOwner() != NA){
							if(players.get(i).isAI() || players.get(i).money > spaces[players.get(i).location].getCost()) {
								System.out.println("AI " + players.get(i).getNum() + " purchased " + spaces[players.get(i).location].getName());
								buy(players.get(i), spaces[players.get(i).location]);
							}else if(!(players.get(i).isAI())){
								if(players.get(i).money > spaces[players.get(i).location].getCost()) {
									System.out.println("Player " + players.get(i).getNum() + "has landed on " + spaces[players.get(i).location].getName());
									System.out.println("Would you like to purchase this property? Enter 'y' for yes or 'n' for no. You currently have $" + players.get(i).money);
									boolean buying = true;
									while(buying) {
										String pur = in.nextLine();
										switch(pur) {
											case "y":
												buy(players.get(i), spaces[players.get(i).location]);
												System.out.println("Player " + players.get(i).getNum() + " purchased " + spaces[players.get(i).location].getName() + "and has $" + players.get(i).money + " remaining.");
												buying = false;
												break;
											case "n": 
												System.out.println("Purchase declined.");
												buying = false;
												break;
											default:
												System.out.println("Invalid option. Please enter either 'y' for yes or 'n' for no.");
										}
									}
								}else {
									System.out.println("Player " + players.get(i).getNum() + ", you don't have enough money to purchase this property...");
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
								System.out.println("You need " + ((players.get(i).money - price) * -1) + " to pay rent. Sell houses, properties, mortage, or declare bankrupt. /n'house', 'mort', 'prop', 'bankrupt'");
								boolean debt = true;
								while(debt) {
									String dec = in.nextLine();
									switch(dec){
										case "house":
											System.out.println("Select the property of the house you'd like to sell or type 'cancel' to cancel");
											ArrayList<BoardSpot> owne = new ArrayList<BoardSpot>();
											//displays properties
											for(int q = 0; q < spaces.length; q++) {
												if(spaces[players.get(i).location].getOwner() == players.get(i)) {
													owne.add(spaces[q]);
													System.out.println("  " + spaces[q].getName());
												}
											}
											boolean con = false;
											boolean can = false;
											while(can == false) {
												String pr = in.nextLine().trim();
												
												for(int y = 0; y < owne.size(); y++) {
													if(pr == "cancel") {
														can = true;
														break;
													}
													if(owne.get(y).getName() == pr) {
														con = true;
														break;
													}else if(y == owne.size() -1) {
														System.out.println("Invalid choice. Please select another");
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
											System.out.println("Select the property you'd like to sell or type 'cancel' to cancel");
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
												String pri = in.nextLine().trim();
												for(int y = 0; y < owned.size(); y++) {
													if(pri == "cancel") {
														can = true;
														break;
													}
													if(owned.get(y).getName() == pri) {
														cont = true;
														break;
													}else if(y == owned.size() -1) {
														System.out.println("Invalid choice. Please select another");
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
											System.out.println("Select the property you'd like to mortage or type 'cancel' to cancel");
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
												String priq = in.nextLine().trim();
												for(int y = 0; y < ownedq.size(); y++) {
													if(priq == "cancel") {
														canq = true;
														break;
													}
													if(ownedq.get(y).getName() == priq) {
														conq = true;
														break;
													}else if(y == ownedq.size() -1) {
														System.out.println("Invalid choice. Please select another");
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
											System.out.println("Are you sure you would like to declare bankrupt? 'y' or 'n'");
											boolean quit = true;
											while(quit == true) {
												String finale = in.nextLine();
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
							if(players.get(i).money - price < 0 && players.get(i).isAI() == true) {
								ArrayList<BoardSpot> eww = new ArrayList<BoardSpot>();
								for(int q = 0; q < spaces.length; q++) {
									if(spaces[q].getOwner() == players.get(i) && spaces[q].getType() == "property") {
										eww.add(spaces[q]);
									}
								}
								if(eww.size() == 0) {
									System.out.println("AI has declared bankrupt");
									i--;
									continue;
								}else {
									while(players.get(i).money - price < 0 && eww.size() != 0) {
										sellBank(players.get(i), bank, eww.get(0));
									}
									if(eww.size() == 0) {
										System.out.println("AI has declared bankrupt");
										i--;
										continue;
									}else {
										players.get(i).money -= price;
										
									}
								}
								break;
							}
							if(bankr == false) {
								System.out.println("Railroad owned. Paying rent...");
								players.get(i).money -= price;
							}
						}else if(spaces[players.get(i).location].getOwner() == bank || spaces[players.get(i).location].getOwner() != NA){
							if(players.get(i).isAI() || players.get(i).money > spaces[players.get(i).location].getCost()) {
								System.out.println("AI " + players.get(i).getNum() + " purchased " + spaces[players.get(i).location].getName());
								buy(players.get(i), spaces[players.get(i).location]);
							}else if(!(players.get(i).isAI())){
								if(players.get(i).money > spaces[players.get(i).location].getCost()) {
									System.out.println("Player " + players.get(i).getNum() + "has landed on " + spaces[players.get(i).location].getName());
									System.out.println("Would you like to purchase this property? Enter 'y' for yes or 'n' for no. You currently have $" + players.get(i).money);
									boolean buying = true;
									while(buying) {
										String pur = in.nextLine();
										switch(pur) {
											case "y":
												buy(players.get(i), spaces[players.get(i).location]);
												System.out.println("Player " + players.get(i).getNum() + " purchased " + spaces[players.get(i).location].getName() + "and has $" + players.get(i).money + " remaining.");
												buying = false;
												break;
											case "n": 
												System.out.println("Purchase declined.");
												buying = false;
												break;
											default:
												System.out.println("Invalid option. Please enter either 'y' for yes or 'n' for no.");
										}
									}
								}else {
									System.out.println("Player " + players.get(i).getNum() + ", you don't have enough money to purchase this property...");
								}
							}
						}
						break;
					case "GoToJail":
						System.out.println("Player " + players.get(i).getNum() + " has been sent to jail.");
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
							System.out.println("You need " + ((players.get(i).money - utilPrice) * -1) + " to pay rent. Sell houses, properties, mortage, or declare bankrupt. /n'house', 'mort', 'prop', 'bankrupt'");
							boolean debt = true;
							while(debt) {
								String dec = in.nextLine();
								switch(dec){
									case "house":
										System.out.println("Select the property of the house you'd like to sell or type 'cancel' to cancel");
										ArrayList<BoardSpot> owne = new ArrayList<BoardSpot>();
										//displays properties
										for(int q = 0; q < spaces.length; q++) {
											if(spaces[players.get(i).location].getOwner() == players.get(i)) {
												owne.add(spaces[q]);
												System.out.println("  " + spaces[q].getName());
											}
										}
										boolean con = false;
										boolean can = false;
										while(can == false) {
											String pr = in.nextLine().trim();
											
											for(int y = 0; y < owne.size(); y++) {
												if(pr == "cancel") {
													can = true;
													break;
												}
												if(owne.get(y).getName() == pr) {
													con = true;
													break;
												}else if(y == owne.size() -1) {
													System.out.println("Invalid choice. Please select another");
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
										System.out.println("Select the property you'd like to sell or type 'cancel' to cancel");
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
											String pri = in.nextLine().trim();
											for(int y = 0; y < owned.size(); y++) {
												if(pri == "cancel") {
													can = true;
													break;
												}
												if(owned.get(y).getName() == pri) {
													cont = true;
													break;
												}else if(y == owned.size() -1) {
													System.out.println("Invalid choice. Please select another");
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
										System.out.println("Select the property you'd like to mortage or type 'cancel' to cancel");
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
											String priq = in.nextLine().trim();
											for(int y = 0; y < ownedq.size(); y++) {
												if(priq == "cancel") {
													canq = true;
													break;
												}
												if(ownedq.get(y).getName() == priq) {
													conq = true;
													break;
												}else if(y == ownedq.size() -1) {
													System.out.println("Invalid choice. Please select another");
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
										System.out.println("Are you sure you would like to declare bankrupt? 'y' or 'n'");
										boolean quit = true;
										while(quit == true) {
											String finale = in.nextLine();
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
						if(players.get(i).money - utilPrice < 0 && players.get(i).isAI() == true) {
							ArrayList<BoardSpot> ewww = new ArrayList<BoardSpot>();
							for(int q = 0; q < spaces.length; q++) {
								if(spaces[q].getOwner() == players.get(i) && spaces[q].getType() == "property") {
									ewww.add(spaces[q]);
								}
							}
							if(ewww.size() == 0) {
								System.out.println("AI has declared bankrupt");
								i--;
								continue;
							}else {
								while(players.get(i).money - utilPrice < 0 && ewww.size() != 0) {
									sellBank(players.get(i), bank, ewww.get(0));
								}
								if(ewww.size() == 0) {
									System.out.println("AI has declared bankrupt");
									i--;
									continue;
								}else {
									players.get(i).money -= utilPrice;
									
								}
							}
							break;
						}
						if(bankr == false) {
							System.out.println("Utility owned. Paying rent...");
							players.get(i).money -= utilPrice;
						}
						break;
					case "tax":
						int taxPrice = 0;
						if(players.get(i).location == 4) {
							System.out.println("Choose to pay either $200 or 10% of all assets. '200' or '10%'");
							while(true) {
								String cho = in.nextLine();
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
										System.out.println("Invaild choice. Please try again.");
								}
								if(taxPrice > 0) {
									break;
								}
							}
						}else {
							taxPrice = 75;
						}
						
						if(players.get(i).money - taxPrice < 0) {
							System.out.println("You need " + ((players.get(i).money - taxPrice) * -1) + " to pay taxes. Sell houses, properties, mortage, or declare bankrupt. /n'house', 'mort', 'prop', 'bankrupt'");
							boolean debt = true;
							while(debt) {
								String dec = in.nextLine();
								switch(dec){
									case "house":
										System.out.println("Select the property of the house you'd like to sell or type 'cancel' to cancel");
										ArrayList<BoardSpot> owne = new ArrayList<BoardSpot>();
										//displays properties
										for(int q = 0; q < spaces.length; q++) {
											if(spaces[players.get(i).location].getOwner() == players.get(i)) {
												owne.add(spaces[q]);
												System.out.println("  " + spaces[q].getName());
											}
										}
										boolean con = false;
										boolean can = false;
										while(can == false) {
											String pr = in.nextLine().trim();
											
											for(int y = 0; y < owne.size(); y++) {
												if(pr == "cancel") {
													can = true;
													break;
												}
												if(owne.get(y).getName() == pr) {
													con = true;
													break;
												}else if(y == owne.size() -1) {
													System.out.println("Invalid choice. Please select another");
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
										System.out.println("Select the property you'd like to sell or type 'cancel' to cancel");
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
											String pri = in.nextLine().trim();
											for(int y = 0; y < owned.size(); y++) {
												if(pri == "cancel") {
													can = true;
													break;
												}
												if(owned.get(y).getName() == pri) {
													cont = true;
													break;
												}else if(y == owned.size() -1) {
													System.out.println("Invalid choice. Please select another");
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
										System.out.println("Select the property you'd like to mortage or type 'cancel' to cancel");
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
											String priq = in.nextLine().trim();
											for(int y = 0; y < ownedq.size(); y++) {
												if(priq == "cancel") {
													canq = true;
													break;
												}
												if(ownedq.get(y).getName() == priq) {
													conq = true;
													break;
												}else if(y == ownedq.size() -1) {
													System.out.println("Invalid choice. Please select another");
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
										System.out.println("Are you sure you would like to declare bankrupt? 'y' or 'n'");
										boolean quit = true;
										while(quit == true) {
											String finale = in.nextLine();
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
								i--;
								continue;
							}else {
								while(players.get(i).money - taxPrice < 0 && ewww.size() != 0) {
									sellBank(players.get(i), bank, ewww.get(0));
								}
								if(ewww.size() == 0) {
									System.out.println("AI has declared bankrupt");
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
}

