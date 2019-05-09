public class JavaRuntimeInfo {
  public static void main(String[] args) throws InterruptedException {
    Runtime runtime = Runtime.getRuntime();

    int availableProcessors = runtime.availableProcessors();
    long maxMemory = runtime.maxMemory();

    System.out.format("availableProcessors: %d\n", availableProcessors);
    System.out.format("maxMemory: %d\n", maxMemory);

    Thread.sleep(60*1000);
  }
}
