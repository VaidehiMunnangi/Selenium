package day5;

public class DemoMultipleBrowserTesting {

	public static void main(String[] args) {
		
		MultipleBrowserTesting m = new MultipleBrowserTesting();
		m.invokeBrowser("ie");
		m.printTitle();
		m.closeBrowser();

	}

}
