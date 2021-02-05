package testfastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestPerson {
    public static void main(String[] args) {
        /**
         * java对象-》json
         */
        List<Person> listOfPerson=new ArrayList<Person>();

        Person person=new Person(30, "John Do1", new Date());

        listOfPerson.add(new Person(15, "John Doe", new Date()));
        listOfPerson.add(new Person(20, "John Doo", new Date()));

        String jsonOutPut1= JSON.toJSONString(person);
        String jsonOutPut2= JSON.toJSONString(listOfPerson);

        System.out.println(person);
        System.out.println(jsonOutPut1);
        System.out.println(listOfPerson);   //java对象
        System.out.println(jsonOutPut2);    //json对象

        System.out.println("--------创建json对象--------------");

        /**
         * 创建json对象
         * JSONObject（fastJson提供的json对象）
         * JSONArray（fastJson提供json数组对象）
         */
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < 2; i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("AGE", 10);
            jsonObject.put("FULL NAME", "Doe " + i);
            jsonObject.put("DATE OF BIRTH", "2016/12/12 12:12:12");
            jsonArray.add(jsonObject);
        }
        String jsonOutput = jsonArray.toJSONString();
        System.out.println(jsonOutput);
        System.out.println("---------JSON 字符串转换为 Java 对象-------------");

        /**
         * JSON 字符串转换为 Java 对象：如何解析 JSON
         */
        Person person1 = new Person(20, "John", new Date());
        //String格式
        String jsonObject = JSON.toJSONString(person1);
        Person newPerson = JSON.parseObject(jsonObject, Person.class);

    }
}
