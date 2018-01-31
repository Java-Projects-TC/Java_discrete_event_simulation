package ssq;

import simulation.Simulation;

public class SingleServerQueue extends Simulation {

  private final int queueLength;

  public SingleServerQueue(int queueLength) {
    this.queueLength = queueLength;
  }
}
