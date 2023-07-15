import aop.targetclass.AopTarget;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author xinLin.huang
 * @date 2023/2/24 18:01
 */
public class Aaa {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationContext =
				new AnnotationConfigApplicationContext(AppConfig.class);
		AopTarget aopTarget = annotationContext.getBean(AopTarget.class);
		aopTarget.doAdvisor();
	}
}
