package com.example.swagger.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "documentation.swagger")
public class SwaggerServicesConfig {
	
	List<SwaggerService> services;
	

    public List<SwaggerService> getServices() {
		return services;
	}



	public void setServices(List<SwaggerService> services) {
		this.services = services;
	}



	public static class SwaggerService {
        String name;
        String url;
        String version;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getVersion() {
			return version;
		}
		public void setVersion(String version) {
			this.version = version;
		}
        
        
    }

}
