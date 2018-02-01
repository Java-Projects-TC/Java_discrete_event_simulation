package ticks;

import simulation.Simulation;

public class Ticks extends Simulation<Ticks> {

  private final double timeLimit;

  public Ticks(double timeLimit) {
    this.timeLimit = timeLimit;
  }


  @Override
  protected Ticks getState() { return this; }

  @Override
  protected boolean stop() {
    return this.getCurrentTime() >= this.timeLimit;
  }


  public static void main(String[] args) {

    double timeLimit = Double.parseDouble(args[0]);

    Ticks t = new Ticks(timeLimit);
    t.schedule(new Tick(), 1);
    t.simulate();
  }

}