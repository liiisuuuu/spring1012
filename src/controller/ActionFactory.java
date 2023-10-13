package controller;

import action.Action;
import action.FBoardAction;

public class ActionFactory {
	// 모델 관리해주는 관리 객체 -> 스프링으로 가면 없어짐
	// 중앙 관리자
	
	private static ActionFactory factory;
	private ActionFactory() {
	}
	
//	싱글톤
	public synchronized static ActionFactory getFactory() {
		if (factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}
	
//	어떤 페이지 호출했는지 equals 로 확인
//	요청에 따른 객체 조립 후 인터페이스로 반환
	public Action getAction(String cmd) {
		Action action = null;
		
		if (cmd.equals("fboard")) {
			action = new FBoardAction();
		}
		
		return action;
	}
}