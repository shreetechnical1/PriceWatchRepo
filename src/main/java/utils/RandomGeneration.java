package utils;

import java.util.Random;

public class RandomGeneration {

    public static String randomUserEmail(){
        return new Random().nextInt(9000000) + 1000000 + "@pricewatch123.com";
    }

    public static String randomUserName(){
        return new Random().nextInt(9000000) + 1000000 + "Kiddyt";
    }


}
