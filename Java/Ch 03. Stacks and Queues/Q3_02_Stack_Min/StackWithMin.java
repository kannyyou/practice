package Q3_02_Stack_Min;

import java.util.Stack;
/**
 * Stack Min : How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum elements ? Push, pop and min should all operate in O(1) time.
 *
 * @author changhun
 *
 */
public class StackWithMin extends Stack<NodeWithMin> {
    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }
    
    public int min() {
    	if (this.isEmpty()) {
    		return Integer.MAX_VALUE;
    	} else {
    		return peek().min;
    	}
    }
}
