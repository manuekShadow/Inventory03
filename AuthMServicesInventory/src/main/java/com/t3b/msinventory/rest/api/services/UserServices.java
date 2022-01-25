package com.t3b.msinventory.rest.api.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.t3b.msinventory.AuthMServicesInventoryApplication;
import com.t3b.msinventory.rest.api.entities.custom.UsuarioOAUTH;
import com.t3b.msinventory.rest.api.repository.UsuarioRepository;

@Service
public class UserServices implements UserDetailsService {
	private static Logger LOG = LoggerFactory.getLogger(AuthMServicesInventoryApplication.class);

	@Autowired
	@Qualifier("UsuarioByQuery")
	UsuarioRepository usarioRepository;
	private @Autowired HttpServletRequest request;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDet;

		//Se debe de descomentar para Usar cuando se requiera validar un useq de la tabla fuser		
		List<UsuarioOAUTH> us = null;
		/*try {
			us = usarioRepository.getUserByLogin(username);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		us = new ArrayList<UsuarioOAUTH>();
		UsuarioOAUTH oauth = new UsuarioOAUTH();
		oauth.setUlogin("ggodoy");
		oauth.setUpassword("g5godoy");
		
		us.add(oauth);
		
		String password = request.getParameter("password");
		LOG.info("El valor de la contraseña del REST es: " + password);
		
		List<SimpleGrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		roles.add(new SimpleGrantedAuthority("USER"));
		roles.add(new SimpleGrantedAuthority("USER_SCANNER"));

		//if (getMD5(password).equals(String.valueOf(us.get(0).getUpassword()))) {
		if (password.equals(String.valueOf(us.get(0).getUpassword()))) {
			LOG.info("El valor de la contraseña coincide");
			LOG.info("El valor de la contraseña de la DB es: " + us.get(0).getUpassword());
			userDet = new User(String.valueOf(us.get(0).getUlogin()), new BCryptPasswordEncoder().encode(password), roles);
			LOG.info("SE REGISTRA A " + userDet.getPassword() + new BCryptPasswordEncoder().encode(password)+ userDet.getUsername() + userDet.getAuthorities());
		} else {
			LOG.info("El valor de la contraseña es diferente");
			LOG.info("El valor de la contraseña de la DB es: " + us.get(0).getUpassword());
			userDet = new User(String.valueOf(us.get(0).getUlogin()), new BCryptPasswordEncoder().encode(String.valueOf(us.get(0).getUpassword())), roles);
		}
		return userDet;
	}

	//Metodo para encriptar Contraseña a MD5
	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			LOG.info("La contraseña del servlet encriptada es: " + " - " + hashtext);
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}