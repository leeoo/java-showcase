package com.lex.showcase.language_feature.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 利用对象字节流将对象序列化再反序列化实现对象深度克隆。
 * 注：1. 对象类及其成员属性对应类型均必须实现java.io.Serializable接口。
 * 2. 对象类及其成员属性对应类型的transient成员和静态成员属性不会被。
 *
 * @author Lex Li
 */
public class DeepCloneViaStream<T> {

    public static <T> T deepCopy(T obj) throws IOException, ClassNotFoundException {
        // Step 1. 通过输出流将对象序列化成字节数组写入内存
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);

        // Step 2. 通过输入流从内存中读取该字节数组反序列化即可得到深克隆的对象
        InputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();
    }

    public static <T> T shallowCopy(T obj) throws IOException, ClassNotFoundException {
        // TODO
        return null;
    }

    public static <T> T clone(T obj, boolean deep) throws IOException, ClassNotFoundException {
        if (obj == null) {
            return null;
        }
        if (deep) {
            return deepCopy(obj);
        } else {
            return shallowCopy(obj);
        }
    }

    public static void main(String[] args) {
        User user = new User(1L, "Tom", "Male", 18);
        Role role = new Role(1L, "administrator", "Administrator role to manage all users.");
        user.setRole(role);
        System.out.println("Origin user -> " + user);

        try {
            User clonedUser = clone(user, true);

            System.out.println("Cloned user -> " + clonedUser);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
