package com.kingfishertom.snobs;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;

public class SnobsTests {

	public static EmbeddedServer server;
	public static HttpClient client;

	public void init() {
		server = ApplicationContext.run(EmbeddedServer.class);
		client = server.getApplicationContext().createBean(HttpClient.class, server.getURL());
	}

	public void stop() {
		if (server != null) {
			server.stop();
		}
		if (client != null) {
			client.stop();
		}
	}

}
