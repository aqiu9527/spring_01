import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Aqiu
 * @create 2022-10-24 15:21
 */
public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        Demo demo = applicationContext.getBean("demo",Demo.class);
        demo.sayHi();
    }
}
