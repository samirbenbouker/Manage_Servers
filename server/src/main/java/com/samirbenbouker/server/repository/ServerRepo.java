package com.samirbenbouker.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samirbenbouker.server.model.Server;

public interface ServerRepo extends JpaRepository<Server, Long>{
		
}
