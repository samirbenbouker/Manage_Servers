package com.samirbenbouker.server.service;

import java.io.IOException;
import java.util.Collection;

import com.samirbenbouker.server.model.Server;

public interface ServerService {
	
	public Server createServer(Server server);
	public Server getPingServer(String ipAddress) throws IOException;
	public Collection<Server> getAllServers(int limit);
	public Server getServer(Long id);
	public Server updateServer(Server server);
	public Boolean deleteServer(Long id);
	
}
