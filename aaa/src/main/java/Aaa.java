import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xinLin.huang
 * @date 2023/2/24 18:01
 */
public class Aaa {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(annotationContext.getBean("user"));


		ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("spring.xml");
		System.out.println(xmlContext.getBean("xmlUser"));
	}
}
