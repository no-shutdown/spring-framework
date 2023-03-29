package entity;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.SmartFactoryBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author xinLin.huang
 * @date 2023/3/29 16:44
 */
@Component
@Lazy
public class NonFactoryBean implements FactoryBean<String> {

	@Override
	public String getObject() throws Exception {
		return new String("123456");
	}

	@Override
	public Class<?> getObjectType() {
		return String.class;
	}

}
