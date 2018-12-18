package day7;

public class DemoAmazonProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AmazonProject ap = new AmazonProject();
		ap.invokeBrowser("chrome");
		
		ap.searchProduct("Selenium", "Books");
		
		ap.printNthProduct(5);
		
		//ap.pritAllElementsViaScrollDownUsingMouse();
		
		ap.printAllElementsViaScrollDownUsingJS();
		
		
	}

}
