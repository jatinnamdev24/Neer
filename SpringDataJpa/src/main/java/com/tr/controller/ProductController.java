package com.tr.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tr.repository.ProductRepository;
import com.tr.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductRepository productRepository;
	HttpSession session;
	
	@RequestMapping("/productform")
	public String showproductform(@ModelAttribute("product")  Product product) {
		product=new Product();
		//System.out.println("kkk");
		return "productform";
	}
	
	@RequestMapping("/save")
	public String addProduct(@Valid @ModelAttribute("product")  Product product,
			BindingResult bindingResult) {
		//System.out.println(bindingResult.hasErrors());
		if(bindingResult.hasErrors()) {
			System.out.println("ui details not correct");
			return "productform";
		}
		productRepository.save(product);
	return "redirect:/viewproduct";
	}
	
	@RequestMapping("/viewproduct")
	public String viewallProduct(Model m) {
		
		List<Product> productlist=productRepository.findAll();
		m.addAttribute("plist",productlist);
		return "viewproduct";
	}
	
	@RequestMapping("/updateform")
	public String updateform(@RequestParam int pid, @ModelAttribute("product")  Product product,Model model) {
		Optional<Product> pp=productRepository.findById(pid);
		product=pp.get();
		model.addAttribute(product);
	//	System.out.println(product);
		return "updateform";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int pid) {
		productRepository.deleteById(pid);
		System.out.println(pid+"deleted");
		session.removeAttribute("clist");
	//	session.removeAttribute("rlist");
		return "redirect:/viewproduct";
	}
	@RequestMapping("/update")
	public String updateProduct(@ModelAttribute("product") Product product) {
		productRepository.save(product);
		session.removeAttribute("clist");
		session.removeAttribute("rlist");
	return "redirect:/viewproduct";
	}
	
	@RequestMapping("/search")
	public String searchbyCategory(@RequestParam String category,HttpServletRequest request) {
		List<Product> catList=productRepository.getProductsByCategory(category);
	//System.out.println(catList);
	 session=request.getSession();
	session.setAttribute("clist", catList);
	session.removeAttribute("rlist");
			return "redirect:/viewproduct";
	}
	@RequestMapping("/searchbyrange")
	public String searchbyRange(@RequestParam double min,@RequestParam double max,HttpServletRequest request) {
		List<Product> rangeList=productRepository.getProductsByRange(min, max);
	//System.out.println(catList);
	 session=request.getSession();
	session.setAttribute("rlist", rangeList);
	session.removeAttribute("clist");
			return "redirect:/viewproduct";
	}
}
