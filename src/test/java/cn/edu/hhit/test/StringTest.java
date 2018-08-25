package cn.edu.hhit.test;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/1612:44
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "a";
        String b = a+"b";
        String ab = "ab";
        System.out.println(b==ab);
        System.out.println(Integer.valueOf('A'));
        Map map = Maps.newConcurrentMap();
    }
}
