package com.china.hcg.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @autor hecaigui
 * @date 2020-11-14
 * @description
 */
public class GetMessageOfAnnotation {
    public static void main(String[] args) {
        boolean hasAnnotation = UseAnnotation.class.isAnnotationPresent(DefineAnnotation.class);
        if ( hasAnnotation ) {
            DefineAnnotation DefineAnnotation = UseAnnotation.class.getAnnotation(DefineAnnotation.class);
            //获取类的注解
            System.out.println("id:"+DefineAnnotation.id());
            System.out.println("msg:"+DefineAnnotation.msg());
        }
//        try {
//            Field a = UseAnnotation.class.getDeclaredField("a");
//            a.setAccessible(true);
////        //获取一个成员变量上的注解
////        Check check = a.getAnnotation(Check.class);
////        if ( check != null ) {
////            System.out.println("check value:"+check.value());
////        }
//            Method UseAnnotationMethod = UseAnnotation.class.getDeclaredMethod("UseAnnotationMethod");
//            if ( UseAnnotationMethod != null ) {
//                // 获取方法中的注解
//                Annotation[] ans = UseAnnotationMethod.getAnnotations();
//                for( int i = 0;i < ans.length;i++) {
//                    System.out.println("method UseAnnotationMethod annotation:"+ans[i].annotationType().getSimpleName());
//                }
//            }
//        } catch (NoSuchFieldException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        } catch (SecurityException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        } catch (NoSuchMethodException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        }
    }

}
