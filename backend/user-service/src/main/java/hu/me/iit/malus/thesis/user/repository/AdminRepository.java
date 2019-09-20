package hu.me.iit.malus.thesis.user.repository;

import hu.me.iit.malus.thesis.user.model.Admin;

import java.util.List;

/**
 * Spring Data repository, that handles all db operations for Admin objects
 * @author Javorek Dénes
 */
public interface AdminRepository extends UserBaseRepository<Admin> {
    List<Admin> findAllBy();
}
