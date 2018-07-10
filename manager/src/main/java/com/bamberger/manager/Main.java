package com.bamberger.manager;

import com.google.gson.Gson;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

public class Main {

    private static Game game = new Game();

    public static void main(String[] args) {
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
