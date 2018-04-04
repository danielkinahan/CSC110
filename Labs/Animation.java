import java.awt.*;
import javax.swing.*;

public class Animation {

	/**
 	 * Runs a small animation example.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		// create a red ball in position (150,70)
		Ball ball = new Ball(150,70,30,Color.red);
		// create a frame to contain the ball
		BallFrame bf = new BallFrame(ball,400,500);
		bf.showFrame();
	}
}