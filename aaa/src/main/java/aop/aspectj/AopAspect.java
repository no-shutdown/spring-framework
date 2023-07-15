package aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author xinLin.huang
 * @date 2023/5/4 17:38
 */
@Aspect
@Component
public class AopAspect {



	@Before(value = "execution(public void aop.targetclass.AopTarget.doAspect())")
	public void before() {
		System.out.println("aspect before");
	}

}
