package hw08;

import java.util.Objects;

public class Address {
    private String country;
    private String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Address address = (Address) object;
        return Objects.equals(country, address.country) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }
}
