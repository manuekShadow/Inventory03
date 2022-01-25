package com.t3b.msinventory.rest.api.db;

public interface IInventory {
	
	public static String SP_FN_INSERTORDERINVENTORY = "{ call dba.INVMOV_SP_FN_INSERTORDERINVENTORY('?','?',?,?,?,?,'?',?,?,?,'?','?','?',?,'?',?,'?')}";
	
	//public static String SP_FN_INSERTORDER = "{call INVMOV_SP_FN_INSERTINFOOAUTH(?)}";
	
	public static String SP_FN_INSERTORDER = "{call INVMOV_SP_FN_INSERTINFOOAUTH('?','?',?,?,'?',?,?,'?',?,?,?,'?','?','?',?,'?',?,'?')}";
	
	public static String INSERT_ORDER = "insert into dba.boa_conteos_nube values ('?','?',?,?,?,'?','?',?,'?','?','?',?,?,?,?,?,'?');";

	public static String CONSULT_FOLIOORDER = "{call INVMOV_SP_FN_CONSULTFOLIO('?','?')}";

}
