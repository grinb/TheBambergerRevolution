package app.game

import app.player.PlayerDao
import com.google.gson.Gson
import java.time.LocalDateTime
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

class GameManager (playerRepository: PlayerDao){

    val gson = Gson()

    val playerRepository: PlayerDao = playerRepository
    var games: HashMap<Int, Game> = hashMapOf();
    var sessions: HashMap<Int, GameSession> = hashMapOf();
    var lastId: AtomicInteger = AtomicInteger(games.size - 1)

    fun create(playerId: Int): GameSession {
        if(playerRepository.findById(playerId) == null) {
            return GameSession(-1, -1,  -1,0, 0)
        }
        val sessionId = lastId.incrementAndGet()

        val currentGame:Game? = getCurrentGame()
        if(currentGame?.startTime!! > 0) {
            setSessionStartTimeByGameId(currentGame!!.id, currentGame!!.startTime)
        }

        var session: GameSession = GameSession(sessionId,currentGame!!.id,playerId,0, currentGame.startTime)
        sessions.put(sessionId, session)
        return session
    }

    fun findSessionById(sessionId: Int): GameSession? {
        return sessions[sessionId]
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
            game = games.get(1)
            val gameStartTime = System.currentTimeMillis() + 15000
            game?.startTime = gameStartTime
        }
        return game
    }

    fun setSessionStartTimeByGameId(gameId: Int, startTime: Long) {

        for ((k, v) in sessions) {
            if(v.gameId == gameId) {
                v.startTime = startTime
            }
        }
    }

    fun updateSessionScore(sessionId: Int, score: Int) {
        for ((k, v) in sessions) {
            if(v.id == sessionId) {
                v.score = score
            }
        }
    }

}