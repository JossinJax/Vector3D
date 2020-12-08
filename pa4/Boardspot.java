package cen4010.pa4;
import java.util.*;  
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;






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
