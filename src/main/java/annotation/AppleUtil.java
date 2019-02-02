package main.java.annotation;

import java.lang.reflect.Field;

/**
 * 注解处理器
 */
public class AppleUtil {
    public static void init(Apple apple) throws IllegalAccessException {

        Field[] fields = apple.getClass().getDeclaredFields();

        for(Field field :fields){
            if(field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
                field.setAccessible(true);
                field.set(apple, fruitName.value());
            }
            else if(field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor= (FruitColor) field.getAnnotation(FruitColor.class);
                field.setAccessible(true);
                field.set(apple, fruitColor.fruitColor().toString());
            }
            else if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider= (FruitProvider) field.getAnnotation(FruitProvider.class);
                field.setAccessible(true);
                field.set(apple, fruitProvider.name());
            }
        }
    }
}