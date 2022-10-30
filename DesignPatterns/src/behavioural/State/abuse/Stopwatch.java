package behavioural.State.abuse;

public class Stopwatch {

	private State currState = new StoppedState(this);

	public void click() {
		currState.click();
	}

	public State getCurrState() {
		return currState;
	}

	public void setCurrState(State currState) {
		this.currState = currState;
	}

}
