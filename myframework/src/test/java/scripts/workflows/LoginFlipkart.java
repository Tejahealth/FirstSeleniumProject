package scripts.workflows;

import objects.SinginObjects;
import ctaf.accelerators.GenericMethods;

public class LoginFlipkart extends GenericMethods{
	public boolean SearchProduct() throws Throwable{
		boolean flag = false;
		waitForElementPresent(SinginObjects.search, "Search Product");
		type(SinginObjects.search, "TV", "Search Product");		
		return flag;
	}
	

	public boolean SearchAircon() throws Throwable{
		boolean flag  = false;
		waitForElementPresent(SinginObjects.search, "searchAircon");
		type(SinginObjects.search, "Aircon", "Searchproduct");
		return flag;
		
	}}