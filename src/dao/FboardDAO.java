package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.FboardDTO;
import factory.FactoryService;

public class FboardDAO {
	private static FboardDAO dao;

	private FboardDAO() { // 생성자는 무조건 private
	}

	public synchronized static FboardDAO getDao() {
//		싱글톤 작업
		if (dao == null) {
			dao = new FboardDAO();
		}
//		없을때만 한번 최초로 생성해주고 다음부터는 return해서 사용 (static)
		return dao;
	}
//	insert
	public void addFboard(FboardDTO vo) {
		SqlSession ss = FactoryService.getFactory().openSession(true); // 오픈세션으로 sql세션 받아냄 => true:autocommit;
//		레퍼런스는 ss 로 사용
		
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
