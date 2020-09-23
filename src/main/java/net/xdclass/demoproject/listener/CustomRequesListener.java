package net.xdclass.demoproject.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class CustomRequesListener implements ServletRequestListener {
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("requestDestroyed+++++++++++");

	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("requestInitialized+++++++++++");

	}
}
