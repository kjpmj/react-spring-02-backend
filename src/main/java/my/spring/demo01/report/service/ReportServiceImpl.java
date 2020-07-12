package my.spring.demo01.report.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService{
	@Override
	public Map<String, String> selectReportError() {
		HashMap<String, String> map = new HashMap<>();
		map.put("menuId", "REPORT_QUARTER");
		map.put("menuName", "분기보고이다");
		
		String str = "aaa";
		Integer.parseInt(str);

		return map;
	}
}
