package com.ecommerce.project.laptop.utils;

import java.util.Random;

public class StringUlis {
    private static final String ASCII = "ABCDEFGHTMALKUGCRCTVGCG1234567890";
    public static String createSKU(String sku, int numberOfCharacter) {
        Random random= new Random();
StringBuffer buffer = new StringBuffer();
        String str="";
        char[] chars=ASCII.toCharArray();
        for (int i = 0; i < numberOfCharacter; i++) {
            int r=random.nextInt(ASCII.length());
            char c=ASCII.charAt(r);
            buffer.append(c);
        }
        return sku+buffer.toString();
    }
}
