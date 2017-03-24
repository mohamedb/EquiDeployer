package equinooxe.requirements;

import java.util.List;

/**
 * 
 * @author mboullouz
 *
 */
public interface Checkable {
	
	String getIdentifier();
	
	boolean isInstalled();

	boolean isMinimalConfigurationOk();

	boolean isRuning();
	
	boolean isCompatibleWith(List<Checkable> elements);
}
