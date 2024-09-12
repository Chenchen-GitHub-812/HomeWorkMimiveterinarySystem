package daO;

public interface IdGenerator_dao {
	
	//從sql查最大的編號
	 void loadCurrentMaxId (String sqlTable);

}
