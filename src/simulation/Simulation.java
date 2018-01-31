package simulation;

import java.util.PriorityQueue;
import java.util.Queue;

public class Simulation {

  // Fields
  private double currentTime;
  private Queue<ScheduledEvent> diary = new PriorityQueue<>();

  // Constructor
  public Simulation() {}

  // Methods
  public double getCurrentTime() {
    return this.currentTime;
  }

  protected void setCurrentTime(double currentTime) {
    this.currentTime = currentTime;
  }

  protected boolean stop() {return false;}

  public void schedule(Event e, double offset) {
    this.diary.add(new ScheduledEvent(e,this.getCurrentTime() + offset));
  }

  protected void simulate() {
    while (!this.diary.isEmpty()) {
      ScheduledEvent event = this.diary.poll();
      this.setCurrentTime(event.getTime());
      if (!this.stop())
      event.getEvent().invoke(this);
    }
  }

}
