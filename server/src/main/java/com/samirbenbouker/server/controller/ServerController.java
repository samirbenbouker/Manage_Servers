package com.samirbenbouker.server.controller;

import static java.time.LocalDate.now;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samirbenbouker.server.enumeration.Status;
import com.samirbenbouker.server.model.Response;
import com.samirbenbouker.server.model.Server;
import com.samirbenbouker.server.service.implementation.ServerServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/server")
@RequiredArgsConstructor
public class ServerController {
	
	private final ServerServiceImpl serverServiceImpl;
	
	public ServerController(ServerServiceImpl serverServiceImpl) {
		this.serverServiceImpl = serverServiceImpl;
	}
	
	// This end point return servers
	@GetMapping("/list")
	public Response getServers() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		return new Response(now(), OK.value(), OK, "", "Servers retrived", "Servers retrived", Map.of("servers", serverServiceImpl.getAllServers(30)));
	}
	
	// This end point return a one server by id
	@GetMapping("/get/{id}")
	public Response getServer(@PathVariable("id") Long id){
		return new Response(now(), OK.value(), OK, "", "Server retrieved", "Server retrieved", Map.of("servers", serverServiceImpl.getServer(id)));
	}
	
	// This end point return servers by ipAddress 
	@GetMapping("/ping/{ipAddress}")
	public Response getServers(@PathVariable("ipAddress") String ipAddress) throws IOException {
		Server server = serverServiceImpl.getPingServer(ipAddress);
		return new Response(now(), OK.value(), OK, "", server.getStatus() == Status.SERVER_UP ? "Ping Success" : "Ping Failed", server.getStatus() == Status.SERVER_UP ? "Ping Success" : "Ping Failed", Map.of("servers", server));
	}
	
	// This end point save a new Response
	@PostMapping("/save")
	public Response saveServer(@RequestBody @Valid Server server) {
		return new Response(now(), CREATED.value(), CREATED, "", "Server Created", "Server Created", Map.of("servers", serverServiceImpl.createServer(server)));
	}
	
	// This end point delete a server by ipAddress 
	@DeleteMapping("/delete/{id}")
	public Response deleteServer(@PathVariable("id") Long id) {
		return new Response(now(), OK.value(), OK, "", "Server deleted", "Server deleted", Map.of("servers", serverServiceImpl.deleteServer(id)));
	}
	
	// This end point delete a server by ipAddress 
	@GetMapping(path = "/image/server1.png", produces = IMAGE_PNG_VALUE)
	public byte[] getServerImage() throws IOException {
		return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/Downloads/images/server1.png"));
	}

}
