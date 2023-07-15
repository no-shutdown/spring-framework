package aop;

import aop.targetclass.AopTarget;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @author xinLin.huang
 * @date 2023/7/15 15:11
 */
public class Aop {


	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationContext =
				new AnnotationConfigApplicationContext(AppConfig.class);
		AopTarget aopTarget = annotationContext.getBean(AopTarget.class);
		aopTarget.doAdvisor();
	}


	@Import({DefaultAdvisorAutoProxyCreator.class})
	@ComponentScan(value = {"aop"})
	public static class AppConfig {

	}
}
