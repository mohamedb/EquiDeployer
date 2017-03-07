package equinooxe.job;

import equinooxe.deployer.AppConfig;
import equinooxe.deployer.CommandRunner;

public class AsseticDumpJob implements Executable {

	@Override
	public String run() {
		String cmd= "php "+AppConfig.WEBSITE_FOLDER+"/app/console assetic:dump --env=prod --no-debug";
		return CommandRunner.run(cmd,false);
	}

	@Override
	public boolean shouldRollback() {
		return false;
	}
	
	 

}
