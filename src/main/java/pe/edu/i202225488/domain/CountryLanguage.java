package pe.edu.i202225488.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "countryLanguage")
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CountryCode", updatable = false, insertable = false)
    private Country country;
    @Column(name = "IsOfficial")
    private String isOfficial;
    @Column(name = "Percentage")
    private Double percentage;

    public CountryLanguage() {
    }

    public CountryLanguage(CountryLanguageId id, Country country, String isOfficial, Double percentage) {
        this.id = id;
        this.country = country;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public String getOfficial() {
        return isOfficial;
    }

    public void setOfficial(String official) {
        isOfficial = official;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public CountryLanguageId getId() {
        return id;
    }

    public void setId(CountryLanguageId id) {
        this.id = id;
    }
}