package com.aptech.demo.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aptech.demo.models.Manufacturers;
import com.aptech.demo.models.Materials;
import com.aptech.demo.models.Prodgroups;
import com.aptech.demo.models.Products;
import com.aptech.demo.models.Subcats;
import com.aptech.demo.repositories.DashboardRepository;
import com.aptech.demo.repositories.ManufacturersRepository;
import com.aptech.demo.repositories.ProdgroupsRepository;
import com.aptech.demo.repositories.ProductsRepository;
import com.aptech.demo.repositories.SubcatsRepository;

@Controller
@RequestMapping("/admin")
public class ProductsController {
	@Autowired
	private ProductsRepository proRepo;
	@Autowired
	private ProdgroupsRepository prodgrRepo;
	@Autowired
	private SubcatsRepository scatRepo;
	@Autowired
	private ManufacturersRepository mnFactsRepo;

	private final Path root = Paths.get("src", "main", "resources", "static", "upload");
	public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

	@RequestMapping("/products")
	// @RequestMapping(value = { "/admin/products" })
	public String listAll(Model model) {

		List<Products> listProducts = proRepo.findAll();
		model.addAttribute("listProducts", listProducts);
		List<Prodgroups> listProdgroups = prodgrRepo.findAll();
		model.addAttribute("listProdgroups", listProdgroups);
		List<Subcats> listScats = scatRepo.findAll();
		model.addAttribute("listScats", listScats);
		List<Manufacturers> listMfgers = mnFactsRepo.findAll();
		model.addAttribute("listMfgers", listMfgers);

		return "admin/product/index";
	}

	@RequestMapping(value = "/products/insert")
	public String create(Model model) {
		model.addAttribute("product", new Products());
		List<Products> listProducts = proRepo.findAll();
		model.addAttribute("listProducts", listProducts);
		List<Prodgroups> listProdgroups = prodgrRepo.findActive();
		model.addAttribute("listProdgroups", listProdgroups);
		List<Subcats> listScats = scatRepo.findActive();
		model.addAttribute("listScats", listScats);
		List<Manufacturers> listMfgers = mnFactsRepo.findActive();
		model.addAttribute("listMfgers", listMfgers);
		return "admin/product/insert";
	}

	@RequestMapping(value = "/products/inserted", method = RequestMethod.POST)
	public String InsertedProduct(@RequestParam("product_id") String product_id,
			@RequestParam("prodgroupid") String prodgroupid, @RequestParam("subcatid") String subcatid,
			@RequestParam("mfgerid") String mfgerid, @RequestParam("product_name") String product_name,
			@RequestParam("product_desc") String product_desc, @RequestParam("sizeX") Float sizeX,
			@RequestParam("sizeY") Float sizeY, @RequestParam("sizeZ") Float SizeZ, @RequestParam("vol") Float vol,
			@RequestParam("weight") Float weight, @RequestParam("img1") MultipartFile img1,
			@RequestParam("img2") MultipartFile img2, @RequestParam("img3") MultipartFile img3, Model model)
			throws IOException {

		String image1 = StringUtils.cleanPath(img1.getOriginalFilename());
		String image2 = StringUtils.cleanPath(img2.getOriginalFilename());
		String image3 = StringUtils.cleanPath(img3.getOriginalFilename());
		String noimage = "no-image.png";

		Products p = new Products();
		p.setProduct_id(product_id);
		p.setProdgroupid(prodgroupid);
		p.setSubcatid(subcatid);
		p.setMfgerid(mfgerid);
		p.setProduct_name(product_name);
		p.setProduct_desc(product_desc);
		p.setSizeX(sizeX);
		p.setSizeY(sizeY);
		p.setSizeZ(SizeZ);
		p.setVol(vol);
		p.setWeight(weight);
		p.setImg1(image1);
		p.setImg2(image2);
		p.setImg3(image3);
		// Get Current Date
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		System.out.println(date);
		p.setProduct_createdat(date);
		p.setProduct_active(1);
		p.setProduct_continuity(1);

		Path staticPath = Paths.get("src", "main", "resources", "static", "upload");
		String uploadRootPath = staticPath.toString();

		System.out.println("uploadRootPath=" + uploadRootPath);
		File uploadRootDir = new File(uploadRootPath);
		// Create directory if it not exists.
		if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}
		List<File> uploadedFiles = new ArrayList<File>();
		List<String> failedFiles = new ArrayList<String>();

		// Paramethod "img1"

		if (image1 != null && image1.length() > 0) {
			try {
				// Create the file at server
				File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + image1);

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(img1.getBytes());
				stream.close();
				//
				uploadedFiles.add(serverFile);
				System.out.println("Write file: " + serverFile);
			} catch (Exception e) {
				System.out.println("Error Write file: " + image1);
				failedFiles.add(image1);
			}
		}

		// Set No Image

		if (image1 == "")
			p.setImg1(noimage);

		// Param img2

		if (image2 != null && image2.length() > 0) {
			try {
				// Create the file at server
				File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + image2);

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(img2.getBytes());
				stream.close();
				//
				uploadedFiles.add(serverFile);
				System.out.println("Write file: " + serverFile);
			} catch (Exception e) {
				System.out.println("Error Write file: " + image2);
				failedFiles.add(image2);
			}
		}

		// Set No Image

		if (image2 == "")
			p.setImg2(noimage);

		// Param img3

		if (image3 != null && image3.length() > 0) {
			try {
				// Create the file at server
				File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + image3);

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(img3.getBytes());
				stream.close();
				//
				uploadedFiles.add(serverFile);
				System.out.println("Write file: " + serverFile);
			} catch (Exception e) {
				System.out.println("Error Write file: " + image3);
				failedFiles.add(image3);
			}
		}

		// Set No Image

		if (image3 == "")
			p.setImg3(noimage);

		Products saveProduct = proRepo.insert(p);
		String uploadDir = "/upload/" + saveProduct.getProduct_id();
		Path uploadPath = Paths.get(uploadDir);

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		try {
			InputStream inputStream = img1.getInputStream();
			Path filePath = uploadPath.resolve(uploadPath);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new IOException("Could not save uploaded file: " + image1);
		}
		try {
			InputStream inputStream = img2.getInputStream();
			Path filePath = uploadPath.resolve(uploadPath);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new IOException("Could not save uploaded file: " + image2);
		}
		try {
			InputStream inputStream = img3.getInputStream();
			Path filePath = uploadPath.resolve(uploadPath);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new IOException("Could not save uploaded file: " + image3);
		}

		return "redirect:/admin/products";
	}

	@GetMapping("/products/edit")
	public String EditView(Model model, @RequestParam("idPro") String id) {
		Products pro = proRepo.findById(id);
		model.addAttribute("product_id", pro.getProduct_id());
		model.addAttribute("prodgroupid", pro.getProdgroupid());
		model.addAttribute("subcatid", pro.getSubcatid());
		model.addAttribute("mfgerid", pro.getMfgerid());
		model.addAttribute("product_name", pro.getProduct_name());
		model.addAttribute("product_desc", pro.getProduct_desc());
		model.addAttribute("sizeX", pro.getSizeX());
		model.addAttribute("sizeY", pro.getSizeY());
		model.addAttribute("sizeZ", pro.getSizeZ());
		model.addAttribute("vol", pro.getVol());
		model.addAttribute("weight", pro.getWeight());
		model.addAttribute("img1", pro.getImg1());
		model.addAttribute("img2", pro.getImg2());
		model.addAttribute("img3", pro.getImg3());
		model.addAttribute("stl", pro.getStl());
		model.addAttribute("product_continuity", pro.getProduct_continuity());
		List<Products> listProducts = proRepo.findAll();
		model.addAttribute("listProducts", listProducts);
		List<Prodgroups> listProdgroups = prodgrRepo.findActive();
		model.addAttribute("listProdgroups", listProdgroups);
		List<Subcats> listScats = scatRepo.findActive();
		model.addAttribute("listScats", listScats);
		List<Manufacturers> listMfgers = mnFactsRepo.findActive();
		model.addAttribute("listMfgers", listMfgers);

		System.out.println();

		return "admin/product/edit";
	}

	@PostMapping("/products/edited")
	public String UpdateProduct(@RequestParam("product_id") String product_id,
			@RequestParam("prodgroupid") String prodgroupid, @RequestParam("subcatid") String subcatid,
			@RequestParam("mfgerid") String mfgerid, @RequestParam("product_name") String product_name,
			@RequestParam("product_desc") String product_desc, @RequestParam("sizeX") Float sizeX,
			@RequestParam("sizeY") Float sizeY, @RequestParam("sizeZ") Float SizeZ, @RequestParam("vol") Float vol,
			@RequestParam("weight") Float weight, @RequestParam("img1") MultipartFile img1,
			@RequestParam("img2") MultipartFile img2, @RequestParam("img3") MultipartFile img3,
			@RequestParam("stl") String stl, Model model) throws IOException {

		String image1 = StringUtils.cleanPath(img1.getOriginalFilename());
		String image2 = StringUtils.cleanPath(img2.getOriginalFilename());
		String image3 = StringUtils.cleanPath(img3.getOriginalFilename());

		Products oldPro = proRepo.findById(product_id);
		String oldImg1 = oldPro.getImg1();
		String oldImg2 = oldPro.getImg2();
		String oldImg3 = oldPro.getImg3();
		// System.out.println("handleBeforeSave :: old customer.avatar = " + oldAv);

		Products p = new Products();
		p.setProduct_id(product_id);
		p.setProdgroupid(prodgroupid);
		p.setSubcatid(subcatid);
		p.setMfgerid(mfgerid);
		p.setProduct_name(product_name);
		p.setProduct_desc(product_desc);
		p.setSizeX(sizeX);
		p.setSizeY(sizeY);
		p.setSizeZ(SizeZ);
		p.setVol(vol);
		p.setWeight(weight);
		p.setStl(stl);

		// Delete old img1

		if (image1 != null && image1.length() > 0) {
//			if (oldImg1 != null && oldImg1.length() > 0) {
				DeleteOldImage1(oldImg1);
//			}
			p.setImg1(image1);
		} else {
			p.setImg1(oldImg1);
		}

		// Delete old img2

		if (image2 != null && image2.length() > 0) {
//			if (oldImg2 != null && oldImg2.length() > 0) {
				DeleteOldImage2(oldImg2);
//			}
			p.setImg2(image2);
		} else {
			p.setImg2(oldImg2);
		}

		// Delete old img3

		if (image3 != null && image3.length() > 0) {
//			if (oldImg3 != null && oldImg3.length() > 0) {
				DeleteOldImage3(oldImg3);
//			}
			p.setImg3(image3);
		} else {
			p.setImg3(oldImg3);
		}
		Path staticPath = Paths.get("src", "main", "resources", "static", "upload");
		String uploadRootPath = staticPath.toString();

		System.out.println("uploadRootPath=" + uploadRootPath);
		File uploadRootDir = new File(uploadRootPath);
		// Create directory if it not exists.
		if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}
		List<File> uploadedFiles = new ArrayList<File>();
		List<String> failedFiles = new ArrayList<String>();
		if (image1 != null && image1.length() > 0) {
			try {
				// Create the file at server
				File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + image1);

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(img1.getBytes());
				stream.close();
				//
				uploadedFiles.add(serverFile);
				System.out.println("Write file: " + serverFile);
			} catch (Exception e) {
				System.out.println("Error Write file: " + image1);
				failedFiles.add(image1);
			}
		}

		if (image2 != null && image2.length() > 0) {
			try {
				// Create the file at server
				File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + image2);

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(img2.getBytes());
				stream.close();
				//
				uploadedFiles.add(serverFile);
				System.out.println("Write file: " + serverFile);
			} catch (Exception e) {
				System.out.println("Error Write file: " + image2);
				failedFiles.add(image2);
			}
		}

		if (image3 != null && image3.length() > 0) {
			try {
				// Create the file at server
				File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + image3);

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(img3.getBytes());
				stream.close();
				//
				uploadedFiles.add(serverFile);
				System.out.println("Write file: " + serverFile);
			} catch (Exception e) {
				System.out.println("Error Write file: " + image3);
				failedFiles.add(image3);
			}
		}

		Products updatePro = proRepo.update(p);
		List<Products> products = proRepo.findAll();
		model.addAttribute("listproducts", products);

		return "redirect:/admin/products";

	}

	/*
	 * @PostMapping("delete") public String Delete(@RequestParam String id) {
	 * proRepo.deleteById(id); return "redirect:/admin/products"; }
	 */

	public boolean DeleteOldImage1(String img1) {
		try {

			Path file = root.resolve(img1);
			Files.deleteIfExists(file);

			System.out.print("Delete is " + Files.deleteIfExists(file));
			return true;

		} catch (IOException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}

	public boolean DeleteOldImage2(String img2) {
		try {

			Path file = root.resolve(img2);
			Files.deleteIfExists(file);

			System.out.print("Delete is " + Files.deleteIfExists(file));
			return true;

		} catch (IOException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}

	public boolean DeleteOldImage3(String img3) {
		try {

			Path file = root.resolve(img3);
			Files.deleteIfExists(file);

			System.out.print("Delete is " + Files.deleteIfExists(file));
			return true;

		} catch (IOException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}

	@RequestMapping("products/viewdetail")
	public String viewdetail(@RequestParam("id") String id, Model model) {

		Products pro = proRepo.findById(id);

		String prodgroupid = pro.getProdgroupid();
		Prodgroups prod = prodgrRepo.findById(prodgroupid);

		String subcatId = pro.getSubcatid();
		Subcats subcat = scatRepo.findById(subcatId);

		String mfgerid = pro.getMfgerid();
		Manufacturers mfger = mnFactsRepo.findById(mfgerid);

		model.addAttribute("product_id", pro.getProduct_id());
		model.addAttribute("prodgroupname", prod.getProdgroup_name());
		model.addAttribute("subcatname", subcat.getSubcat_name());
		model.addAttribute("mfgername", mfger.getMfger_name());
		model.addAttribute("product_name", pro.getProduct_name());
		model.addAttribute("product_desc", pro.getProduct_desc());
		model.addAttribute("sizeX", pro.getSizeX());
		model.addAttribute("sizeY", pro.getSizeY());
		model.addAttribute("sizeZ", pro.getSizeZ());
		model.addAttribute("vol", pro.getVol());
		model.addAttribute("weight", pro.getWeight());
		model.addAttribute("img1", pro.getImg1());
		model.addAttribute("img2", pro.getImg2());
		model.addAttribute("img3", pro.getImg3());
		model.addAttribute("stl", pro.getStl());
		model.addAttribute("product_continuity", pro.getProduct_continuity());
		model.addAttribute("product_active", pro.getProduct_active());
		model.addAttribute("product_createdat", pro.getProduct_createdat());

		return "admin/product/detail";
	}

	@PostMapping("/products/delete")
	public String DeleteProduct(Model model, @RequestParam("idPro") String idPro, Products pro) {
		proRepo.deleteById(idPro);
		Iterable<Products> prolist = proRepo.findAll();
		model.addAttribute("listPro", prolist);
		return "redirect:/admin/products";
	}

	@GetMapping("/products/active")
	public String Active(Model model, @RequestParam("idPro") String idPro, Products pro) {
		proRepo.active(idPro);
		Iterable<Products> prolist = proRepo.findAll();
		model.addAttribute("listPro", prolist);
		return "redirect:/admin/products";
	}

	@GetMapping("/products/inactive")
	public String Inactive(Model model, @RequestParam("idPro") String idPro, Products pro) {
		proRepo.inactive(idPro);
		Iterable<Products> prolist = proRepo.findAll();
		model.addAttribute("listPro", prolist);
		return "redirect:/admin/products";
	}

	@GetMapping("/products/continuity")
	public String Continuity(Model model, @RequestParam("idPro") String idPro, Products pro) {
		proRepo.continuity(idPro);
		Iterable<Products> prolist = proRepo.findAll();
		model.addAttribute("listPro", prolist);
		return "redirect:/admin/products";
	}

	@GetMapping("/products/incontinuity")
	public String Incontinuity(Model model, @RequestParam("idPro") String idPro, Products pro) {
		proRepo.incontinuity(idPro);
		Iterable<Products> prolist = proRepo.findAll();
		model.addAttribute("listPro", prolist);
		return "redirect:/admin/products";
	}

	@GetMapping("/products/3d")
	public String stl(@RequestParam("id") String id, Model model) {
		// List<Products> listProducts = proRepo.findAll();
		Products pro = proRepo.findById(id);
		model.addAttribute("stl", pro.getStl());
		return "admin/product/3d";
	}

}
