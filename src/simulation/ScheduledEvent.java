package simulation;

public class ScheduledEvent<S> implements Comparable<ScheduledEvent<S>> {


  private final Event<S> event;
  private final double time;


  ScheduledEvent(Event<S> e, double t) {
    this.event = e;
    this.time = t;
  }


  double getTime() {
    return this.time;
  }

  Event<S> getEvent() {
    return this.event;
  }

  @Override
  public int compareTo(ScheduledEvent<S> scheduledEvent) {
    return Double.compare(this.getTime(), scheduledEvent.getTime());
  }

}
