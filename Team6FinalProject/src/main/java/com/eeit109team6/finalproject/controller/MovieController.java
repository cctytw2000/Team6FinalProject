package com.eeit109team6.finalproject.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
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
import com.eeit109team6.finalproject.model.HomeMovie;
import com.eeit109team6.finalproject.model.Member;
import com.eeit109team6.finalproject.model.Movie;
import com.eeit109team6.finalproject.model.MovieInfo;
import com.eeit109team6.finalproject.model.Product;
import com.eeit109team6.finalproject.service.IHomeMovieService;
import com.eeit109team6.finalproject.service.IMemberService;
import com.eeit109team6.finalproject.service.IMovieService;

@Controller
public class MovieController {

	
	IMemberService memberService;
	IHomeMovieService homeMovieService;
	IMovieService service;
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

	@Autowired
	public void setHomeMovieService(IHomeMovieService homeMovieService) {
		this.homeMovieService = homeMovieService;
	}

	// 影片區Click --> "/movies" --> movieindex.jsp
	@RequestMapping("/movies")
	public String findMovies(Model model, HttpSession session) {

		System.out.println(
				"------------------------------------@(\"/movies\")     findMovies-----------------------------------");
		List<MovieInfo> list = service.getMovies();
		
		
		ArrayList<MovieInfo> newMovies = service.getNewMovieInfo(3);
		
		model.addAttribute("movies", list);
		model.addAttribute("newMovies", newMovies);
		return "movieindex";

	}

	// 後台Click --> 影片管理 --> "/moviepersonal" --> moviepersonal.jsp
	@RequestMapping("/moviepersonal")
	public String addMovie(Model model, HttpSession session, MovieInfo movieinfo) {

		System.out.println(
				"---------------------------------  (\"/moviepersonal\")         moviepersonal.jsp------------------------------");
		Member member = (Member) session.getAttribute("mem");
		List<MovieInfo> list = service.getMovieInfoByOwnerID(member.getMember_id());

		// List<MovieInfo> list = service.getMovies();
		model.addAttribute("allmovies", list);

		// 測試用

		System.out.println("member.getMember_id()=======================================" + member.getMember_id());
		System.out.println("member.getAccount()=========================================" + member.getAccount());
		System.out.println("member.getUsername()========================================" + member.getUsername());
		System.out.println("member.getPassword()========================================" + member.getPassword());
		System.out.println("member.getMemberlevel();====================================" + member.getMemberlevel());
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

		// System.out.println(video_file.getOriginalFilename());//video_file(xxx.mp4)

		movieInfo.setName(movie_name);
		movieInfo.setMovie_content(movie_content);
		movieInfo.setMember((Member) session.getAttribute("mem"));// session.getAttribute("mem") //再用 (Member) 做強轉型別
		movieInfo.setLocation_Test(video_file.getOriginalFilename());
		movieInfo.setClick_Sum(0);
		// ===========================設定影片上傳時間=================================
		// SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		// String addDate = sf.format(new Date());
		// movieInfo.setDate(addDate);

		videoname = video_file.getOriginalFilename();

		System.out.println("@RequestMapping(value = \"/moviepersonal/addMovie\")" + movieInfo);

		service.addMovie(movieInfo);

		// System.out.println("========================================="+member.getMember_id());
		// System.out.println("========================================="+member.getUsername());
		// System.out.println("session.getAttribute(\"mem\")========================================="+
		// session.getAttribute("mem") );

		if (!video_file.isEmpty()) {
			try {
				byte[] bytes = video_file.getBytes();

				// File dir = new
				// File("C:\\Users\\User\\Desktop\\finalproject\\Team6FinalProject\\Team6FinalProject\\src\\main\\webapp\\WEB-INF\\views\\Movie");
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
			// @ModelAttribute("movieInfo") MovieInfo movieInfo,
			@RequestParam(value = "movie_ID") Integer movie_ID, @RequestParam(value = "member_id") Integer member_id,
			@RequestParam(value = "movie_name") String movie_name,
			@RequestParam(value = "movie_content") String movie_content,
			@RequestParam(value = "video_file") MultipartFile video_file, HttpSession session, Model model,
			@RequestParam(value = "oldfilename") String oldfilename) {

		System.out.println(
				"----------------\"/moviepersonal/update\"    -->    \"redirect:/moviepersonal\"---------------");
		String videoname = video_file.getOriginalFilename();
		System.out.println("oldfilename===" + oldfilename);
		// 檢查 movieInfo
//		System.out.println("==========檢查 movieInfo=========== ");
//		System.out.println("movieInfo.getMovie_ID()=========== " + movie_ID);
//		System.out.println("movieInfo.member_id================== " + member_id);
//		System.out.println("movieInfo.getName()=============== " + movie_name);
//		System.out.println("movieInfo.getMovie_content()====== " + movie_content);
//		System.out.println("movieInfo.videoname=============== " + videoname);
		// 檢查 movieInfo End

		String path = session.getServletContext().getRealPath("/"); // 找到影片上傳路徑
		System.out.println("path============" + path + "\\WEB-INF\\views\\Movie");

		MovieInfo movieInfo = service.getMovieInfoByMovieID(movie_ID);
		
		
//		MovieInfo movieInfo = new MovieInfo();
//		movieInfo.setMovie_ID(movie_ID);

		Member member = memberService.findById(member_id);

		System.out.println("member Check =======" + member);

		movieInfo.setMember(member);
		// movieInfo.setMember((Member) session.getAttribute("mem"));
		movieInfo.setName(movie_name);
		movieInfo.setMovie_content(movie_content);

		if (!"".equals(videoname)) {
			System.out.println("!\"\".equals(videoname)");
			movieInfo.setLocation_Test(videoname);
		} else {
			movieInfo.setLocation_Test(oldfilename);
		}

		// movieInfo.setMember((Member) session.getAttribute("mem"));//
		// session.getAttribute("mem") //再用 (Member) 做強轉型別
		// movieInfo.setLocation_Test(video_file.getOriginalFilename());//設定MsSQL的檔名

		// 檢查 movieInfo Set
//		System.out.println("=======檢查 movieInfo Set========== ");
//		System.out.println("movieInfo.getMovie_ID()=========== " + movieInfo.getMovie_ID());
//		System.out.println("movieInfo.getMember()============= " + movieInfo.getMember());
//		System.out.println("movieInfo.getName()=============== " + movieInfo.getName());
//		System.out.println("movieInfo.getMovie_content()====== " + movieInfo.getMovie_content());
//		System.out.println("movieInfo.getLocation_Test()====== " + movieInfo.getLocation_Test());
		// 檢查 movieInfo Set End

		service.updateMovieInfoById(movieInfo);
		// MovieInfo movieInfo = new MovieInfo();

		// System.out.println(video_file.getOriginalFilename());//video_file(xxx.mp4)

		// 檢查 updateMovieInfoById
//		System.out.println("======檢查 updateMovieInfoById===== ");
//		System.out.println("movieInfo.getMovie_ID()=========== " + movieInfo.getMovie_ID());
//		System.out.println("movieInfo.getMember()============= " + movieInfo.getMember());
//		System.out.println("movieInfo.getName()=============== " + movieInfo.getName());
//		System.out.println("movieInfo.getMovie_content()====== " + movieInfo.getMovie_content());
//		System.out.println("movieInfo.getLocation_Test()====== " + movieInfo.getLocation_Test());
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
//			return "redirect:/moviepersonal";
		}
		
		
		
		
		 return "redirect:/moviepersonal";
	}

	// moviepersonal.jsp DeleteClick --> moviepersonal.jsp
	@RequestMapping("/moviepersonal/deleteMovie")
	public String deleteMovie(Model model, HttpSession session, MovieInfo movieinfo,
			@RequestParam("movie_ID") int movie_ID) {
		System.out.println(
				"----------------@RequestMapping(\"/moviepersonal/deleteMovie\")     redirect:/moviepersonal---------------");
		service.deleteMovieInfoById(movie_ID);
		System.out.println("----------------deleteMovieInfoById     Done---------------");
		// List<MovieInfo> list = service.getMovies();
		// model.addAttribute("allmovies", list);
		return "redirect:/moviepersonal";
	}

	// ============================================================================moviehome.jsp===============================================================================================
	// ============================================================================moviehome.jsp===============================================================================================
	// ============================================================================moviehome.jsp===============================================================================================
	// ============================================================================moviehome.jsp===============================================================================================
	// ============================================================================moviehome.jsp===============================================================================================

	// 後台Click --> 影片管理(首頁管理) Clicked --> "/movieHome" --> moviehome.jsp
	@RequestMapping("/movieHome")
	public String homeSelectAllMovie(Model model, HttpSession session) {

		System.out.println(
				"-------------------------------------------  後台Click --> 影片管理(首頁管理) Clicked --> \"/movieHome\" --> moviehome.jsp-----------------------------------------");

		// Member member = (Member)session.getAttribute("mem");
		List<Movie> list = homeMovieService.findAll();
		System.out.println("list.size() ===================================== " + list.size());
		model.addAttribute("homeMovies", list);

		// 測試用
		// System.out.println("member.getMember_id()======================================="+member.getMember_id());
		// System.out.println("member.getAccount()========================================="+member.getAccount());
		// System.out.println("member.getUsername()========================================"+member.getUsername());
		// System.out.println("member.getPassword()========================================"+member.getPassword());
		// System.out.println("member.getMemberlevel();===================================="+member.getMemberlevel());
		// 測試用 END
		return "movieHome";

	}


	@RequestMapping(value = "/movieHome/addMovie", method = RequestMethod.POST)
	public String homeAddMovie(@RequestParam("video_file") MultipartFile video_file, String videoname,
			HttpSession session, Movie movie) {

		System.out.println(
				"------------------------------------ moviehome.jsp --> 新增影片 Clicked --> \"/movieHome/addMovie\" --> \"redirect:/moviehome\" ------------------------------------");


		movie.setMovieName(video_file.getOriginalFilename());// video_file.getOriginalFilename() --> 取檔案名稱 xxx.mp4
		homeMovieService.addMovie(movie);

		movie = homeMovieService.moviefindById(movie.getMovieId());
		movie.setMovieName(movie.getMovieId() + video_file.getOriginalFilename());// movie.getMovieId()+video_file.getOriginalFilename()
																					// --> 取 movieId+xxx.mp4 重新儲存 進SQL
		homeMovieService.addMovie(movie);

		Path p = Paths.get("C:/movieHome"); // 路徑設定

		if (Files.exists(p)) {

			System.out.print("資料夾已存在");
		} else if (!Files.exists(p)) {
			try {
				Files.createDirectory(p); // 建立資料夾 memberMovies folder
				System.out.print("已成功建立資料夾");
			} catch (IOException e) {
				System.out.println("發生錯誤");
			}
		}

	

		String path = "C:/movieHome";

		if (!video_file.isEmpty()) {
			try {
				byte[] bytes = video_file.getBytes();

				File dir = new File(path, movie.getMovieId() + video_file.getOriginalFilename());// 建立儲存路徑path與檔案名稱
																									// movieId+xxx.mp4

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(dir));
				stream.write(bytes);// 按stream 設定的 dir 存入 檔案 bytes
				stream.close();

				return "redirect:/movieHome";
			} catch (Exception e) {
				return "redirect:/movieHome";
			}
		} else {
			return "redirect:/movieHome";
		}
	}

	@RequestMapping("/movieHome/updateMovie")
	public String homeSelectOneMovie(Model model, HttpSession session, Movie movie,
			@RequestParam("updateMovieId") Integer updateMovieId,
			@RequestParam("updateMovieName") String originMovieName,
			@RequestParam("video_file") MultipartFile video_file) {
		System.out.println(
				"-------------------------    \"/movieHome/updateMovie\"        homeSelectOneMovie   -----------------------------------");

		Member mem = (Member) session.getAttribute("mem");
		movie = homeMovieService.moviefindById(updateMovieId);

		// 判斷空值是下列哪一種情況
		// if(video_file.getOriginalFilename() == null) {
		// System.out.println("video_file.getOriginalFilename() == null");
		// }else if (video_file.getOriginalFilename() == "" ) {
		// System.out.println("video_file.getOriginalFilename() == \"\"");
		// }else if (video_file.getOriginalFilename() == " " ) {
		// System.out.println("video_file.getOriginalFilename() == \"space\"");
		// }else {
		// System.out.println("video_file.getOriginalFilename() == unknew String");
		// }
		// 判斷空值是下列哪一種情況 END

		// 判斷是否沒選檔(空值)，如果有選就做修改
		if (video_file.getOriginalFilename() == "") {
			System.out.println(
					"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! video_file.getOriginalFilename() == \"\" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			return "redirect:/movieHome";
		} else {
			movie.setMovieName(movie.getMovieId() + video_file.getOriginalFilename());
			homeMovieService.updateMovieById(movie);

			// 檔案上傳
			Path p = Paths.get("C:/memberMovies"); // 路徑設定

			if (Files.exists(p)) {
				System.out.print("資料夾已存在");
			} else if (!Files.exists(p)) {
				/* 不存在的話,直接建立資料夾 */
				try {
					Files.createDirectory(p);
					System.out.print("已成功建立資料夾");
				} catch (IOException e) {
					System.out.println("發生錯誤");
				}
			}

			p = Paths.get("C:/memberMovies/" + mem.getAccount() + mem.getMember_id()); // 路徑設定

			if (Files.exists(p)) {
				System.out.println("資料夾已存在");
			}
			if (!Files.exists(p)) {
				/* 不存在的話,直接建立資料夾 */
				try {
					Files.createDirectory(p);
					System.out.println("已成功建立資料夾");
				} catch (IOException e) {
					System.out.println("發生錯誤");
				}
			}

			String path = "C:/memberMovies/" + mem.getAccount() + mem.getMember_id();

			if (!video_file.isEmpty()) {
				try {
					byte[] bytes = video_file.getBytes();

					File dir = new File(path, movie.getMovieId() + video_file.getOriginalFilename());

					// File serverFile = new File(dir.getAbsolutePath() + File.separator +
					// videoname);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(dir));
					stream.write(bytes);
					stream.close();

					return "redirect:/movieHome";
				} catch (Exception e) {
					return "redirect:/movieHome";
				}
			} else {
				return "redirect:/movieHome";
			}

		}

	}

	// moviehome.jsp --> delete Clicked --> "/movieHome/deleteMovie" -->
	// "redirect:/moviehome";
	@RequestMapping(value = "/movieHome/deleteMovie")
	public String homeDeleteMovie(Model model, HttpSession session, Movie movie,
			@RequestParam("deleteMovieId") Integer deleteMovieId,
			@RequestParam("deleteMovieIdCheck") Integer deleteMovieIdCheck) {
		System.out.println(
				"----------------@RequestMapping(\"/movieHome/deleteMovie\")     homeDeleteMovie---------------");

		System.out.println("deleteMovieId ====================================================== " + deleteMovieId);
		System.out.println(
				"deleteMovieIdCheck ====================================================== " + deleteMovieIdCheck);
		// System.out.println("movie.getMovieId()
		// ============================================= "+movie.getMovieId());
		// System.out.println("movie.getMovieName()
		// ============================================ "+movie.getMovieName());
		homeMovieService.deleteMovieById(deleteMovieIdCheck);
		return "redirect:/movieHome";
	}
	
	// moviehome.jsp --> Choose Clicked --> "/movieHome/setIndex" --> "redirect:/moviehome";
		@RequestMapping(value = "/movieHome/setIndex")
		public String homeSetIndex(Model model, HttpSession session, HomeMovie homeMovie,
				@RequestParam("movieId") Integer movieId) {
			System.out.println("----------------@RequestMapping(\"/movieHome/deleteMovie\")     homeDeleteMovie---------------");

			System.out.println("movieId ====================================================== " + movieId);
			homeMovie = homeMovieService.findById(1);
			homeMovie.setMovie(homeMovieService.getMovieInfoByMovieID(movieId));
			homeMovieService.updateMovieid(homeMovie);
			return "movieHome";
		}
}
