package com.cg.sprint1.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import  static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.sprint1.entity.Product;
import com.cg.sprint1.entity.RawMaterial;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(IServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IServiceTest {
	
	@Autowired
	IServiceImpl service;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testTrackRawMaterialOrder() {
		RawMaterial rm1=service.addRawMaterials(new RawMaterial(7, "Wire", 432, 4,null,null,null,"Delivered"));
		RawMaterial rm=service.trackRawMaterialOrder(rm1.getProductId());
	    assertEquals(rm1.getProductName(),rm.getProductName());
		
		
	}

	@Test
	void testDisplayProduct() {
		RawMaterial rm=service.addRawMaterials(new RawMaterial(12,"hard disk",413,8,null,null,null, "Delivered"));
		List<RawMaterial> rm1=service.displayProduct();
		assertEquals(rm, rm1);
		
	}

	@Test
	void testSetProcessDate() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateMfExpDate() {
		fail("Not yet implemented");
	}

	@Test
	void testTrackProductOrder() {
		
		Product prod=service.addProduct(new Product(100, "Bike",2346.0, 5, null, null, null, "Delivery"));
		Product prod1=service.trackProductOrder(prod.getpId());
		assertEquals(prod.getpName(), prod1.getpName());
		
	}

	@Test
	void testSetExitDate() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateMfExpProdDate() {
		fail("Not yet implemented");
	}

	@Test
	void testDisplayAllProduct() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdatePDeliveryStatus() {
		Product prod=service.addProduct(new Product(101, "Wire", 432, 4,null,null,null,"Delivered"));
		Product prod1=service.updatePDeliveryStatus(prod.getpId(),prod.getpDeliveryStatus());
		assertEquals(prod.getpDeliveryStatus(),prod1.getpDeliveryStatus());
	}

	@Test
	void testUpdateRmDeliveryStatus() {
		RawMaterial rm1=service.addRawMaterials(new RawMaterial(5, "Wire", 432, 4,null,null,null,"Delivered"));
		RawMaterial rm=service.updateRmDeliveryStatus(rm1.getProductId(),rm1.getRmDeliveryStatus());
		assertEquals(rm1.getRmDeliveryStatus(), rm.getRmDeliveryStatus());
	}

	@Test
	void testAddRawMaterialsIntegerStringInteger() {
		fail("Not yet implemented");
	}

	@Test
	void testAddRawMaterialsRawMaterial() {
		fail("Not yet implemented");
	}

	@Test
	void testAddProduct() {
		fail("Not yet implemented");
	}

}
