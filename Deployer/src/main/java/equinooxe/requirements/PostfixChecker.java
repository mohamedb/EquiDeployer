package equinooxe.requirements;

import java.util.List;

/**
 * Check Postfix
 * 
 * @author mboullouz
 *
 */
public class PostfixChecker implements Checkable {
	static String IDENTIFIER="POSTFIX";
	@Override
	public boolean isInstalled() {
		/**
		 * Open expected {depending on the distribution} file and check its
		 * content
		 */
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
