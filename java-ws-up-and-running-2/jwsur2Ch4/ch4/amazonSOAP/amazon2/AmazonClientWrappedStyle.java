package amazon2;

import amazon2.AWSECommerceService;
import amazon2.AWSECommerceServicePortType;
import amazon2.ItemSearchRequest;
import amazon2.ItemSearch;
import amazon2.Items;
import amazon2.Item;
import amazon2.OperationRequest;
import amazon2.SearchResultsMap;
import amazon2.AwsHandlerResolver; 

import javax.xml.ws.Holder;
import java.util.List;
import java.util.ArrayList;

class AmazonClientWrappedStyle { 
    public static void main(String[ ] args) {
      if (args.length < 2) {
        System.err.println("Usage: java AmazonClientW <access key> <secrete key>");
        return;
      }
      final String accessID = args[0];
      final String secretKey = args[1];

      AWSECommerceService service = new AWSECommerceService();
      service.setHandlerResolver(new AwsHandlerResolver(secretKey)); 
      AWSECommerceServicePortType port = service.getAWSECommerceServicePort();

      ItemSearchRequest request = new ItemSearchRequest();
      request.setSearchIndex("Books"); 
      request.setKeywords("Austen");

      ItemSearch search = new ItemSearch();
      search.getRequest().add(request);
      search.setAWSAccessKeyId(accessID);
      search.setAssociateTag("kalin");      

      Holder<OperationRequest> operation_request = null;
      Holder<List<Items>> items = new Holder<List<Items>>();

      port.itemSearch(search.getMarketplaceDomain(),
                      search.getAWSAccessKeyId(),
                      search.getAssociateTag(),
                      search.getXMLEscaping(),
                      search.getValidate(),
                      search.getShared(),
                      search.getRequest(),
                      operation_request,
                      items);

      Items retval = items.value.get(0);      
      int i = 1;
      List<Item> item_list = retval.getItem(); // list of Item subelements
      for (Item item : item_list)              // each Item in the list
	  System.out.println(String.format("%2d: ", i++) + 
			     item.getItemAttributes().getTitle());
    }
}
