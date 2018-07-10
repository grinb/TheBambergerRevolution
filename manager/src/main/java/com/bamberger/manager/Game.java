package com.bamberger.manager;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Game {

    Instant instant;

    Map<String, Player> players;

    public Game(){
        players = new HashMap<String, Player>();
    }


    public Map<String, Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player){
        this.players.put(player.getName(), player);
    }

    public Instant getInstant() {
        return instant;
    }

    public void initGame(){
        if(players.size() > 1 && (this.instant == null)) {
            this.instant = Instant.now().plus(15, ChronoUnit.SECONDS);
        }
    }

    public void reset(){
        players.clear();
        this.instant = null;
    }
}
