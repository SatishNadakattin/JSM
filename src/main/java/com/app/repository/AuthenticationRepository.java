package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.entity.Authentication;

public interface AuthenticationRepository extends CrudRepository<Authentication, Long>{

	
	List<Authentication> findByUsernameAndLoginType(String username , String logintype);
	
	@Query(value = "select username as username , password as password from ex_authentication  where username = ?1 AND login_type = ?2", nativeQuery = true)
	public UserDetails findByUser(String username , String logintype);
}