package log4j;

import java.util.Scanner;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.Test;

public class log4j {
	
	private static Logger log =  (Logger) LogManager.getLogger(log4j.class.getName());

	
	public static void main(String[] args) {
		
		log.debug("I am debugging");
		log.info("Info....");
		log.error("ERROR!!!");
		System.out.println(Integer.MAX_VALUE);
		
	}

}
