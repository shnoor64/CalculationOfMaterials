import entity.PriceList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Remover {
    public static void RemoverFromDatabase(String nameProvider) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(PriceList.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            String hql = "delete PriceList where provider  =:nameProvider";
            session.createQuery(hql).setParameter("nameProvider",nameProvider).executeUpdate();
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }

}