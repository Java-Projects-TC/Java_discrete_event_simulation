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
    return currentTime;
  }

  public void setCurrentTime(double currentTime) {
    this.currentTime = currentTime;
  }

  boolean stop() {return false;};

  protected void schedule(Event e, double offset) {
    diary.add(new ScheduledEvent(e, offset));
  }

  protected void simulate() {
    
      }
    }
  }

}
