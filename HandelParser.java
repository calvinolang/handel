
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import javax.inject.Named;
import javax.inject.Singleton;

import org.json.JSONArray;

@Singleton
@Named("HandelParser")
public class HandelParser implements Processor {

  public void process(Exchange exchange) throws Exception {
    try {
      String jsonString = exchange.getIn().getBody().toString();
      JSONArray jsonArray = new JSONArray(jsonString);      
      exchange.getIn().setBody(jsonArray.toString(4));
    }
    catch (Exception ex) {
      exchange.getIn().setBody("Invalid Handel statement");
    }

  }
}