package com.eeit109team6.finalproject.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eeit109team6.finalproject.model.BoardType;
import com.eeit109team6.finalproject.service.IBoardTypeService;

@Controller
public class BoardTypeController {

	public BoardTypeController() {
	}
	
	IBoardTypeService service;
	ServletContext context;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(IBoardTypeService service) {
		this.service = service;
	}

	// 討論區後台，顯示討論區看板列表 --> discussionBack.jsp
	@RequestMapping("/discussionBack")
	public String getAllBoardType(Model model) {
		List<BoardType> list = service.getAllBoardType();
		System.out.println("討論區後台");
		model.addAttribute(list);
		return "discussionBack";
	}
	
	// 提供新增討論看板時的表單 --> addBoard.jsp
	@RequestMapping(value = "addBoard", method = RequestMethod.GET)
	public String getAddBoardTypeForm(Model model) {

		BoardType boardType = new BoardType();
		model.addAttribute("boardType", boardType);

		return "addBoard";
	}
	
	// 新增討論看板 -->重定向至討論區後台 discussionBack.jsp
	@RequestMapping(value = "addBoard", method = RequestMethod.POST)
	public String processAddBoardType(@ModelAttribute("boardType") BoardType bt) {
		System.out.println("進入processAddBoardType()方法");
		service.addBoardType(bt);
		return "redirect:/discussionBack";
	}

	// 提供修改討論看板時的表單 --updateBoard.jsp
//	@RequestMapping(value = "updateBoard", method = RequestMethod.GET)
//	public String getUpdateBoardTypeForm(@RequestParam("boardId") Integer boardId, Model model) {
//		System.out.println("進入getUpdateBoardTypeForm()方法");
//		BoardType boardtype = service.getBoardTypeById(boardId);
//		model.addAttribute("boardType", boardtype);
//		return "updateBoard";
//	}
//	
	// 修改討論看板--> 重定向至討論區後台 discussionBack.jsp
//	@RequestMapping(value = "updateBoard", method = RequestMethod.POST)
//	public String processUpdateBoardType(@ModelAttribute("boardType") BoardType boardType, @RequestParam("boardId") Integer boardId) {
//		
//		
//		boardType.updateBoard
//		return "redirect:/discussionBack";
//	}
	
	
}




