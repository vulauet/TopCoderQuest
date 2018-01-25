import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ManySquares {
	
	public int howManySquares(int[] sticks) {
		Map<Integer, Integer> lenthCount = new HashMap<>();
		for (int stick : sticks) {
			if (lenthCount.containsKey(stick)) {
				lenthCount.put(stick, lenthCount.get(stick) + 1);
			} else lenthCount.put(stick, 1);
		}

		int numSquare = 0;
		for (Integer count : lenthCount.values()) {
			numSquare += count / 4;
		}
		return numSquare;
	}
}
