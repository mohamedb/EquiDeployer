package equinooxe.deployer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandRunner {
   public static String run(String command, boolean souldRollbackOnError){
	   StringBuffer output = new StringBuffer();
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			if(souldRollbackOnError){
				System.out.println("... Error rolling back operation...");
			}
			e.printStackTrace();
		}

		System.out.println(">> " + output.toString() + " \n");

		return output.toString();
   }
}
