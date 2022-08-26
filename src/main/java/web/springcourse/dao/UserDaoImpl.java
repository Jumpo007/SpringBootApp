package web.springcourse.dao;

import org.springframework.stereotype.Repository;
import web.springcourse.models.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<User> index() {
        return entityManager.createQuery("select u from User u", User.class)
                .getResultList();
    }
    public User showUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(int id) { entityManager.remove(showUser(id)); }

}


