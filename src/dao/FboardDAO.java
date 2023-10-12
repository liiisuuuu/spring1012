package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.FboardDTO;
import factory.FactoryService;

public class FboardDAO {
	private static FboardDAO dao;

	private FboardDAO() { // �����ڴ� ������ private
	}

	public synchronized static FboardDAO getDao() {
//		�̱��� �۾�
		if (dao == null) {
			dao = new FboardDAO();
		}
//		�������� �ѹ� ���ʷ� �������ְ� �������ʹ� return�ؼ� ��� (static)
		return dao;
	}
//	insert
	public void addFboard(FboardDTO vo) {
		SqlSession ss = FactoryService.getFactory().openSession(true); // ���¼������� sql���� �޾Ƴ� => true:autocommit;
//		���۷����� ss �� ���
		
		ss.insert("fb.add", vo);
//		ss.commit();
		ss.close();
	}
	
//	select
	public List<FboardDTO> listFboard() {
		SqlSession ss = FactoryService.getFactory().openSession(true);
		List<FboardDTO> list = ss.selectList("fb.list");
		ss.close();
		return list;
	}
}
