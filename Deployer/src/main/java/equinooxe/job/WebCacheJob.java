package equinooxe.job;

import equinooxe.deployer.AppConfig;
import equinooxe.deployer.CommandRunner;

public class WebCacheJob implements Executable {

	@Override
	public String run() {
		String cmdRmCache = "rm -rf "+AppConfig.WEBSITE_FOLDER+"/app/cache/*";
		String cmdClear   = "php "+AppConfig.WEBSITE_FOLDER+"/app/console cache:clear --env=prod --no-debug";
		return CommandRunner.run(cmdRmCache,false)+ CommandRunner.run(cmdClear,false);
	}

	@Override
	public boolean shouldRollback() {
		return false;
	}
	
	 

}
