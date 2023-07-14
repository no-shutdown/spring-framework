import aop.AopTarget;
import aop.advisor.AopAdvisor;
import config.AppConfig;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author xinLin.huang
 * @date 2023/2/24 18:01
 */
public class Aaa {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		AopTarget proxyTarget = new AopTarget();
		ProxyFactory proxyFactory = new ProxyFactory();
		//设置target
		proxyFactory.setTarget(proxyTarget);
		//添加advisor
		proxyFactory.addAdvisor(new AopAdvisor());
		//得到代理对象
		AopTarget proxy = (AopTarget) proxyFactory.getProxy();
		proxy.doAdvisor();


		proxy.doAspect();


//		AopTarget aopTarget = annotationContext.getBean(AopTarget.class);
//		aopTarget.doAspect();

	}
}
