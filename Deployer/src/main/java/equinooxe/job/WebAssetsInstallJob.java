package equinooxe.job;

import equinooxe.deployer.AppConfig;
import equinooxe.deployer.CommandRunner;

public class WebAssetsInstallJob implements Executable {

	@Override
	public String run() {
		String cmd= "php app/console assets:install"+AppConfig.WEBSITE_FOLDER+"/web";
		return CommandRunner.run(cmd,false);
	}

	@Override
	public boolean shouldRollback() {
		return false;
	}
	
	 

}
