package com.example.demo.ex;

import com.example.demo.ex.support.RpcApi;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

/**
 * @author makui
 * @created on  2022/3/17
 **/
public class BeanRegister implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println("---------------------------111-------------------");
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false) {
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                return true;
            }
        };
        scanner.addIncludeFilter(new AnnotationTypeFilter(RpcApi.class));
        Set<BeanDefinition> beanDefinitionSet = scanner.findCandidateComponents("com."); //
        System.out.println("beanDefinitionSet size: " + beanDefinitionSet.size());
        for (BeanDefinition beanDefinition : beanDefinitionSet) {
            System.out.println("---------------------------222-------------------");
            final String beanClassName = beanDefinition.getBeanClassName();
            Class<?> aClass = null;
            try {
                aClass = Class.forName(beanClassName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                continue;
            }
            final String beanName = AnnotationBeanNameGenerator.INSTANCE.generateBeanName(beanDefinition, new SimpleBeanDefinitionRegistry());
            beanDefinitionRegistry.registerBeanDefinition(beanName, beanDefinition);
        }

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }

}
