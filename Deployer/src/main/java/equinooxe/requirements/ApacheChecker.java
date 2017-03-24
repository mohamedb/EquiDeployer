package equinooxe.requirements;

import java.util.ArrayList;
import java.util.List;

public class ApacheChecker implements Checkable {
	static String IDENTIFIER="APACHE";
	
	public String getVersion(){
		return "2.0";
	}
	
	public List<Compatibility> getCompatibilityList() {
		List<Compatibility> list = new ArrayList<>();
		list.add(new Compatibility(new PostfixChecker(), "0.0") );
		return list;
	}
	
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
