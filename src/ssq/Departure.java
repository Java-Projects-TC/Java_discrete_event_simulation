package ssq;

import simulation.Event;
import simulation.Simulation;

public class Departure implements Event {

  private static final double SERVICE_TIME = 0.25;

  @Override
  public void invoke(Simulation simulation) {
    SingleServerQueue ssq = (SingleServerQueue) simulation;
    ssq.decrQueueLength();
    System.out.println("Departure at " + ssq.getCurrentTime() + ", new "
        + "population = " + ssq.getQueueLength());
    if (ssq.getQueueLength() == 0) {
      ssq.schedule(new Departure(), SERVICE_TIME);
    }
  }
}
