package equinooxe.requirements;

public class Compatibility {
	private Checkable target;
	private String minimalVersion = "0.0";
	
	public Compatibility(Checkable target, String minVersion){
		this.target= target;
		this.minimalVersion= minVersion;
	}
	
	public Checkable getTarget() {
		return target;
	}

	public void setTarget(Checkable target) {
		this.target = target;
	}

	public void setMinimalVersion(String minimalVersion) {
		this.minimalVersion = minimalVersion;
	}
	
}
