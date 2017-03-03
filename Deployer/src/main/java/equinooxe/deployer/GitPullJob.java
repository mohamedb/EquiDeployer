package equinooxe.deployer;

public class GitPullJob {
	static String repositoryUrl = AppConfig.getPropValue("git.repositoryUrl");
	static String command = "git -C "+App.sourcesDirectory+" pull";

	public static String pull() {
		System.out.println("\n ---- Start pulling from repo:" + repositoryUrl + "---\n");
		return CommandRunner.run(command, false);
	}
}
