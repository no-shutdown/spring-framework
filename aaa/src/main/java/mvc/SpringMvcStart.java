package mvc;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

/**
 * @author xinLin.huang
 * @date 2023/7/24 14:54
 */

public class SpringMvcStart {

	public static void main(String[] args) throws LifecycleException {

		Tomcat tomcat = new Tomcat();

		Connector connector = new Connector();
		connector.setPort(8081);//设置端口
		tomcat.getService().addConnector(connector);

		tomcat.addWebapp("/", new File("src/main/web").getAbsolutePath());

		tomcat.start();
		tomcat.getServer().await();
	}

}
