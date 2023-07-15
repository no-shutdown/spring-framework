package config;

import entity.BeanUser;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.*;


/**
 * @author xinLin.huang
 * @date 2023/2/24 18:03
 */
@Configuration
@ComponentScan(value = {"entity","aop"})
@Import({DefaultAdvisorAutoProxyCreator.class})
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
