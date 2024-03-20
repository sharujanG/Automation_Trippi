

public class Main {
	
	public static void main(String[] args) {
		   // Create an instance of TestWebSite
        TestWebSite testSite = new TestWebSite();

        // Call the setUp method
        testSite.setUp();

        // Call the performTravelOperations method
        testSite.performTravelOperations();

        // Call the tearDown method to close the browser
        testSite.tearDown();

	}

}
