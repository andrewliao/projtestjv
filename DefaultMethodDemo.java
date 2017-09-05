interface MyIF {
	//This is a normal interface method declaration.
	//It does NOT define a default implementation
	int getUSERID();

	//this is a default method. Notice that is provides a default implementation.
	default int getAdminID() {
		return 1;
	}

	//this is the static interface method.
	static int getUniversalID() {
		return 0;
	}
}

//implement MyIF

class MYIFmp implements MyIF {
	//only get UserID() defined by MyIf needs to be implement
	//getAdminId() can be allowed to default
	public int getUSERID() {
		return 100;
	}
}

class DefaultMethodDemo {
	public static void main(String[] args) {

		MYIFmp obj = new MYIFmp();

		//can call getUserID(),  because it is explicityly implemented by MYIFImp:
		System.out.println(obj.getUSERID());

		//can also call getAdminId(), because of default implementation
		System.out.println("Administration ID is " + obj.getAdminID());

		int uID = MyIF.getUniversalID();
		System.out.println(uID);
	}
}