package equinooxe.requirements;

import java.util.List;

public class LanguageChecker implements Checkable {
	static String IDENTIFIER="LANGUAGE";
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
