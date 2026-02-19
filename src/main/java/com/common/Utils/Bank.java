package com.common.Utils;

public abstract class Bank {
	 private double account=457689;
	public static void main(String[] args) {
		Bank hdfc = new MumbaiBranch();
		hdfc.createAccount("Roshan");
		//hdfc.account=90987;
	}

	public void createAccount(String name) {
		System.out.println("Account has been created for " + name);
	}

	public abstract boolean validateDoccument(String doccument);

}

class MumbaiBranch extends Bank {
 
	@Override
	public boolean validateDoccument(String doccument) {
		
		// TODO Auto-generated method stub
		if (doccument.equalsIgnoreCase("Aadar") || doccument.equalsIgnoreCase("EB")) {
			System.out.println(doccument + " Verified successfully!");
			return true;
		} else {
			System.out.println(doccument + " Not Verified");
			return false;
		}

	}
}
class HydBranch extends Bank{

	@Override
	public boolean validateDoccument(String doccument) {
		if (doccument.equalsIgnoreCase("Passport") || doccument.equalsIgnoreCase("voterID")) {
			System.out.println(doccument + " Verified successfully!");
			return true;
		} else {
			System.out.println(doccument + " Not Verified ");
			return false;
		}
	}
	
}
interface Payment {
    void pay(double amount);
    void refund(double amount);
}
class CreditCardPayment implements Payment {

	@Override
	public void pay(double amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refund(double amount) {
		// TODO Auto-generated method stub
		
	}
	
}
class cricketer implements Comparable<cricketer>{
	private int runs;
	private String name;
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(cricketer o) {
		// TODO Auto-generated method stub
		return Integer.compare(runs, o.runs);
	}
	
}
