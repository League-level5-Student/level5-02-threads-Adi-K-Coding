package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.

	public static void main(String[] args) {

		Robot r1 = new Robot(200, 400);
		Robot r2 = new Robot(600, 400);
		Robot r3 = new Robot(1000, 400);
		Robot r4 = new Robot(400, 600);
		Robot r5 = new Robot(800, 600);

		Robot[] rs = { r1, r2, r3, r4, r5 };

		Thread[] robots = new Thread[5];

		for (int i = 0; i < robots.length; i++) {
			int x = i;
			robots[x] = new Thread(() -> {
				rs[x].penDown();
				rs[x].turn(-90);
				for (int t = 0; t < 360; t++) {
					rs[x].move(3);
					rs[x].turn(1);
				}
			});
		}
		for (int i = 0; i < robots.length; i++) {
			robots[i].start();
		}
	}
}
