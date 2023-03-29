package entity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xinLin.huang
 * @date 2023/3/2 11:39
 */
public class BeanUser {
	private ComponentUser componentUser;

	@Autowired
	public void setComponentUser(ComponentUser componentUser) {
		this.componentUser = componentUser;
	}
}
