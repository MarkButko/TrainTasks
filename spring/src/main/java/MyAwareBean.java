import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MyAwareBean implements ApplicationContextAware,
        ApplicationEventPublisherAware, BeanClassLoaderAware, BeanFactoryAware,
        BeanNameAware, LoadTimeWeaverAware, MessageSourceAware,
        NotificationPublisherAware, ResourceLoaderAware ,
        DisposableBean, InitializingBean {

    protected MyAwareBean() {
        System.out.println("constructor");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory");

    }

    @Override
    public void setBeanName(String s) {
        System.out.println(s + " beanname");

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext");

    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("setApplicationEventPublisher");

    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("setMessageSource");

    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println();

    }

    @Override
    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
        System.out.println("setLoadTimeWeaver");

    }

    @Override
    public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
        System.out.println("setNotificationPublisher");

    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct anno");

    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy anno");
    }

    public void init() {
        System.out.println("init");

    }

    public void destroyMethod() {
        System.out.println("destroy");

    }

    @Override
    public void destroy() {
        System.out.println("Disposable interface");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing interface");

    }
}
