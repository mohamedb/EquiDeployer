package equinooxe.deployer;

import equinooxe.job.DatabaseSchemaUpdateJob;
import equinooxe.job.GitPullJob;
import equinooxe.job.MySqlExporterJob;
import equinooxe.job.RSyncronizeJob;

/**
 *
 */
public class App {
	

	public static void main(String[] args) {
		System.out.println("... Start deploy ...\n");
		GitPullJob gitJob = new GitPullJob();
		gitJob.run();
		new MySqlExporterJob().run();
	    RSyncManager.generateExcludeFile(); 
	    new RSyncronizeJob().run();
	    new DatabaseSchemaUpdateJob();
		 
		DbManager.init();
	}
}
