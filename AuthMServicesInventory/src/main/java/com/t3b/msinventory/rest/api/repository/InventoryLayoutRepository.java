package com.t3b.msinventory.rest.api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.t3b.msinventory.rest.api.entities.custom.InventoryLayout;

@Repository
public class InventoryLayoutRepository {
	//@Autowired
	//private JdbcTemplate jdbcTemplate;
	
	//private String sql;
	
	public List<InventoryLayout> getInfoLayoutAll() {

		List<InventoryLayout> accionList = null;
		
		accionList = new ArrayList<>();
		InventoryLayout i1 = new InventoryLayout("1","Prohogar_LAB","2296","Hielo Iglu","5 Kg","7501882621145","Ice","Prueba","0","1","7501035109095");
		InventoryLayout i2 = new InventoryLayout("1","Prohogar_LAB","	2296","	Hielo Fiesta","5 kg","7501035109094","Ice","Prueba","0","1","7501035109096");
		InventoryLayout i3 = new InventoryLayout("1","Prohogar_LAB","	2296","	Hielo Fiesta","5 kg","43320176884","Ice","Prueba","0","1","7501035109097");
		InventoryLayout i4 = new InventoryLayout("1","Prohogar_LAB","	9451","	Hielo l Purisima","5 kg","501553310002","Ice","Inactivo","0","1","7501035109098");
		InventoryLayout i5 = new InventoryLayout("1","Prohogar_LAB","	9934","	Hielo Cryspuraice","5 kg","7501362800046","Ice","Inactivo","0","1","7501035109099");
		InventoryLayout i6 = new InventoryLayout("1","Prohogar_LAB","	10423","Hielo La Nacional","5 kg","7503008051010","Ice","Inactivo","0","1","7501035109100");
		InventoryLayout i7 = new InventoryLayout("1","Prohogar_LAB","	14376","Hielo Bajo Cero","5 kg","7501402600018","Ice","Inactivo","0","1","7501035109101");
		InventoryLayout i8 = new InventoryLayout("1","Prohogar_LAB","	14289","Hielo La Higienica","5 kg","7502261269927","Ice","Desplazable","0","1","7501035109102");
		InventoryLayout i9 = new InventoryLayout("1","Prohogar_LAB","	14290","Hielo La Higienica 2 nuevo","5 kg","22110079806","Ice","Desplazable","0","1","7501035109103");
		InventoryLayout i10 = new InventoryLayout("1","Prohogar_LAB","	14291","Hielo La HigienicaRes","5 kg","7502261269928","Ice","Desplazable","0","1","7501035109104");
		
		accionList.add(i1);
		accionList.add(i2);
		accionList.add(i3);
		accionList.add(i4);
		accionList.add(i5);
		accionList.add(i6);
		accionList.add(i7);
		accionList.add(i8);
		accionList.add(i9);
		accionList.add(i10);
		
		return accionList;
	}

	public List<InventoryLayout> getInfoLayoutByClaveTienda(String claveTienda) {
		List<InventoryLayout> inventarioFilter = null;
		inventarioFilter = new ArrayList<>();
		if(claveTienda.equals("105")) {
			inventarioFilter =  getInfoLayoutAll();			
		}else{
			inventarioFilter = null;
		}

		return inventarioFilter;
	}
	
	/*
	public ModelUserInfo getInfoLayoutAll(String username) {
		ModelUserInfo response = null;
		if (username == null) {
			response = new ModelUserInfo();
			response.setCode(300);
			response.setStatus(false);
			response.setMensaje("El Usuario " + username + " consultado no cuenta con informacion");
			response.setUserInfoResponse(null);

		} else {
			sql = Constants.SQL_USER_INFO;
			sql = sql.replace("?", String.valueOf(username));
			System.out.println("Consulta SQL" + sql);
		}
		List<com.t3b.msinventory.rest.api.entities.custom.Usuario> userInfoList = new ArrayList<>();
		// Mapeo de Consulta optimizada
		try {
			userInfoList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<com.t3b.msinventory.rest.api.entities.custom.Usuario>(com.t3b.msinventory.rest.api.entities.custom.Usuario.class));
			if (userInfoList.size() > 0 || !userInfoList.isEmpty()) {
				for (int i = 0; i < userInfoList.size(); i++) {
					System.out.println("Se realizo consulta Exitosa : " + userInfoList.get(i).getUseq() + " - "
							+ userInfoList.get(i).getUlogin());
				}
			} else {
				userInfoList = null;
				System.out.println("Se realizo consulta, no se encontraron coincidencias");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Consulta SQL" + e.getMessage().toString());
		}

		response = new ModelUserInfo();
		response.setCode(200);
		response.setStatus(true);
		response.setMensaje("La region " + username + " consultado cuenta con informacion");
		response.setUserInfoResponse(userInfoList.get(0));

		return response;
	}*/

}
