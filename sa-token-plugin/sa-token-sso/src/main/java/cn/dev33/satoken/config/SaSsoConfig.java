package cn.dev33.satoken.config;


import java.io.Serializable;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.util.SaFoxUtil;
import cn.dev33.satoken.util.SaResult;

/**
 * Sa-Token SSO 单点登录模块 配置类 Model 
 * @author kong
 *
 */
public class SaSsoConfig implements Serializable {

	private static final long serialVersionUID = -6541180061782004705L;

	
	// ----------------- Server端相关配置 
	
	/**
	 * Ticket有效期 (单位: 秒) 
	 */
	public long ticketTimeout = 60 * 5;
	
	/**
	 * 所有允许的授权回调地址，多个用逗号隔开 (不在此列表中的URL将禁止下放ticket) 
	 */
	public String allowUrl = "*";

	/**
	 * 是否打开单点注销功能 
	 */
	public Boolean isSlo = true; 
	
	/**
	 * 是否打开模式三（此值为 true 时将使用 http 请求：校验ticket值、单点注销、获取userinfo） 
	 */
	public Boolean isHttp = false; 

	/**
	 * 接口调用秘钥 (用于SSO模式三单点注销的接口通信身份校验) 
	 */
	public String secretkey;

	
	// ----------------- Client端相关配置 

	/**
	 * 配置 Server 端单点登录授权地址 
	 */
	public String authUrl = "/sso/auth";

	/**
	 * 是否打开单点注销功能 
	 */
	// public Boolean isSlo = true;  // 同Server端 

	/**
	 * 是否打开模式三（此值为 true 时将使用 http 请求：校验ticket值、单点注销、获取userinfo） 
	 */
	// public Boolean isHttp = false;  // 同Server端

	/**
	 * 接口调用秘钥 (用于SSO模式三单点注销的接口通信身份校验) 
	 */
	// public String secretkey;  // 同Server端

	/**
	 * 配置 Server 端的 ticket 校验地址 
	 */
	public String checkTicketUrl = "/sso/checkTicket";

	/**
	 * 配置 Server 端查询 userinfo 地址 
	 */
	public String userinfoUrl = "/sso/userinfo";
	
	/**
	 * 配置 Server 端单点注销地址 
	 */
	public String sloUrl = "/sso/signout";

	/**
	 * 配置当前 Client 端的单点注销回调URL （为空时自动获取） 
	 */
	public String ssoLogoutCall;

	/**
	 * 配置 Server 端主机总地址，拼接在 authUrl、checkTicketUrl、userinfoUrl、sloUrl 属性前面，用以简化各种 url 配置 
	 */
	public String serverUrl;

	// ----------------- 其它 

	/**
	 * 接口调用时的时间戳允许的差距（单位：ms），-1代表不校验差距 
	 */
	public long timestampDisparity = 1000  * 60 * 10;




	/**
	 * @return Ticket有效期 (单位: 秒)  
	 */
	public long getTicketTimeout() {
		return ticketTimeout;
	}

	/**
	 * @param ticketTimeout Ticket有效期 (单位: 秒)   
	 * @return 对象自身
	 */
	public SaSsoConfig setTicketTimeout(long ticketTimeout) {
		this.ticketTimeout = ticketTimeout;
		return this;
	}

	/**
	 * @return 所有允许的授权回调地址，多个用逗号隔开 (不在此列表中的URL将禁止下放ticket) 
	 */
	public String getAllowUrl() {
		return allowUrl;
	}

	/**
	 * @param allowUrl 所有允许的授权回调地址，多个用逗号隔开 (不在此列表中的URL将禁止下放ticket) 
	 * @return 对象自身
	 */
	public SaSsoConfig setAllowUrl(String allowUrl) {
		this.allowUrl = allowUrl;
		return this;
	}

	/**
	 * @return 是否打开单点注销功能 
	 */
	public Boolean getIsSlo() {
		return isSlo;
	}

	/**
	 * @param isSlo 是否打开单点注销功能 
	 * @return 对象自身 
	 */
	public SaSsoConfig setIsSlo(Boolean isSlo) {
		this.isSlo = isSlo;
		return this;
	}

	/**
	 * @return isHttp 是否打开模式三（此值为 true 时将使用 http 请求：校验ticket值、单点注销、获取userinfo） 
	 */
	public Boolean getIsHttp() {
		return isHttp;
	}

	/**
	 * @param isHttp 是否打开模式三（此值为 true 时将使用 http 请求：校验ticket值、单点注销、获取userinfo） 
	 * @return 对象自身 
	 */
	public SaSsoConfig setIsHttp(Boolean isHttp) {
		this.isHttp = isHttp;
		return this;
	}

	/**
	 * @return 接口调用秘钥 (用于SSO模式三单点注销的接口通信身份校验)  
	 */
	public String getSecretkey() {
		return secretkey;
	}

	/**
	 * @param secretkey 接口调用秘钥 (用于SSO模式三单点注销的接口通信身份校验)  
	 * @return 对象自身
	 */
	public SaSsoConfig setSecretkey(String secretkey) {
		this.secretkey = secretkey;
		return this;
	}

	/**
	 * @return 配置的 Server 端单点登录授权地址 
	 */
	public String getAuthUrl() {
		return authUrl;
	}

	/**
	 * @param authUrl 配置 Server 端单点登录授权地址  
	 * @return 对象自身
	 */
	public SaSsoConfig setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
		return this;
	}

	/**
	 * @return 配置的 Server 端的 ticket 校验地址  
	 */
	public String getCheckTicketUrl() {
		return checkTicketUrl;
	}

	/**
	 * @param checkTicketUrl 配置 Server 端的 ticket 校验地址  
	 * @return 对象自身
	 */
	public SaSsoConfig setCheckTicketUrl(String checkTicketUrl) {
		this.checkTicketUrl = checkTicketUrl;
		return this;
	}

	/**
	 * @return 配置的 Server 端查询 userinfo 地址 
	 */
	public String getUserinfoUrl() {
		return userinfoUrl;
	}

	/**
	 * @param userinfoUrl 配置 Server 端查询 userinfo 地址 
	 * @return 对象自身 
	 */
	public SaSsoConfig setUserinfoUrl(String userinfoUrl) {
		this.userinfoUrl = userinfoUrl;
		return this;
	}

	/**
	 * @return 配置 Server 端单点注销地址  
	 */
	public String getSloUrl() {
		return sloUrl;
	}

	/**
	 * @param sloUrl 配置 Server 端单点注销地址  
	 * @return 对象自身
	 */
	public SaSsoConfig setSloUrl(String sloUrl) {
		this.sloUrl = sloUrl;
		return this;
	}

	/**
	 * @return 配置当前 Client 端的单点注销回调URL （为空时自动获取） 
	 */
	public String getSsoLogoutCall() {
		return ssoLogoutCall;
	}

	/**
	 * @param ssoLogoutCall 配置当前 Client 端的单点注销回调URL （为空时自动获取）  
	 * @return 对象自身
	 */
	public SaSsoConfig setSsoLogoutCall(String ssoLogoutCall) {
		this.ssoLogoutCall = ssoLogoutCall;
		return this;
	}

	/**
	 * @return 配置的 Server 端主机总地址，拼接在 authUrl、checkTicketUrl、userinfoUrl、sloUrl 属性前面，用以简化各种 url 配置 
	 */
	public String getServerUrl() {
		return serverUrl;
	}

	/**
	 * @param serverUrl 配置 Server 端主机总地址，拼接在 authUrl、checkTicketUrl、userinfoUrl、sloUrl 属性前面，用以简化各种 url 配置 
	 * @return 对象自身
	 */
	public SaSsoConfig setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
		return this;
	}

	/**
	 * @return 接口调用时的时间戳允许的差距（单位：ms），-1代表不校验差距 
	 */
	public long getTimestampDisparity() {
		return timestampDisparity;
	}

	/**
	 * @param timestampDisparity 接口调用时的时间戳允许的差距（单位：ms），-1代表不校验差距 
	 * @return 对象自身 
	 */
	public SaSsoConfig setTimestampDisparity(long timestampDisparity) {
		this.timestampDisparity = timestampDisparity;
		return this;
	}

	@Override
	public String toString() {
		return "SaSsoConfig ["
				+ "ticketTimeout=" + ticketTimeout 
				+ ", allowUrl=" + allowUrl 
				+ ", isSlo=" + isSlo
				+ ", isHttp=" + isHttp 
				+ ", secretkey=" + secretkey 
				+ ", authUrl=" + authUrl 
				+ ", checkTicketUrl=" + checkTicketUrl
				+ ", userinfoUrl=" + userinfoUrl 
				+ ", sloUrl=" + sloUrl 
				+ ", ssoLogoutCall=" + ssoLogoutCall 
				+ ", serverUrl=" + serverUrl 
				+ ", timestampDisparity=" + timestampDisparity 
				+ "]";
	}
	

	// 额外添加的一些函数 
	
	/**
	 * @return 获取拼接url：Server 端单点登录授权地址 
	 */
	public String splicingAuthUrl() {
		return SaFoxUtil.spliceTwoUrl(getServerUrl(), getAuthUrl());
	}

	/**
	 * @return 获取拼接url：Server 端的 ticket 校验地址  
	 */
	public String splicingCheckTicketUrl() {
		return SaFoxUtil.spliceTwoUrl(getServerUrl(), getCheckTicketUrl());
	}

	/**
	 * @return 获取拼接url：Server 端查询 userinfo 地址 
	 */
	public String splicingUserinfoUrl() {
		return SaFoxUtil.spliceTwoUrl(getServerUrl(), getUserinfoUrl());
	}

	/**
	 * @return 获取拼接url：Server 端单点注销地址 
	 */
	public String splicingSloUrl() {
		return SaFoxUtil.spliceTwoUrl(getServerUrl(), getSloUrl());
	}
	
	/**
	 * 以数组形式写入允许的授权回调地址 
	 * @param url 所有集合 
	 * @return 对象自身
	 */
	public SaSsoConfig setAllow(String ...url) {
		this.allowUrl = SaFoxUtil.arrayJoin(url);
		return this;
	}

	
	// -------------------- SaSsoHandle 所有回调函数 -------------------- 
	

	/**
	 * SSO-Server端：未登录时返回的View 
	 */
	public Supplier<Object> notLoginView = () -> {
		return "当前会话在SSO-Server认证中心尚未登录";
	};

	/**
	 * SSO-Server端：登录函数 
	 */
	public BiFunction<String, String, Object> doLoginHandle = (name, pwd) -> {
		return SaResult.error();
	};

	/**
	 * SSO-Client端：自定义校验Ticket返回值的处理逻辑 （每次从认证中心获取校验Ticket的结果后调用）
	 * <p> 参数：loginId, back
	 * <p> 返回值：返回给前端的值 
	 */
	public BiFunction<Object, String, Object> ticketResultHandle = null;

	/**
	 * SSO-Client端：发送Http请求的处理函数 
	 */
	public Function<String, String> sendHttp = url -> {
		throw new SaTokenException("请配置 Http 请求处理器");
	};


	/**
	 * @param notLoginView SSO-Server端：未登录时返回的View 
	 * @return 对象自身
	 */
	public SaSsoConfig setNotLoginView(Supplier<Object> notLoginView) {
		this.notLoginView = notLoginView;
		return this;
	}

	/**
	 * @return 函数 SSO-Server端：未登录时返回的View
	 */
	public Supplier<Object> getNotLoginView() {
		return notLoginView;
	}

	/**
	 * @param doLoginHandle SSO-Server端：登录函数 
	 * @return 对象自身
	 */
	public SaSsoConfig setDoLoginHandle(BiFunction<String, String, Object> doLoginHandle) {
		this.doLoginHandle = doLoginHandle;
		return this;
	}

	/**
	 * @return 函数 SSO-Server端：登录函数
	 */
	public BiFunction<String, String, Object> getDoLoginHandle() {
		return doLoginHandle;
	}

	/**
	 * @param ticketResultHandle SSO-Client端：自定义校验Ticket返回值的处理逻辑 （每次从认证中心获取校验Ticket的结果后调用）
	 * @return 对象自身
	 */
	public SaSsoConfig setTicketResultHandle(BiFunction<Object, String, Object> ticketResultHandle) {
		this.ticketResultHandle = ticketResultHandle;
		return this;
	}

	/**
	 * @return 函数 SSO-Client端：自定义校验Ticket返回值的处理逻辑 （每次从认证中心获取校验Ticket的结果后调用）
	 */
	public BiFunction<Object, String, Object> getTicketResultHandle() {
		return ticketResultHandle;
	}

	/**
	 * @param sendHttp SSO-Client端：发送Http请求的处理函数 
	 * @return 对象自身 
	 */
	public SaSsoConfig setSendHttp(Function<String, String> sendHttp) {
		this.sendHttp = sendHttp;
		return this;
	}

	/**
	 * @return 函数 SSO-Client端：发送Http请求的处理函数
	 */
	public Function<String, String> getSendHttp() {
		return sendHttp;
	}

	
}
