package java_base.Collection;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

    public static void main(String[] args) {
        System.out.println("HashMap testing.............");

        HashMap hashMap=new HashMap();
        hashMap.put("I1","Value1");
        hashMap.put("I2","Value2");
        hashMap.put("I3","Value3");
        System.out.println(hashMap);

        //直接限定key value的值类型
        Map<String,Integer> map=new HashMap();
        map.put("apple",11);
        map.put("pear",15);
        map.put("bana",23);

        //key进行遍历，keySet()方法返回的Set集合
        for (String key : map.keySet()){
            int value=map.get(key);
            System.out.println(value);
        }

        //key，value遍历Map对象集合：entrySet()，每个元素是一个key-value映射
        //Map.entry<k,v>是一个泛型，Map的一个内部接口，表示Map中的一个实体，一个key-value对
        for (Map.Entry entry : map.entrySet()){
            System.out.println(entry+":"+entry.getKey()+"/"+entry.getValue());
        }


    }
}
