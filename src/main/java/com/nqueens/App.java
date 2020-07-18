package com.nqueens;

import com.google.common.annotations.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String... args) {
        if (args.length != 1) {
            System.out.println("CLI util for n-queens problem solution.");
            System.out.println("Usage: <number-of-queens>");
            System.out.println("\t number-of-queens - integer representing number of queens to find positions for.");
            System.out.println("\t                    Chess board has the same dimensions size by problem definition.");
            return;
        }
        final String arg = args[0];
        int queensNumber;
        try {
            queensNumber = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            System.out.println("Can't parse '" + arg + "' as a number.");
            return;
        }
        if (queensNumber <= 0) {
            System.out.println("Must be a number >0.");
            return;
        }

        try {
            System.out.println(positionsToString(solve(queensNumber)));
        } catch (SolutionNotFoundException e) {
            System.out.println("No solution found.");
        }
    }

    @VisibleForTesting
    static List<Integer> solve(int queensNumber) throws SolutionNotFoundException {
        return new SquareBoardBackTracker().solve(queensNumber, QueenPredicate.createQueenPredicate());
    }

    @VisibleForTesting
    static String positionsToString(List<Integer> positions) {
        List<String> result = new ArrayList<>();
        int index = 0;
        for (Integer position : positions) {
            result.add(letterPositionToString(index) + numberPositionToString(position));
            index++;
        }
        return String.join(", ", result);
    }

    @VisibleForTesting
    static String numberPositionToString(int position) {
        return String.valueOf(position + 1);
    }

    /**
     * Solution copied from https://stackoverflow.com/a/41733499
     *
     * @param position - zero based position on the board.
     * @return number by base 26, denoted using latin letters a-z.
     */
    @VisibleForTesting
    static String letterPositionToString(int position) {
        char[] str = Integer.toString(position, 26).toCharArray();
        for (int i = 0; i < str.length; i++) {
            str[i] += str[i] > '9' ? 10 : 49;
        }
        return new String(str);
    }
}
