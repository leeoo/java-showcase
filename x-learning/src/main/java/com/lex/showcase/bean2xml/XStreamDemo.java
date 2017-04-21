package com.lex.showcase.bean2xml;

import com.thoughtworks.xstream.XStream;

public class XStreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PhoneNumber phone = new PhoneNumber();
		phone.setCode("021");
		phone.setNumber(10086);

		Person p = new Person();
		p.setName("Jack");
		p.setGender("Male");
		p.setAge(20);
		p.setMarried(true);
		p.setPhoneNumber(phone);
		
		XStream xs = new XStream();
		xs.autodetectAnnotations(true);
//		xs.setMarshallingStrategy(marshallingStrategy);
		String xml = xs.toXML(p);
		System.out.println(xml);
	}

}
