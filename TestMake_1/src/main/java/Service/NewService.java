package Service;

import DAO.NewDao;
import spring.LoginData;
import spring.RegisterData;

public class NewService {
	
	private NewDao dao;
	
	public NewService(NewDao dao) {
		this.dao = dao;
	}
	
	public void insert(RegisterData rd)
	{
		dao.insert(rd);
	}
	
	public int checkCount(LoginData ld)
	{
		System.out.println(ld.getId()+"    "+ld.getPassword());
		int count = dao.checkCount(ld.getId(), ld.getPassword());
		return count;
	}
	
	
}




