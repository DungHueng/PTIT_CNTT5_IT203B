import Demo.Calculate;
import Demo.CheckNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class CheckNumber {
    @Test
    @DisplayName("Check Even number")
    public void checkEven(){
        Assert.assertTrue(CheckNumbers.checkEven(3));
    }

    @Test
    @DisplayName("Check element number")
    public void checkElementNumber(){
        Assert.assertTrue(CheckNumbers.checkElementNumber(3));
    }

    @Test
    @DisplayName("Check Throw")
    public void checkThrow(){
        Assert.assertThrows(RuntimeException.class,
                () -> {double result = Calculate.devide(5, 0);
                    System.out.println(result);});
    }
}
