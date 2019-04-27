package model;

import javax.persistence.*;

@Entity
@Table(name = "Projekt")
public class Projekt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(name = "NEV")
    private String pNev;

    @Column(name = "MEGJEGYZES")
    private String pMegjegyzes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getpNev() {
        return pNev;
    }

    public void setpNev(String nev) {
        this.pNev = nev;
    }

    public String getpMegjegyzes() {
        return pMegjegyzes;
    }

    public void setpMegjegyzes(String megjegyzes) {
        this.pMegjegyzes = megjegyzes;
    }

    public Projekt(Integer id, String nev, String megjegyzes) {
        this.id = id;
        this.pNev = nev;
        this.pMegjegyzes = megjegyzes;
    }

    public Projekt(String nev, String megjegyzes) {
        this.pNev = nev;
        this.pMegjegyzes = megjegyzes;
    }

    public Projekt() {
    }

    @Override
    public String toString() {
        return "Projekt{" +
                "id=" + id +
                ", pNev='" + pNev + '\'' +
                ", pMegjegyzes='" + pMegjegyzes + '\'' +
                '}';
    }
}
