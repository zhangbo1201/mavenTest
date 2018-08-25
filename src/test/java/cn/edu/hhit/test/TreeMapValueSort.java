package cn.edu.hhit.test;

import java.util.Comparator;
import java.util.Map;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/2021:32
 */
public class TreeMapValueSort implements Comparator<String> {

    Map<String,String> map;

    public TreeMapValueSort(Map<String,String> map) {
        this.map = map;
    }

    @Override
    public int compare(String o1, String o2) {
        return map.get(o2).compareToIgnoreCase(map.get(o1));
    }
}
