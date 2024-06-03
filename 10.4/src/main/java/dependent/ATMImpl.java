package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {//atmimpl dependent on transport1
	//private long cash;//mandatory dependency(through logic) 
	private Transport myTransport;// optional dpendency= new SoapTransport();

	private ATMImpl(Transport t) {
		this.myTransport=t;
		System.out.println("in cnstr of " + getClass() + " " + myTransport);
	}
	//add setters method


	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);//dependent obj using dependency

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
	}
	// setter based D.I

	
	// custom init method
	public void anyInit() {
		System.out.println("in init " + myTransport);
	}

	// custom destroy method
	public void anyDestroy() {
		System.out.println("in destroy " + myTransport);
	}


	/*
	 * //adding setters public void setMyTransport(Transport myTransport) {
	 * this.myTransport = myTransport; }
	 */
	//add factory method
	public static ATMImpl myFactoryMethod(Transport t12) {
		System.out.println("in factory method ");
		return new ATMImpl(t12);
		
	}

}
