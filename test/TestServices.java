
import com.java.cargonam.bean.Person;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.catalina.WebResource;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author furibe
 */
public class TestServices {

    private static final String BASE_URI = "http://localhost:8080/cargonamServices/webresources";

    public static void main(String[] args) {
        try {
            Client client = javax.ws.rs.client.ClientBuilder.newClient();
            WebTarget webTarget = client.target(BASE_URI).path("person");
            
            WebTarget resource = webTarget;
            resource = resource.path("create");
            System.out.println("resource.getUri() = " + resource.getUri());
            Response response = resource.request(MediaType.APPLICATION_JSON).get();
             
             System.out.println("response.getStatus() = " + response.getStatus());
            
//            //            WebTarget target = client.target("http://localhost:8080/cargonamServices/webresources/person/edit");
//            //            target = target.queryParam("id", "prueba");
//            //            System.out.println("target = " + target.getUri());
//            //            Response response = target.request(MediaType.APPLICATION_JSON).get();
//            //            System.out.println("response.getStatus() = " + response.getStatus());
//            //
//            //            TestClient testClient = new TestClient();
//            //            Person person = new Person();
//            //            String result = ""
//            +"<person>\n"
//                    + "    <docIdentificationNumber>15912749</docIdentificationNumber>\n"
//                    + "    <gender>50</gender>\n"
//                    + "    <personName>Alejandro De Andrade</personName>\n"
//                    + "    <phonesSet>\n"
//                    + "        <areaCode>212</areaCode>\n"
//                    + "        <countryCode>\n"
//                    + "            <countryCode>1</countryCode>\n"
//                    + "            <countryName>Venezuela</countryName>\n"
//                    + "            <phoneCode>58</phoneCode>\n"
//                    + "            <regionCode>\n"
//                    + "                <regionCode>1</regionCode>\n"
//                    + "                <regionName>Sur america</regionName>\n"
//                    + "            </regionCode>\n"
//                    + "        </countryCode>\n"
//                    + "        <phoneNumber>5018766</phoneNumber>\n"
//                    + "        <phoneType>1</phoneType>\n"
//                    + "        <phonesTypeId>\n"
//                    + "            <phonesTypeDescription>Local</phonesTypeDescription>\n"
//                    + "            <phonesTypeId>1</phonesTypeId>\n"
//                    + "        </phonesTypeId>\n"
//                    + "    </phonesSet>\n"
//                    + "    <registrationDate>2018-11-30T00:00:00-04:00</registrationDate>\n"
//                    + "    <specialNotes>Prueba</specialNotes>\n"
//                    + "</person>";
//
////            InputStream stream = new ByteArrayInputStream(result.getBytes(StandardCharsets.UTF_8));
////            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
////            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            person.setPersonId(5);
//            person.setPersonName("Alejandro");
//            System.out.println("person = " + person);
//            testClient.create(responseType);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
