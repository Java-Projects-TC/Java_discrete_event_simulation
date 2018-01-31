package ssq;

import java.util.Random;
import simulation.Simulation;

public class SingleServerQueue extends Simulation {

  private int queueLength = 0;
  private final double timeLimit;
  private static Random interArrGen;


  public SingleServerQueue(long seed, double timeLimit) {
    this.interArrGen = new Random(seed);
    this.timeLimit = timeLimit;
  }

  @Override
  protected boolean stop() {
    return this.getCurrentTime() >= this.timeLimit;
  }

  static double getInterArrivalTime() {
    return interArrGen.nextDouble();
  }

  int getQueueLength() {
    return this.queueLength;
  }

  void incrQueueLength() {
    this.queueLength++;
  }

  void decrQueueLength() {
    this.queueLength--;
  }


  public static void main(String[] args) {
    long seed = Long.parseLong(args[0]);
    double timeLimit = Double.parseDouble(args[1]);
    SingleServerQueue s = new SingleServerQueue(seed, timeLimit);
    s.schedule(new Arrival(), getInterArrivalTime());
    s.simulate();
  }
}
