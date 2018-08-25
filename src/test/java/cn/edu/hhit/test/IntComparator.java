package cn.edu.hhit.test;

import java.util.Comparator;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/2021:22
 */
public class IntComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return ((Integer)o2).compareTo((Integer)o1);
    }
}
