package model;

import javax.persistence.*;

@Entity
@Table(name = "Anyag")
public class Anyag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "SAP")
    private String sap;

    @Column(name = "MEGNEV")
    private String megnevezes;

    @Column(name = "ME")
    private String mertekegyseg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSap() {
        return sap;
    }

    public void setSap(String sap) {
        this.sap = sap;
    }

    public String getMegnevezes() {
        return megnevezes;
    }

    public void setMegnevezes(String megnevezes) {
        this.megnevezes = megnevezes;
    }

    public String getMertekegyseg() {
        return mertekegyseg;
    }

    public void setMertekegyseg(String mertekegyseg) {
        this.mertekegyseg = mertekegyseg;
    }

    public Anyag(Integer id, String sap, String megnevezes) {
        this.id = id;
        this.sap = sap;
        this.megnevezes = megnevezes;
    }

    public Anyag(String sap, String megnevezes) {
        this.sap = sap;
        this.megnevezes = megnevezes;
    }

    public Anyag() {
    }

    @Override
    public String toString() {
        return "Anyag{" +
                "id=" + id +
                ", sap='" + sap + '\'' +
                ", megnevezes='" + megnevezes + '\'' +
                ", mertekegyseg='" + mertekegyseg + '\'' +
                '}';
    }
}
