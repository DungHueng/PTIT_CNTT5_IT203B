import Demo.Calculate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.Optional;

public class TestCalculate {
    @BeforeAll
    public static void notification(){
        System.out.println("----- TEST -----");
        System.out.println("  START TESTING   ");
        System.out.println("----------------");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("Testing case");
    }


    // test add
    @Test
    @DisplayName("Test case dung")
    public void testFeatureAdd(){
        int result = Calculate.add(5, 7);
        Assert.assertEquals(result, 12);
    }

    @Test
    @DisplayName("Test case dung")
    public void testFeatureMinus(){
        int result = Calculate.minus(5, 2);
        Assert.assertEquals(result, 3);
    }

    @Test
    @DisplayName("Test case dung")
    public void testFeatureMultiply(){
        int result = Calculate.multi(10, 5);
        Assert.assertEquals(result, 50);
    }

    @Test
    @DisplayName("Test case dung")
    public void testFeatureDivide(){
        Double result = Calculate.devide(10, 5);
        Assert.assertEquals(Optional.of(result), Optional.of(2.0));
    }
}
