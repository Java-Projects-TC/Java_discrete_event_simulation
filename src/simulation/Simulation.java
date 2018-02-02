package simulation;

import java.util.PriorityQueue;
import java.util.Queue;

public class Simulation<S> {


  private double currentTime;
  private Queue<ScheduledEvent<S>> diary = new PriorityQueue<>();


  protected S getState() {
    return null;
  }

  public double getCurrentTime() {
    return this.currentTime;
  }

  private void setCurrentTime(double currentTime) {
    this.currentTime = currentTime;
  }

  protected boolean stop() {
    return false;
  }

  public void schedule(Event<S> e, double offset) {
    this.diary.add(new ScheduledEvent<S>(e, this.getCurrentTime() + offset));
  }

  protected void simulate() {
    while (!this.diary.isEmpty()) {
      ScheduledEvent<S> event = this.diary.poll();
      this.setCurrentTime(event.getTime());
      if (!this.stop()) {
        event.getEvent().invoke(this.getState());
      }
    }
  }

}
