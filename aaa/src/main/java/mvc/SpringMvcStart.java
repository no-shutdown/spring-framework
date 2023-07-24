package mvc;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

/**
 * @author xinLin.huang
 * @date 2023/7/24 14:54
 */

public class SpringMvcStart {

	public static void main(String[] args) throws LifecycleException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		Tomcat tomcat = new Tomcat();


//		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");//设置协议
		Connector connector = new Connector();
		connector.setPort(8081);//设置端口
		tomcat.getService().addConnector(connector);

		tomcat.addWebapp("/", System.getProperty("java.io.tmpdir"));

//		Context context = tomcat.addContext("/", System.getProperty("java.io.tmpdir"));
//		context.addLifecycleListener((LifecycleListener) Class.forName(tomcat.getHost().getConfigClass()).newInstance());

		tomcat.start();
		tomcat.getServer().await();
	}

}
