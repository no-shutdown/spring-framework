package entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xinLin.huang
 * @date 2023/3/2 11:25
 */
@Component
public class ComponentUser {




//	@Autowired（虽然最后都调用无参，但执行逻辑是不一样的）
	public ComponentUser() {

		System.out.println(2);
	}
}
