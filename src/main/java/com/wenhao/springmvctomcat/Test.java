package com.wenhao.springmvctomcat;

import org.apache.catalina.Host;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class Test {
    public static void main(String[] args) throws LifecycleException, InterruptedException, ServletException {
        Tomcat tomcatServer = new Tomcat();
        tomcatServer.setPort(8080);
        StandardContext ctx = (StandardContext) tomcatServer.addWebapp("/", new File("src/main").getAbsolutePath());
        //禁止重新载入
        ctx.setReloadable(false);
        //class文件读取地址
        File additionWebInfClasses = new File("target/classes");
        //创建webroot
        WebResourceRoot resources = new StandardRoot(ctx);
        //tomcat内部读取class执行
        resources.addPreResources(new DirResourceSet(resources, "/target/classes", additionWebInfClasses.getAbsolutePath(), "/"));
        tomcatServer.start();
        Host host = tomcatServer.getHost();

        tomcatServer.getServer().await();

    }
}
