import model.Raktar;
import org.junit.jupiter.api.*;
import sample.DBLayer;
import sample.Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

public class DBUnitTest {


    private EntityManager em;
    private static EntityManagerFactory emf;



    @BeforeAll
    public static void init(){
        emf = Persistence.createEntityManagerFactory("jpa-persistence-unit-1");
    }

    @BeforeEach
    void setUp() {
        em = emf.createEntityManager();
    }

    @AfterEach
    void tearDown() {
        em.close();
    }

    @AfterAll
    public static void destroy(){
        emf.close();
    }


    @Test
    void projektTest() {
        assertNotNull(DBLayer.getProjektNevek(), "A Projekt tábla nem elérhető");
    }
    @Test
    void projektTest2() {
        assertTrue(DBLayer.getProjektNevek().toArray().length > 0, "A Projekt tábla üres");
    }
    @Test
    void anyagTest() {
        assertNotNull(DBLayer.getAnyagok(), "Az Anyag tábla nem elérhető");
    }
    @Test
    void anyagTest2() {
        assertTrue(DBLayer.getAnyagok().toArray().length > 0, "Az Anyag tábla üres");
    }
    @Test
    void addTetelTest() {
        Raktar raktar = new Raktar("BBB","10012492", 1000000);
        int elotte =DBLayer.getRaktarSorokSzama();
        System.out.println(elotte);
        DBLayer.rogzitRaktar(raktar);
        int utana =DBLayer.getRaktarSorokSzama();
        System.out.println(utana);
        assertEquals((elotte+1), utana, "Nem lehetett sort beszurni a Raktar tablaba");
    }

}
