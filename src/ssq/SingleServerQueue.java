package ssq;

import java.util.Random;
import simulation.Simulation;

public class SingleServerQueue extends Simulation<SingleServerQueue> {


  private int queueLength = 0;
  private final double simLength;
  private Random interArrGen;
  double meanPop;
  double prevTime;
  static final double SERVICE_TIME = 0.25;
  private int serviced;


  public SingleServerQueue(long seed, double simLength) {
    this.interArrGen = new Random(seed);
    this.simLength = simLength;
  }


  @Override
  protected boolean stop() {
    return this.getCurrentTime() >= this.simLength;
  }

  @Override
  protected SingleServerQueue getState() {
    return this;
  }

  void incrServiced() {
    this.serviced++;
  }

  int getServiced() {
    return this.serviced;
  }

  double getSimLength() {
    return this.simLength;
  }

  double getInterArrivalTime() {
    return interArrGen.nextDouble();
  }

  int getQueueLength() {
    return this.queueLength;
  }

  void incrQueueLength() {
    this.meanPop += this.getQueueLength() * (this.getCurrentTime() - this
        .prevTime);
    this.prevTime = this.getCurrentTime();
    this.queueLength++;
  }

  void decrQueueLength() {
    this.meanPop += this.getQueueLength() * (this.getCurrentTime() - this
        .prevTime);
    this.prevTime = this.getCurrentTime();
    this.queueLength--;
  }

  double getMeanQueueLength() {
    return this.meanPop / this.getSimLength();
  }


  public static void main(String[] args) {
    long seed = Long.parseLong(args[0]);
    double timeLimit = Double.parseDouble(args[1]);
    SingleServerQueue s = new SingleServerQueue(seed, timeLimit);
    s.schedule(new Arrival(), s.getInterArrivalTime());
    s.simulate();
    s.meanPop += s.getQueueLength() * (s.getSimLength() - s
        .prevTime);
    System.out.println("SIMULATION COMPLETE - the mean queue length was " + s
        .getMeanQueueLength());
  }


}
