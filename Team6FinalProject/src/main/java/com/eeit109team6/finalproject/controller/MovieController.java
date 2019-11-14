package com.eeit109team6.finalproject.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.eeit109team6.finalproject.model.Category;
import com.eeit109team6.finalproject.model.Member;
import com.eeit109team6.finalproject.model.MovieInfo;
import com.eeit109team6.finalproject.model.Product;
import com.eeit109team6.finalproject.service.IMovieService;

@Controller
public class MovieController {

	IMovieService service;

	@Autowired
	public void setService(IMovieService service) {
		this.service = service;
	}

	ServletContext context;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	// movieindex 撈出Page Section 的影片
	@RequestMapping("/movies")
	public String findMovies(Model model, HttpSession session) {
		System.out.println("----------------@RequestMapping(\"/movies\")     findMovies---------------");
		List<MovieInfo> list = service.getMovieInfoByOwnerID();

		model.addAttribute("movies", list);
		return "movieindex";
	}

	// 後台進入 影片管理頁面
	@RequestMapping("/moviepersonal")
	public String addMovie(Model model, HttpSession session, MovieInfo movieinfo) {
		System.out.println("----------------@RequestMapping(\"/moviepersonal\")     moviepersonal---------------");
		List<MovieInfo> list = service.getMovies();
		model.addAttribute("allmovies", list);
		return "moviepersonal";
	}

	
	
	
	
	// 新增商品--> 商城後台 productsBack.jsp

	@RequestMapping(value = "/moviepersonal/addMovie", method = RequestMethod.POST)
	public String addMovie(
			@RequestParam("movie_name") String movie_name,
			@RequestParam("movie_content") String movie_content,
			@RequestParam("video_file") MultipartFile video_file,
			String videoname,HttpSession session
			) {

		System.out.println(
				"----------------@RequestMapping(value = \"/moviepersonal/addMovie\"     addMovie---------------");
		String path= session.getServletContext().getRealPath("/");

		System.out.println("path============"+path+"\\WEB-INF\\views\\Movie");
		MovieInfo movieInfo = new MovieInfo();
		System.out.println(video_file.getOriginalFilename());
		movieInfo.setName(movie_name);
		movieInfo.setMovie_content(movie_content);
		movieInfo.setLocation_Test(video_file.getOriginalFilename());
		videoname = video_file.getOriginalFilename();
		System.out.println("@RequestMapping(value = \"/moviepersonal/addMovie\")" + movieInfo);

		service.addMovie(movieInfo);

		if (!video_file.isEmpty()) {
			try {
				byte[] bytes = video_file.getBytes();

//				File dir = new File("C:\\Users\\User\\Desktop\\finalproject\\Team6FinalProject\\Team6FinalProject\\src\\main\\webapp\\WEB-INF\\views\\Movie");
				File dir = new File(path+"\\WEB-INF\\views\\Movie");
				System.out.println("File dir ======== "+dir);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + videoname);
				BufferedOutputStream stream = new BufferedOutputStream( new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println("You successfully uploaded file=" + videoname); 
				return "redirect:/moviepersonal";
			} catch (Exception e) {
				System.out.println("You failed to upload " + videoname + " => " + e.getMessage()); 
				return "redirect:/moviepersonal";
			}
		} else {
			System.out.println( "You failed to upload " + videoname + " because the file was empty.");
			return "redirect:/moviepersonal";
		}

	}

}
