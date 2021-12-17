import java.util.Random;

public class TestDemo {

	//Class takes two positive non zero numbers and adds them together
	public int addPositive(int a, int b) {
		
		//checks for positive, throws exception if 0 or neg
		if (a >0 && b>0) {
			return a+b;
		}
		else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}	
	// Squares a random number obtained from getRandomInt
	public int randomNumberSquared() {
		int a = getRandomInt();
		return (a*a);
	}
	//Produces random number 1-10
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) +1;
	}
	
}
	
	

	
