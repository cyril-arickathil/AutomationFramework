package org.example.api;

public class Contacts {

    private String _id;
    private String firstName;
    private String lastName;
    private String email;
    private String owner;
    private int __v;
    private Location location;
    private Employer employer;

    // post/put request - add contacts / update contacts
    public Contacts(String firstName, String lastName, String email, Location location, Employer employer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.location = location;
        this.employer = employer;

    }

    public static class Location {
        private String city;
        private String country;

        public String getCity() {
            return city;
        }

        public String getCountry() {
            return country;
        }

        public Location(String city, String country) {
            this.city = city;
            this.country = country;
        }
    }

    public static class Employer {
        private String jobTitle;
        private String company;

        public String getJobTitle() {
            return jobTitle;
        }

        public String getCompany() {
            return company;
        }

        public Employer(String jobTitle, String company) {
            this.jobTitle=jobTitle;
            this.company=company;
        }
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }
}
