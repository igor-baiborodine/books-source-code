/* To create the WSDL artifacts, the command is:

  wsimport -p amazon -keep \
    http://webservices.amazon.com/AWSECommerceService/AWSECommerceService.wsdl \
    -b custom.xml .

  The file custom.xml is:

  <jaxws:bindings
     wsdlLocation = 
     "http://webservices.amazon.com/AWSECommerceService/AWSECommerceService.wsdl"
     xmlns:jaxws="http://java.sun.com/xml/ns/jaxws">
    <jaxws:enableWrapperStyle>false</jaxws:enableWrapperStyle>
  </jaxws:bindings>      
*/
package amazon;

import amazon.AWSECommerceService;
import amazon.AWSECommerceServicePortType;
import amazon.ItemSearchRequest;
import amazon.ItemSearchResponse;
import amazon.ItemSearch;
import amazon.Items;
import amazon.Item;
import amazon.AwsHandlerResolver;
import java.util.List;

class AmazonClientBareStyle { 
    public static void main(String[ ] args) {
	if (args.length < 2) {
	    System.err.println("Usage: java AmazonClientU <access key> <secrete key>");
	    return;
	}
	final String accessID = args[0];
	final String secretKey = args[1];
	
        // Create service and get portType reference.
        AWSECommerceService service = new AWSECommerceService();
	// Secret key for Amazon.
	service.setHandlerResolver(new AwsHandlerResolver(secretKey)); 

        AWSECommerceServicePortType port = service.getAWSECommerceServicePort();

        // Create request.
        ItemSearchRequest request = new ItemSearchRequest();

        // Add details to request.
        request.setSearchIndex("Books");
        request.setKeywords("Austen");
	
        ItemSearch itemSearch= new ItemSearch();
        itemSearch.setAWSAccessKeyId(accessID);
	itemSearch.setAssociateTag("kalin");
        itemSearch.getRequest().add(request);

        // Invoke service operation and get response.
        ItemSearchResponse response = port.itemSearch(itemSearch);

        List<Items> itemsList = response.getItems();

	int i = 1;
        for (Items next : itemsList) 
           for (Item item : next.getItem())
	       System.out.println(String.format("%2d: ", i++) + 
				  item.getItemAttributes().getTitle());
    }
}
