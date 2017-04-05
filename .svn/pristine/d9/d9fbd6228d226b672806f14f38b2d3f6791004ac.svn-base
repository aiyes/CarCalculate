package com.chinalife.sz.carcalculate.security;

/**
 * 用户和密码（包含验证码）令牌类
 * @author MarsCheng
 * @email chengjie@sz.chinalife-p.com.cn
 * @create_date 2016年12月8日
 *
 */
public class UsernamePasswordToken extends org.apache.shiro.authc.UsernamePasswordToken {

	private static final long serialVersionUID = 1L;

	private String captcha;
	
	public UsernamePasswordToken() {
		super();
	}

	public UsernamePasswordToken(String username, String password,String captcha) {
		super(username, password);
		this.captcha = captcha;
	}
	
	public UsernamePasswordToken(String username, char[] password,
			boolean rememberMe, String host, String captcha) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
}