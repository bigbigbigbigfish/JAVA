package com.cao.four;

import java.io.*;

public class TestSerializable {
    public static void main(String[] args) {
        Person person = new Person("张三",22);
        Person person1 = new Person("李四",23);
        System.out.println("Person"+ person);
        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream)
        ){
            out.writeObject(person);
            out.flush();
            byteArrayOutputStream.toByteArray();
            //data对象变成的二进制流
             byte[] data = byteArrayOutputStream.toByteArray();
             try (  ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
                     ObjectInputStream in= new ObjectInputStream(byteArrayInputStream)) {
                 Object returnvalue =in.readObject();
                 System.out.println(returnvalue.getClass());
                 Person person2 =(Person) returnvalue;
                 System.out.println("Person2" + person2);
                 System.out.println(person1 == person2);
             } catch (ClassNotFoundException e) {
                 e.printStackTrace();
             }
        }catch (IOException e ){
            System.out.println(e);
        }
    }
}


/***
 * 一个类的实例化对象要能够进行实例化,必须实现Serializable 接口
 * 序列化oos
 * 反序列化ois
 */
class Person implements Serializable{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age + '}';
    }

}
