package equinooxe.job;

import equinooxe.deployer.AppConfig;
import equinooxe.deployer.CommandRunner;

public class ApachePostDeployJob implements Executable {

	@Override
	public String run() {
		String changePermssionsCmd = "chown -Rf www-data:www-data "+AppConfig.WEBSITE_FOLDER+"";
		String apacheRestartCmd    = "service apache2 restart";
		return CommandRunner.run(changePermssionsCmd,false)+ CommandRunner.run(apacheRestartCmd,false);
	}

	@Override
	public boolean shouldRollback() {
		return false;
	}
	
	 

}
