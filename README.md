# swarm
sudo apt-get install libwebkitgtk-1.0-0
package fi.foyt.foursquare.example;

import java.util.Date;

import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.Checkin;
import fi.foyt.foursquare.api.entities.CheckinGroup;
import fi.foyt.foursquare.api.entities.CompactUser;
import fi.foyt.foursquare.api.io.DefaultIOHandler;

/**
 * Basic search example
 * @TODO - more examples please :)
 * @author rmangi
 *
 */
public class BasicExample {

	  public static void main(String[] args) {
	    String ll = args.length > 0 ? args[0] : "44.3,37.2";
	    try {
	      (new BasicExample()).searchVenues(ll);
	    } catch (FoursquareApiException e) {
	      // TODO: Error handling
	    }
	  }

	  public void searchVenues(String ll) throws FoursquareApiException {
	    // First we need a initialize FoursquareApi. 
	    FoursquareApi foursquareApi = new  FoursquareApi("R1II31IJ4Q5F43I03G4ZHCKQI3QLNKDOFNIYRJTQNJRPIR4U", "NRILN0SH31GR3AOBVXJGTWJAVYA2I4ZIY2XOJ2DVXATIQS4D", "http://www.cafesanzelize.com");
	    foursquareApi = new FoursquareApi("R1II31IJ4Q5F43I03G4ZHCKQI3QLNKDOFNIYRJTQNJRPIR4U", "NRILN0SH31GR3AOBVXJGTWJAVYA2I4ZIY2XOJ2DVXATIQS4D", "http://www.cafesanzelize.com", "BCNJOBU512V12SAFMLGIW1WPHB30U051KCUDAXRNIYMVP5BM", new DefaultIOHandler());
	    String oAuthToken = foursquareApi.getOAuthToken();
	    
	    Result<CheckinGroup> hereNow = foursquareApi.venuesHereNow("55c10412498ecf54b18a344b", null, null, null);
	    CheckinGroup result = hereNow.getResult();
	    
	    if (hereNow.getMeta().getCode() == 200) {
	    	
	    	Checkin[] items = result.getItems();
	    	for (Checkin checkin : items) {
				CompactUser user = checkin.getUser();
				Date d = new Date(checkin.getCreatedAt() * 1000);
				System.out.println(user.getFirstName() + " " + user.getLastName() + " " + d);
			}
	    } else {
	      // TODO: Proper error handling
	      System.out.println("Error occured: ");
	      System.out.println("  code: " + hereNow.getMeta().getCode());
	      System.out.println("  type: " + hereNow.getMeta().getErrorType());
	      System.out.println("  detail: " + hereNow.getMeta().getErrorDetail()); 
	    }
	  }
}
