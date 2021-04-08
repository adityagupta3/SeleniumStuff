package XRAY;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		String XrayID = args[0];
//		String XrayID = "XRAY-3412";

		XrayMain xray = new XrayMain();

		ArrayList<String> tcIDs = xray.fetchXRAYids(XrayID);

		xray.fetchTestSteps(tcIDs);

		xray.createHTML();

	}
}
