package equinooxe.deployer;

/**
 *
 */
public class App {
	static String sourcesDirectory = AppConfig.getPropValue("folder.sources");
	static String distDirectory    = AppConfig.getPropValue("folder.dist");
	static String webDirectory     = AppConfig.getPropValue("folder.web");

	public static void main(String[] args) {
		System.out.println("... Start deploy ...\n");
		System.out.println("Source: " + sourcesDirectory);
		GitPullJob.pull();
		if(RSyncManager.generateExcludeFile()){
			System.out.println(" .. OK ..");
		}
		else {
			System.out.println("... ERROR.. Should start rollback");
		}
		DbManager.init();
	}
}
