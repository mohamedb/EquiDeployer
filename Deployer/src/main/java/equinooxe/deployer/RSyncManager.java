package equinooxe.deployer;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

public class RSyncManager {

	public static boolean generateExcludeFile() {
		boolean success=false;
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(AppConfig.RSYNC_EXCLUDE_FILE_PATH), "utf-8"));
			for (String fileToIgnore : filesToIgnore()) {
				writer.write(fileToIgnore);
				writer.write("\n");
			}
			success=true;
			System.out.println("... RSync exclude file generated with success ...\n");
		} catch (IOException ex) {
			System.out.println("Error generating exlude file for Rsync "+ ex.getMessage());
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				System.out.println("Unable to close the file!"+  ex.getMessage());
			}
		}

		return success;
	}

	public static List<String> filesToIgnore() {
		String files = AppConfig.getPropValue("files.ignore");
		return Arrays.asList(files.split(","));
	}
}
