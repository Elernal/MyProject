package org.cwf.component;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 
   * <p>Title : MvcConfig</p>
   * <p>Description : 扩展springmvc</p>
   * <p>DevelopTools : Eclipse_x64</p>
   * <p>DevelopSystem : Window7_x64</p>
   * <p>Company : org.cwf</p>
   * @author : cwf
   * @date : 2018年12月25日 下午9:32:31
   * @version : 12.0.0
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		WebMvcConfigurer adConfigurer = new WebMvcConfigurer(){
			//设置默认访问
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				// TODO Auto-generated method stub
				registry.addViewController("/").setViewName("login");
				registry.addViewController("/login.html").setViewName("login");
			}
				
			//注册拦截器
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				// TODO Auto-generated method stub
				//排除拦截静态资源
				String[] excludes = new String[]{"/adminLogin","/css/**","/img/**","/js/**","/login.html","/","/login","/3rd/**","/image_code"};
				registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
						.excludePathPatterns(excludes);
			}
			
		};
		return adConfigurer;
	}

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 1.定义一个converters转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        // 2.添加fastjson的配置信息，比如: 是否需要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        // 3.在converter中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        // 4.将converter赋值给HttpMessageConverter
        HttpMessageConverter<?> converter = fastConverter;
        // 5.返回HttpMessageConverters对象
        return new HttpMessageConverters(converter);
    }

	
}
