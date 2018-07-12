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


@Entity
@Table(name= "BOOK")
public class Book {
    
    @Id
    @GeneratedValue
    @Column(name= "BOOK_ID")
    private long id;
    
    @Column(name= "TITLE", length= 50)
    private String title;
    
    @Column(name= "DESCRIPTION", length= 50)
    private String description;
    
    @Column(name= "PUBLISH")
    private Date publishedDate;
    
    @ManyToMany(fetch= FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinTable(name= "AUTHOR_BOOK", joinColumns={
                                                  @JoinColumn(name= "BOOK_ID", nullable = false, updatable = false)},
                                                  inverseJoinColumns={
                                                                       @JoinColumn(name= "AUTHOR_ID", nullable = false, updatable = false)})
    private Set<Author> authors;

    public Book(){}
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
    
    @Override
    public String toString(){
        return "Book = {" + getId() + ", " + getTitle() + ", " + getDescription() +"}";
    }
}
