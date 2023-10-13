package factory;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FactoryService {
//	SqlSessionFactory를 사용해서 MyBatis의 환경설정 (config.xml) 읽어와서
//	SqlSession을 통해서 mapper.xml에 정의한 sql문을 사용 / 값을 전달하거나 받기위한 목적
	private static SqlSessionFactory factory;
	
	static { // static 초기화
		try(Reader reader = Resources.getResourceAsReader("config/config.xml");) {
			factory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getFactory() {
		return factory;
	}
}