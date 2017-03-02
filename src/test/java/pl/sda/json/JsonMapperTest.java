package pl.sda.json;

import jdk.nashorn.internal.AssertsEnabled;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by RENT on 2017-03-02.
 */
public class JsonMapperTest {

    @Test
    public void test1() throws IOException {
        String jsonToDeserialise = "{\"firstName\":\"Jan\",\"lastName\":\"Nowak\",\"addresses\":{\"Work\":{\"street\":\"Wiejska\",\"code\":\"60-234\",\"city\":\"Poznan\"},\"Home\":{\"street\":\"Polna\",\"code\":\"60-455\",\"city\":\"Poznan\"}},\"childrenNames\":[\"Kasia\",\"Witek\",\"Ola\"]}\n";

        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(jsonToDeserialise, User.class);

        Assert.assertEquals("Jan", user.getFirstName());

        Assert.assertNotNull(user.getChildrenNames());
        Assert.assertTrue(user.getChildrenNames() != null);

        Assert.assertTrue(user.getChildrenNames().size() == 3);
        Assert.assertEquals(Arrays.asList("Kasia", "Witek", "Ola"), user.getChildrenNames());
    }

    @Test
    public void test2() throws IOException {
        User user = new UserBuilder().withFirstName("Jan").withLastName("Nowak")
                .withAddress("Work", new AddressBuilder().withStreet("Wiejska").withCode("60-234").withCity("Poznan").build())
                .withAddress("Home", new AddressBuilder().withStreet("Polna").withCode("60-455").withCity("Poznan").build())
                .withChildrenNames(Arrays.asList("Kasia", "Witek", "Ola")).build();

        ObjectMapper mapper = new ObjectMapper();

        String serializedObject = mapper.writeValueAsString(user);

        Assert.assertTrue(serializedObject.contains("Jan"));
        Assert.assertTrue(serializedObject.contains("Kowalski"));
        Assert.assertTrue(serializedObject.contains("Kasia"));

    }

    @Test
    public void test3() throws IOException {
        User user = new UserBuilder().withFirstName("Jan").withLastName("Nowak")
                .withAddress("Work", new AddressBuilder().withStreet("Wiejska").withCode("60-234").withCity("Poznan").build())
                .withAddress("Home", new AddressBuilder().withStreet("Polna").withCode("60-455").withCity("Poznan").build())
                .withChildrenNames(null)
                .build();

        ObjectMapper mapper = new ObjectMapper();

        String serializedObject = mapper.writeValueAsString(user);

        System.out.println(serializedObject);

    }
}
