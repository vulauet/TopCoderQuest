import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class HalvingEasy {

	public int count(int[] S, int T) {
		int count = 0;
		for (int num : S) {
			while (num > T) {
				num = num / 2;
			}
			if (num == T) ++count;
 		}
		return count;
	}
}
