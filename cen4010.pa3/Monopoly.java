package cen4010.pa2;

class BoardSpot {
	private String nameOfSpace;
	private String spaceColor;
	private String spotType;
	private String owner;
	private int cost;
	private int mort;
	
	public BoardSpot(String spot, String color, String bSpot, String whoOwn, int spotCost, int mortage) {
		this.nameOfSpace = spot;
		this.spaceColor = color;
		this.spotType = bSpot;
		this.owner = whoOwn;
		this.cost = spotCost;
		this.mort = mortage;
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
	public String getOwner() {
		return this.owner;
	}
	public int getCost() {
		return this.cost;
	}
	public int getMort() {
		return this.mort;
	}
	public void setOwner(String newOwner) {
		this.owner = newOwner;
	}
}

public class Monopoly{
	int houses = 32;
	int hotels = 12;
	int bankMoney = 20580;
	BoardSpot MediterraneanAvenue = new BoardSpot("Mediterranean Avenue", "brown", "property", "bank", 60, 30);
	BoardSpot CommunityChest1 = new BoardSpot("CommunityChest", "none", "special", "none", 0, 0);
	BoardSpot BalticAvenue = new BoardSpot("Baltic Avenue", "brown", "property", "bank", 60, 30);
	BoardSpot IncomeTax = new BoardSpot("Income Tax", "none", "tax", "none", 0, 0);
	BoardSpot ReadingRailroad = new BoardSpot("Reading Railroad", "none", "railroad", "bank", 200, 100);
	BoardSpot OrientalAvenue = new BoardSpot("Oriental Avenue", "l_blue", "property", "bank", 100, 50);
	BoardSpot Chance1 = new BoardSpot("Chance", "none", "special", "none", 0, 0);
	BoardSpot VermontAvenue = new BoardSpot("Vermont Avenue", "l_blue", "property", "bank", 100, 50);
	BoardSpot ConneticutAvenue = new BoardSpot("Conneticut Avenue", "l_blue", "property", "bank", 120, 60);
	BoardSpot Jail = new BoardSpot("Jail", "none", "jail", "none", 0, 0);
	BoardSpot StCharlesPlace = new BoardSpot("St. Charles Place", "pink", "property", "bank", 140, 70);
	BoardSpot ElectricCompany = new BoardSpot("Electric Company", "none", "utility", "bank", 150, 75);
	BoardSpot StatesAvenue = new BoardSpot("States Avenue", "pink", "property", "bank", 140, 70);
	BoardSpot VirginiaAvenue = new BoardSpot("Virginia Avenue", "pink", "property", "bank", 160, 80);
	BoardSpot PennsylvaniaRailroad = new BoardSpot("Pennsylvania Railroad", "none", "railroad", "bank", 200, 100);
	BoardSpot StJamesPlace = new BoardSpot("St. James Place", "orange", "property", "bank", 180, 90);
	BoardSpot CommunityChest2 = new BoardSpot("CommunityChest", "none", "special", "none", 0, 0);
	BoardSpot TennesseeAvenue = new BoardSpot("Tennessee Avenue", "orange", "property", "bank", 180, 90);
	BoardSpot NewYorkAvenue = new BoardSpot("New York Avenue", "orange", "property", "bank", 200, 100);
	BoardSpot FreeParking = new BoardSpot("Free Parking", "none", "special", "none", 0, 0);
	BoardSpot KentuckyAvenue = new BoardSpot("Kentucky Avenue", "red", "property", "bank", 220, 110);
	BoardSpot Chance2 = new BoardSpot("Chance", "none", "special", "none", 0, 0);
	BoardSpot IllinoisAvenue = new BoardSpot("Illinois Avenue", "red", "property", "bank", 240, 120);
	BoardSpot BORailroad = new BoardSpot("B. & O. Railroad", "none", "railroad", "bank", 200, 100);
	BoardSpot AtlanticAvenue = new BoardSpot("Atlantic Avenue", "yellow", "property", "bank", 260, 130);
	BoardSpot VentorAvenue = new BoardSpot("Ventor Avenue", "yellow", "property", "bank", 260, 130);
	BoardSpot WaterWorks = new BoardSpot("Water Works", "none", "utility", "bank", 150, 75);
	BoardSpot MarvinGardens = new BoardSpot("Marvin Gardens", "yellow", "property", "bank", 280, 140);
	BoardSpot GoToJail = new BoardSpot("Go to Jail", "none", "GoToJail", "none", 0, 0);
	BoardSpot PacificAvenue = new BoardSpot("Pacific Avenue", "green", "property", "bank", 300, 150);
	BoardSpot NorthCarolinaAvenue = new BoardSpot("North Carolina Avenue", "green", "property", "bank", 300, 150);
	BoardSpot CommunityChest3 = new BoardSpot("CommunityChest", "none", "special", "none", 0, 0);
	BoardSpot PennsylvaniaAvenue = new BoardSpot("Pennsylvania Avenue", "green", "property", "bank", 320, 160);
	BoardSpot ShortLine = new BoardSpot("Short Line", "none", "railroad", "bank", 200, 100);
	BoardSpot Chance3 = new BoardSpot("Chance", "none", "special", "none", 0, 0);
	BoardSpot ParkPlace = new BoardSpot("Park Place", "d_blue", "property", "bank", 350, 175);
	BoardSpot LuxuryTax = new BoardSpot("Luxury Tax", "none", "tax", "none", 0, 0);
	BoardSpot Boardwalk = new BoardSpot("Boardwalk", "d_blue", "property", "bank", 400, 200);
	BoardSpot Go = new BoardSpot("Go", "none", "go", "none", 0, 0);
	BoardSpot[] spaces = {Go, MediterraneanAvenue, CommunityChest1, BalticAvenue, IncomeTax, ReadingRailroad, OrientalAvenue, Chance1, VermontAvenue, ConneticutAvenue, Jail, StCharlesPlace, ElectricCompany, StatesAvenue, VirginiaAvenue, PennsylvaniaRailroad, StJamesPlace, CommunityChest2, TennesseeAvenue, NewYorkAvenue, FreeParking, KentuckyAvenue, Chance2, IllinoisAvenue, BORailroad, AtlanticAvenue, VentorAvenue, WaterWorks, MarvinGardens, GoToJail, PacificAvenue, NorthCarolinaAvenue, CommunityChest3, PennsylvaniaAvenue, ShortLine, Chance3, ParkPlace, LuxuryTax, Boardwalk};
	
	public static void main(String args[]) {
		System.out.println("How many people are playing?");
		
	}
	
	
}

