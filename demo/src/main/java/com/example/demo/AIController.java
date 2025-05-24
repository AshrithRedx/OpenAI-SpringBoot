package com.example.demo;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
public class AIController {
    private final Chat chat;
    private final ImageFetch imageFetch;

    public AIController(Chat chat, ImageFetch imageFetch) {
        this.chat = chat;
        this.imageFetch = imageFetch;
    }

    @GetMapping("generate-image")
    public void generateImage(HttpServletResponse response, @RequestParam("prompt") String prompt) throws IOException {
        ImageResponse imageResponse = imageFetch.generateImage(prompt);

        // Get URL of the generated image
        String imageUrl = imageResponse.getResult().getOutput().getUrl();

        // Send redirect to the image URL
        response.sendRedirect(imageUrl);
    }

    @GetMapping("ask-ai")
    public String askAi(@RequestParam("prompt") String prompt){
        return chat.queryAi(prompt);
    }


    @GetMapping("city-guide")
    public String cityGuide(@RequestParam("city") String city, @RequestParam("interest") String interest) {
        return chat.getCityGuide(city, interest);
    }
}
