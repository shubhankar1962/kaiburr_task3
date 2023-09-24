package com.example.controller;

import com.example.model.Server;
import com.example.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servers")
public class ServerController {

    @Autowired
    public ServerService service;

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Server createServer(@RequestBody Server server){
        return service.addServer(server);
    }

    @GetMapping
    public List<Server> getServers(){
        return service.findAllServer();
    }

    @GetMapping("/{serverId}")
    public Server getServer(@PathVariable String serverId){
        return service.getServerByServerId(serverId);
    }

    @GetMapping("/server-name/{serverName}")
    public List<Server> findServerUsingServerName(@PathVariable String serverName){
        return service.getServerByServerName(serverName);
    }

    @DeleteMapping("/{serverId}")
    public String deleteServer(@PathVariable String serverId){
        return service.deleteServer(serverId);
    }

}
