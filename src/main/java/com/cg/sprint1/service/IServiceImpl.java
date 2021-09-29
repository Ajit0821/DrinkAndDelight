package com.cg.sprint1.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.sprint1.dao.IProductDao;
import com.cg.sprint1.dao.IRawMaterialDao;
import com.cg.sprint1.entity.Product;
import com.cg.sprint1.entity.RawMaterial;
import com.cg.sprint1.exception.ProductException;
import com.cg.sprint1.exception.RawMaterialException;
@Service
@Transactional
public class IServiceImpl implements IService{
	@Autowired
	private IRawMaterialDao mDao;
	@Autowired
	private IProductDao pDao;

	@Override
	public RawMaterial trackRawMaterialOrder(Integer productId) {
		Optional<RawMaterial> op=mDao.findById(productId);
		if(!op.isPresent())
			throw new RawMaterialException("No Raw Material Found For Product id: "+productId);
		return  op.get();
	}

	@Override
	public List<RawMaterial> displayProduct() {
	
		System.out.println(mDao.getClass().getName());
		List<RawMaterial> list = mDao.findAll();
        return list;
	}

	@Override
	public RawMaterial setProcessDate(Integer productId,Date processDate) {
		Optional<RawMaterial> op=mDao.findById(productId);
		RawMaterial rm=null;
		if(!op.isPresent())
			throw new RawMaterialException("No Raw Material Found For Product id: "+productId);
		else
		{
			rm=op.get();
			rm.setProcessDate(processDate); 
			mDao.save(rm);
			System.out.println("Process date is inserted");
		}
		return rm;
	}

	@Override
	public RawMaterial updateMfExpDate(@Valid Integer productId, Date mfDate, Date expDate) {
		Optional<RawMaterial> op=mDao.findById(productId);
		RawMaterial rm=null;
		if(!op.isPresent())
			throw new RawMaterialException("No Raw Material Found For Product id: "+productId);
		else
		{
			rm=op.get();
			rm.setMfDate(mfDate);
			rm.setExpDate(expDate); 
			mDao.save(rm);
			System.out.println(" Manufacturing Date, Expiry Date  is inserted");
		}
		return rm;
	}

	@Override
	public Product trackProductOrder(Integer pId) 
	{
		Optional<Product> op=pDao.findById(pId);
		if(!op.isPresent())
			throw new ProductException("No Raw Material Found For Product id: "+pId);
		return  op.get();
	}

	@Override
	public Product setExitDate(@Valid Integer pId, Date exitDate) {
		
		Optional<Product> op=pDao.findById(pId);
		Product prod=null;
		if(!op.isPresent())
			throw new ProductException("No Raw Material Found For Product id: "+pId);
		else
		{
			prod=op.get();
			prod.setExitDate(exitDate); 
			pDao.save(prod);
			System.out.println("Exit date is inserted");
		}
		return prod;
	}

	@Override
	public Product updateMfExpProdDate(@Valid Integer pId, Date mfDate, Date expDate) {
	
		Optional<Product> op=pDao.findById(pId);
		Product prod=null;
		if(!op.isPresent())
			throw new ProductException("No Raw Material Found For Product id: "+pId);
		else
		{
			prod=op.get();
			prod.setMfDate(mfDate);
			prod.setExpDate(expDate); 
			pDao.save(prod);
			System.out.println(" Manufacturing Date, Expiry Date  is inserted");
		}
		return prod;
		
	}

	@Override
	public List<Product> displayAllProduct() {
		System.out.println(pDao.getClass().getName());
		List<Product> list = pDao.findAll();
        return list;
	}

	@Override
	public Product updatePDeliveryStatus(@Valid Integer pId, String status) {
		Optional<Product> op=pDao.findById(pId);
		Product prod=null;
		if(!op.isPresent())
			throw new RawMaterialException("No ProductFound For Product id: "+pId);
		else
		{
			prod=op.get();
			prod.setpDeliveryStatus(status);
			pDao.save(prod);
			System.out.println(" Manufacturing Date, Expiry Date  is inserted");
		}
		return prod;
	}

	@Override
	public RawMaterial updateRmDeliveryStatus(@Valid Integer productId, String status) {
		Optional<RawMaterial> op=mDao.findById(productId);
		RawMaterial rm=null;
		if(!op.isPresent())
			throw new RawMaterialException("No Raw Material Found For Product id: "+productId);
		else
		{
			rm=op.get();
			rm.setRmDeliveryStatus(status);
			mDao.save(rm);
			System.out.println("Delivery Status updated for product id:"+productId);
		}
		return rm;
	}

	@Override
	public RawMaterial addRawMaterials(Integer productId, String productName, Integer productQuantity) {
		
		Optional<RawMaterial> op=mDao.findById(productId);
		RawMaterial rm=null;
		int a=(int) (200 + (Math.random() * 1000));
			rm=op.get();
			rm.setProductId(productId);
			rm.setProductName(productName);
			rm.setProductQuantity(productQuantity);
			rm.setProductPrice(a);
			
			mDao.save(rm);
		
		return rm;
		
	}

	@Override
	public RawMaterial addRawMaterials(@Valid RawMaterial rm) {
		RawMaterial rm1=new RawMaterial();
			rm1.setProductId(rm.getProductId());
			rm1.setProductName(rm.getProductName());
			rm1.setProductQuantity(rm.getProductQuantity());
			rm1.setProductPrice(rm.getProductPrice());
			mDao.save(rm1);
		
		return rm1;
	}

	@Override
	public Product addProduct(@Valid Product prod) {
		Product prod1=new Product();
		prod1.setpId(prod.getpId());
		prod1.setpName(prod.getpName());
		prod1.setpQuantity(prod.getpQuantity());
		prod1.setpPrice(prod.getpPrice());
		pDao.save(prod1);
		return prod1;
	}


		

}
