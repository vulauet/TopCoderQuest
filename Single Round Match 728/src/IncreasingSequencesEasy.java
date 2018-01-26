import java.util.*;

public class IncreasingSequencesEasy {

    static Map<Integer, Map<Integer, Integer>> valueCache;

    public int count(int[] L, int[] R) {
        valueCache = new HashMap<>();
        for (int i = 1; i < L.length; i++) {
            if (L[i] <= L[i - 1])
                L[i] = L[i - 1] + 1;
        }

        for (int i = R.length - 1; i > 0; i--) {
            if (R[i] <= R[i - 1])
                R[i - 1] = R[i] - 1;
        }
        return count(0, L, R);
    }

    private int count(int startIndex, int[] l, int[] r) {
        if (l.length - startIndex == 1) {
            int numLastChoice = r[startIndex] - l[startIndex];
            return numLastChoice < 0 ? 0 : numLastChoice + 1;
        }

        if (l[startIndex] == r[startIndex])
            return count(startIndex + 1, l, r);

        if (valueCache.containsKey(startIndex)) {
            if (valueCache.get(startIndex).containsKey(l[startIndex]))
                return valueCache.get(startIndex).get(l[startIndex]);
        } else valueCache.put(startIndex, new HashMap<>());

        if (l[startIndex] == l[startIndex + 1])
            for (int i = startIndex + 1; i < l.length; i++)
                l[i] = l[i] + 1;


        int count = l[startIndex + 1] <= r[startIndex] ?
                (l[startIndex + 1] - l[startIndex]) : (r[startIndex] - l[startIndex] + 1);

        int curStartVal = l[startIndex];
        int returnVal = count * count(startIndex + 1, l, r) ;
        if (r[startIndex] >= l[startIndex + 1]) {
            l[startIndex] += 1;
            returnVal += count(startIndex, l, r);
        }
        valueCache.get(startIndex).put(curStartVal, returnVal);
        return returnVal;
    }
}
