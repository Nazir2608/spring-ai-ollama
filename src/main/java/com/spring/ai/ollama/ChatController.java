package com.spring.ai.ollama;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatClient ollamaChatClient;
    private final ChatClient geminiChatClient;

    public ChatController(@Qualifier("ollamaChatClient") ChatClient ollamaChatClient, @Qualifier("geminiChatClient") ChatClient geminiChatClient) {
        this.ollamaChatClient = ollamaChatClient;
        this.geminiChatClient = geminiChatClient;
    }

    @GetMapping("/ollama")
    public ResponseEntity<String> ollama(@RequestParam String q) {
        return ResponseEntity.ok(ollamaChatClient.prompt(q).call().content()
        );
    }

    @GetMapping("/gemini")
    public ResponseEntity<String> gemini(@RequestParam String q) {
        return ResponseEntity.ok(geminiChatClient.prompt(q).call().content()
        );
    }
}