package behavioural.State.abuse;

public class RunningState implements State {

	private Stopwatch stopwatch;

	public RunningState(Stopwatch stopwatch) {
		this.stopwatch = stopwatch;
	}

	@Override
	public void click() {
		stopwatch.setCurrState(new StoppedState(stopwatch));
		System.out.println("Stopped");
	}

}
