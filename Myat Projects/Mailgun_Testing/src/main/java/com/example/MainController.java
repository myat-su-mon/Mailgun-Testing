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
	
	public static final String YOUR_DOMAIN_NAME = "sandbox87797febf9584a65b97f4cc95c58d9c9.mailgun.org";
	public static final String API_KEY = "47c85980f6c7166b71d9572ea24e277b-e438c741-b3cd7942";

	@GetMapping("/mail")
	public static JsonNode sendSimpleMessage() throws UnirestException {

        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + YOUR_DOMAIN_NAME + "/messages")
            .basicAuth("api", API_KEY)
            .field("from", "Myat Su Mon <admin@myatsumon.com>")
            .field("to", "sumon25399@gmail.com")
            .field("subject", "Mailgun Testing")
            .field("text", "testing")
            .asJson();
        System.out.println(request.getStatus());
        System.out.println(request.getBody());

        return request.getBody();
    }

}
