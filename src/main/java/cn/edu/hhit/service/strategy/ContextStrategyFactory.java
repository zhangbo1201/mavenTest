package cn.edu.hhit.service.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/2110:01
 */
@Component
public class ContextStrategyFactory {
    @Autowired
    private Map<String, IContextStrategy> contextStrategy;

    public IContextStrategy doStrategy(String type){

        return this.contextStrategy.get(type);
    }

}
