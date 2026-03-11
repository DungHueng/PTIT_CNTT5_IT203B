package Demo;

public class CheckNumbers {
    // Check EvenNumber
    public static boolean checkEven(int number){
        return number % 2 == 0;
    }
    // Check OddNumber
    public static boolean CheckOdd(int number){
        return number % 2 != 0;
    }
    // Check ElementNumber
    public static boolean checkElementNumber(int number){
        if(number < 2) return false;
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
