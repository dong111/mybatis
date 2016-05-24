package cn.dong111.pojo;

import java.util.List;

/**
 * 用户查询信息vo
 * @author chendong
 *
 */
public class UserQueryVo {
	
	//传入多个ids
	private List<Integer> ids;
	
	private UserCustom userCustom;
	
	
	
	

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	
	

}
