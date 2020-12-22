package com.app.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.config.JwtTokenUtil;
import com.app.entity.Authentication;
import com.app.entity.Users;
import com.app.repository.AuthenticationRepository;
import com.app.repository.UsersRepository;
import com.app.request.Login;
import com.app.service.LoginService;
import com.app.util.AutoManager;
import com.app.util.EncryptionAndDecryption;

@Service
@Transactional
public class LoginImpl  extends AutoManager implements UserDetailsService , LoginService{
		
	private static Logger logger = LoggerFactory.getLogger("master-log");
	
	@Autowired
	private  UsersRepository UserRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationRepository authenticationRepository;
	
	@Autowired
	private EncryptionAndDecryption EncryptionAndDecryption;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = UserRepository.findByUser(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
	}
	
	
		@Override
		public Map<String, Object> login(Login login) {
			Map<String, Object> info = new LinkedHashMap<>();
			Map<String, Object> info1 = new LinkedHashMap<>();
			try {
				LinkedList dataList = new LinkedList();     				
				//String serverurl = commonHelper.getSettingValue("SERVER_IP");
		
			
				if(login.getLoginType().equalsIgnoreCase("admin")) {
					String dcrypt =EncryptionAndDecryption.getDecryptedStringaddhexkey(login.getPassword().trim());
					List<Users> task = super.users.findByUsernameAndPassword( login.getUserName(), dcrypt);
					if(task.size() >0) {
					
							List dataList1 = new LinkedList();
							for (Users e : task) {
								List college = new LinkedList();
								List collegeId = new LinkedList();
								Map<Object, Object>data = new HashMap<Object, Object>(); //

								
								
								
								
					
							info.put("name", task.get(0).getName());	
							info.put("username", task.get(0).getUsername());						
							info.put("emailId", task.get(0).getEmailId());
							info.put("mobile", task.get(0).getMobile());
							//info.put("exPhoto",(task.get(0).getExPhoto() == null || task.get(0).getExPhoto()== "NA")?"NA" :serverurl+task.get(0).getExPhoto() );	
							info.put("loginType", "admin");
							info.put("slno", task.get(0).getSlno());
									//	info.put("token", login.getToken());
							info.put("token", getToken(login.getUserName() , login.getUserName() , login.getLoginType()));
							dataList1.add(info);
							info1.put("status", "1");
							info1.put("message","User login successfully");	
							info1.put("details", dataList1);	

							return info1;
							}
						
					}
					
					info.put("status", "2");
					info.put("message", "Invalid username or password");
					return info;
				}	
				info.put("status", "2");
				info.put("message", "Invalid login type");
				return info;								
			}catch(Exception e) {
				e.printStackTrace();
				logger.error("Exception occured" + e);
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				logger.error(errors.toString());
				info.put("status", "0");
				info.put("message", "Something went wrong");
				return info;
			}
		}
		

		private void authenticate(String username, String password) throws Exception {
			try {
				Objects.requireNonNull(username);
				Objects.requireNonNull(password);
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			} catch (DisabledException e) {
				throw new Exception("USER_DISABLED", e);
			} catch (BadCredentialsException e) {
				throw new Exception("INVALID_CREDENTIALS", e);
			}
		}
		
		@SuppressWarnings("unused")
		private String getToken(String username , String password , String logintype) throws Exception {
			// check username present 
			List<Authentication> task  = authenticationRepository.findByUsernameAndLoginType(username, logintype);
			if(task.size() <=0) {
				String encodedPassword = new BCryptPasswordEncoder().encode(password);
				Date date = new Date();
				// Insert new record into table
				Authentication aouth  = new Authentication();
				aouth.setLoginType(logintype);
				aouth.setUsername(username);
				aouth.setPassword(encodedPassword);
				authenticationRepository.save(aouth);			
			}
			
			authenticate(username,password);		
			final UserDetails userDetails = loadUserByUsername(username);		
			final String token = jwtTokenUtil.generateToken(userDetails ,logintype);		
			return token;
		}

		
	//	@Override
		public UserDetails loadUserByUsernameAndType(String username, String userType) {
			UserDetails user = authenticationRepository.findByUser(username, userType);		
			if (user == null) {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					new ArrayList<>());
		}

		


}


	
	
	
