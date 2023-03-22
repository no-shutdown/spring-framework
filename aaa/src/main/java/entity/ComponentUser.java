package entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author xinLin.huang
 * @date 2023/3/2 11:25
 */
@Component
public class ComponentUser {

	@Autowired
	@Qualifier("user")
	private BeanUser user;

}
