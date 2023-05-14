import java.util.LinkedList;
import java.util.Scanner;

public class collectionFrameworkLL {
	public static void reverse(LinkedList<Integer> l) {
		int size = l.size();
		for(int i = size-1; i>=0; i--) {
			l.add(l.get(i));
			l.remove(i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> l1 = new LinkedList<>();
		l1.add(2);
		l1.add(3);
		l1.add(5);
		char c = 'y';
		while(c=='y') {
			System.out.println("Insert Index and a Integer value : ");
			Scanner sc = new Scanner(System.in);
			int indx = sc.nextInt();
			if(indx>=l1.size())
				l1.add(sc.nextInt());
			else 
				l1.add(indx, sc.nextInt());
			System.out.println("Do you want to insert more numbers? (y/n) ");
			c = sc.next().charAt(0);
		}
		System.out.println(l1);
		reverse(l1);
		System.out.println(l1);
	}

}
