package java_base.Generic;



public class TestGeneric_func {

    //这个类是个泛型类，在上面已经介绍过
    public class Generic<T>{
        private T key;

        public Generic(T key) {
            this.key = key;
        }

        //虽然在方法中使用了泛型，但是这并不是一个泛型方法。
        //返回值是在声明泛型类已经声明过的泛型
        public T getKey(){
            return key;
        }

    }

    //类中的泛型方法
    class GeneticTest<T>{
        public void show_1(T t){
            System.out.println(t.toString());
        }

        public <T> void show_2(T t){
            System.out.println(t.toString());
        }

        public <E> void show_3(E e){
            System.out.println(e.toString());
        }
    }

    /**
     * 泛型方法
     * 1、在public与返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T
     * 2、T可以出现任何位置，数量也不定
     */
    public <T, K> T showKeyName(Generic<T> container){
        System.out.println("container key :" + container.getKey());
        //当然这个例子举的不太合适，只是为了说明泛型方法的特性。
        T test = container.getKey();
        return test;
    }

    class Fruit{
        @Override
        public String toString() {
            return "fruit";
        }
    }

    class Apple extends Fruit{
        @Override
        public String toString() {
            return "apple";
        }
    }

    class Person{
        @Override
        public String toString() {
            return "com.yjm.test.java_base.Person";
        }
    }

    //这也不是一个泛型方法，这就是一个普通的方法，只是使用了Generic<Number>这个泛型类做形参而已。
    public void showKeyValue1(Generic<Number> obj){
        System.out.println("泛型测试 key value is " + obj.getKey());
    }

    public static void main(String[] args) {
//        //??不知道怎么解决
//        Apple apple=new Apple();
//        com.yjm.test.java_base.Person person=new com.yjm.test.java_base.Person();
//        GeneticTest<Fruit> geneticTest = new GeneticTest<Fruit>();
//        //apple是Fruit的子类，所以这里可以
//        geneticTest.show_1(apple);
//        //编译器会报错，因为泛型类型实参指定的是Fruit，而传入的实参类是Person
//        //generateTest.show_1(person);
//
//        //使用这两个方法都可以成功
//        geneticTest.show_2(apple);
//        geneticTest.show_2(person);
//
//        //使用这两个方法也都可以成功
//        geneticTest.show_3(apple);
//        geneticTest.show_3(person);
    }

}
