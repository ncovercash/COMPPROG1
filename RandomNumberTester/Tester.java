
public class Tester {
	public static void main(String [] args) {
		System.out.println("deez nuts");
		
		int[] list = new int[10];
		for (int i=0; i<list.length; i++) {
			list[i]=-1;
		}
		for (int i=0; i<list.length; i++) {
			System.out.print("{");
			for (int ii = 0; ii < list.length; ii++) {
				if (ii<list.length-1) {
					System.out.print(list[ii] + ", ");
				} else {
					System.out.print(list[ii]);
				}
			}
			System.out.println("}");
			list[i] = (int)(Math.random()*16); // [0,15)
			boolean iDown=false;
			if (i != 0) {
				for (int ii=0; ii<list.length; ii++) {
					if (list[i] == list[ii] && ii != i) {
						iDown=true;
					}
				}
			}
			if (iDown) {
				i--;
			}
		}
		System.out.println("RESULT:");
		System.out.print("{");
		for (int ii = 0; ii < list.length; ii++) {
			if (ii<list.length-1) {
				System.out.print(list[ii] + ", ");
			} else {
				System.out.print(list[ii]);
			}
		}
		System.out.println("}");
	}
}
