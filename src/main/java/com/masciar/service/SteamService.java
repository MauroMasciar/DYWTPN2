package com.masciar.service;

import com.masciar.app.ApiSteamKey;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SteamService {
    ApiSteamKey apiSteamKey = new ApiSteamKey();
    private String API_KEY = apiSteamKey.GetApiSteamKey();

    public void getPlayerAchievements() {
        String steamId = "76561198201938341";
        int appId = 813780;

        String url = String.format(
                "https://api.steampowered.com/ISteamUserStats/GetPlayerAchievements/v1/?key=%s&steamid=%s&appid=%d",
                API_KEY,
                steamId,
                appId);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (InterruptedException e) {

        } catch (IOException e) {

        }
    }
}
