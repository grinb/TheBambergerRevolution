package app.game

import com.google.gson.Gson
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

class GameSessionDao {

    val gson = Gson()

    // "Initialize" with a few players
    // This demonstrates type inference, map-literals and named parameters
    val sessions:HashMap<Int,GameSession> =  hashMapOf();

    var lastId: AtomicInteger = AtomicInteger(players.size - 1)

    fun create(playerId :Int):GameSession {
        var session:GameSession = GameSession()

        val id = lastId.incrementAndGet()
        session.id = id;
        session.playerId = playerId

        players.put(id,session)
        return session
    }

    fun findById(id: Int): Player? {
        return players[id]
    }


//    fun update(id: Int, score: Int) {
//        players.put(id, Player(name = name, email = email, id = id))
//    }

    fun delete(id: Int) {
        players.remove(id)
    }

}