package com.lex.showcase.bean2xml;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class PersonConverter implements Converter {

	@Override
	public boolean canConvert(Class type) {
		return type.equals(Person.class);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		Person person = (Person) source;
		writer.startNode("fullname");
		writer.setValue(person.getName());
		writer.endNode();
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		Person p = new Person();
		reader.moveDown();
		p.setName(reader.getValue());
		return p;
	}

}
