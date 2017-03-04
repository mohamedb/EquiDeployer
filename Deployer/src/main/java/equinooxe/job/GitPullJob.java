package equinooxe.job;

import equinooxe.deployer.AppConfig;
import equinooxe.deployer.CommandRunner;

public class GitPullJob implements Executable {
	
	static String command = "git -C "+AppConfig.SOURCES_FOLDER+" pull";
	
	@Override
	public String run() {
		System.out.println("\n ---- Start pulling from repo:" + AppConfig.GIT_REPO_URL + "---\n");
		return CommandRunner.run(command, shouldRollback());
	}
 

	@Override
	public boolean shouldRollback() {
		return true;
	}
}
