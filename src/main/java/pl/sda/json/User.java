package pl.sda.json;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created by RENT on 2017-03-02.
 */

@JsonSerialize
public class User {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
