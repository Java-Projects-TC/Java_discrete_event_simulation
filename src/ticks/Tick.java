package ticks;

import simulation.Event;
import simulation.Simulation;

public class Tick implements Event{

  @Override
  public void invoke(Simulation simulation) {
    System.out.println("Tick at: " + simulation.getCurrentTime());
    simulation.schedule(new Tick(), 1);
  }
}
