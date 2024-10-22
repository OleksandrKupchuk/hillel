package patterns;

public class AddressBuilder {
    private String street;
    private String area;
    private String country;
    private String postCode;
    private String apartmentNumber;
    private String house;

    public String getStreet() {
        return street;
    }

    public String getArea() {
        return area;
    }

    public String getCountry() {
        return country;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getHouse() {
        return house;
    }

    public AddressBuilder(){}

    public static class Builder{
        private String street;
        private String area;
        private String country;
        private String postCode;
        private String apartmentNumber;
        private String house;

        private final AddressBuilder addressBuilder;

        public Builder setStreet(String street) {
            addressBuilder.street = street;
            return this;
        }

        public Builder setArea(String area) {
            addressBuilder.area = area;
            return this;
        }

        public Builder setCountry(String country) {
            addressBuilder.country = country;
            return this;
        }

        public Builder setPostCode(String postCode) {
            addressBuilder.postCode = postCode;
            return this;
        }

        public Builder setApartmentNumber(String apartmentNumber) {
            addressBuilder.apartmentNumber = apartmentNumber;
            return this;
        }

        public Builder setHouse(String house) {
            addressBuilder.house = house;
            return this;
        }

        public Builder(){
            addressBuilder = new AddressBuilder();
        }

        public AddressBuilder build(){
            return addressBuilder;
        }
    }
}
