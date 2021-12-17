
//import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;





class TestDemoTest {
	
	private TestDemo testDemo;
	
	//Creates a new testDemo object before each test
	@BeforeEach
	void setUp(){
		testDemo = new TestDemo();
	}
	
	//Tests that addPositives works as desired
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPostiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException){
	
		//Given: two numbers to test
		//When: when the method addPositive is called
		if(!expectException) {
			//Then: If positive numbers the numbers are added properly
			assertThat(testDemo.addPositive(a,b)).isEqualTo(expected);
		}	
		else {
			// If non positive number(s), exception thrown
			assertThatThrownBy(() -> 
		    testDemo.addPositive(a, b))
		    .isInstanceOf(IllegalArgumentException.class);
		}
	}

	//Creates arguments for assertThatTwoPOsitveNumbersAreAddedCorrectly
	static Stream<Arguments> argumentsForAddPositive() {
			return Stream.of(
					arguments(2, 4, 6, false ), // Tests for two valid positive numbers
					arguments(-2, 4, 0, true),  // tests for one negative number
					arguments(0,0,0, true),     // tests for two zero numbers
					arguments(0, 4, 0, true),   // tests for one zero number
					arguments(-2, -4, 0, true)  // tests for two negative numbers
					);
		}
	
	//Tests randomNumberSquared
	@Test
	void assertThatNumberSquaredIsCorrect() {
		
		
		//Creates a mock of TestDemo
		TestDemo mockDemo = spy(testDemo);
		//Given: A random number between 1-10
		doReturn(5).when(mockDemo).getRandomInt();
		//When: When the number is retrieved
		int fiveSquared = mockDemo.randomNumberSquared();
		//Then: The number is correctly squared
		assertThat(fiveSquared).isEqualTo(25);
		
		
		
		
		
	}
		
	
	
	
	
	
}
