/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


/**
 *
 * @author user
 */
 @Entity
    @Table(name="COUNTRY")
public class Country {
     
    @Id
    @Column(name="Country_Name")
    String countryName;

    @Column(name="Country_Population")
    long countryPopulation;
    
    public Country(){}

    public Country(String countryName, long countryPopulation) {
        this.countryName = countryName;
        this.countryPopulation = countryPopulation;
    }
    
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public long getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(long countryPopulation) {
        this.countryPopulation = countryPopulation;
    }
}
