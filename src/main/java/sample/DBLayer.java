package sample;

import model.Anyag;
import model.Projekt;
import model.Raktar;
import model.RaktarOssz;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DBLayer {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-persistence-unit-1");
    public static EntityManager em;
    private static List<Projekt> projektek;
    public static List<Anyag> anyagok;
    //public  static Map<String, String> anyagokMap;
    //public static List<Raktar> raktarOssz;
    //public static List<RaktarOssz> results;
    //private static List<String> projektNevek;



    public static List<String> getProjektNevek() {
        em = emf.createEntityManager();
        List<String> projektNevek = em.createQuery("SELECT p.pNev FROM Projekt p", String.class).getResultList();
        em.close();
        return projektNevek;
    }
    public static List<Anyag> getAnyagok() {
        em = emf.createEntityManager();
        List<Anyag> anyagok = em.createQuery("SELECT a FROM Anyag a", Anyag.class).getResultList();
        em.close();
        return anyagok;
    }


    public static Map<String, String> getAnyagokMap() {
        List<Anyag> anyagok = getAnyagok();
        Map<String, String> anyagokMap = anyagok.stream().collect(Collectors.toMap(a -> a.getSap(), a2 -> a2.getMegnevezes()));
        return anyagokMap;
    }

    public static List<RaktarOssz> getRaktarOssz() {
        em = emf.createEntityManager();
        Session session = (Session) em.getDelegate();
        List<RaktarOssz> ossz = session.createCriteria(Raktar.class).setProjection(Projections.projectionList()
                .add(Projections.groupProperty("projekt"), "projekt")
                .add(Projections.groupProperty("sap"), "sap")
                .add(Projections.sum("mennyiseg"), "mennyiseg"))
                .setResultTransformer(Transformers.aliasToBean(RaktarOssz.class))
                .list();
        em.close();
        return ossz;
    }

    public static boolean rogzitRaktar(Raktar raktar)
    {
        int elotte =DBLayer.getRaktarSorokSzama();
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(raktar);
            em.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            return false;
        } finally {
            em.close();
        }

    }

    public static int getRaktarSorokSzama() {

        int ossz = 0;
        em = emf.createEntityManager();
        Session session = (Session) em.getDelegate();

        try
        {
            List<BigInteger> list = session.createSQLQuery("SELECT count(*) FROM Raktar ").list();
            ossz = list.get(0).intValue();
                    }
        catch (Exception e)
        {
           ossz = 0;
        }
        em.close();

        return ossz;
    }

}
