package equinooxe.job;

public interface Executable {
   String run();
   boolean shouldRollback();
}
