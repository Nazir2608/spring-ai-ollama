package com.spring.ai.ollama;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean(name="ollamaChatClient")
    public ChatClient ollamaChatModel(OllamaChatModel chatModel){
        return ChatClient.builder(chatModel).build();
    }

    @Bean(name="geminiChatClient")
    public ChatClient geminiChatModel(GoogleGenAiChatModel chatModel){
        return ChatClient.builder(chatModel).build();
    }
}
