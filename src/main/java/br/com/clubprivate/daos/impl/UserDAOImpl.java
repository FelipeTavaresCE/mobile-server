package br.com.clubprivate.daos.impl;

import br.com.clubprivate.daos.UserDAO;
import br.com.clubprivate.models.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends DAOImpl<User, Long> implements UserDAO {
}
