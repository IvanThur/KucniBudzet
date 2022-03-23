/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package budzet.util;

import budzet.model.Osoba;
import budzet.model.Prihod;
import budzet.model.Rashod;
import budzet.model.Vrsta;
import com.github.javafaker.Faker;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Ivan
 */
public class PocetniInsert {
    
    public static void izvedi() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Faker faker = new Faker();

        List<Osoba> osobe = generirajOsobe(faker, session);
        List<Vrsta> vrste = generirajVrste(faker,session);
       
        
        session.getTransaction().commit();

    }
    
    private static List<Osoba> generirajOsobe(Faker faker, Session session) {
        List<Osoba> osobe = new ArrayList();
        Osoba o;
        for (int i = 0; i < 10; i++) {
            o = new Osoba();
            o.setIme(faker.name().firstName());
            o.setPrezime(faker.name().lastName());
            session.save(o);
            osobe.add(o);
            System.out.println("Kreirao osobu: " + o.getIme()+" "+o.getPrezime());
        }
        return osobe;
    }
    /*private static List<Polaznik> generirajPolaznike(Faker faker, Session session) {
        List<Polaznik> polaznici = new ArrayList();
        Polaznik p;
        for (int i = 0; i < 3000; i++) {
            p = new Polaznik();
            p.setIme(faker.name().firstName());
            p.setPrezime(faker.name().lastName());
            p.setEmail(faker.name().firstName().substring(0, 1).toLowerCase()
                    + faker.name().lastName().toLowerCase().replace(" ", "")
                    + "@edunova.hr");
            p.setOib(EdunovaUtil.generirajOib());
            p.setBrojUgovora((i + 1) + "/2022");
            session.save(p);
            polaznici.add(p);
            System.out.println("Krierao polaznika: " + p.getIme() + " " + p.getOib());
        }
        return polaznici;
    }*/


    private static List<Vrsta> generirajVrste(Faker faker, Session session) {
       List<Vrsta> vrste = new ArrayList();
        Vrsta v;
        for (int i = 0; i < 10; i++) {
            v = new Vrsta();
            v.setNaziv(faker.beer().name());
            session.save(v);
            vrste.add(v);
            System.out.println("Kreirao vrstu: " + v.getNaziv());
        }
        return vrste;
    }

    
}
