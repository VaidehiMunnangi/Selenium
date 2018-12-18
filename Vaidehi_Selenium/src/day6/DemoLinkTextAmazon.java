package day6;

public class DemoLinkTextAmazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkTextAmazon al = new LinkTextAmazon();
		
		al.invokeBrowser("ie");
		System.out.println("Link for the given Text: " + al.getLink());
		System.out.println("Total no.of links: " + al.linkCount());
		al.printAllLinks();

	}

}
