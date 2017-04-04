package com.lex.showcase.bean2xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class PersonConverterTest {

	public static void main(String[] args) {
		Person p = new Person();
		p.setName("Rose");
		
		XStream xs = new XStream(new DomDriver());
		xs.registerConverter(new PersonConverter());
		xs.alias("Person", Person.class);
		System.out.println(xs.toXML(p));
	}
}
