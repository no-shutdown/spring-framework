package aop;

import org.springframework.stereotype.Component;

/**
 * @author xinLin.huang
 * @date 2023/5/4 17:32
 */
@Component
public class AopTarget {

	public void doAdvisor() {
		System.out.println("doAdvisor");
	}

	public void doAspect() {
		System.out.println("doAspect");
	}
}
