import java.util.ArrayList;

public class ArraysRUs {
	
	public static void main(String[] args) {
		//Test cases
		int[] nums = new int [10];
		
		System.out.println("Making Arrays");
		System.out.println(nums[3]);
	
		printArray(nums);
		System.out.println();
		
		int[] vals = {1, 3, 4, 8, 2, 9};
		
		printArray(vals);
		System.out.println();
		
		vals[2] = 15;
		printArray(vals);
		System.out.println();
		System.out.println();
		
		System.out.println("Finding values in arrays");
		int x = 7;
		System.out.println("Is " + x + " in the array? " + containsArray(vals, x));
		int y = 2;
		System.out.println("Is " + y + " in the array? " + containsArray(vals, y));
		System.out.println();
		
		System.out.println("Array reversed");
		reverseArray(vals);
		printArray(vals);
		System.out.println();
		System.out.println();
		
		System.out.println("Sorting arrays");
		sortsArray(vals);
		printArray(vals);
		System.out.println();
		System.out.println();
		
		System.out.println("Fun with java.util.ArrayList");
		ArrayList<String> a = new ArrayList<String>();
		a.add("food");
		a.add("tree");
		a.add("wrong");
		a.add("true");
		System.out.println(a);
		a.add(2, "pie");
		System.out.println(a);
		a.set(3, "right");
		System.out.println(a);
		a.remove(0);
		System.out.println(a);
		System.out.println();
		
		System.out.println("Sorting arrays alphabetically");
		sort(a);
		System.out.println(a);
		System.out.println();
		
		System.out.println("Removing words ending with 'E'");
		removeWordsEndingWithE(a);
		System.out.println(a);
		System.out.println();
		
		ArrayList<Integer> n = new ArrayList<Integer>();
		
		System.out.println("Wrappings in Arrays");
		n.add(new Integer(7));
		n.add(19); // auto-boxing (automatically wraps primitive type up into an object so it can be in the array
		
		int z = 4 + n.get(1); // auto-unboxing unwraps the object into the primitive type in the array
		System.out.println(z);
	}
	/*
	 * prints the content of an array of int values on a single line using for-each
	 */
	public static void printArray(int[] a) {
		for(int value: a) {
			System.out.print(value + " ");
			/* 
			 * for-each loop = for(type varName: collection)
			 *no loop counter declaration necessary
			 */
		}
	}
	
	/*
	 * determines whether a given value is in the array
	 */
	public static boolean containsArray(int[] a, int value) {
		for(int num: a) {
			if(num == value)
				return true;
		}
		return false;
	}
	
	/*
	 * reverses the contents of the array
	 */
	public static void reverseArray(int[] a) {
		for(int i = 0; i < a.length / 2; i++) {
			int temp = a[i];
			a[i] = a[a.length - i - 1];
			a[a.length - i - 1] = temp;
		}
	}
	/*
	 * sorts array of int values in order of smallest to biggest
	 * using a Gnome sort
	 */
	public static void sortsArray(int[] a) {
		for(int i = 0; i < a.length; i++){
			for(int j = i + 1; j < a.length; j++){
				if(a[j] < a[i]){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	/*
	 * sorts an ArrayList in alphabetical order
	 */
	public static void sort(ArrayList<String> list) {
		for(int i = 0; i < list.size(); i++) {
			for(int j = i + 1; j < list.size(); j++) {
				if(list.get(j).compareTo(list.get(i)) < 0) {
					String temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}
	/*
	 * Removes all array values that end in a certain letter
	 */
	public static void removeWordsEndingWithE(ArrayList<String> list) {
		for(int i = list.size() - 1; i >= 0; i-- ) {
			String word = list.get(i);
			int lastLetter = word.length() - 1;
			if(word.charAt(lastLetter) == 'e') {
				list.remove(i);
				}
		}
	}
}
