package cn.edu.hhit.service.strategy;

import java.util.Map;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/219:55
 */
public interface IContextStrategy {
    void staff(Map map);

    void commit(Map map);

}
