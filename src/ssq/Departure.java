package ssq;

import static ssq.SingleServerQueue.SERVICE_TIME;

import simulation.Event;
import simulation.Simulation;

public class Departure implements Event {

  @Override
  public void invoke(Simulation simulation) {
    SingleServerQueue ssq = (SingleServerQueue) simulation;
    ssq.decrQueueLength();
    System.out.println("Departure at " + ssq.getCurrentTime() + ", new "
        + "population = " + ssq.getQueueLength());
    if (ssq.getQueueLength() != 0) {
      ssq.schedule(new Departure(), SERVICE_TIME);
    }
  }
}
