package java_base.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 通过反射操作注解：https://www.bilibili.com/video/BV1p4411P7V3?p=16
 */
public class Test4 {

    public static void main(String[] args) throws ClassNotFoundException,NoSuchFieldException {
        Class c1 = Class.forName("com.yjm.test.java_base.reflection.Student");

        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获得注解的value值:db_student
        TableA tableA = (TableA) c1.getAnnotation(TableA.class);
        String value = tableA.value();
        System.out.println(value);

        //获得类指定的注解
        Field name = c1.getDeclaredField("name");
        FieldA annotation = name.getAnnotation(FieldA.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.lenth());
        System.out.println(annotation.type());
    }

}

@TableA("db_student")
class Student {
    @FieldA(columnName = "id", type = "int", lenth = 10)
    private int id;
    @FieldA(columnName = "age", type = "int", lenth = 10)
    private int age;
    @FieldA(columnName = "name", type = "varchar", lenth = 3)
    private String name;

    //无参构造器
    public Student() {
    }

    //有参构造器
    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableA {
    String value();
}

//属性注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldA {
    String columnName();

    String type();

    int lenth();
}