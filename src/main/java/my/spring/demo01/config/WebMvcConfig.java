package my.spring.demo01.config;

import java.util.Arrays;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		// 루트 맵핑
		registry.addViewController("/").setViewName("forward:/index.html");
		
		// /api로 시작하는 않으면 index.html로 forward
		registry.addViewController("/{x:^(?!api$).*$}/**/{y:[\\w\\-]+}").setViewName("forward:/index.html");
		
		//error
		registry.addViewController("/not-found").setViewName("forward:/index.html");
	}
	
	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> containerCustomizer() {
		 return container -> {
//            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/not-found"));
            
            Arrays.asList(HttpStatus.values()).forEach(status -> {
            	Series series = Series.valueOf(status);
            	
            	System.out.println(status.toString() + " : " + series.toString());
            	
            	container.addErrorPages(new ErrorPage(status, "/not-found"));
            });
            
//            container.addErrorPages(new ErrorPage(HttpStatus.Series.CLIENT_ERROR, "/not-found"));
        };
	}
}
