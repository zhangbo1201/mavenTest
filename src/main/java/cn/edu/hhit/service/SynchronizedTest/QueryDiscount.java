package cn.edu.hhit.service.SynchronizedTest;

import java.util.Map;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${所有卷查询的入口}
 * @date 2018/8/2614:27
 */
public interface QueryDiscount {

    /**
     *
     * 功能描述:
     *
     * @param: request,查询条件，context 存卷列表
     * @return: 0 fail 1 success
     * @auther: Demon
     * @date: 2018/8/26 14:40
     */
    Integer queryDiscount(String requset, Map<String,Object> context);
}
