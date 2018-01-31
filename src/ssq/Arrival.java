package ssq;

import simulation.Event;
import simulation.Simulation;

public class Arrival implements Event{

  private static final double SERVICE_TIME = 0.25;

  @Override
  public void invoke(Simulation simulation) {
    SingleServerQueue ssq = (SingleServerQueue) simulation;
    ssq.incrQueueLength();
    System.out.println("Arrival at " + ssq.getCurrentTime() + ", new "
        + "population = " + ssq.getQueueLength());
    ssq.schedule(new Arrival(), ssq.getInterArrivalTime());
    if (ssq.getQueueLength() == 1) {
      ssq.schedule(new Departure(), SERVICE_TIME);
    }
  }
}
