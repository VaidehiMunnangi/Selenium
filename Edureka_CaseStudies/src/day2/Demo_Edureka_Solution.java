package day2;

public class Demo_Edureka_Solution {

	public static void main(String args[]) {
		chrome();
		firefox();
	}

	public static void chrome() {
		System.out.println(" Starting the test for chrome browser");
		Edureka_Solution a = new Edureka_Solution();
		a.browser("chrome", "./chromedriver.exe");
	}

	public static void firefox() {
		System.out.println(" Starting the test for firefox browser");
		Edureka_Solution a = new Edureka_Solution();
		a.browser("firefox", "./geckodriver.exe");
	}
}
