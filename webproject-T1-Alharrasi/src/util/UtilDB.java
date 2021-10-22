/**
 */
package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import datamodel.MyEmployeeAlharrasi;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDB {
   static SessionFactory sessionFactory = null;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory != null) {
         return sessionFactory;
      }
      Configuration configuration = new Configuration().configure();
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
      return sessionFactory;
   }
   
   

   public static List<MyEmployeeAlharrasi> listEmployees() {
      List<MyEmployeeAlharrasi> resultList = new ArrayList<MyEmployeeAlharrasi>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;  // each process needs transaction and commit the changes in DB.

      try {
         tx = session.beginTransaction();
         List<?> employees = session.createQuery("FROM MyEmployeeAlharrasi").list();
         for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();) {
            MyEmployeeAlharrasi employee = (MyEmployeeAlharrasi) iterator.next();
            resultList.add(employee);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }



   public static void createEmployees(String fIRST_NAME, String lAST_NAME, String pASSWORD, String pHONE, String eMAIL,
			int aGE, String dATE, String sALARY, String pPOSITION) {
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         session.save(new MyEmployeeAlharrasi( fIRST_NAME,  lAST_NAME,  pASSWORD,  pHONE,  eMAIL,
     			 aGE,  dATE,  sALARY,  pPOSITION));
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
}
