package my.spring.demo01.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

	@PostMapping("/api/report/weekly")
	public Map<String, String> reportWeekly() {
		HashMap<String, String> map = new HashMap<>();
		map.put("menuId", "REPORT_WEEKLY");
		map.put("menuName", "주간보고이다");
		
		return map;
	}
	
	@PostMapping("/api/report/quarter")
	public Map<String, String> reportQuarter() {
		HashMap<String, String> map = new HashMap<>();
		map.put("menuId", "REPORT_QUARTER");
		map.put("menuName", "분기보고이다");
		
		return map;
	}
}
