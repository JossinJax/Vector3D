package cen4010.pa4;

import java.util.Timer;
import java.util.TimerTask;

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
