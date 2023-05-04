package config;

import entity.BeanUser;
import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.core.io.ClassPathResource;
import pojo.ImportUser;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		// Configuration的环境，数据源，事务管理器配置会被忽略
		// 取而代之的是SqlSessionFactoryBean对应的environment，dataSource，transactionFactory属性
//		configuration.setEnvironment(new Environment("prod", new SpringManagedTransactionFactory(), new PooledDataSource()));
		sqlSessionFactoryBean.setConfiguration(configuration);
		sqlSessionFactoryBean.setDataSource(new PooledDataSource());//配置自己的数据源
		sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
		return sqlSessionFactoryBean;
	}

}
