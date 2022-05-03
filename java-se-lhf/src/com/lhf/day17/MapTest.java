package com.lhf.day17;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

/**
 * @author Lin
 * 2022/5/3  15:37
 */
public class MapTest {
    @Test
    public void test1(){
        HashMap map = new HashMap();
        map.put("AA",11);
        map.put("BB",55);
        map.put("CC",66);
        map.put("DD",44);
        map.put("EE",88);

        //方式一：获取 Map 中所有的 key 组成的 Set.
        //方法：keySet()
        Set keySet = map.keySet();
        for (Object key : keySet) {
            Object value = map.get(key);
            System.out.println(key+"="+value);
        }
        System.out.println("-----------------------------------------");
        //方式二：获取 Map 中所有的 value 组成的 Collection
        //方法： values()
        Collection coll = map.values();
        Iterator it = coll.iterator();
        while (it.hasNext()) {
            Object value = it.next();
            System.out.println(value);
        }
        System.out.println("-----------------------------------------");
        //方式三：获取 Map 中所有的 Entry（Entry是Map的内部类，一个Entry对应着一个key和一个value）组成的 Set。
        //方法：entrySet()
        Set entrySet = map.entrySet();
        for (Object o : entrySet) {
            Entry entry = (Entry) o;
            Object key = entry.getKey();
            Object value = entry.getValue();

            String strKey = (String) key;
            Integer intValue = (Integer) value;
            System.out.println(strKey+"="+intValue);
        }
        System.out.println("-------------------------------------------");
        //方式三：获取 Map 中所有的 Entry（Entry是Map的内部类，一个Entry对应着一个key和一个value）组成的 Set。
        //方法：entrySet()
        Iterator it2 = entrySet.iterator();
        while (it2.hasNext()) {
            Entry entry = (Entry) it2.next();
            String strKey = (String) entry.getKey();
            Integer intValue = (Integer) entry.getValue();
            System.out.println(strKey+"="+intValue);
        }
    }
    @Test
    public void test2() throws IOException {
        //1. 创建 Properties 对象
        Properties props = new Properties();
        //2. 通过 load() 方法加载属性文件
        props.load(new FileInputStream("hello.properties"));
        //3. 通过 getProperty() 根据 key 获取对应的value，Properties 的特点：key 和 value 都是 String
        String username = props.getProperty("username");
        String password = props.getProperty("password");
        System.out.println(username);
        System.out.println(password);
    }

    @Test
    public void test3(){

    }

}
