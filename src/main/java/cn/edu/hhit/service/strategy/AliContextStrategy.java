package cn.edu.hhit.service.strategy;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/219:56
 */
@Component
public class AliContextStrategy implements IContextStrategy {
    @Override
    public void staff(Map map) {
        System.out.println("aLI提交文件"+map);
    }

    @Override
    public void commit(Map map) {
        System.out.println("ALI提交文件"+map);
    }
}
