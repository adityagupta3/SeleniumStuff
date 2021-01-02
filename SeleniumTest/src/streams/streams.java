package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class streams {
	
	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>();
		
		names = Arrays.asList("Hello", "World!", "How", "Are", "You");
		
		
		// -> is lambda operator where s is the parameter and rest is expression
		names.stream().filter(s->s.contains("u")).forEach(s->System.out.println(s));
	}

}
