package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;

public interface Action { // 추상 메소드, 상수, (version 확인 필요 : default 메소드, static 메소드)
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
//	이 인터페이스는 servlet과 has a 관계가 될거임
//	이 인터페이스를 사용하는 주체는 servlet => request, response 인자 때문에
//	인터페이스를 선언하는 이유 : 결합도를 낮춤
//	인터페이스 하나당 여러 인터페이스 (다형성)
//	하나의 객체로 여러 객체 생성하고 관리
}