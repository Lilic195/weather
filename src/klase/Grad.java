package klase;

/**
 * Created by Aleksa on 13-Jan-17.
 */
public class Grad {
    private String name;
    private String country;
    private String subcountry;
    private String geonameid;

    public Grad(String name, String country, String subcountry, String geonameid) {
        this.name = name;
        this.country = country;
        this.subcountry = subcountry;
        this.geonameid = geonameid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSubcountry() {
        return subcountry;
    }

    public void setSubcountry(String subcountry) {
        this.subcountry = subcountry;
    }

    public String getGeonameid() {
        return geonameid;
    }

    public void setGeonameid(String geonameid) {
        this.geonameid = geonameid;
    }

    @Override
    public String toString() {
        return name + ", " + country;
    }
}
