/**
 * 
 */
package com.pinkitec.aps.filter;

import java.util.Locale;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.pinkitec.core.interceptor.UserLoginInterceptor;

/**
 * @author tyler-zhou
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MainWebAppConfigurer implements WebMvcConfigurer {
	
	@Bean  
    public LocaleResolver localeResolver() {  
        SessionLocaleResolver slr = new SessionLocaleResolver();  
        slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);  
        return slr;  
    }  
  
    @Bean  
    public LocaleChangeInterceptor localeChangeInterceptor() {  
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();  
        lci.setParamName("lang");  
        return lci;  
    }  

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addInterceptor(localeChangeInterceptor());
		
		 registry.addInterceptor(new UserLoginInterceptor())
			.addPathPatterns("/**")
			.excludePathPatterns("/static/**")
			.excludePathPatterns("/user/login")
			.excludePathPatterns("/user/logout") 
			.excludePathPatterns("/error")
			.excludePathPatterns("/captcha")
			.excludePathPatterns("/http/**")
			.excludePathPatterns("/com/logo")
			.excludePathPatterns("/com/name")
			.excludePathPatterns("/itoc")
		    .excludePathPatterns("/plan/formwork")
		    .excludePathPatterns("/report/rep12/lymessage")
			.excludePathPatterns("/file")
//			.excludePathPatterns("/so/plan/init")
//			.excludePathPatterns("/so/plan/save")
			.excludePathPatterns("/sev/**")
			.excludePathPatterns("/image/show");
	}
}
