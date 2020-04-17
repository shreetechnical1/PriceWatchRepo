package utils;

import java.util.Random;

public class RandomGeneration {

    public static String randomUserEmail(){
        return new Random().nextInt(900000) + 100000 + "@pricewatch123.com";
    }

    public static String randomUserName(){
        return new Random().nextInt(900000) + 100000 + "Kiddyt";
    }


}
