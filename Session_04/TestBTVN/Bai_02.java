import Bai_02.UserService;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class Bai_02 {
    @Test
    void AgeUser18(){
        UserService userService = new UserService();
        int age = 18;

        boolean result = userService.checkRegistrationAge(age);

        Assert.assertEquals(result,true);
    }

    @Test
    void LowerThan18(){
        UserService userService = new UserService();
        int age = 17;
        boolean result = userService.checkRegistrationAge(age);
        Assert.assertEquals(result,false);
    }

    @Test
    void AgeNegative(){
        UserService userService = new UserService();
        int age = -1;
        Assert.assertThrows(IllegalArgumentException.class, () -> userService.checkRegistrationAge(age));
    }
}
