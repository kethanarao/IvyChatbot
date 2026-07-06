package com.HerbHarmony.Ivy.model;

import java.time.LocalDateTime;

public class ChatMessage {
    private String role;
    private String content;
    private LocalDateTime timestamp;

    public ChatMessage() { this.timestamp = LocalDateTime.now(); }
    public ChatMessage(String role, String content) { this(); this.role = role; this.content = content; }

    public String getRole() { return role; }
    public String getContent() { return content; }
    public LocalDateTime getTimestamp() { return timestamp; }
}