class FixedQueue implements ICharQ {
	private char q[]; //this array holds the queue
	private int putloc, getloc; //the put and get indices

	//construct an emput queue given the size
	public FixedQueue(int size) {
		q = new char[size]; // allocate memory for queue
		putloc = getloc = 0;
	}

	//put characer into the queue
	public void put(char ch) 
		throws QueueFullException {
		if(putloc == q.length) {
			System.out.println(" - Queue is full.");
			return;
		}

		q[putloc++] = ch;
	}

	//get character form the queu
	public char get() 
		throws QueueEmptyException{
		if(putloc == getloc) {
			System.out.println("Queue is empty.");
			return (char) 0;
		}

		return q[getloc++];
	}
		
}