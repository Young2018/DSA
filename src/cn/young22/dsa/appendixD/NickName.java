package cn.young22.dsa.appendixD;

import cn.young22.dsa.appendixC.Name;

public class NickName {

	private Name nick;
	
	public NickName() {
		nick = new Name();
	} // end default constructor

	public String getNick() {
		return nick.getFirst();
	}

	public void setNick(String nickName) {
		nick.setFirst(nickName);
	}
	
	
	
}
