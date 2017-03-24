package equinooxe.requirements;

import java.util.ArrayList;
import java.util.List;

public class AppChecker {

	private List<Checkable> registred = new ArrayList<>();
	
	public AppChecker() {
		this.registred.add(new ApacheChecker());
	}

	public void register(Checkable element) {
		this.registred.add(element);
	}

	public List<Checkable> getRegistered() {
		return this.registred;

	}
}
