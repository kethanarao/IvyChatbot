package com.HerbHarmony.Ivy.controller;

import com.HerbHarmony.Ivy.model.ChatMessage;
import com.HerbHarmony.Ivy.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/")
    public String home() {
        return "chat";
    }

    @PostMapping("/chat")
    @ResponseBody
    public ChatMessage chat(@RequestBody Map<String, String> payload) {
        String message = payload.get("content");
        String tradition = payload.getOrDefault("tradition", "mixed");
        return chatService.sendMessage(message, tradition);
    }

    @PostMapping("/clear")
    @ResponseBody
    public String clear() {
        chatService.clearHistory();
        return "Chat history cleared";
    }
}