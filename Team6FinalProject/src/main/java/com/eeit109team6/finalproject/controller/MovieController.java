package com.eeit109team6.finalproject.controller;

import java.sql.Blob;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
//	movieindex      撈出Page Section 的影片 
	@RequestMapping("/movies")
	public String findMovies(Model model, HttpSession session) {
		System.out.println("----------------@RequestMapping(\"/movies\")     findMovies---------------");
		List<MovieInfo> list = service.getMovieInfoByOwnerID();
		
		model.addAttribute("movies", list);
		return "movieindex";
	}
	
	
	@RequestMapping("/moviepersonal")
	public String addMovie(Model model, HttpSession session,MovieInfo movieinfo) {
		System.out.println("----------------@RequestMapping(\"/moviepersonal\")     addMovie---------------");
		List<MovieInfo> list = service.getMovies();
		model.addAttribute("allmovies", list);
		return "moviepersonal";
	}
	   
	// 新增商品--> 商城後台 productsBack.jsp
	
	
			@RequestMapping(value = "/moviepersonal/addmovie")
			public String addProduct(Integer movie_ID, String name, String movie_content, Date time, Integer owner_ID,
					Integer like_Sum, Integer click_Sum, String location_Test) {
				System.out.println("----------------@RequestMapping(value = \"/moviepersonal/addmovie\")     addProduct--------,MultipartFile productImage-------");
				MovieInfo  movieInfo = new MovieInfo();
				movieInfo.setName(name);
				movieInfo.setMovie_content(movie_content);
				movieInfo.setLocation_Test(location_Test);
				
				
//				movieInfo.setProductImage(productImage);
//				Date time = new Date();
//				movieInfo.setTime(insertTime);
				//測試上傳圖片
				
//				String originalFilename = productImage.getOriginalFilename();
//				if(productImage != null && !productImage.isEmpty()) {
//					try {
//						byte[] b = productImage.getBytes();
//						Blob blob = new SerialBlob(b);
//						movieInfo.setPhoto(blob);
//					} catch(Exception e) {
//						e.printStackTrace();
//						throw new RuntimeException("檔案上傳發生異常:"+e.getMessage());
//					}
//				}
				//測試上傳圖片
				
				
				service.addMovie(movieInfo);
				return "redirect:/moviepersonal";
			}
	
}
