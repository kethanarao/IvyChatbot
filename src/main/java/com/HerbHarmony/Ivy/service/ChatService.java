package com.HerbHarmony.Ivy.service;

import com.HerbHarmony.Ivy.model.ChatMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {

    private final OpenAiChatModel chatModel;
    private final List<ChatMessage> chatHistory = new ArrayList<>();

    public ChatService(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public ChatMessage sendMessage(String userMessage, String tradition) {
        try {
            String systemPrompt = buildSystemPrompt(tradition);

            List<org.springframework.ai.chat.messages.Message> messages = new ArrayList<>();
            messages.add(new SystemMessage(systemPrompt));
            messages.add(new UserMessage(userMessage));

            ChatResponse response = chatModel.call(new Prompt(messages));
            String botReply = response.getResult().getOutput().getText();

            ChatMessage assistantMsg = new ChatMessage("assistant", botReply);
            chatHistory.add(assistantMsg);
            return assistantMsg;

        } catch (Exception e) {
            System.err.println("=== OPENAI ERROR ===");
            e.printStackTrace();
            System.err.println("====================");
            return new ChatMessage("assistant", "Sorry, I couldn't process your request right now. Please try again.");
        }
    }

    public void clearHistory() {
        chatHistory.clear();
    }

    private String buildSystemPrompt(String tradition) {
        String base = "You are Herb Harmony, a wise and compassionate ancient healer. " +
                      "Give practical food, herb, and remedy recommendations. Be warm and helpful.";

        return switch (tradition.toLowerCase()) {
            case "ayurveda" -> base + " Focus on Ayurvedic principles (doshas,millets,ayurvedic doctor blogs, tastes, digestion).";
            case "tcm" -> base + " Focus on Traditional Chinese Medicine (yin/yang, hot/cold foods,herbs,teas,soups).";
            case "korean" -> base + " Focus on Korean medicinal foods and fermentation wisdom,soups,herbs.";
            default -> base + " Blend Ayurveda, TCM, and Korean traditions wisely.";
        };
    }
}