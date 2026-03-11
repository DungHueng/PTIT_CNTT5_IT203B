import Bai_04.PasswordChecking;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Bai_04 {
    PasswordChecking passwordChecking;

    @Test
    public void TestPasswordChecking() {
        assertAll(

                () -> assertEquals("Mạnh",
                        passwordChecking.passwordCheck("Abc123!@")),

                () -> assertEquals("Trung bình",
                        passwordChecking.passwordCheck("abc123!@")),

                () -> assertEquals("Trung bình",
                        passwordChecking.passwordCheck("ABC123!@")),

                () -> assertEquals("Trung bình",
                        passwordChecking.passwordCheck("Abcdef!@")),

                () -> assertEquals("Trung bình",
                        passwordChecking.passwordCheck("Abc12345")),

                () -> assertEquals("Yếu",
                        passwordChecking.passwordCheck("Ab1!")),

                () -> assertEquals("Yếu",
                        passwordChecking.passwordCheck("password")),

                () -> assertEquals("Yếu",
                        passwordChecking.passwordCheck("ABC12345"))
        );
    }
}
