package entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xinLin.huang
 * @date 2023/3/2 11:25
 */
@Component
public class ComponentUser {

	private BeanUser user;


	@Autowired(required = true)
	public ComponentUser(BeanUser user) {
		System.out.println(1);
		this.user = user;
	}

	@Autowired(required = false)
	public ComponentUser(BeanUser user, BeanUser user3) {

		System.out.println(2);
		this.user = user;
	}
}
