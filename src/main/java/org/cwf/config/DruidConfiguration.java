package org.cwf.config;


import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
@PropertySource(value = "application.yml")
public class DruidConfiguration {

	@Bean(destroyMethod = "close", initMethod = "init")  
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druidDataSource() {
		return new DruidDataSource();
	}


	@Bean
	public ServletRegistrationBean statViewServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),
				"/druid/*");
		servletRegistrationBean.addInitParameter("allow", "127.0.0.1"); // 设置ip白名单
		servletRegistrationBean.addInitParameter("deny", "");// 设置ip黑名单，优先级高于白名单
		// 设置控制台管理用户
		servletRegistrationBean.addInitParameter("loginUsername", "admin");
		servletRegistrationBean.addInitParameter("loginPassword", "admin");
		// 是否可以重置数据
		servletRegistrationBean.addInitParameter("resetEnable", "false");
		return servletRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean statFilter() {
		// 创建过滤器
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
		// 设置过滤器过滤路径
		filterRegistrationBean.addUrlPatterns("/*");
		// 忽略过滤的形式
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}
}