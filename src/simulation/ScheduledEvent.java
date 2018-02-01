package simulation;

public class ScheduledEvent<S> implements Comparable<ScheduledEvent> {


  private final Event event;
  private final double time;


  public ScheduledEvent(Event e, double t) {
    this.event = e;
    this.time = t;
  }


  double getTime() {
    return time;
  }

  public Event getEvent() {
    return event;
  }

  @Override
  public int compareTo(ScheduledEvent scheduledEvent) {
    return Double.compare(this.getTime(), scheduledEvent.getTime());
  }

}
