package day3;

public class DemoGuru99Project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Guru99Project guru = new Guru99Project();
		
		guru.invokeBrowser();
		guru.loginGuru("mngr166113", "epyrepE");
		guru.addCustomer();		
		String customerId = guru.getCustomerID();
		guru.addAccount(customerId);
		guru.closeBrowser();
		

	}

}
