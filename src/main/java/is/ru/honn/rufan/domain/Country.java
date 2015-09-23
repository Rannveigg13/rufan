package is.ru.honn.rufan.domain;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Gudmundsdottir
 * @version 1.0 22/9/2015.
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

    /**
     * Getter for the name of the country
     * @return This country's ID. Should never be null.
     */
    public String getName() { return name; }

    /**
     * Getter for the abbreviation of the country.
     * @return This country's abbreviation
     */
    public String  getAbbreviation() { return abbreviation; }

    /**
     * Sets the country ID
     * @param countryId This country's ID
     */
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    /**
     * Sets the country's abbreviation
     * @param abbreviation This country's abbreviation
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * Sets the name of the country
     * @param name This country's name
     */
    public void setName(String name) {
        this.name = name;
    }
}
