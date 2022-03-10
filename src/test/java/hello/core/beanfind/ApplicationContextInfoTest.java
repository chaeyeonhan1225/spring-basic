package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefintionNames = ac.getBeanDefinitionNames();
        for (String beanDefintionName : beanDefintionNames) {
            Object bean = ac.getBean(beanDefintionName);
            System.out.println("bean = " + beanDefintionName + " object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefintionNames = ac.getBeanDefinitionNames();
        for (String beanDefintionName : beanDefintionNames) {
            BeanDefinition beanDefination = ac.getBeanDefinition(beanDefintionName);

            // Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            // Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (beanDefination.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefintionName);
                System.out.println("bean = " + beanDefintionName + " object = " + bean);
            }

        }
    }
}
