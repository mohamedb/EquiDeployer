package equinooxe.job;

import equinooxe.deployer.AppConfig;
import equinooxe.deployer.CommandRunner;

public class RSyncronizeJob implements Executable {

	@Override
	public String run() {
		System.out.println("...Syncronizing sources with WebSiteFolder...");
		return CommandRunner.run(getCommand(), shouldRollback());
	}

	@Override
	public boolean shouldRollback() {
		return false;
	}
	
	public String getCommand(){
		String cmd ="rsync -rlptgoD --stats --delete --ignore-errors --force --exclude-from=\""+AppConfig.RSYNC_EXCLUDE_FILE_PATH+"\""
				+ AppConfig.SOURCES_FOLDER+"/"+ AppConfig.WEBSITE_FOLDER+"/";
		return cmd;
	}

}
