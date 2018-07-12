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
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

/**
 *
 * @author user
 */
@Entity
@Table(name="CAPITAL")
public class Capital {
    
    @Id
    @Column(name="Capital_Name")
    String capitalName;
    
    @Column(name="Capital_Population")
    long capitalPopulation;
    
    @OneToOne
    @JoinColumn(name="Country_Name")
    Country country;
    
    public Capital(){}
    
    public Capital(String capitalName, long capitalPopulation){
        this.capitalName = capitalName;
        this.capitalPopulation = capitalPopulation;
    }
    
     public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }
     
    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalPopulation(long capitalPopulation) {
        this.capitalPopulation = capitalPopulation;
    }
    
    public long getCapitalPopulation() {
        return capitalPopulation;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    
    
}
