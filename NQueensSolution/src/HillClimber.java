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
                //System.out.println(" failed: "+neighbor.Cost+":"+current.Cost);
                return null;
            }
        }
        return current;//found it
    }
}

/*

 if (neighbor.Cost == current.Cost) {//run on that plateau
                current = neighbor;
                counter++;
            }
            if (counter == iterationNum || neighbor.Cost > current.Cost) {//iterative plateau running with local min cutoff
                System.out.println(iterationNum+" failed: "+neighbor.Cost+":"+current.Cost);
                return null;
            }

 */
