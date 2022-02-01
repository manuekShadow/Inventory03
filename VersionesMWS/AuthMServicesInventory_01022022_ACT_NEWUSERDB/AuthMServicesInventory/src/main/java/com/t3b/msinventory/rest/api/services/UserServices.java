package com.t3b.msinventory.rest.api.services;

import java.sql.SQLException;
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
		UserDetails userDet = null;

		//Se debe de descomentar para Usar cuando se requiera validar un useq de la tabla fuser		
		List<UsuarioOAUTH> us = null;
		us = new ArrayList<UsuarioOAUTH>();

		try {
			us = usarioRepository.getUserByLogin(username);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UsuarioOAUTH oauth = new UsuarioOAUTH();
		oauth.setUlogin(us.get(0).ulogin);
		oauth.setUpassword(us.get(0).upassword);
		
		us.add(oauth);
		
		String password = request.getParameter("password");
		LOG.info("El valor de la contraseña del REST es: " + password);
		
		List<SimpleGrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		roles.add(new SimpleGrantedAuthority("USER"));
		roles.add(new SimpleGrantedAuthority("USER_SCANNER"));

		if (password.equals(getValidateUpassword(us.get(0).getUpassword()))) {
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

	
	//Metodo para encriptar Contraseña a Sybases GGODOY - 01/02/2022
	
	public static String getValidateUpassword(String upassword){
		String ls_cadena="",ls_passwd="";
		
		String str = upassword;

		//Recorrer la cadena
		for (int n = 0; n <(str.trim()).length(); n ++) { 
			char c = str.charAt (n);
			
			//Comparacion de caracteres
			switch(c)
		    {
		        case 'a':
		        	ls_cadena=ls_cadena + "e";
		        	break;
		        case 'b':
		        	ls_cadena=ls_cadena + "d";
		        	break;
		        case 'c':
		        	ls_cadena=ls_cadena + "c";
		        	break;
		        case 'd':
		        	ls_cadena=ls_cadena + "b";
		        	break;
		        case 'e':
		        	ls_cadena=ls_cadena + "a";
		        	break;
		        	
		        	
		        case 'f':
		        	ls_cadena=ls_cadena + "j";
		        	break;
		        case 'g':
		        	ls_cadena=ls_cadena + "i";
		        	break;
		        case 'h':
		        	ls_cadena=ls_cadena + "h";
		        	break;
		        case 'i':
		        	ls_cadena=ls_cadena + "g";
		        	break;
		        case 'j':
		        	ls_cadena=ls_cadena + "f";
		        	break;
		        	
		        	
		        case 'k':
		        	ls_cadena=ls_cadena + "ñ";
		        	break;
		        case 'l':
		        	ls_cadena=ls_cadena + "n";
		        	break;
		        case 'm':
		        	ls_cadena=ls_cadena + "m";
		        	break;
		        case 'n':
		        	ls_cadena=ls_cadena + "l";
		        	break;
		        case 'ñ':
		        	ls_cadena=ls_cadena + "k";
		        	break;
		        	
		        	
		        case 'o':
		        	ls_cadena=ls_cadena + "s";
		        	break;
		        case 'p':
		        	ls_cadena=ls_cadena + "r";
		        	break;
		        case 'q':
		        	ls_cadena=ls_cadena + "q";
		        	break;
		        case 'r':
		        	ls_cadena=ls_cadena + "p";
		        	break;
		        case 's':
		        	ls_cadena=ls_cadena + "o";
		        	break;
		        	
		        	
		        case 't':
		        	ls_cadena=ls_cadena + "z";
		        	break;
		        case 'u':
		        	ls_cadena=ls_cadena + "y";
		        	break;
		        case 'v':
		        	ls_cadena=ls_cadena + "x";
		        	break;
		        case 'w':
		        	ls_cadena=ls_cadena + "w";
		        	break;
		        case 'x':
		        	ls_cadena=ls_cadena + "v";
		        	break;
		        case 'y':
		        	ls_cadena=ls_cadena + "u";
		        	break;
		        case 'z':
		        	ls_cadena=ls_cadena + "t";
		        	break;
		        	
		        	
		        case '1':
		        	ls_cadena=ls_cadena + "5";
		        	break;
		        case '2':
		        	ls_cadena=ls_cadena + "4";
		        	break;
		        case '3':
		        	ls_cadena=ls_cadena + "3";
		        	break;
		        case '4':
		        	ls_cadena=ls_cadena + "2";
		        	break;
		        case '5':
		        	ls_cadena=ls_cadena + "1";
		        	break;
		        	
		        	
		        case '6':
		        	ls_cadena=ls_cadena + "0";
		        	break;
		        case '7':
		        	ls_cadena=ls_cadena + "9";
		        	break;
		        case '8':
		        	ls_cadena=ls_cadena + "8";
		        	break;
		        case '9':
		        	ls_cadena=ls_cadena + "7";
		        	break;
		        case '0':
		        	ls_cadena=ls_cadena + "6";
		        	break;
		        	
		        default:
		        	LOG.info("no coincide");
		            //System.out.println("no coincide");
		    }

			//Suma de caracteres recolectados
			ls_passwd = ls_cadena;
			//Impresion de caracteres en consola
			//System.out.println (newStr); 
			LOG.info("La suma de caracteres para la nueva contraseña es: " + " - " + ls_passwd);
			}				
		//Impresion de la nueva contraseña en consola
		LOG.info("La contraseña final transformda es: " + " - " + ls_passwd);
		return ls_passwd;
	}
	
}