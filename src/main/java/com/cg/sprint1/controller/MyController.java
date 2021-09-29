package com.cg.sprint1.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint1.dto.UserDetailsDto;
import com.cg.sprint1.entity.Product;
import com.cg.sprint1.entity.RawMaterial;
import com.cg.sprint1.entity.UserDetails;
import com.cg.sprint1.service.ICustomerRegister;
import com.cg.sprint1.service.IService;
@RestController
@RequestMapping("/DrinkAndDelight")
@Validated
public class MyController {
	@Autowired
	public IService service;
	@Autowired
	private ICustomerRegister cRegister;
	@GetMapping("/raw_material/by/id/{rmId}")
	public ResponseEntity<RawMaterial>trackRawMaterialOrder(@PathVariable("rmId") Integer productId) {
		System.out.println("cntrlr fetch productId: " + productId);
		RawMaterial material = service.trackRawMaterialOrder(productId);
		return new ResponseEntity<RawMaterial>(material,HttpStatus.OK);
	}
	
	@GetMapping("/raw_material/display_raw_material")
	public ResponseEntity<List<RawMaterial>> displayProduct()
	{ 
		List<RawMaterial> material=service.displayProduct();
		return new ResponseEntity<List<RawMaterial>>(material,HttpStatus.OK);
	}
	

	@GetMapping("/raw_material/setDate/{rmId}/{processdate}")
	public  ResponseEntity<RawMaterial> setProcessDate(@PathVariable("rmId") Integer productId,@PathVariable("processdate") Date processDate)
	{
		System.out.println("cntrlr fetch productId: " + productId);
		RawMaterial material = service.setProcessDate(productId,processDate);
		return new ResponseEntity<RawMaterial>(material,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/raw_material/setDate/{rmId}/{mfdate}/{expdate}")
	public  ResponseEntity<RawMaterial> updateMfExpDate( @PathVariable("rmId") Integer productId,@PathVariable("mfdate") Date mfDate,@PathVariable("expdate") Date expDate)
	{
		System.out.println("cntrlr fetch productId: " + productId);
		RawMaterial material = service.updateMfExpDate(productId,mfDate,expDate);
		return new ResponseEntity<RawMaterial>(material,HttpStatus.OK);
	}
	 
	@GetMapping("/product/by/{pId}")
	public ResponseEntity<Product>trackOrder(@PathVariable("pId") Integer pId) {
		System.out.println("cntrlr fetch productId: " + pId);
		Product prod= service.trackProductOrder(pId);
		return new ResponseEntity<Product>(prod,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/product/setDate/{pId}/{exitDate}")
	public  ResponseEntity<Product> setExitDate(@PathVariable("pId") Integer pId,@PathVariable("exitDate") Date exitDate)
	{
		System.out.println("cntrlr fetch productId: " + pId);
		Product prod= service.setExitDate(pId,exitDate);
		return new ResponseEntity<Product>(prod,HttpStatus.OK);
	}
	
	
	@GetMapping("/product/Date/{pid}/{mfdate}/{expdate}")
	public  ResponseEntity<Product> updateMfExpProdDate(@PathVariable("pid") Integer pId,@PathVariable("mfdate") Date mfDate,@PathVariable("expdate") Date expDate)
	{
		System.out.println("cntrlr fetch productId: " + pId);
		Product prod= service.updateMfExpProdDate(pId,mfDate,expDate);
		return new ResponseEntity<Product>(prod,HttpStatus.OK);
	}
	
	@GetMapping("/product/display_products")
	public ResponseEntity<List<Product>> displayAllProduct()
	{ 
		List<Product> prod=service.displayAllProduct();
		return new ResponseEntity<List<Product>>(prod,HttpStatus.OK);
	}
	
	@GetMapping("/product/delivery_status/{pid}/{status}")
	public ResponseEntity<Product> updateDeliveryStatusOfProduct(@Valid @PathVariable ("pid") Integer pId,@PathVariable("status") String status)
	{
		System.out.println("cntrlr fetch productId: " + pId);
		Product prod= service.updatePDeliveryStatus(pId,status);
		return  new ResponseEntity<Product>(prod,HttpStatus.OK);
	}
	
	@GetMapping("/raw_material/delivery_status/{rmId}/{status}")
	public ResponseEntity<RawMaterial> updateDeliveryStatusOfRawMaterial(@Valid @PathVariable ("rmId") Integer productId,@PathVariable("status") String status)
	{
		System.out.println("cntrlr fetch productId: " + productId);
		RawMaterial rm= service.updateRmDeliveryStatus(productId,status);
		return  new ResponseEntity<RawMaterial>(rm,HttpStatus.OK);
	}
	
	
	@PostMapping("raw_material/place_order")
	public ResponseEntity<RawMaterial> placeRawMaterialOrder(@RequestBody @Valid RawMaterial rm)
	{ 
		RawMaterial rm1=service.addRawMaterials(rm);
		
		return new ResponseEntity<RawMaterial>(rm1,HttpStatus.OK);
	}
	
	
	@PostMapping("product/place_order")
	public ResponseEntity<Product> placeProductOrder(@RequestBody @Valid Product prod)
	{ 
		Product prod1=service.addProduct(prod);
		
		return new ResponseEntity<Product>(prod1,HttpStatus.OK);
	}
	
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/login")
	public String login(@RequestBody UserDetailsDto userDetails, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDetails uDetails = cRegister.findByName(userDetails);
		session.setAttribute("username", uDetails.getUsername());
		session.setAttribute("role", uDetails.getUserRole());
		session.setAttribute("custid", uDetails.getCustid());
		return "Login Successful.......Welcome " + uDetails.getUsername() + " ->" + uDetails.getUserRole();
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/logout")
	public String logout(@RequestBody UserDetailsDto userDetails, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (userDetails.getUsername().equals(session.getAttribute("username"))) {
			session.invalidate();
			return "You have successfully logged out " + userDetails.getUsername();
		}
		return "Not logged off";
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/login/register")
	public String register(@RequestBody UserDetailsDto userDetails, HttpServletRequest request) {
		UserDetails uDetails = new UserDetails(userDetails.getUsername(), userDetails.getPassword(), "User");
		uDetails = cRegister.register(uDetails);
		return "Registration successful with Username : " + uDetails.getUsername() + " Role-> "
				+ uDetails.getUserRole();
	}
	
}