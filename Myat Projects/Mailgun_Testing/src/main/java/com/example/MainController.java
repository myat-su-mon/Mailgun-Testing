package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
@RequestMapping
public class MainController {
	
//	public static final String YOUR_DOMAIN_NAME = "sandbox87797febf9584a65b97f4cc95c58d9c9.mailgun.org";
	public static final String YOUR_DOMAIN_NAME = "myatsumon.me";
	public static final String API_KEY = "47c85980f6c7166b71d9572ea24e277b-e438c741-b3cd7942";

	@GetMapping("/mail")
	public static JsonNode sendSimpleMessage() throws UnirestException {

        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + YOUR_DOMAIN_NAME + "/messages")
            .basicAuth("api", API_KEY)
            .field("from", "Admin <admin@myatsumon.me>")
            .field("to", "aunghtetmyatoo187@gmail.com")
            .field("subject", "Hello Testing")
            .field("text", "Hi I'm myat su mon. Here is my portfolio" +
                    "https://www.myatsumon.me")
            .asJson();
        System.out.println(request.getStatus());
        System.out.println(request.getBody());

        return request.getBody();
    }

}
