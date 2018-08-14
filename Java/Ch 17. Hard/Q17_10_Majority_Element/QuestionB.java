package Q17_10_Majority_Element;

public class QuestionB {
	
	public static int getCandidate(int[] array) {
		int majority = 0;
		int count = 0;
		for (int n : array) {
			if (count == 0) {
				majority = n;
			}
			if (n == majority) {
				count++;
			} else {
				count--;
			}
			System.out.println(n + "\t" + majority + "\t" + count);

		}
		
		System.out.println(majority);

		return majority;
	}
	
	public static boolean validate(int[] array, int majority) {
		int count = 0;
		for (int n : array) {
			if (n == majority) {
				count++;
			} 
			System.out.println("v " + n + "\t" + count);

		}

		return count > array.length / 2;
	}

	public static int findMajorityElement(int[] array) {
		int candidate = getCandidate(array);
		
		return validate(array, candidate) ? candidate : -1;
	}
	
	public static void main(String[] args) {
		int[] array = {7, 1, 7, 1, 7, 3, 7, 3, 7, 1, 7};
		System.out.println(array.length);
		System.out.println(findMajorityElement(array));
	}

}
