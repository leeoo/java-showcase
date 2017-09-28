package com.lex.showcase.serialization.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 1 minute tutorial: POJOs to JSON and back
 * See https://github.com/FasterXML/jackson-databind
 * @author Lex Li
 */
public class JacksonDemo {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse

//        MyValue value = mapper.readValue(new File("data.json"), MyValue.class);
// or:
//        value = mapper.readValue(new URL("http://some.com/api/entry.json"), MyValue.class);
// or:
//        value = mapper.readValue("{\"name\":\"Bob\", \"age\":13}", MyValue.class);

        try {
            MyValue value = mapper.readValue("{\"name\":\"Bob\", \"age\":13}", MyValue.class);
            System.out.println("Deserialize - JSON to object: " + value);

            String json = mapper.writeValueAsString(value);
            System.out.println("Deserialize - Object to JSON: " + json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MyValue foo = new MyValue();
        foo.setName("Tom");
        foo.setAge(20);

        MyValue bar = new MyValue();
        bar.setName("Jay");
        bar.setAge(18);

        String json = JsonUtil.toJSON(foo);
        System.out.println("json: " + json);

        MyValue parsedObj = JsonUtil.parseObject(json, MyValue.class);
        System.out.println("object: " + parsedObj);

        List<MyValue> list = new ArrayList<>();
        list.add(foo);
        list.add(bar);

        String jsonFromList = JsonUtil.toJSON(list);
        System.out.println("Object list to json: " + jsonFromList);

        List<MyValue> values = JsonUtil.parseObject(jsonFromList, new TypeReference<List<MyValue>>(){});
        System.out.println("Json to object list: " + values);

    }
}
