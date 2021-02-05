package java_base.Collection;

import java.util.*;

//类A的equals方法总是返回true,但没有重写其hashCode()方法。不能保证当前对象是HashSet中的唯一对象
class A
{
    public boolean equals(Object obj)
    {
        return true;
    }
}

//类B的hashCode()方法总是返回1,但没有重写其equals()方法。不能保证当前对象是HashSet中的唯一对象
class B
{
    public int hashCode()
    {
        return 1;
    }
}

//类C的hashCode()方法总是返回2,且有重写其equals()方法
class C
{
    public int hashCode()
    {
        return 2;
    }
    public boolean equals(Object obj)
    {
        return true;
    }
}

public class TestCollection
{
    public static void main(String[] args)
    {
        HashSet books = new HashSet();
        //分别向books集合中添加两个A对象，两个B对象，两个C对象
        books.add(new A());
        books.add(new A());

        //books
        books.add(new B());
        books.add(new B());

        //实现如何set中只能添加一个对象元素，不是很理解？
        //1、固定hashCode返回值；2、重写equals，返回true
        books.add(new C());
        books.add(new C());

        System.out.println(books);
        boolean flag1=books.contains(new A());
        boolean flag2=books.contains(new C());
        System.out.println("对象A是否存在："+flag1);
        System.out.println("对象C是否存在："+flag2);

        //HashSet的一些操作
        /**
         * hashset.clear()：从此 set 中移除所有元素。
         * hashset.remove(Object o)：如果指定元素存在于此 set 中，则将其移除。
         * hashset.isEmpty()：如果此 set 不包含任何元素，则返回 true。
         * hashset.contains(Object o)：如果此 set 包含指定元素，则返回 true。
         * hashset.size()：返回此 set 中的元素的数量（set 的容量）
         */
        System.out.println("HashSet的一些操作 testing.............");
        HashSet car=new HashSet();
        car.add("a4");
        car.add("P7");
        car.add(11);
        System.out.println(car);
        System.out.println(car.size());
        //不排序，添加顺序和元素顺序没有关系
        car.remove("a4");
        car.add("a4");
        System.out.println(car);
        car.clear();
        System.out.println(car);

        //LinkedHashSet
        //1、元素的顺序总是与添加顺序一致
        //2、inkedHashSetTest是HashSet的子类，因此它不允许集合元素重复
        System.out.println("LinkedHashSet testing.............");
        LinkedHashSet linkedHashSet=new LinkedHashSet();
        linkedHashSet.add("a1");
        linkedHashSet.add("b1");
        System.out.println(linkedHashSet);

        linkedHashSet.remove("a1");
        linkedHashSet.add("a1");
        System.out.println(linkedHashSet);

        System.out.println("ArrayList testing.............");
        List list=new ArrayList();
        list.add("l1");
        list.add("l1");
        list.add("l2");
        list.add("l3");
        list.add("l4");
        System.out.println(list);

        list.add(1,"c1");
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        //子集合：[1,3)  左边闭区间，右边开区间
        System.out.println(list.subList(1,3));

        System.out.println("Stack testing.............");
        System.out.println("LinkedList testing.............");

        System.out.println("Queue testing.............");
        System.out.println("PriorityQueue testing.............");
        PriorityQueue priorityQueue=new PriorityQueue();
        //按元素的大小顺序排列，输出[-1, 5, 2, 8]
        priorityQueue.offer(8);
        priorityQueue.offer(-1);
        priorityQueue.offer(2);
        priorityQueue.offer(5);
        System.out.println(priorityQueue);
        //取最小元素
        System.out.println(priorityQueue.poll());

        System.out.println("iterator实现遍历 testing.............");
        Collection collection=new HashSet();
        collection.add("car1");
        collection.add("car2");
        collection.add("car3");
        collection.add("car4");
        System.out.println(collection);
        Iterator iterator=collection.iterator();
        while (iterator.hasNext()){
            //it.next()方法返回的数据类型是Object类型，
            //需要强制类型转换
            String bk=(String)iterator.next();
            System.out.println(bk);

            if (bk.equals("car3")) {
                //从集合中删除上一次next方法返回的元素(删除当下的元素）
                iterator.remove();
            }
        }
        System.out.println(collection);
        //foreach遍历
        System.out.println("iterator foreach遍历 testing.............");
        for (Object obj :
                collection) {
            String bk = (String)obj;
            System.out.println(bk);

            if (bk.equals("car4")) {
                //从集合中删除上一次next方法返回的元素(删除当下的元素）
                iterator.remove();
            }
        }
        System.out.println(collection);

        System.out.println("Map testing.............");
        System.out.println("HashMap testing.............");

    }
}