package com.demo.base.reflect.final_modify;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by yangyuan on 12/26/17.
 * 修改final域的值
 */
public class TestReflection {


    public static void main(String[] args) throws Exception {
        Field nameField = OneCity.class.getDeclaredField("name");

        Field modifiersField = Field.class.getDeclaredField("modifiers"); //①
        modifiersField.setAccessible(true);
        modifiersField.setInt(nameField, nameField.getModifiers() & ~Modifier.FINAL); //②

        nameField.setAccessible(true); //这个同样不能少，除非上面把 private 也拿掉了，可能还得 public
        nameField.set(null, "Shenzhen");
        System.out.println(OneCity.getName()); //输出 Shenzhen
    }
}

class OneCity {
    private static final String name = new String("Beijing");
    public static String getName() {
        return name;
    }
}