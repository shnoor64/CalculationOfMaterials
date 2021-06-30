import entity.PriceList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Recorder {
    public  static void recordInDatabase (String filePathXls,String provider,String updateDate) {
//public  static void recordInDatabase () {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(PriceList.class)
                .buildSessionFactory();
        try {

            for (PriceList priceRow : Parser.parse(filePathXls, provider, updateDate)
            ) {
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

