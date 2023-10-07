package dao;

import entity.Goods;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class GoodsDAO {
  public Goods findById(Long id) {
    return HibernateUtil.getSessionFactory().openSession().get(Goods.class, id);
  }

  public void save(Goods goods) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx1 = session.beginTransaction();
    session.save(goods);
    tx1.commit();
    session.close();
  }

  public void update(Goods goods) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx1 = session.beginTransaction();
    session.update(goods);
    tx1.commit();
    session.close();
  }

  public void delete(Goods goods) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx1 = session.beginTransaction();
    session.delete(goods);
    tx1.commit();
    session.close();
  }
}
