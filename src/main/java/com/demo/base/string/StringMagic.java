package com.demo.base.string;

/**
 * @author yangyuan
 * @date 20-7-22.
 */
public class StringMagic {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "AAAA";
        java.lang.reflect.Field f = String.class.getDeclaredField("value");
        f.setAccessible(true);
        char[] charArray = (char[])f.get(str);
        java.util.Arrays.fill(charArray, 'B');
        System.out.println("AAAA".equals("BBBB"));// 让 "AAAA".equals "BBBB"返回true
        String b = new String("AAA") + "A";
        System.out.println(b.equals("BBBB"));
    }
}
