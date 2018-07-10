package app.game

import com.google.gson.Gson
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

class GameManager {

    val gson = Gson()

    val games: HashMap<Int, Game> = hashMapOf();
    val sessions: HashMap<Int, GameSession> = hashMapOf();
    var lastId: AtomicInteger = AtomicInteger(games.size - 1)

    fun create(playerId: Int): GameSession {
        val sessionId = lastId.incrementAndGet()

        val currentGame:Game? = getCurrentGame()
        var session: GameSession = GameSession(currentGame!!.id,playerId,0,0)
        sessions.put(sessionId, session)
        return session
    }


//    fun save(playerJson :String):Player {
//        var player:Player = gson.fromJson(playerJson, Player::class.java)
//
//        val id = lastId.incrementAndGet()
//        player.id = id;
//        players.put(id,player)
//        return player
//    }

    fun findById(id: Int): Game? {
        return games[id]
    }


//    fun update(id: Int, score: Int) {
//        players.put(id, Player(name = name, email = email, id = id))
//    }

    fun delete(id: Int) {
        games.remove(id)
    }

    fun getCurrentGame(): Game? {

        var game: Game?
        if (games.isEmpty()) {
            val id: Int = lastId.incrementAndGet()
            game = Game(id, 0, false)
            games.put(id, game)
        } else {
            game = games[0]
        }
        return game
    }
}