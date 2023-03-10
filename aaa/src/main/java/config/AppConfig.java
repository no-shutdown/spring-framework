package config;

import entity.BeanUser;
import pojo.ImportUser;
import org.springframework.context.annotation.*;

/**
 * @author xinLin.huang
 * @date 2023/2/24 18:03
 */
@Configuration
@ComponentScan(value = {"entity"})
@Import({ImportUser.class, ImportConfig.class})
@PropertySource("classpath:myProperties.yml")
public class AppConfig {

	@Bean
	public BeanUser user() {
		return new BeanUser();
	}


	public class ImportMemberConfig {
		@Bean
		public BeanUser user2() {
			return new BeanUser();
		}
	}
}
