import org.junit.jupiter.api.Test;
import Bai_01.UserValidator;
import org.testng.Assert;

public class Bai_01 {
    @Test
    public void CheckTC01(){
        UserValidator validator = new UserValidator();
        String userName = "user123";
        boolean result = validator.isValidUserName(userName);
        Assert.assertTrue(result);
    }

    @Test
    public void CheckTC02(){
        UserValidator validator = new UserValidator();
        String userName = "abc";
        boolean result = validator.isValidUserName(userName);
        Assert.assertFalse(result);
    }

    @Test
    public void CheckTC03(){
        UserValidator validator = new UserValidator();
        String userName = "user name";
        boolean result = validator.isValidUserName(userName);
        Assert.assertTrue(result);
    }
}
