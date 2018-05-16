package com.dongk.test.io;

import java.net.MalformedURLException;

import org.junit.Test;
import org.springframework.core.io.UrlResource;

public class UrlResourceTest {
    
	@Test
	public void test() {
		try {
			UrlResource ur = new UrlResource("file:D:\\menuCode.xml");
			System.out.println(ur.getFilename());
			System.out.println(ur.getDescription());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
