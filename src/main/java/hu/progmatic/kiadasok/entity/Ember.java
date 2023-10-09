package hu.progmatic.kiadasok.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "emberek")
public class Ember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nev")
    private String nev;

    @Column(name = "szuletesi_hely")
    private String szuletesiHely;

    @Column(name = "email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getSzuletesiHely() {
        return szuletesiHely;
    }

    public void setSzuletesiHely(String szuletesiHely) {
        this.szuletesiHely = szuletesiHely;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Ember(int id, String nev, String szuletesiHely, String email) {
        this.id = id;
        this.nev = nev;
        this.szuletesiHely = szuletesiHely;
        this.email = email;
    }

    public Ember() {

    }

}
