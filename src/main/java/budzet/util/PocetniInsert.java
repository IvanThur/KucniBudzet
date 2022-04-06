/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package budzet.util;

import budzet.model.Operater;
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
import org.mindrot.jbcrypt.BCrypt;

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
        List<Vrsta> vrste = generirajVrste(faker, session);

        Osoba o;
        Vrsta v;
        Prihod p;
        for (int i = 0; i < vrste.size() - 2; i++) {
            o = osobe.get(i);
            v = vrste.get(i);
            for (int j = 0; j < ((int) Math.random() * (10 - 2) + 2); j++) {
                p = new Prihod();
                p.setVrsta(v);
                p.setPrimatelj(o);
                p.setDatumPlacanja(new Date());
                p.setIznos(new BigDecimal(Math.random() * (10000 - 5000) + 5000));
                Collections.shuffle(osobe);
                session.save(p);

            }
        }

        session.getTransaction().commit();

    }

    public static void unosOperatera() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Operater o = new Operater();
        o.setUloga("oper");
        o.setEmail("admin@admin.hr");
        o.setLozinka(BCrypt.hashpw("admin", BCrypt.gensalt()));
        session.save(o);
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
            System.out.println("Kreirao osobu: " + o.getIme() + " " + o.getPrezime());
        }
        return osobe;
    }

    private static List<Vrsta> generirajVrste(Faker faker, Session session) {
        List<Vrsta> vrste = new ArrayList<>();
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
