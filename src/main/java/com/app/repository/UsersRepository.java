package com.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.app.entity.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {
	
	List<Users> findByUsername(String username);

	List<Users> findByUsernameAndPassword(String userName, String trim);

	@Query(value = "select username as username , password as password from gen_std_authentication  where username = ?1", nativeQuery = true)
	public UserDetails findByUser(String username);


	@Modifying
	@Transactional
	@Query(value = "update gen_std_users set password = ?1 where username =?2", nativeQuery = true)
	int updateusersPassword(String newpassworddcrypt, String username);
	
}