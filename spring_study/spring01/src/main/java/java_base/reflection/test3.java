package java_base.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 性能测试demo
 *
 */
public class test3 {

    public static void test01(){
        User user=new User();
        long startTime=System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
//            user.getClass();
            user.getName();
        }
        long endTime=System.currentTimeMillis();
        System.out.println("普通方式执行10亿次："+(endTime-startTime)+"ms");
    }

    public static void test02() throws NoSuchMethodException,IllegalAccessException,InvocationTargetException{
        User user=new User();
        Class c1 = user.getClass();

        Method method=c1.getDeclaredMethod("getName",null);

        long startTime=System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            method.invoke(user, null);
        }
        long endTime=System.currentTimeMillis();
        System.out.println("反射方式执行10亿次："+(endTime-startTime)+"ms");
    }

    public static void test03() throws NoSuchMethodException,IllegalAccessException,InvocationTargetException{
        User user=new User();
        Class c1 = user.getClass();

        Method method=c1.getDeclaredMethod("getName",null);

        method.setAccessible(true);

        long startTime=System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            method.invoke(user, null);
        }
        long endTime=System.currentTimeMillis();
        System.out.println("关闭检测方式执行10亿次："+(endTime-startTime)+"ms");
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
        test01();
        test02();
        test03();
    }

}

class User{
    private int name;

    public int getName() {
        return name;
    }
}
