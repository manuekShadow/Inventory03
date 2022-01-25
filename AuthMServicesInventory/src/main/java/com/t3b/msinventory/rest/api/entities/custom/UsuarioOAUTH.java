package com.t3b.msinventory.rest.api.entities.custom;

public class UsuarioOAUTH {
		
		public String ulogin;
		public String upassword;
		
		public String getUlogin() {
			return ulogin;
		}
		public void setUlogin(String ulogin) {
			this.ulogin = ulogin;
		}
		public String getUpassword() {
			return upassword;
		}
		public void setUpassword(String upassword) {
			this.upassword = upassword;
		}
		@Override
		public String toString() {
			return "UsuarioOAUTH [ulogin=" + ulogin + ", upassword=" + upassword + ", getUlogin()=" + getUlogin()
					+ ", getUpassword()=" + getUpassword() + "]";
		}
		public UsuarioOAUTH(String ulogin, String upassword) {
			super();
			this.ulogin = ulogin;
			this.upassword = upassword;
		}
		public UsuarioOAUTH() {
			
		}

		
}
