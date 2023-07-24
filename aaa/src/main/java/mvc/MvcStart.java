package mvc;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

/**
 * @author xinLin.huang
 * @date 2023/7/24 14:54
 */

public class MvcStart {

	public static void main(String[] args) throws LifecycleException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);


		// 创建一个Web应用上下文并关联到Tomcat服务器
		File base = new File(System.getProperty("java.io.tmpdir"));
		Context context = tomcat.addContext("", base.getAbsolutePath());
		context.addLifecycleListener((LifecycleListener)Class.forName(tomcat.getHost().getConfigClass()).newInstance());


		tomcat.start();
		tomcat.getServer().await();
	}

}
