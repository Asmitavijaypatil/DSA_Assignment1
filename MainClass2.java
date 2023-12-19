
class Node <T> {
    T data;
    Node next;

    Node(T data) {
        this.data = data;
    }
    Node(Node next) {
        this.next = next;
    }
     void setNext(Node t)
    {
        next = t;
    }
    T getData() {
        return data;
    }
    Node getNext() {
        return next;
    }
    public String toString() {
        return data +" ";
    }
}
class LinkedList <T> {
    Node head;
    void add(T x) {
        Node newnode = new Node(x);

        if(head == null) {
           head = newnode;
        } else {
            Node currentNode = head;
            while(currentNode.getNext() != null) {
               currentNode = currentNode.getNext();
            }
            currentNode.setNext(newnode);
        }
    }
    public int max() {
        Node <Integer> p = head;
        int max = 0;
        max = p.getData();
        while(p != null) {
            if(p.getData() > max) {
                max = p.getData();
            }
            p = p.getNext();
        }
        return max;
    }
    boolean delete(T d) {
		Node p = head, prev =null;
		while(p!=null) {
			if(d.equals(p.getData())) 
				break;
				
				prev=p;
				p= p.getNext();			
			}
		if(p == null)
			return false;	
	    if(prev == null)
	    	head = p.getNext();
	    else
	    	prev.setNext(p.getNext());
	    return true;
	}
    public void AddBeg(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    public int count() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    public void insertAt(int value, int position) {
        Node newNode = new Node(value);

        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.next;
            }

            if (current != null) {
                newNode.next = current.next;
                current.next = newNode;
            } else {
                System.out.println("Invalid position for insertion: " + position);
            }
        }
    }
     public void deleteAt(int position) {
        if (position == 1) {
            if (head != null) {
                head = head.next;
            } else {
                System.out.println("Cannot delete from an empty list.");
            }
        } else {
            Node current = head;
            Node prev = null;

            for (int i = 1; i < position && current != null; i++) {
                prev = current;
                current = current.next;
            }
            if (current != null) {
                prev.next = current.next;
            } else {
                System.out.println("Invalid index for deletion: " + position);
            }
        }
    }
    public void insertOrder(T data) {
		Node<T> newNode = new Node<>(data);
		if (head == null || (((Integer) head.data).compareTo((Integer) data) > 0)) {
			newNode.next = head;
			head = newNode;
			return;
		}
		Node<T> current = head;
		while (current.next != null && (((Integer) current.next.data).compareTo((Integer) data) < 0)) {
			current = current.next;
		}
		newNode.next = current.next;
		current.next = newNode;
	}
    public String toString() {
        String s = " ";
        Node currentNode = head;
        while(currentNode != null) {
            s = s + currentNode.getData() + " ";
            currentNode = currentNode.getNext();
        }
        return s;
    }
}
public class MainClass2 {
    public static void main(String[] args) {
        LinkedList<Integer> l =new LinkedList<>(); 
        l.add(10);
        l.add(20);
        l.add(50);
        l.add(30);
        l.add(40);
        System.out.println("Elements In LinkedList: ");
        System.out.println(l);
        int m = l.max();
        System.out.println("Maximum Element: ");
        System.out.println(m);
        l.delete(50);
        System.out.println("After deleting max element: "+l);
        l.delete(10);
        System.out.println("After deleting 10: "+l);
        l.AddBeg(15);
        System.out.println("After ading 1st element: "+l);
        l.AddBeg(5);
        System.out.println("After ading 1st element as 5: "+l);
        System.out.println("No of nodes "+l.count());
        l.insertAt(25,4);
        System.out.println("Inserted Element: "+l);
        l.insertAt(2,1);
        System.out.println("Inserted Element: "+l);
        l.deleteAt(1);
        System.out.println("After deleting Element: "+l);
        l.insertOrder(27);
        System.out.println("Inserted Element 27: "+l);
        l.insertOrder(35);
        System.out.println("Inserted Element 35: "+l);
        l.insertOrder(3);
        System.out.println("Inserted Element 3: "+l);

    }
}