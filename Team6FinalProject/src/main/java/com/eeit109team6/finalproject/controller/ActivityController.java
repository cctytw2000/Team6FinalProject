package com.eeit109team6.finalproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eeit109team6.finalproject.model.Activity;
import com.eeit109team6.finalproject.model.ActivityType;
import com.eeit109team6.finalproject.model.NewsType;
import com.eeit109team6.finalproject.service.IActivityService;
import com.eeit109team6.finalproject.service.INewsService;

@Controller
public class ActivityController {

	public ActivityController() {
	}

	IActivityService activityService;

	@Autowired
	public void setService(IActivityService activityService) {
		this.activityService = activityService;
	}

	INewsService newsService;

	@Autowired
	public void setService(INewsService newsService) {
		this.newsService = newsService;
	}

	// 新增活動類別
	@RequestMapping("/newsBack/addActivityType")
	public String addActivityType(@RequestParam("activityTypeName") String activityTypeName) {
		ActivityType at = new ActivityType();
		at.setActivityTypeName(activityTypeName);
		activityService.addActivityType(at);
		;
		return "redirect:/newsBack";
	}

	// 查詢所有活動類別並存入Model
	@ModelAttribute("activityTypes")
	public List<ActivityType> getActivityTypes() {
		return activityService.getAllActivityTypes();
	}

	// 導向新增活動頁面--> addActivity.jsp
	@RequestMapping(value = "/newsBack/addActivity", method = RequestMethod.GET)
	public String getAddNewActivityForm(Model model) {
		Activity activity = new Activity();
		model.addAttribute("activity", activity);

		List<ActivityType> list = activityService.getAllActivityTypes();
		Map<Integer, String> activityTypeMap = new HashMap<>();
		for (ActivityType a : list) {
			activityTypeMap.put(a.getActivityTypeId(), a.getActivityTypeName());
		}
		model.addAttribute("activityTypeMap", activityTypeMap);

		return "addActivity";
	}

	// 新增活動--> 消息後台 newsBack.jsp
	@RequestMapping(value = "/newsBack/addActivity1", method = RequestMethod.POST)
	public String processAddNewActivityForm(@ModelAttribute("activity") Activity activity) {
		Integer at_ = activity.getActivityType_(); // 取回遊戲類別分類id
		ActivityType at = activityService.getActivityTypeById(at_); // 利用id取得遊戲類別
		Integer nt_ = activity.getNewsType_(); // 取回新聞類別分類id
		NewsType nt = newsService.getNewsTypeById(nt_); // 利用id取得新聞類別
		// ==============其實不用=======================
		// ==============設定活動日期(時間)其實不用=======================
//		Calendar rightNow = Calendar.getInstance();
//		String registeredtime = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
//				+ rightNow.get(Calendar.DATE) + " " + rightNow.get(Calendar.HOUR) + ":" + rightNow.get(Calendar.MINUTE)
//				+ ":" + rightNow.get(Calendar.SECOND);
		// ==============/設定活動日期(時間)=======================

		activity.setActivityType(at); // 設定遊戲的遊戲類別
		activity.setNewsType(nt); // 設定遊戲的新聞類別
		activityService.addActivity(activity);
		return "redirect:/newsBack";
	}


}
