package config;

import entity.BeanUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.core.io.ClassPathResource;
import pojo.ImportUser;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author xinLin.huang
 * @date 2023/2/24 18:03
 */
@Configuration
@ComponentScan(value = {"entity"})
@Import({ImportUser.class, ImportConfig.class})
@PropertySource("classpath:myProperties.yml")
@MapperScan(basePackages = {"mapper"})
public class AppConfig {

	@Bean(autowire = Autowire.BY_NAME)
	public BeanUser user() {
		return new BeanUser();
	}


	public class ImportMemberConfig {
		@Bean
		public BeanUser user2() {
			return new BeanUser();
		}
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		sqlSessionFactoryBean.setDataSource(new DataSource() {});
		return sqlSessionFactoryBean;
	}

}
