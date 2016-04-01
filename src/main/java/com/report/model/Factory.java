package com.report.model;

import java.util.ArrayList;
import java.util.List;

/**
 * generate test data
 * @author Po Dang
 *
 */
public class Factory {
	static public List<TestModel> createBeanCollection() {

		List<TestModel> list = new ArrayList<TestModel>();

		TestModel a1 = new TestModel("Đặng Tấn Lộc", "08-12-2014",
				"Nam", "Biên Hòa","Kỹ Sư",
				"Kinh","Việt Nam", "123456789",
				"Abc");
		TestModel a2 = new TestModel("Đặng Tấn Lộc", "08-12-2014",
				"Nam", "Biên Hòa","Kỹ Sư",
				"Kinh","Việt Nam", "123456789",
				"Abc");
		TestModel a3 = new TestModel("Đặng Tấn Lộc", "08-12-2014",
				"Nam", "Biên Hòa","Kỹ Sư",
				"Kinh","Việt Nam", "123456789",
				"Abc");
		
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		return list;
	}

}
