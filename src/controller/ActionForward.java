package controller;

public class ActionForward {
	private String url; // ���� ������ �� �̵��� viewName
	private boolean method; // ���� ���� �� �̵��� �̵� ��� - forward redirect
	
//	hollo, false(foward), true(redirect)
	public ActionForward(String url, boolean method) {
		super();
		this.url = url;
		this.method = method;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isMethod() {
		return method;
	}
	public void setMethod(boolean method) {
		this.method = method;
	}
}