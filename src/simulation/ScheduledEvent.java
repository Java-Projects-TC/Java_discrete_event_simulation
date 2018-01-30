package simulation;

public class ScheduledEvent implements Comparable<ScheduledEvent> {

  // Fields
  private Event event;
  private double time;

  // Constructor
  public ScheduledEvent(Event e, double t) {
    this.event = e;
    this.time = t;
  }

  // Methods
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
