package java_base.reflection;

public class Test1 {
    public static void main(String[] args) {
        //所有类型的class
        Class c1= Object.class; //类
        Class c2=Comparable.class; //接口
        Class c3=String[].class; //一维数组
        Class c4=int[][].class; //二位数组
        Class c5=Override.class; //注解
        Class c6=String.class;
        Class c7=Integer.class;

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
    }
}
