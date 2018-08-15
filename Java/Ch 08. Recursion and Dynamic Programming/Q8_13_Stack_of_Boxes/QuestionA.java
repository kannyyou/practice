package Q8_13_Stack_of_Boxes;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Stack of Boxes : You have a stack of n boxes, with widths w, heights h and depths d.
 * The boxes cannot be rotated and can only be stacked on top of one another 
 * if each box in the stack is strictly larger than the box above it in width, height and depth.
 * Implement a method to compute the height of the tallest possible stack. 
 * The height of a stack is the sum of the heights of each box.
 * 
 * 
 * @author changhun
 *
 */
public class QuestionA {	
	public static int createStack(ArrayList<Box> boxes) {
		Collections.sort(boxes, new BoxComparator());
		int maxHeight = 0;
		for (int i = 0; i < boxes.size(); i++) {
			int height = createStack(boxes, i);
			maxHeight = Math.max(maxHeight, height);
		}
		return maxHeight;
	}
	
	public static int createStack(ArrayList<Box> boxes, int bottomIndex) {
		Box bottom = boxes.get(bottomIndex);
		int maxHeight = 0;
		for (int i = bottomIndex + 1; i < boxes.size(); i++) {
			if (boxes.get(i).canBeAbove(bottom)) {
				int height = createStack(boxes, i);
				maxHeight = Math.max(height, maxHeight);
			}
		}		
		maxHeight += bottom.height;
		return maxHeight;
	}
		
	
	public static void main(String[] args) {
		Box[] boxList = { new Box(6, 4, 4), new Box(8, 6, 2), new Box(5, 3, 3), new Box(7, 8, 3), new Box(4, 2, 2), new Box(9, 7, 3)};
		ArrayList<Box> boxes = new ArrayList<Box>();
		for (Box b : boxList) {
			boxes.add(b);
		}
		
		int height = createStack(boxes);
		System.out.println(height);
	}

}
