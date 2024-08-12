package com.webApp;

import org.junit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebAppApplicationTests {
	@Autowired
	WebAppController wpc;
	
	
	@Test
	public void get1() {
		assertEquals(wpc.getHello(),"Hi");
	}
	
	@Test
	public void contextLoads() {
		assertNotNull(wpc.getHello());
	}
	
	

}
