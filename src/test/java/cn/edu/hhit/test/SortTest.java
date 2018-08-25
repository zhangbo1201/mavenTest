package cn.edu.hhit.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/2021:06
 */
public class SortTest {
    public static void main(String[] args) {
        List list = Lists.newArrayList();
        list.add("A");
        list.add("C");
        list.add("B");
        list.add("D");
        list.sort(new StringComparator());
        System.out.println(list);
        List list1 = Lists.newLinkedList();
        list1.add(1);
        list1.add(4);
        list1.add(2);
        list1.add(11);
        list1.sort(new IntComparator());
        System.out.println(list1);
        Map map = Maps.newHashMap();
        map.put("1","1");
        map.put("3","4");
        map.put("4","3");
        map.put("2","2");
        System.out.println("1".hashCode());
        System.out.println("3".hashCode());
        System.out.println("4".hashCode());
        System.out.println("2".hashCode());
        System.out.println("1".hashCode()&(map.size()-1));
        System.out.println("3".hashCode()&(map.size()-1));
        System.out.println("4".hashCode()&(map.size()-1));
        System.out.println("2".hashCode()&(map.size()-1));
        Map map1 = Maps.newTreeMap(new TreeMapValueSort(map));
        map1.putAll(map);
        System.out.println(map);
        System.out.println(map1);
        Map map2 = Maps.newHashMap();
        map2.put("张三","1");
        map2.put("里斯","2");
        map2.put("wangwu ","3");
        System.out.println(map2);
        System.out.println("张三".hashCode());
        System.out.println("里斯".hashCode());
        System.out.println("wangwu ".hashCode());
        System.out.println("张三".hashCode()&(map2.size()-1));
        System.out.println("里斯".hashCode()&(map2.size()-1));
        System.out.println("wangwu ".hashCode()&(map2.size()-1));
    }


}
