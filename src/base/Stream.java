package base;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = Arrays.asList("my","new","list","new","new");
		names.stream().distinct().forEach(System.out::println);
		names.stream().filter(name->name.length()>=4).forEach(System.out::println);
//		System.out.println(names.stream().filter(name->name.length()>=4).count()==1);
		List<String> example = names.stream().filter(name->name.startsWith("ne")).collect(Collectors.toList());
		example.stream().forEach(System.out::println);
		System.out.println(names.stream().map(String::toUpperCase).sorted().collect(Collectors.joining(", ")));
		
		
		int[] arr; int divisor;
	}

}
