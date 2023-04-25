package SPoudel_Project;
import java.util.Random;

public class DebitCard {
	private long cardNumber;
	
	public DebitCard() {
		Random randGen = new Random();
		cardNumber = (long) (randGen.nextDouble() * Math.pow(10, 16));
	}
	
}