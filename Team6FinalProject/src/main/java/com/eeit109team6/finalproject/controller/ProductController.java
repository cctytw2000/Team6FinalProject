package com.eeit109team6.finalproject.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eeit109team6.finalproject.model.Member;
import com.eeit109team6.finalproject.model.Product;
import com.eeit109team6.finalproject.service.ProductService;

@Controller
public class ProductController {
	ProductService service;

	@Autowired
	public void setService(ProductService service) {
		this.service = service;
	}
	
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	// 查詢所有商品--> 商城前台 products.jsp
	@RequestMapping("/products")
	public String list(Model model, HttpSession session) {
		Member mem = new Member();
		mem.setAccount("sandy60108@yahoo.com.tw");
		mem.setPassword("a14789632");
		mem.setUsername("andy");
		List<Product> list = service.getAllProducts();
		model.addAttribute("products", list);
		session.setAttribute("products", list);
		model.addAttribute("Member", mem);
		return "products";
	}

	// 商城管理 --> manager.jsp
	@RequestMapping("/manager")
	public String manager(Model model) {
		return "manager";
	}

	// 提供新增商品時的表單--> addProduct.jsp
	@RequestMapping(value = "/productsBack/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "addProduct";
	}

	// 新增商品--> 商城後台 productsBack.jsp
	@RequestMapping(value = "/productsBack/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("product") Product product) {
		Date date = new Date();
		product.setDate(date);
		//測試上傳圖片
		MultipartFile productImage = product.getProductImage();
		String originalFilename = productImage.getOriginalFilename();
		if(productImage != null && !productImage.isEmpty()) {
			try {
				byte[] b = productImage.getBytes();
				Blob blob = new SerialBlob(b);
				product.setPhoto(blob);
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常:"+e.getMessage());
			}
		}
		//測試上傳圖片
		service.addProduct(product);
		return "redirect:/productsBack";
	}

	// 依照分類查詢商品
	@RequestMapping("/queryCategory")
	public String getProductsByCategory(@RequestParam("category") String category, Model model) {
		List<Product> products = service.getProductsByCategory(category);
		model.addAttribute("products", products);
		return "products";
	}

	// 查詢所有商品分類並存入Model
	@ModelAttribute("categories")
	public List<String> getCategories() {
		return service.getAllCategories();
	}

	// 查詢單筆商品詳細資料--> product.jsp
	@RequestMapping("/product")
	public String getProductById(@RequestParam("game_id") Integer game_id, Model model) {
		Member mem = new Member();
		mem.setAccount("sandy60108@yahoo.com.tw");
		mem.setPassword("a14789632");
		mem.setUsername("andy");
		model.addAttribute("Member", mem);
		List<Product> list = service.getAllProducts();
		model.addAttribute("products", list);
		Product product = service.getProductById(game_id);
		model.addAttribute("product", product);
		return "product";
	}

	// 查詢所有商品--> 商城後台 productsBack.jsp
	@RequestMapping("/productsBack")
	public String listBack(Model model) {
		List<Product> list = service.getAllProducts();
		model.addAttribute("products", list);
		return "productsBack";
	}

	// 商品下架--> 商城後台 productsBack.jsp
	@RequestMapping("/products/delete")
	public String deleteProductById(@RequestParam("game_id") Integer game_id, Model model) {
		service.deleteProductById(game_id);
		List<Product> products = service.getAllProducts();
		model.addAttribute("products", products);
		return "redirect:/productsBack";
	}

	// 提供更新商品時的表單--> updateProduct.jsp
	@RequestMapping(value = "/products/update", method = RequestMethod.GET)
	public String getUpdateProductForm(@RequestParam("game_id") Integer game_id, Model model) {
		Product product = service.getProductById(game_id);
		model.addAttribute("product", product);
		return "updateProduct";
	}

	// 更新商品--> 商城後台 productsBack.jsp
	@RequestMapping(value = "/products/update", method = RequestMethod.POST)
	public String processUpdateProductForm(@ModelAttribute("product") Product product) {
		Date date = new Date();
		product.setDate(date);
		//上傳圖片
		MultipartFile productImage = product.getProductImage();
		String originalFilename = productImage.getOriginalFilename();
		if(productImage != null && !productImage.isEmpty()) {
			try {
				byte[] b = productImage.getBytes();
				Blob blob = new SerialBlob(b);
				product.setPhoto(blob);
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常:"+e.getMessage());
			}
		}
		//上傳圖片
		service.updateProductById(product);;
		return "redirect:/productsBack";
	}
	
	//取消
//	@RequestMapping("/products/cancel")
//	public String cancel(Model model) {
//		List<Product> products = service.getAllProducts();
//		model.addAttribute("products", products);
//		return "redirect:/productsBack";
//	}
	
	// 查詢所有商品(含已下架)--> 商城後台 productsBack.jsp
	@RequestMapping("/productsBack/all")
	public String getAll(Model model) {
		List<Product> list = service.getAllProducts();
		model.addAttribute("products", list);
		return "redirect:/productsBack";
	}
	
	@RequestMapping(value="getPicture/{game_id}", method=RequestMethod.GET)
	public ResponseEntity<byte[]> getPicture(HttpServletResponse resp, @PathVariable Integer game_id){
		String filePath = "resources/images/NoImage.jpg";
		byte[] media = null;
		HttpHeaders headers = new HttpHeaders();
		int len = 0;
		Product product = service.getProductById(game_id);
		if(product != null) {
			Blob blob = product.getPhoto();
			if(blob != null) { //資料庫有圖片
				try {
					len = (int) blob.length();
					media = blob.getBytes(1, len);
				} catch(SQLException e) {
					throw new RuntimeException("ProductController的getPicture()發生SQLException:"+e.getMessage());
				}
			}else { //資料庫沒圖片
				media = toByteArray(filePath);
			}
		}
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
		return responseEntity;
	}

	private byte[] toByteArray(String filePath) {
		byte[] b = null;
		String realPath = context.getRealPath(filePath);
		try {
			File file = new File(realPath);
			long size = file.length();
			b = new byte[(int)size];
			InputStream fis = context.getResourceAsStream(filePath);
			fis.read(b);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return b;
	}
}