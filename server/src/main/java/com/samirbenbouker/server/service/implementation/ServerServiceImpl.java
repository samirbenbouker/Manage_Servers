package com.samirbenbouker.server.service.implementation;

import java.io.IOError;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.samirbenbouker.server.enumeration.Status;
import com.samirbenbouker.server.model.Server;
import com.samirbenbouker.server.repository.ServerRepo;
import com.samirbenbouker.server.service.ServerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService{

	private final ServerRepo serverRepo;
	
	public ServerServiceImpl(ServerRepo serverRepo) {
		this.serverRepo = serverRepo;
	}
	
	// Create a new Server
	@Override
	public Server createServer(Server server) {
		server.setImageUrl(setServerImageUrl());
		return serverRepo.save(server);
	}

	// Get ping server by ip address
	@Override
	public Server getPingServer(String ipAddress) throws IOException{
		Server server = findByIpAddress(ipAddress);
		if(server == null) {
			throw new IllegalStateException("SERVER NULL");
		}
		
		InetAddress address = InetAddress.getByName(ipAddress);
		server.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
		serverRepo.save(server);
		
		return server;
	}

	// Get all servers with a limit
	@Override
	public Collection<Server> getAllServers(int limit) {
		return serverRepo.findAll(PageRequest.of(0, limit)).toList();
	}

	// Get Server by id
	@Override
	public Server getServer(Long id) {
		return serverRepo.findById(id).get();
	}

	// Update server
	@Override
	public Server updateServer(Server server) {
		return serverRepo.save(server);
	}

	// Delete server by id server
	@Override
	public Boolean deleteServer(Long id) {
		serverRepo.deleteById(id);
		return true;
	}
	
	private String setServerImageUrl() {
		return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/server1.png").toUriString();
	}
	
	private Server findByIpAddress(String ipAddress) {
		List<Server> servers = serverRepo.findAll();
		for (Server server : servers) {
			if(server.getIpAddress().equals(ipAddress)) {
				return server;
			}
		}
		
		return null;
	}

}
