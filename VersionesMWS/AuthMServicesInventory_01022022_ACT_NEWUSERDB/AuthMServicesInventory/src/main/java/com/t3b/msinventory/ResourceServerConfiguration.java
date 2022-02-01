package com.t3b.msinventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t3b.msinventory.rest.api.services.DataServices;


@EnableResourceServer
@RestController
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	//Base del MicroServicio

@Autowired
	DataServices dataServices;

	@RequestMapping("/publica")
	public String publico() {
		return "Pagina Publica";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "Pagina Administrador";
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/oauth/token", "/oauth/authorize**", "/publica").permitAll();
//		 .anyRequest().authenticated();

		
		http.requestMatchers()
				.and().requestMatchers().antMatchers("/admin") // Denegamos el acceso a "/admin"
				.and().authorizeRequests().antMatchers("/admin").hasAuthority("ADMIN")
				
				//Informacion de Usuario Logeado
				.and().requestMatchers().antMatchers("/usuarios/{usario}") // Denegamos el acceso a "/privada"
				.and().authorizeRequests().antMatchers("/usuarios/{usuario}").hasAuthority("ADMIN")

				//Informacion del Layout cargado en almacen
				.and().requestMatchers().antMatchers("/inventory/layoutInventory") // Denegamos el acceso a "/privada"
				.and().authorizeRequests().antMatchers("/inventory/layoutInventory").hasAuthority("ADMIN")
				
				//Informacion del Layout cargado en almacen
				.and().requestMatchers().antMatchers("/inventory/layoutInventory/{claveTienda}") // Denegamos el acceso a "/privada"
				.and().authorizeRequests().antMatchers("/inventory/layoutInventory/{claveTienda}").hasAuthority("ADMIN")
		
				//Insert Informacion de Orden Inventariada por Movil
				.and().requestMatchers().antMatchers("/inventory/insertOrderInventory") // Denegamos el acceso a "/privada"
				.and().authorizeRequests().antMatchers("/inventory/insertOrderInventory").hasAuthority("ADMIN")
		

				//Insert Informacion de Orden Inventariada por Movil
				.and().requestMatchers().antMatchers("/inventory/folioOrdenDevices/{fecha}/{id_scanner}") // Denegamos el acceso a "/privada"
				.and().authorizeRequests().antMatchers("/inventory/folioOrdenDevices/{fecha}/{id_scanner}").hasAuthority("ADMIN")
				
				//Insert Informacion de Orden Inventariada por Movil
				.and().requestMatchers().antMatchers("/inventory/OrderInventory") // Denegamos el acceso a "/privada"
				.and().authorizeRequests().antMatchers("/inventory/OrderInventory").hasAuthority("ADMIN");
			
	//33
	
	}


}
