package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;

public interface Action { // �߻� �޼ҵ�, ���, (version Ȯ�� �ʿ� : default �޼ҵ�, static �޼ҵ�)
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
//	�� �������̽��� servlet�� has a ���谡 �ɰ���
//	�� �������̽��� ����ϴ� ��ü�� servlet => request, response ���� ������
//	�������̽��� �����ϴ� ���� : ���յ��� ����
//	�������̽� �ϳ��� ���� �������̽� (������)
//	�ϳ��� ��ü�� ���� ��ü �����ϰ� ����
}