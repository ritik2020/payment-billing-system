package com.virtusa.batch31.paymentbillingsystem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ApiRoleMapping {

	private Map<String, List<String>> mapping = new HashMap<>();

	public ApiRoleMapping() {
		super();
		mapping.put("/branch/", Arrays.asList("accountant"));
		mapping.put("/admin/",Arrays.asList("admin"));
		mapping.put("/student/",Arrays.asList("admin","accountant"));
		mapping.put("/login/",Arrays.asList("admin","accountant"));
		mapping.put("/course/",Arrays.asList("admin","accountant"));
		mapping.put("/paymentdetail/",Arrays.asList("admin","accountant"));

		
		
		
		
		
	}
	
	public List<String> getAllowedRoles(String url) {
		return mapping.get(url);
	}
	
}
