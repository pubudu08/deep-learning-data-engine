package org.rapter.core.api.foursquare;

import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.CompactVenue;
import fi.foyt.foursquare.api.entities.CompleteVenue;
import fi.foyt.foursquare.api.entities.VenuesSearchResult;

/**
 * Created by Pubudu Dissanayake on 12/12/15.
 * Project : sentiment-engine
 */
public class FoursquareOperations {
    public static void main(String[] args) {
        String ll = args.length > 0 ? args[0] : "44.3,37.2";
        try {
            (new FoursquareOperations()).searchVenues("44.3,37.2");
        } catch (FoursquareApiException e) {
            // TODO: Error handling
        }
    }

    public void searchVenues(String ll) throws FoursquareApiException {
        // First we need a initialize FoursquareApi.
        FoursquareApi foursquareApi = new FoursquareApi("DDJPB025CWIVPSWUM23B0323IVCKERE3YQWXISYDUFE3D5FQ", "UY4VSDPWAWZ1FEVNJKMXIKIODBRIRWPGLZJAKGUVUCHB21TU", "http://geekdetected.wordpress.com");


        // After client has been initialized we can make queries.
        foursquareApi.getAuthenticationUrl();
        Result<VenuesSearchResult> resultw = foursquareApi.venuesSearch(ll, null, null, null, null, null, null, null, null, null, null, null, null);
        Result<CompleteVenue> result = foursquareApi.venue("4c0771cb3cbed13a7af40bc0");

        if (result.getMeta().getCode() == 200) {
            // if query was ok we can finally we do something with the data
//            for (CompleteVenue venue : result.getResult()) {
//                // TODO: Do something we the data
//                System.out.println(venue.getName());
//            }
        } else {
            // TODO: Proper error handling
            System.out.println("Error occured: ");
            System.out.println("  code: " + result.getMeta().getCode());
            System.out.println("  type: " + result.getMeta().getErrorType());
            System.out.println("  detail: " + result.getMeta().getErrorDetail());
        }
    }
}


