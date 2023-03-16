import config.AppConfig;
import entity.ComponentUser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xinLin.huang
 * @date 2023/2/24 18:01
 */
public class Aaa {
	public static void main(String[] args) {
//		AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//		ComponentUser componentUser = annotationContext.getBean("componentUser", ComponentUser.class);
//		System.out.println(componentUser);

		ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("spring.xml");

	}
}
