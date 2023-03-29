import config.AppConfig;
import entity.ComponentUser;
import entity.JavaCodingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xinLin.huang
 * @date 2023/2/24 18:01
 */
public class Aaa {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		annotationContext.register(JavaCodingBean.class);
		BeanDefinition beanDefinition = annotationContext.getBeanDefinition("javaCodingBean");
		beanDefinition.getPropertyValues().add("attr", 1);
		JavaCodingBean bean = annotationContext.getBean("javaCodingBean", JavaCodingBean.class);

		Object nonFactoryBean = annotationContext.getBean("nonFactoryBean");
		System.out.println(nonFactoryBean);


		ComponentUser componentUser = annotationContext.getBean("componentUser", ComponentUser.class);
		System.out.println(componentUser);



//		ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("spring.xml");

	}
}
