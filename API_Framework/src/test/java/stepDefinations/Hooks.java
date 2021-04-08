package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeDeletePlace() throws IOException {	

		if (StepDefinations.place_id == null) {
			
			StepDefinations sd = new StepDefinations();
			sd.add_place_payload("aditya", "English", "aaa");
			sd.when_user_calls_with_method("AddPlaceAPI", "POST");
			sd.response_is_success_with_code(200);
			sd.verify_is_added_using("place_id", "GetPlaceAPI", "aditya");
		}
	}

}
