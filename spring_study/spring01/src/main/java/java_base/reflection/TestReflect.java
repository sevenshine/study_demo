package java_base.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect {


    public static void main(String[] args) throws ClassNotFoundException{
        System.out.println("获取Class--------------------------");
        //三种方式获取Class
        //1、直接通过类名获取
        Class class1= TestReflect.class;
        System.out.println(class1);
        System.out.println(class1.getName());

        //2、通过类对象获取
        TestReflect testReflect=new TestReflect();
        Class class2= testReflect.getClass();
        System.out.println(class2.getName());

        //3、直接通过路径包名来获取
        Class class3 = Class.forName("com.yjm.test.java_base.reflection.TestReflect");
        System.out.println(class3.getName());

        //4、基本内置类型有TYPE属性
        Class c4=Integer.TYPE;
        System.out.println(c4);

        //获取父类类型
        Class c5=class1.getSuperclass();
        System.out.println(c5);

        System.out.println("--------------------------");
        try {
            Class cl= Class.forName("com.yjm.test.java_base.Person");
            //创建实例
            Object obj=cl.newInstance();
            //获取单独的类函数
            Method method=cl.getMethod("fun", String.class, int.class);
            //invoke 激活
            //（对象，方法的值）
            method.invoke(obj, "yes", 10);

            //获取所有函数，包含父类
            //Method[] methods=cl.getMethods();
            //不包含父类
            Method[] methods=cl.getDeclaredMethods();
            for (Method m:methods) {
                System.out.println(m.getName());
            }
            System.out.println("--------------------");
            //获取所有成员变量
            Field[] fields=cl.getDeclaredFields();
            for (Field f:fields) {
                System.out.println(f.getName());
            }
            System.out.println("--------------------");
            //获取所有构造函数
            Constructor[] constructors = cl.getDeclaredConstructors();
            for(Constructor constructor:constructors){
                System.out.println(constructor);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

