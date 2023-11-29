package vn.edu.iuh.fit.lab_week_01.repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import vn.edu.iuh.fit.lab_week_01.models.Log;

import java.sql.Date;
import java.util.List;
@Stateless
public class LogRepository {
    private EntityManager em;

    public LogRepository() {
        em = Persistence.createEntityManagerFactory("lab_week_1").createEntityManager();
    }

    public List<Log> findAll() {
        TypedQuery<Log> log = em.createQuery("select l from Log l", Log.class);
        return log.getResultList();
    }

    public List<Log> findLogByUser(String account_id) {
        TypedQuery<Log> q = em.createQuery("select l from Log l where l.account_id=?1", Log.class);
        q.setParameter(1, account_id);
        return q.getResultList();
    }

    public List<Log> findLogInTime(Date begin, Date end) {
        TypedQuery<Log> q = em.createQuery("select l from Log l where l.login_time>=?1 and l.login_time<=?2", Log.class);
        q.setParameter(1, begin);
        q.setParameter(2, end);
        return q.getResultList();
    }

    public void insert(Log log) {
        em.persist(log);
    }

    public void update(Log log) {
        log.setLogout_time(new Date(System.currentTimeMillis()));
        em.merge(log);
    }
}
