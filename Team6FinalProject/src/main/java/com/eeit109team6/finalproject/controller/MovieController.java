package com.eeit109team6.finalproject.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.eeit109team6.finalproject.dao.IMemberDao;
import com.eeit109team6.finalproject.model.Category;
import com.eeit109team6.finalproject.model.Member;
import com.eeit109team6.finalproject.model.MovieInfo;
import com.eeit109team6.finalproject.model.Product;
import com.eeit109team6.finalproject.service.IMemberService;
import com.eeit109team6.finalproject.service.IMovieService;
import com.sun.xml.internal.ws.developer.MemberSubmissionEndpointReference;

@Controller
public class MovieController {

	IMovieService service;
	IMemberService memberService;

	@Autowired
	public void setService(IMovieService service) {
		this.service = service;
	}

	@Autowired
	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}

	ServletContext context;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}



	// 影片區Click --> "/movies" --> movieindex.jsp
	@RequestMapping("/movies")
	public String findMovies(Model model, HttpSession session) {

		System.out.println(
				"------------------------------------@(\"/movies\")     findMovies-----------------------------------");
		List<MovieInfo> list = service.getMovies();
		model.addAttribute("movies", list);
		return "movieindex";

	}

	// 後台Click --> 影片管理 --> "/moviepersonal" --> moviepersonal.jsp
	@RequestMapping("/moviepersonal")
	public String addMovie(Model model, HttpSession session, MovieInfo movieinfo) {

		System.out.println(
				"---------------------------------  (\"/moviepersonal\")         moviepersonal.jsp------------------------------");
		List<MovieInfo> list = service.getMovies();
		model.addAttribute("allmovies", list);

//		測試用
		Member member = (Member) session.getAttribute("mem");
//		System.out.println("session.getAttribute(\"mem\")==============================="+session.getAttribute("mem"));
//		System.out.println("member======================================================"+member);
		System.out.println("member.getMember_id()=======================================" + member.getMember_id());
		System.out.println("member.getAccount()=========================================" + member.getAccount());
		System.out.println("member.getUsername()========================================" + member.getUsername());
		System.out.println("member.getPassword()========================================" + member.getPassword());

		return "moviepersonal";

	}

	// moviepersonal --> 新增影片Submit --> /moviepersonal/addMovie -->
	// redirect:/moviepersonal --> moviepersonal.jsp
	@RequestMapping(value = "/moviepersonal/addMovie", method = RequestMethod.POST)
	public String addMovie(@RequestParam("movie_name") String movie_name,
			@RequestParam("movie_content") String movie_content, @RequestParam("video_file") MultipartFile video_file,
			String videoname, HttpSession session) {

		System.out.println(
				"-----------------------------(\"/moviepersonal/addMovie\")     addMovie----------------------------");

		String path = session.getServletContext().getRealPath("/"); // 找到影片上傳路徑
		System.out.println("path============" + path + "\\WEB-INF\\views\\Movie");

		MovieInfo movieInfo = new MovieInfo();

//		System.out.println(video_file.getOriginalFilename());//video_file(xxx.mp4)

		movieInfo.setName(movie_name);
		movieInfo.setMovie_content(movie_content);
		movieInfo.setMember((Member) session.getAttribute("mem"));// session.getAttribute("mem") //再用 (Member) 做強轉型別
		movieInfo.setLocation_Test(video_file.getOriginalFilename());

		videoname = video_file.getOriginalFilename();

		System.out.println("@RequestMapping(value = \"/moviepersonal/addMovie\")" + movieInfo);

		service.addMovie(movieInfo);

//		System.out.println("========================================="+member.getMember_id());
//		System.out.println("========================================="+member.getUsername());
//		System.out.println("session.getAttribute(\"mem\")========================================="+ session.getAttribute("mem") );

		if (!video_file.isEmpty()) {
			try {
				byte[] bytes = video_file.getBytes();

//				File dir = new File("C:\\Users\\User\\Desktop\\finalproject\\Team6FinalProject\\Team6FinalProject\\src\\main\\webapp\\WEB-INF\\views\\Movie");
				File dir = new File(path + "\\WEB-INF\\views\\Movie");
				System.out.println("File dir ======== " + dir);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + videoname);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println("You successfully uploaded file=" + videoname);
				return "redirect:/moviepersonal";
			} catch (Exception e) {
				System.out.println("You failed to upload " + videoname + " => " + e.getMessage());
				return "redirect:/moviepersonal";
			}
		} else {
			System.out.println("You failed to upload " + videoname + " because the file was empty.");
			return "redirect:/moviepersonal";
		}

	}

	// moviepersonal.jsp UpdateClick --> /moviepersonal/updateMovie -->
	// movieupdate.jsp
	@RequestMapping("/moviepersonal/viewUpdateMovie")
	public String selectOneMovie(Model model, HttpSession session, MovieInfo movieinfo,
			@RequestParam("movie_ID") Integer movie_id) {

		System.out.println("----------------\"/moviepersonal/viewUpdateMovie\"   -->  movieupdate.jsp---------------");
		MovieInfo movieInfo = service.getMovieInfoByMovieID(movie_id);
		List<MovieInfo> list = new ArrayList<>();
		list.add(movieInfo);

		model.addAttribute("movieInfo", list);

		System.out.println("movieInfo.getMovie_ID() ============================" + movieInfo.getMovie_ID());
		System.out.println("movieInfo.getName()=================================" + movieInfo.getName());
		System.out.println("movieInfo.getMovie_content()========================" + movieInfo.getMovie_content());
		System.out.println("movieInfo.getLocation_Test()========================" + movieinfo.getLocation_Test());
		System.out
				.println("movieInfo.getMember().getMember_id()================" + movieInfo.getMember().getMember_id());

		return "movieupdate";

	}

	// movieupdate.jsp SubmitClick --> /movieupdate/update -->
	// redirect:/moviepersonal --> moviepersonal.jsp
	@RequestMapping(value = "/moviepersonal/updateMovie", method = RequestMethod.POST)
	public String updateMovie(
//				@ModelAttribute("movieInfo") MovieInfo movieInfo,
			@RequestParam(value = "movie_ID") Integer movie_ID, @RequestParam(value = "member_id") Integer member_id,
			@RequestParam(value = "movie_name") String movie_name,
			@RequestParam(value = "movie_content") String movie_content,
			@RequestParam(value = "video_file") MultipartFile video_file, HttpSession session, Model model) {
		System.out.println(
				"----------------\"/moviepersonal/update\"    -->    \"redirect:/moviepersonal\"---------------");
		String videoname = video_file.getOriginalFilename();
		// 檢查 movieInfo
		System.out.println("==========檢查 movieInfo=========== ");
		System.out.println("movieInfo.getMovie_ID()=========== " + movie_ID);
		System.out.println("movieInfo.member_id================== " + member_id);
		System.out.println("movieInfo.getName()=============== " + movie_name);
		System.out.println("movieInfo.getMovie_content()====== " + movie_content);
		System.out.println("movieInfo.videoname=============== " + videoname);
		// 檢查 movieInfo End

		String path = session.getServletContext().getRealPath("/"); // 找到影片上傳路徑
		System.out.println("path============" + path + "\\WEB-INF\\views\\Movie");

		MovieInfo movieInfo = new MovieInfo();
		movieInfo.setMovie_ID(movie_ID);

		Member member = memberService.findById(member_id);

		System.out.println("member Check =======" + member);

		movieInfo.setMember(member);
//			movieInfo.setMember((Member) session.getAttribute("mem"));
		movieInfo.setName(movie_name);
		movieInfo.setMovie_content(movie_content);
		movieInfo.setLocation_Test(videoname);
//			movieInfo.setMember((Member) session.getAttribute("mem"));// session.getAttribute("mem") //再用 (Member) 做強轉型別
//			movieInfo.setLocation_Test(video_file.getOriginalFilename());//設定MsSQL的檔名

		// 檢查 movieInfo Set
		System.out.println("=======檢查 movieInfo Set========== ");
		System.out.println("movieInfo.getMovie_ID()=========== " + movieInfo.getMovie_ID());
		System.out.println("movieInfo.getMember()============= " + movieInfo.getMember());
		System.out.println("movieInfo.getName()=============== " + movieInfo.getName());
		System.out.println("movieInfo.getMovie_content()====== " + movieInfo.getMovie_content());
		System.out.println("movieInfo.getLocation_Test()====== " + movieInfo.getLocation_Test());
		// 檢查 movieInfo Set End

		service.updateMovieInfoById(movieInfo);
//			MovieInfo movieInfo = new MovieInfo();

//			System.out.println(video_file.getOriginalFilename());//video_file(xxx.mp4)

		// 檢查 updateMovieInfoById
		System.out.println("======檢查 updateMovieInfoById===== ");
		System.out.println("movieInfo.getMovie_ID()=========== " + movieInfo.getMovie_ID());
		System.out.println("movieInfo.getMember()============= " + movieInfo.getMember());
		System.out.println("movieInfo.getName()=============== " + movieInfo.getName());
		System.out.println("movieInfo.getMovie_content()====== " + movieInfo.getMovie_content());
		System.out.println("movieInfo.getLocation_Test()====== " + movieInfo.getLocation_Test());
		// 檢查 updateMovieInfoById End

		if (!video_file.isEmpty()) {
			try {
				byte[] bytes = video_file.getBytes();
				File dir = new File(path + "\\WEB-INF\\views\\Movie");
				System.out.println("File dir ======== " + dir);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + videoname);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println("You successfully uploaded file=" + videoname);
				return "redirect:/moviepersonal";
			} catch (Exception e) {
				System.out.println("You failed to upload " + videoname + " => " + e.getMessage());
				return "redirect:/moviepersonal";
			}
		} else {
			System.out.println("You failed to upload " + videoname + " because the file was empty.");
			return "redirect:/moviepersonal";
		}
//			return "redirect:/moviepersonal";
	}

	// moviepersonal.jsp DeleteClick --> moviepersonal.jsp
	@RequestMapping("/moviepersonal/deleteMovie")
	public String deleteMovie(Model model, HttpSession session, MovieInfo movieinfo,
			@RequestParam("movie_ID") int movie_ID) {
		System.out.println("----------------@RequestMapping(\"/moviepersonal\")     moviepersonal---------------");
		service.deleteMovieInfoById(movie_ID);
//					List<MovieInfo> list = service.getMovies();
//					model.addAttribute("allmovies", list);
		return "redirect:/moviepersonal";
	}
}
