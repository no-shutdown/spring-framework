package aop.advisor;

import aop.AopTarget;
import org.aopalliance.aop.Advice;
import org.springframework.aop.*;
import org.springframework.aop.support.RootClassFilter;
import org.springframework.aop.support.StaticMethodMatcher;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author xinLin.huang
 * @date 2023/7/14 11:29
 */
@Component
public class AopAdvisor implements PointcutAdvisor {
	@Override
	public Advice getAdvice() {
		return new MethodBeforeAdvice() {
			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {
				System.out.println("advisor before");
			}
		};
	}

	@Override
	public Pointcut getPointcut() {
		return new Pointcut() {
			@Override
			public ClassFilter getClassFilter() {
				return new RootClassFilter(AopTarget.class);
			}

			@Override
			public MethodMatcher getMethodMatcher() {
				return new StaticMethodMatcher() {
					@Override
					public boolean matches(Method method, Class<?> targetClass) {
						return method.getName().equals("doAdvisor");
					}
				};
			}
		};
	}

	@Override
	public boolean isPerInstance() {
		return false;
	}
}
