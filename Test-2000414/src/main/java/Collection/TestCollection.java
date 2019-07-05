package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCollection {
    public static void code1() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"java","c++","python");
        list.forEach(System.out::println);
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"1,java","2,python","3,c++","4,java-script","5,php","6,tomcat");
        Stream<String> stream = list.stream();
        List<String > resultList =stream.skip(0).limit(3).map((s)->s.toUpperCase()).collect(Collectors.toList());
        System.out.println(resultList);
    }
}
