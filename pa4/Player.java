package cen4010.pa4;
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


