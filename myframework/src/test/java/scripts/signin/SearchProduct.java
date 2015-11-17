package scripts.signin;

import org.testng.annotations.Test;

import scripts.workflows.LoginFlipkart;

public class SearchProduct extends LoginFlipkart {
  @Test
  public void searchValidProduct() throws Throwable {
	  SearchProduct();
	  SearchAircon();
  }
}
