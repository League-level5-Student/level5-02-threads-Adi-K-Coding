package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.
	public static void main(String[] args) {

		Robot[] robots = new Robot[5];
		for (int i = 0; i < robots.length; i++) {
			robots[i] = new Robot();
		}

		for (int i = 0; i < robots.length; i++) {
			robots[i].setX(i * 140 + 50);
			robots[i].setY(300);
			robots[i].setSpeed(100);
		}

		Random rand = new Random();

		Thread[] robotsThread = new Thread[5];

		for (int i = 0; i < robots.length; i++) {
			int x = i;

			robotsThread[x] = new Thread(() -> {
				boolean isRacing = true;
				while (isRacing == true) {
					int randomInt = rand.nextInt(50);
					robots[x].move(randomInt);
						if (robots[x].getY() < 5) {
							isRacing = false;
							System.out.println("Robot " + (x+1) + " won");
							break;
						}
					
				}

			});
		}

		for (int i = 0; i < robots.length; i++) {
			robotsThread[i].start();
		}

	}
}
