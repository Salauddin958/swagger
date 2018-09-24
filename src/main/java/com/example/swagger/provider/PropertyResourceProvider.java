package com.example.swagger.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;

import com.example.swagger.config.SwaggerServicesConfig;
import com.example.swagger.config.SwaggerServicesConfig.SwaggerService;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Controller
@Primary
public class PropertyResourceProvider implements SwaggerResourcesProvider{
	
	@Autowired
	private SwaggerServicesConfig config; 

	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>();
        for(SwaggerService resource : this.config.getServices()){
        	System.out.println("resource "+resource);
            resources.add(createSwaggerResource(resource));
        }

        return resources;
	}
	
	private SwaggerResource createSwaggerResource(SwaggerService resource) {
		SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(resource.getName());
        swaggerResource.setLocation(resource.getUrl());
        swaggerResource.setSwaggerVersion(resource.getVersion());
        return swaggerResource;
    }

}
