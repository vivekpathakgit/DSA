import java.util.HashSet;
import java.util.Scanner;

//Node class
class Node{
	int val;
	Node next;
	Node(int n){
		val = n;
	}
}
public class nodeClassLL {
	//Reverse LL
	public static Node reverse(Node head) {
		Node p = null, q = head, r = head;
		while(q!=null) {
			r = q.next;
			q.next = p;
			p = q;
			q = r;
		}
		return p;
	}
	//Display LL
	public static void display(Node head) {
		Node curr = head;
		while(curr!=null) {
			System.out.print(curr.val+" ");
			curr = curr.next;
		}
		System.out.println();
	}
	//Size of LL
	public static int size(Node head) {
		int s = 0;
		Node curr = head;
		while(curr!=null) {
			s++;
			curr = curr.next;
		}
		return s;
	}
	//Sort LL (by swapping nodes)
	public static Node sort(Node head) {
		int size = size(head);
		Node newHead = head;
		while(size!=1) {
			Node p = newHead, q = p.next, prev = null;
			while(q!=null) {
				Node r = q.next;
				if(q.val<p.val) {
					q.next = p;
					p.next = r;
					if(prev==null) {
						prev = q;
						newHead = prev;
					}
					else {
						prev.next = q;
						prev = prev.next;
					}	
					q = r;
					
				}
				else {
					if(prev == null) {
						prev = p;
						newHead = prev;
					}
						
					else {
						prev.next = p;
						prev = prev.next;
					}
					p = q;
					q = r;	
				}
			}
			size--;
		}
		return newHead;
	}
	// Insert an Element in Sorted Linked List
	private static void insertSorted(Node head, int i) {
		// TODO Auto-generated method stub
		Node curr = head, prev = null;
		while(curr!=null) {
			if(curr.val>i) {
				if(prev!=null) {
					prev.next = new Node(i);
					prev.next.next = curr;
				}
				else {
					Node temp = new Node(i);
					temp.next = head;
					head = temp;
				}
				return;
			}
			prev = curr;
			curr = curr.next;
		}
		prev.next = new Node(i);
	}
	//Remove Duplicates
	private static void removeDuplicates(Node head) {
		// TODO Auto-generated method stub
		HashSet<Integer> set = new HashSet<>();
		Node curr = head, prev = null;
		while(curr!=null) {
			if(set.contains(curr.val)) {
				prev.next = curr.next;
				curr = curr.next;
			}
				
			else {
				set.add(curr.val);
				prev = curr;
				curr = curr.next;
			}
		}
	}
	//Insertion
	private static Node insertNode(Node head) {
		// TODO Auto-generated method stub
		Node curr = head;
		char c = 'y';
		while(c=='y') {
			System.out.println("Insert an Integer value : ");
			Scanner sc = new Scanner(System.in);
			if(head==null)
				head = curr = new Node(sc.nextInt());
			else {
				curr.next = new Node(sc.nextInt());
				curr = curr.next;
			}
			System.out.println("Do you want to insert more numbers? (y/n) ");
			c = sc.next().charAt(0);
		}
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = null;
		head = insertNode(head);
		display(head);
		head = reverse(head);
		display(head);
		head = sort(head);
		display(head);
		insertSorted(head, 7);
		display(head);
		removeDuplicates(head);
		display(head);
		
		//Sample Input
//		head = new Node(5);
//		head.next = new Node(5);
//		head.next.next = new Node(3);
//		head.next.next.next = new Node(3);
//		head.next.next.next.next = new Node(5);
//		head.next.next.next.next.next = new Node(7);
	}
}
