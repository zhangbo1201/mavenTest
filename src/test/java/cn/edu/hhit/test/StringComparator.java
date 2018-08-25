package cn.edu.hhit.test;

import java.util.Comparator;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/2021:15
 */
public class StringComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return ((String)o2).compareToIgnoreCase((String)o1);
    }
}
