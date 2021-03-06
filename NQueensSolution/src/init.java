
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class init {

    public static void main(String[] args) {//my java has become slightly better
        Integer NSize = 8;//to appease the compiler
        if (args.length < 1) {
            System.out.println("Requires argument for board size: (Integer)");
            System.exit(23);
        } else {
            NSize = Integer.parseInt(args[0]);
        }
        HillClimber HC = new HillClimber(randomState(NSize));
        State result;
        while (true) {
            result = HC.climb();
            if (result == null) {
                HC = new HillClimber(randomState(NSize));
            } else {
                break;
            }
        }
        result.print();
    }

    private static State randomState(Integer size) {
        ArrayList<Integer> current = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, size);//stackoverflow
            current.add(randomNum);
        }
        return new State(size, current);
    }
}
