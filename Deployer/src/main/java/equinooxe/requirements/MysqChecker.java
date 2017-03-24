package equinooxe.requirements;

import java.util.List;

public class MysqChecker implements Checkable {
	static String IDENTIFIER="MYSQL";
	@Override
	public boolean isInstalled() {
		return false;
	}

	@Override
	public boolean isMinimalConfigurationOk() {
		return false;
	}

	@Override
	public boolean isRuning() {
		return false;
	}

	@Override
	public String getIdentifier() {
		return IDENTIFIER;
	}
	@Override
	public boolean isCompatibleWith(List<Checkable> elements) {
		return false;
	}
}
