package com.model2.mvc.purchase.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.purchase.PurchaseService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/commonservice.xml"})
public class PurchaseServiceTest {

	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	
	//ok
	//@Test
	public void testAddPurchase() throws Exception{
		User user = new User();
		Product product = new Product();
		Purchase purchase = new Purchase();
		
		user.setUserId("user01");
		product.setProdNo(10020);
		purchase.setReceiverName("test01");
		purchase.setReceiverPhone("9090909");
		purchase.setDivyAddr("강남");
		purchase.setDivyRequest("문");
		
		
		System.out.println(purchase);
		purchase.setPurchaseProd(product);
		purchase.setBuyer(user);
		purchaseService.addPurchase(purchase);
		System.out.println("sql add 완료");
	}
	
	//ok
	//@Test
	public void testGetPurchase() throws Exception{
		Purchase purchase = new Purchase();
		
		purchase = purchaseService.findPurchase(10000);
		System.out.println(purchase);
		System.out.println("find 완료");
	}
	
	@Test
	public void testUpdatePurchase() throws Exception{
		Purchase purchase = purchaseService.findPurchase(10000);
		Assert.assertNotNull(purchase);
		
		Assert.assertEquals("test01", purchase.getBuyer());
	}
}
