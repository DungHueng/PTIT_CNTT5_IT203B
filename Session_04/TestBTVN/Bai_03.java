import Bai_03.EmailChecking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class Bai_03 {
    EmailChecking processor;
    @BeforeEach
    public void UserProcessor(){
        processor = new EmailChecking();
        System.out.println("Testing case");
    }

    @Test
    public void testEmail(){
        String email = "user@gmail.com";
        String result = processor.checkEmail(email);
        Assert.assertEquals(result,"user@gmail.com");
    }

    @Test
    public void testMissing(){
        String email = "user";
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            processor.checkEmail(email);
        });
    }
}
