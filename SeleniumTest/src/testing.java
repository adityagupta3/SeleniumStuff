import org.testng.annotations.Test;

public class testing {
	
	@Test
	public void test() {
		String date = java.time.LocalDate.now().toString();

		System.out.println(date);
	}
}
