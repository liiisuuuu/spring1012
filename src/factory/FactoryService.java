package factory;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FactoryService {
//	SqlSessionFactory�� ����ؼ� MyBatis�� ȯ�漳�� (config.xml) �о�ͼ�
//	SqlSession�� ���ؼ� mapper.xml�� ������ sql���� ��� / ���� �����ϰų� �ޱ����� ����
	private static SqlSessionFactory factory;
	
	static { // static �ʱ�ȭ
		try(Reader reader = Resources.getResourceAsReader("config/config.xml");) {
			factory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getFactory() {
		return factory;
	}
}