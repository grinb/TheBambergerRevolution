package app.user

import com.google.gson.Gson
import java.io.FileReader
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

class PlayerDao {

    val gson = Gson()

    // "Initialize" with a few players
    // This demonstrates type inference, map-literals and named parameters
    val players:HashMap<Int,Player> =  hashMapOf();

    var lastId: AtomicInteger = AtomicInteger(players.size - 1)

    fun save(playerJson :String):Player {
        var player:Player = gson.fromJson(playerJson, Player::class.java)

        val id = lastId.incrementAndGet()
        player.id = id;
        players.put(id,player)
        return player
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