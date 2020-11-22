package cen4010.pa2;
import java.util.*;  
import java.lang.Math; 
import java.util.ArrayList;
import java.util.Collections; 
import java.util.Scanner;

class Player {
	public int money;
	public String token;
	public int location = -1;
	public int turn;

	public Player(String token, int turn) {
		this.money = 1500;
		this.token = token;
		this.turn = turn;
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
}

public class Monopoly{
	
	
	public static void main(String args[]) {
		int houses = 32;
		int hotels = 12;
		Player bank = new Player(null, 0);
		Player NA = new Player(null, 0);
		int playerCount = 0;

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

		while(true) {
			System.out.println("How many people are playing?");
			Scanner in = new Scanner(System.in);
			String numOfPlayers = in.next();
			playerCount = Integer.parseInt(numOfPlayers);
			in.close();
			if(!(isInt(numOfPlayers))) {	//Check how many players
				System.out.println("Entered value is not a number. Try again.");
				continue;
			}
			if(playerCount > 8) {
				System.out.println("That's too many players");
				continue;
			}
			if(playerCount < 2) {
				System.out.println("It'll be more fun to play with more players.");
				continue;
			}
			break;
		}
		
//Assign each player their turn order
		Random rand = new Random();
		System.out.println("Number of players: " + playerCount);
		ArrayList<Integer> turns = new ArrayList<Integer>();
		ArrayList<Player> playerTracker = new ArrayList<Player>();
		Player newPlayer = new Player(null, 0);
		for(int i = 0; i < playerCount; i++) {
			String tokens[] = {"car", "dog", "hat", "iron", "ship", "shoe", "thimble", "wheelbarrow"};
//this next section sets the tokens for identifying players, rather than using a string.
//it might be better suited in another location.
			for (int counter = 0; counter < playerCount; counter++) {
				while(true) {
					System.out.println("Select a token for Player " + counter + ":");
					for (int cntr = 0; cntr < tokens.length; cntr++) {
						System.out.println(tokens[counter]);
					}
					Scanner in = new Scanner(System.in);
					String temptok = in.next();
					in.close();
					if (temptok.equals("taken")){
						System.out.println("That token is taken.  Please select another.");
						continue;
					}
					for (int cntr = 0; cntr < tokens.length; cntr++) {
						if(temptok.equals(tokens[cntr])) {
							tokens[cntr] = "taken";
							newPlayer.token = temptok;
							int tempTurn = rollDie() + rollDie();
							turns.add(tempTurn);
							playerTracker.add(cntr+1, newPlayer);
							System.out.println(newPlayer.token + ", you rolled " + tempTurn);
						}
					}
					break;
				}
			}
		}
		
//Organize players by turn orders
		for(int o = 0; o < turns.size(); o++) {
			for(int y = o + 1; y < turns.size(); y++) {
				if(turns.get(o) > turns.get(y)) {
					//organize dice rolls
					int temp = turns.get(o);
					turns.set(o, turns.get(y));
					turns.set(y, temp);
					//organize player turn order accordingly
					temp = playerTracker(0);
					playerTracker.set(o, playerTracker.get(y));
					playerTracker.set(y, temp);
				}
			}
		}
		
//actual game play
		boolean gameStart = true;
		while(gameStart) {
			for(int k = 0; k < playerTracker.size(); k++) {
				System.out.println(playerTracker.get(k) + "'s turn.");
				int current = position.get(k);
				System.out.println("Current money: $" + moneys.get(k) + " Current position is '" + spaces[current].getName() + "'");
				System.out.println("Choose an action: 'Move', 'Sell', 'Mortage', 'House', 'Bankrupt'");
				Scanner action = new Scanner(System.in);
				String whatDo = action.nextLine();
				switch(whatDo) {
					case "Move":
						int dice1 = rollDie();
						int dice2 = rollDie();
						int totalMove = dice1 + dice2;
						int tempPos = current + totalMove;
						if(tempPos > 40) {
							tempPos -= 40;
							position.set(k, tempPos);
							moneys.set(k, moneys.get(k) + 200);
						}
						switch(spaces[tempPos].getType()) {
							case "tax":
								boolean paid = false;
								while(paid == false) {
									if(spaces[tempPos].getName() == "Luxury Tax") {
										if(moneys.get(k) >= 75) {
											moneys.set(k, moneys.get(k) - 75);
											System.out.println("You landed on 'Luxury Tax.' You were charged $75.");
										}else {
											System.out.println("You cannot afford the tax. You must sell assets until you can afford it.");
											System.out.println("Select an option: 'pay', 'sell', 'bankrupt'");
											whatDo = action.nextLine();
											switch(whatDo) {
												case "pay":
													moneys.set(k, moneys.get(k) - 75);
													System.out.println("You landed on 'Luxury Tax.' You were charged $75.");
													paid = true;
													break;
												case "sell":
													ArrayList<BoardSpot> owned = new ArrayList<BoardSpot>();
													String owner = "Player " + k;
													for(int j = 0; j < spaces.length; j++) {
														if(spaces[j].getOwner() == owner) {
															owned.add(spaces[j]);
														}
													}
													System.out.println("Select a property to sell or mortage: ");
													for(int qw = 0; qw < owned.size(); qw++) {
														System.out.print(owned.get(qw).getName() + ", ");
														if(qw == owned.size() - 2) {
															System.out.print(owned.get(qw).getName());
															qw++;
														}
													}
													whatDo = action.nextLine();
													for(int qw = 0; qw < owned.size(); qw++) {
														if(whatDo == owned.get(qw).getName()) {
															if(owned.get(qw).getNumHouse() > 0) {

																moneys.set(k, moneys.get(k) + owned.get(qw).getHouseHotelPrice());
																if(owned.get(qw).getNumHouse() == 5) {
																	System.out.println("Sold hotel for $" + owned.get(qw).getHouseHotelPrice());
																	hotels++;
																	spaces[qw].setNumHouse(owned.get(qw).getNumHouse() - 1);
																}else {
																	houses++;
																	System.out.println("Sold house for $" + owned.get(qw).getHouseHotelPrice());
																	spaces[qw].setNumHouse(owned.get(qw).getNumHouse() - 1);
																}
															}else {
																System.out.println("Sell or Mortage?");
																whatDo = action.nextLine();
																if(whatDo == "Sell" || whatDo == "sell") {
																	moneys.set(k, moneys.get(k) + spaces[qw].getCost());
																	spaces[qw].setOwner(bank);
																	System.out.println("Sold for $" + owned.get(qw).getCost());
																}else if(whatDo == "Mortage" || whatDo == "mortage") {
																	moneys.set(k, moneys.get(k) + spaces[qw].getMort());
																	spaces[qw].setMortT();
																	System.out.println("Mortaged for $" + owned.get(qw).getMort());
																}else {
																	System.out.println("Invalid option. Check spelling and try again.");
																}
															}
															break;
														}else if(qw == owned.size() - 1 && !(whatDo == owned.get(qw).getName())) {
															System.out.println("You do not own this property or entered the name incorrectly. Please try again.");
														}
													}
													
											}
										}
									}else {
										System.out.println("You landed on 'Income Tax.' Choose to pay either 10% of total assets or $200. Choose: 'percent' or 'flat'");
										while(true) {
											whatDo = action.nextLine();
											switch(whatDo) {
												case "flat":
													
													
											}
										}
									}
								}
								break;
						}
//purchase houses, needs to implement enoughCash().
					 	case "house":
								System.out.println("Which property?");
								for (int cntr = 0; cntr < 40; cntr++) {
									if (spaces[cntr].getOwner().equals(playerTracker)) {
										System.out.println(spaces[cntr].getName());
									}
								}
								Scanner buy = new Scanner(System.in);
								String purchase = buy.next();
								for (int cntr = 0; cntr < 40; cntr++) {
									if(spaces[cntr].getOwner().equals(playerTracker)&&spaces[cntr].getName().equals(purchase)) {
										buy(playerTracker, spaces[cntr].getHouseHotelPrice());
									}
								}
						}
						
				}
			}
		}
		}
		
		
	}
	
	public static int rollDie() {
		Random rand = new Random();
		return rand.nextInt(6)+1;
	}
	
	public void buy (Player buyer, BoardSpot property) {
		buyer.money+=property.getCost();
		property.setOwner(buyer);
		property.setMortF();
	}
	
	public void mortgage(Player owner, BoardSpot property) {
		owner.money+=property.getMort();
		property.setMortT();
	}
	
	public void sellPlayer (Player seller, Player buyer, BoardSpot property, int price) {
		buyer.money-=price;
		seller.money+=price;
		property.setOwner(buyer);
	}
	
	public void sellBank (Player seller, Player bank, BoardSpot property) {
		seller.money+=property.getCost();
		property.setOwner(bank);
	}
	
	public void rent (Player renter, BoardSpot property) {
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

	public void buyHouse (BoardSpot property) {
		if (property.getNumHouse()<5) {
			property.getOwner().money -= property.getHouseHotelPrice();
			property.setNumHouse(property.getNumHouse()+1);
		} else {
			System.out.println("You already have a hotel.  You can't build anymore on this property.");
		}
	}

	public void sellHouse (BoardSpot property) {
		if (property.getNumHouse()>0) {
			property.getOwner().money += property.getHouseHotelPrice();
			property.setNumHouse(property.getNumHouse()-1);
		} else {
			System.out.println("There are no houses to sell on this property.");
		}
	}
	
	public void payBank (Player player, int cost) {
		player.money -= cost;
	}

//gives players options when they don't have cash
//returns true when they do
//needs further actions
	public Boolean enoughCash (Player player, int cost) {
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

