package com.test.via;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass {
	@Parameters({ "URL" })
	@Test
	public void dummyfunction3(String Weburl) {
		System.out.println("Inside dummy fn3");
		System.out.println("Url is :" + Weburl);
	}

}
