class HillClimber {
    private State startState;
    private int iterationNum;

    HillClimber(State start, int iteration) {
        startState = start;
        iterationNum = iteration;
    }

    State climb() {
        State current = startState;
        State neighbor;
        int counter = 0;
        while (current.Cost > 0) {
            neighbor = current.getNext();
            if (neighbor.Cost < current.Cost) {//made cost public for speed
                current = neighbor;
            } else if (neighbor.Cost == current.Cost) {//run on that plateau
                current = neighbor;
                counter++;
            }
            if (counter == iterationNum || neighbor.Cost > current.Cost) {//iterative plateau running with local min cutoff
                return null;
            }
        }
        return current;//found it
    }
}
