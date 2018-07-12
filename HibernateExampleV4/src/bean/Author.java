/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;

@Entity
@Table(name= "AUTHOR")
public class Author {
    
    @Id
    @GeneratedValue
    @Column(name= "AUTHOR_ID")
    private long id;
    
    @Column(name= "NAME", length= 50)
    private String name;
    
    @Column(name= "EMAIL", length= 50)
    private String email;
    
    @ManyToMany(fetch= FetchType.LAZY, cascade= CascadeType.ALL, mappedBy= "authors")
    private Set<Book> books;
    
    public Author(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
    
    @Override
    public String toString(){
        return "Author = {" + getId() + ", " + getName() + ", " + getEmail() +"}";
    }
    
}
