package com.cg.sprint1.service;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import com.cg.sprint1.entity.Product;
import com.cg.sprint1.entity.RawMaterial;
import com.cg.sprint1.exception.ProductException;

public interface IService { 


	RawMaterial trackRawMaterialOrder(Integer productId);

	List<RawMaterial> displayProduct();

	RawMaterial setProcessDate(Integer productId, Date processDate);

	RawMaterial updateMfExpDate(@Valid Integer productId, Date mfDate, Date expDate);

	Product trackProductOrder(Integer pId);

	Product setExitDate(@Valid Integer pId, Date exitDate);

	Product updateMfExpProdDate(@Valid Integer pId, Date mfDate, Date expDate);

	List<Product> displayAllProduct();

	Product updatePDeliveryStatus(@Valid Integer pId, String status);

	RawMaterial updateRmDeliveryStatus(@Valid Integer productId, String status);

	RawMaterial addRawMaterials(Integer productId, String productName, Integer productQuantity);

	RawMaterial addRawMaterials(@Valid RawMaterial rm);

	Product addProduct(@Valid Product prod);

	
	

}
