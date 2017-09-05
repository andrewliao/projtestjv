class FixedQueue implements ICharQ {
	private char q[]; //this array holds the queue
	private int putloc, getloc; //the put and get indices

	//construct an emput queue given the size
	public FixedQueue(int size) {
		q = new char[size]; // allocate memory for queue
		putloc = getloc = 0;
	}

	//put characer into the queue
	public void put(char ch) {
		if(putloc == q.length) {
			System.out.println(" - Queue is full.");
			return;
		}

		q[putloc++] = ch;
	}

	//get character form the queu
	public char get() {
		if(putloc == getloc) {
			System.out.println("Queue is empty.");
			return (char) 0;
		}

		return q[getloc++];
	}
		
}

//circular queue
class CircularQueue implements ICharQ {
	private char q[]; //this array holds the queue
	private int putloc, getloc; //the put and get indices

	//construct an empty queue given its size
	public CircularQueue(int size) {
		q = new char[size + 1]; //allocate memory for queue
		putloc = getloc = 0;
	}

	//put a character into the queue
	public void put(char ch) {
		/* Queue is full if either the putloc is one less than the getloc, or 
		if putloc is at the end of the array and getloc is at the beginning */

		if((putloc + 1 == getloc) || ((putloc == q.length) && (getloc == 0)) ) {
			System.out.println(" - Queue is full.");
			return;
		}

		q[putloc++] = ch;
		if (putloc == q.length) putloc = 0; //loop back


	}

	public char get() {
		if(getloc == putloc) {
			System.out.println(" - Queue is empty");
			return (char) 0;
		}

		char ch = q[getloc++];
		if(getloc == q.length) getloc = 0; //loop back
		return ch;
	}
}


class DynQueue implements ICharQ {
	private char q[];
	private int putloc, getloc;

	public DynQueue(int size) {
		q = new char[size];
		putloc = getloc = 0;
	}

	public void put(char ch) {
		//increase the queue size if it is already full
		if(putloc == getloc) {
			char t[] = new char[q.length * 2];

			//copy the elements into the new queue
			for (int i = 0; i < q.length; i++) {
				t[i] = q[i];
			}

			q = t;
		}
		q[putloc++] = ch;

	}

	//get a character from the queue
	public char get() {
		if(getloc == putloc) {
			System.out.println(" - Queue is empty.");
			return (char) 0;
		}

		return q[getloc++];
	}
}

class IQDemo {
	public static void main(String[] args) {
		FixedQueue q1 = new FixedQueue(10);
		DynQueue q2 = new DynQueue(5);
		CircularQueue q3 = new CircularQueue(10);

		ICharQ iQ;

		char ch;

		iQ = q1;
		//put some characters into fixed queue
		for (int i = 0; i < 10; i++) {
			iQ.put((char) ('A' +  i));
		}

		//show the queue
		System.out.println("Contents of fixed queue");

		for(int i = 0; i < 10; i++) {
			ch = iQ.get();
			System.out.print(ch);
		}
		System.out.println();

		iQ = q2;
		//put some characters into dynamic queue
		for(int i = 0; i < 10; i++) {
			iQ.put((char) ('Z' - i));
		}

		//show the queue
		System.out.print("Contents of dynamic queue: ");
		for(int i = 0; i < 10; i++) {
			ch = iQ.get();
			System.out.print(ch);
		}
		System.out.println();

		iQ = q3;
		//put some characters into circular queue
		for(int i = 0; i < 10; i++) {
			iQ.put((char) ('A' + i));
		}

		//show the queue
		System.out.println("Contents of circular queue: ");
		for (int i = 0; i < 10; i++) {
			ch = iQ.get();
			System.out.print(ch);
		}
		System.out.println();

		//put some more characters into circular queue
		for (int i = 10; i < 20; i++) {
			iQ.put((char) ('A' + i));
		}

		//show the queue
		System.out.println("Contents of circular queue: ");
		for (int i = 0; i < 10; i++) {
			ch = iQ.get();
			System.out.print(ch);
		}
		System.out.println("\nStore and consume from circular queue");

		//store in and consume from circular queue
		for (int i = 0; i < 20; i++) {
			iQ.put((char) ('A' + i));
			ch = iQ.get();
			System.out.print(ch);
		}

	}
}





















