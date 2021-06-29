import entity.PriceList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Searcher {

    public static List<PriceList> searchByWord(String searchWord) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(PriceList.class)
                .buildSessionFactory();
        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();
            String hql = "select pL from PriceList pL where pL.nameProduct LIKE concat('%', :nameProductSearch,'%')";
//            String hql = "from PriceList pL where pL.nameProduct in :nameProductSearch";
            List<PriceList> resultSearch = session.createQuery(hql).setParameter("nameProductSearch", searchWord).list();




            System.out.println(resultSearch);
            session.getTransaction().commit();
            return resultSearch;
        } finally {
            factory.close();
        }
}
}
