package equinooxe.deployer;

import equinooxe.job.GitPullJob;

/**
 *
 */
public class App {
	

	public static void main(String[] args) {
		System.out.println("... Start deploy ...\n");
		System.out.println("Source: " + AppConfig.SOURCES_FOLDER);
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
