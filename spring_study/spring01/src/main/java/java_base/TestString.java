package java_base;

public class TestString {
    public static void main(String[] args) {
        //a1放在栈内存，str指向同一个地址
        String str1="a1";
        String str2="a1";
        //a1动态分配了堆内存，str3分别指向对应的堆地址，所以不一致
        String str3=new String("a1");
        String str4=new String("a1");
        System.out.println(str1==str2);
        System.out.println(str3==str4);
    }
}
