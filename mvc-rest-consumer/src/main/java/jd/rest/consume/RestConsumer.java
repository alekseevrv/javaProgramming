package jd.rest.consume;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;

public class RestConsumer {

    public static void main(String... args) throws IOException {
        // получаем строку JSON от REST
//        String response = IOUtils.toString(new URL("http://services.groupkt.com/country/get/iso2code/RU"), "UTF8");
        String response = IOUtils.toString(new URL("http://localhost:8080/counter?name=The+Who"), "UTF8");
        System.out.println(response);

        response = IOUtils.toString(new URL("http://localhost:8080/coords?location=lat56.4,lon34.6"), "UTF8");
        System.out.println(response);

        response = IOUtils.toString(new URL("http://localhost:8080/coords?location=lat56.4"), "UTF8");
        System.out.println(response);

        response = IOUtils.toString(new URL("http://localhost:8080/coords"), "UTF8");
        System.out.println(response);
        // преобразуем строку JSON в объект
        /*ObjectMapper mapper = new ObjectMapper();
        Country country = mapper.readValue(response, Country.class);
        System.out.println(country.RestResponse.result.entrySet());
        System.out.println(country.RestResponse.messages.length);
        System.out.println(country.RestResponse.messages[0]);*/

    }
}
