package vn.edu.iuh.fit.lab_week_01.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.lab_week_01.models.Account;
import vn.edu.iuh.fit.lab_week_01.models.GrantAccess;
import vn.edu.iuh.fit.lab_week_01.models.Role;


import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AccountRepository {
    private final Logger logger = Logger.getLogger(AccountRepository.class.getName());
    private EntityManager em;
    private EntityTransaction trans;

    @Inject
    private RoleRepository roleRepository;
    @Inject
    private GrantAccessRepository grantAccessRepository;

    public AccountRepository() {
        em = Persistence.createEntityManagerFactory("lab_week_1").createEntityManager();
        trans = em.getTransaction();
    }

    public void insert(Account account) {
        try {
            trans.begin();
            em.persist(account);
            List<Role> roles = roleRepository.getAllRoles();
            roles.forEach(role -> {
                GrantAccess grantAccess = new GrantAccess(account.getAccount_id(), role.getRole_id(), false, "initialize");
                grantAccessRepository.insert(grantAccess);
            });

            trans.commit();
        } catch (Exception exception) {
            trans.rollback();
            logger.log(Level.SEVERE, exception.getMessage() + "\n" + exception.getCause());
        }
    }

    public void update(Account account) {
        try {
            trans.begin();
            em.merge(account);
            trans.commit();
        } catch (Exception exception) {
            trans.rollback();
            logger.log(Level.SEVERE, exception.getMessage() + "\n" + exception.getCause());
        }
    }

    public boolean updateStatus(String account_id, int status) {
        try {
            trans.begin();
            Account acc = em.find(Account.class, account_id);
            if (acc != null)
                acc.setStatus(status);
            trans.commit();
            return true;
        } catch (Exception exception) {
            trans.rollback();
            logger.log(Level.SEVERE, exception.getMessage() + "\n" + exception.getCause());
        }
        return false;
    }

    public Optional<Account> login(String id, String psw) {
        Account acc = em.find(Account.class, id);
        if (acc != null) {
            if (acc.getPassword().equals(psw))
                return Optional.of(acc);
        }
        return Optional.empty();
    }

    public List<Account> getAllAccounts() {
        TypedQuery<Account> acc = em.createQuery("select a from Account a", Account.class);
        return acc.getResultList();
    }
}
