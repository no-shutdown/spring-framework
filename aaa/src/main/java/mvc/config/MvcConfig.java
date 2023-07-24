package mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author xinLin.huang
 * @date 2023/7/24 14:54
 */
@Configuration
@ComponentScan({"mvc"})
@EnableWebMvc
public class MvcConfig {

}
