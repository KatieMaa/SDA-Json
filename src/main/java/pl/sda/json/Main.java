package pl.sda.json;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        User user1 = new User();
        user1.setFirstName("Jan");
        user1.setLastName("Nowak");

        Address address1 = new Address();
        address1.setStreet("Polna");
        address1.setCode("60-455");
        address1.setCity("Poznan");

        Address address2 = new Address();
        address2.setStreet("Wiejska");
        address2.setCode("60-234");
        address2.setCity("Poznan");

        Map<String, Address> addresses = new HashMap<>();
        addresses.put("Home", address1);
        addresses.put("Work", address2);

        user1.setAddresses(addresses);

        List<String> childrenNames = Arrays.asList("Kasia", "Witek", "Ola");

        user1.setChildrenNames(childrenNames);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(user1);

        System.out.println(json);

    }
}
