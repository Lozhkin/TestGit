package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private SessionFactory sessionFactory;

   @Autowired
   public void setSessionFactory(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User findUserByCar(Car car) {
      String HQL="FROM User u JOIN FETCH u.car c WHERE c.model=:model and c.series=:series";
      Query query=sessionFactory.getCurrentSession().createQuery(HQL);
      query.setParameter("model", car.getModel());
      query.setParameter("series", car.getSeries());
      return (User) query.getSingleResult();
   }
}