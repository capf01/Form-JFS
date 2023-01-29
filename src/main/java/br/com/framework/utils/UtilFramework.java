package br.com.framework.utils;

import java.io.Serializable;

public class UtilFramework implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();

	public synchronized static ThreadLocal<Long> getThreadLocal() {
		return threadLocal;
	}// Separa o usuário que está fazendo as alterações 
}
