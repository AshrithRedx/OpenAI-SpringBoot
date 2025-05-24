# Spring AI + OpenAI Demo Application

This project demonstrates a Spring Boot application integrated with **Spring AI and OpenAI**. It is intended as a companion to the blog post **"Getting Started with Spring AI"** and the **creator and contributor vojtechruz**.

---

## 🔑 Adding Your OpenAI Token

To make this application function correctly, you must supply your own **OpenAI API key**. This key should be defined in the `src/main/resources/application.properties` file as shown below:

```
spring.ai.openai.api-key=<YOUR_API_KEY>
```

You can obtain an API key by creating an account on [OpenAI's website](https://platform.openai.com/). Once registered, visit the API Keys section and generate a new key.

> ⚠️ **Disclaimer:** You must have a valid OpenAI API key for this project to run successfully. The application relies on OpenAI’s services for processing prompts and generating outputs.

---

## ▶️ Running the Application

To run the application, first build it using Maven:

```
mvn clean install
```

Then, you can start it by running the `SpringAiDemoApplication` class like any standard Spring Boot application.

---

## 🌐 Accessing REST Endpoints

Once the application is running, it exposes several REST endpoints via `localhost:8080`. These are defined in the `AiController` class.

### 🗣️ Simple Text Prompts

You can send simple queries using the `/ask-ai` endpoint. Example:

```
http://localhost:8080/ask-ai?prompt=how%20are%20you
```

### 🧭 Templated Prompts

The `/city-guide` endpoint uses predefined templates with parameters. Based on the values of `city` and `interest`, the application returns tourist recommendations:

```
http://localhost:8080/city-guide?city=Prague&interest=history
```

### 🖼️ Generating Images

Image generation is available at the `/generate-image` endpoint. You can pass a prompt describing the image you want to generate:

```
http://localhost:8080/generate-image?prompt=cute%20cat
```

---

## 📌 Notes

- The application uses Spring AI’s abstraction for working with OpenAI models.
- Ensure that your internet connection is stable while generating responses or images, as it depends on real-time API calls to OpenAI.
