package Service;

import DAO.NewDao;
import spring.RegisterData;

public class NewService {
	
	private NewDao dao;
	
	public NewService(NewDao dao) {
		this.dao = dao;
	}
	
	public void insert(RegisterData rd)
	{
//		dao.insert(rd);
	}
	
	
}




