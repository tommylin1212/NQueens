import java.util.ArrayList;
import java.util.Arrays;

class State extends ArrayList<Integer> {
    int Cost;
    private int NSize;

    State(Integer size, ArrayList<Integer> start) {//public constructor SLOWER used once
        this.addAll(start);
        NSize = size;
        Cost = getCheapCost(this.toArray(new Integer[0]));
    }

    private State(Integer size, Integer[] start, int cost) {//private constructor fast used constantly
        this.addAll(new ArrayList<>(Arrays.asList(start)));
        NSize = size;
        Cost = cost;
    }

    private int getCheapCost(Integer[] integers) {//faster called when checking new possible states
        int Cost = 0;
        int offset;
        for (int row = 0; row < NSize; row++) {
            for (int column = row + 1; column < NSize; column++) {
                if (integers[row].equals(integers[column])) {
                    Cost++;//same row
                }
                offset = column - row;
                if ((integers[row] == (integers[column] - offset)) || (integers[row] == (integers[column] + offset))) {
                    Cost++;//diagonals
                }
            }
        }
        return Cost;
    }

    State getNext() {//avoids constructing unnecessary State objects
        Integer best[] = this.toArray(new Integer[0]);
        Integer temp[];
        int bestCost = getCheapCost(best);
        int tempCost;
        for (int i = 0; i < NSize; i++) {//col
            for (int j = 0; j < NSize; j++) {//row
                temp = this.toArray(new Integer[0]);//convert to simple array for SPEEEEED
                temp[i] = temp[i] + j % NSize;//cycle through available rows
                tempCost = getCheapCost(temp);
                if (tempCost < bestCost) {
                    best = temp;
                    bestCost = tempCost;
                }
            }
        }
        return new State(NSize, best, bestCost);
    }


    void print() {
        for (int i = 0; i < NSize; i++) {//row
            System.out.print('\n');
            for (int j = 0; j < NSize; j++) {//col
                if (this.get(j) == i) {
                    System.out.print(" Q ");//Queen
                } else {
                    System.out.print(" X ");//Not Queen
                }
            }
        }
        System.out.print('\n');
    }

}
