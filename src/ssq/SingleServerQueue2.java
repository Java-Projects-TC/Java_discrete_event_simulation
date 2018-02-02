package ssq;

public class SingleServerQueue2 extends SingleServerQueue {

  // Extension that takes the number of people to service as an argument for
  // the length of the simulation instead of the time limit.

  public SingleServerQueue2(long seed, double simLength) {
    super(seed, simLength);
  }


  @Override
  protected boolean stop() {
    return this.getServiced() >= this.getSimLength();
  }

  @Override
  protected SingleServerQueue2 getState() {
    return this;
  }

  public static void main(String[] args) {
    long seed = Long.parseLong(args[0]);
    double timeLimit = Double.parseDouble(args[1]);
    SingleServerQueue2 s = new SingleServerQueue2(seed, timeLimit);
    s.schedule(new Arrival(), s.getInterArrivalTime());
    s.simulate();
    s.meanPop += s.getQueueLength() * (s.getSimLength() - s
        .prevTime);
    System.out.println("SIMULATION COMPLETE - the mean queue length was " + s
        .getMeanQueueLength());
  }


}
