package is.ru.honn.rufan.domain;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Guðmundsdóttir
 * @date 22/9/2015.
 * @version 1.0
 */
public class Country {

    private int countryId;
    private String name;
    private String abbreviation;

    /***
     * Getter for the unique ID of the country.
     * @return This country's country ID. Should never be null.
     */
    public int getCountryId() { return countryId; }

    public String getName() { return name; }

    public String  getAbbreviation() { return abbreviation; }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setName(String name) {
        this.name = name;
    }
}
