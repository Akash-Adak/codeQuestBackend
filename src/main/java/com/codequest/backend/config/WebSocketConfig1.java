package com.codequest.backend.config;

import com.codequest.backend.controller.WhiteboardHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig1 implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new WhiteboardHandler(), "/ws/whiteboard").setAllowedOrigins("*");
    }
}
