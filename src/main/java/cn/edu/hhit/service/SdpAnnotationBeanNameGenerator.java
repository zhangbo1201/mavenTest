package cn.edu.hhit.service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/3010:32
 */
public class SdpAnnotationBeanNameGenerator  extends AnnotationBeanNameGenerator {
    protected String buildDefaultBeanName(BeanDefinition definition) {

        return definition.getBeanClassName();
    }
}
