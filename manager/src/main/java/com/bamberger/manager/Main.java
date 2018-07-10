package com.bamberger.manager;

import com.google.gson.Gson;

import static spark.Spark.*;

public class Main {

    private static Game game = new Game();

    public static void main(String[] args) {

        options("/*",
                (request, response) -> {

                    String accessControlRequestHeaders = request
                            .headers("Access-Control-Request-Headers");
                    if (accessControlRequestHeaders != null) {
                        response.header("Access-Control-Allow-Headers",
                                accessControlRequestHeaders);
                    }

                    String accessControlRequestMethod = request
                            .headers("Access-Control-Request-Method");
                    if (accessControlRequestMethod != null) {
                        response.header("Access-Control-Allow-Methods",
                                accessControlRequestMethod);
                    }

                    return "OK";
                });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        post("/register/:name", (req, res) -> {
            String str = req.params(":name");
            game.addPlayer(new Player(str));
            game.initGame();
            return "created";
        });

        get("/start", (req, res) -> {
            return game.getInstant() == null ? "00.00.00" : game.getInstant();
        });

        put("/scores/:name/:score", (req, res) -> {
            String name = req.params(":name");
            String score = req.params(":score");
            game.getPlayers().get(name).addScore(Integer.parseInt(score));
            return true;
        });

        get("/scores", (req, res) -> {
            return new Gson().toJson(game.getPlayers());
        });
    }
}
