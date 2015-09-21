package is.ru.honn.rufan.domain;

/**
 * Created by Notandi on 21-Sep-15.
 */
public class Country {
    private int countryId;
    private String name;
    private String abbreviation;

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
