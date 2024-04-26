package com.phuong.livestreamapi.config.socket;

import com.phuong.livestreamapi.model.ChatBox;
import io.socket.engineio.server.EngineIoServer;
import io.socket.engineio.server.EngineIoServerOptions;
import io.socket.socketio.server.SocketIoServer;
import io.socket.socketio.server.SocketIoSocket;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanConfig {

    @Bean
    EngineIoServer engineIoServer() {
        var opt = EngineIoServerOptions.newFromDefault();
        opt.setCorsHandlingDisabled(true);
        var eioServer = new EngineIoServer(opt);
        return eioServer;
    }

    @Bean
    SocketIoServer socketIoServer(EngineIoServer eioServer) {
        var sioServer = new SocketIoServer(eioServer);
        var namespace = sioServer.namespace("/mynamespace");
        List<SocketIoSocket> socketIoSockets = new ArrayList<>();

        namespace.on("connection", args -> {
            var socket = (SocketIoSocket) args[0];
            socketIoSockets.add(socket);
//            System.out.println("Client " + socket.getId() + " (" + socket.getInitialHeaders().get("remote_addr") + ") has connected.");

            socket.on("message", args1 -> {

                JSONObject o = (JSONObject) args1[0];

                var messageVo = JsonUtils.toPojoObj(o, MessageVo.class);

//                System.out.println("[Client " + socket.getId() + "] " + messageVo.fromUser + ": " + messageVo.message + " to " + messageVo.toUser);

                socketIoSockets.forEach(socketIoSocket -> {
                    socketIoSocket.send("hello", JsonUtils.toJsonObj("message"));
                });
            });

//            ------------------------------------------------
        });

        return sioServer;
    }

    record MessageVo(
            String toUser,
            String message,
            String fromUser
    ) {

    }
}
