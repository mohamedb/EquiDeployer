package equinooxe.job;

import equinooxe.deployer.AppConfig;
import equinooxe.deployer.CommandRunner;

public class DatabaseSchemaUpdateJob implements Executable {

	@Override
	public String run() {
		System.out.println("..Updating schema..");
		return CommandRunner.run(getCommand(), shouldRollback());
	}

	@Override
	public boolean shouldRollback() {
		return false;
	}
	
	public String getCommand() {
		String cmd = "php "+AppConfig.WEBSITE_FOLDER+"/app/console doctrine:schema:update --force"; 
		return cmd;
	}

}
