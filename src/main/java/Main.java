import entity.PriceList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Main {

    public static void main(String... args) {
        // System.out.println(Parser.parse("testfile.xls", "Рога и копыта", "27.06.2021"));
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(PriceList.class)
                .buildSessionFactory();
        try {

//            Session session = factory.getCurrentSession();

            for (PriceList priceRow : Parser.parse("testfile.xls", "Рога и копыта", "27.06.2021")
            ) {
                //Session session = factory.openSession();
                Session session = factory.getCurrentSession();
                session.beginTransaction();
                session.save(priceRow);
                session.getTransaction().commit();
//                session.close();
            }

        } finally {

            factory.close();
        }
    }

}