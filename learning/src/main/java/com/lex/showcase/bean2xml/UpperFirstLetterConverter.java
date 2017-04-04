package com.lex.showcase.bean2xml;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

public class UpperFirstLetterConverter extends ReflectionConverter {
	
//	private ReflectionConverter converter = new ReflectionConverter();

	public UpperFirstLetterConverter(Mapper mapper, ReflectionProvider reflectionProvider) {
		super(mapper, reflectionProvider);
	}


	@Override
	public boolean canConvert(Class type) {
		return super.canConvert(type);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		super.marshal(source, writer, context);
		System.out.println(writer.toString()); // TODO
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		Person p = new Person();
		reader.moveDown();
		p.setName(reader.getValue());
		return p;
	}

}
