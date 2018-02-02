package ssq;

import static ssq.SingleServerQueue.SERVICE_TIME;

import simulation.Event;

public class Departure implements Event<SingleServerQueue> {


  @Override
  public void invoke(SingleServerQueue ssq) {
    //SingleServerQueue ssq = (SingleServerQueue) simulation;
    ssq.decrQueueLength();
    ssq.incrServiced();
    System.out.println("Departure at " + ssq.getCurrentTime() + ", new "
        + "population = " + ssq.getQueueLength());
    if (ssq.getQueueLength() != 0) {
      ssq.schedule(new Departure(), SERVICE_TIME);
    }
  }
}
