package controller;

import action.Action;
import action.FBoardAction;

public class ActionFactory {
	// �� �������ִ� ���� ��ü -> ���������� ���� ������
	// �߾� ������
	
	private static ActionFactory factory;
	private ActionFactory() {
	}
	
//	�̱���
	public synchronized static ActionFactory getFactory() {
		if (factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}
	
//	� ������ ȣ���ߴ��� equals �� Ȯ��
//	��û�� ���� ��ü ���� �� �������̽��� ��ȯ
	public Action getAction(String cmd) {
		Action action = null;
		
		if (cmd.equals("fboard")) {
			action = new FBoardAction();
		}
		
		return action;
	}
}