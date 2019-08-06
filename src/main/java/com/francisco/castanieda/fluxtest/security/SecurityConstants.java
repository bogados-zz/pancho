package com.francisco.castanieda.fluxtest.security;

public abstract class SecurityConstants {
	public static final String SECRET = "SecretKeyToGenJWTs";
	public static final long EXPIRATION_TIME = 864_000_000; // 10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/users";
	public static final String SCHEDULE_URL = "/alarms/schedule";
	public static final String[] SWAGGER_WHITELIST = { "/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs", "/webjars/**" };
}
