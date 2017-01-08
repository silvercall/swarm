package fi.foyt.foursquare.example;

import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.Photo;
import fi.foyt.foursquare.api.entities.PhotoGroup;

public class Main {

	public static void main(String[] args) throws FoursquareApiException {
		FoursquareApi foursquareApi = new FoursquareApi("TZ3HUFJGUA3YFSJABF4JSW25RNP3GCGXNLG0A2KDZ4F5C125", "JW2RW0QJ5QCN4X1L3DBQVRUY3J3P11GMIHRULYBUC3BP4TXZ", "http://www.cafesanzelize.com");

		Result<PhotoGroup> venuesPhotos = foursquareApi.venuesPhotos("55c10412498ecf54b18a344b", null, null, null);
		PhotoGroup photoGroup = venuesPhotos.getResult();
		for (Photo photo : photoGroup.getItems()) {
			String prefix = photo.getPrefix();
			String suffix = photo.getSuffix();
			String url = prefix + photo.getHeight() + "x" + photo.getWidth()+ suffix;

			String photo2 = photo.getUser().getPhoto();
			String firstName = photo.getUser().getFirstName();
			String lastName = photo.getUser().getLastName();
			System.out.println(url);
		}
		
		
	}

}
