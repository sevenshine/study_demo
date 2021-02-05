package java_base.reflection;

//类初始化
public class Test2 {
    static{
        System.out.println("Main类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1、主动引用
        Son son=new Son();

        //2、反射产生主动引用
        Class.forName("com.yjm.test.java_base.reflection.Son");

        //数组，开辟5个空间，没有加载
//        Son[] sons=new Son[5];

        //常量：在链接阶段就存入调用类的常量池中了
//        System.out.println(Son.M);



    }

}

class Father{
    static int b=2;

    static{
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    static {
        System.out.println("子类被加载");
        m=200;
    }

    static int m=100;

    static final int M=1;
}