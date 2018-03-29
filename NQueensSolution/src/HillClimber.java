class HillClimber {
    private State startState;

    HillClimber(State start) {
        startState = start;
    }

    State climb() {
        State current = startState;
        State neighbor;
        while (current.Cost > 0) {
            neighbor = current.getNext();
            if (neighbor.Cost < current.Cost) {//made cost public for speed
                current = neighbor;
            } else {
                return null;
            }
        }
        return current;//found it
    }
}

