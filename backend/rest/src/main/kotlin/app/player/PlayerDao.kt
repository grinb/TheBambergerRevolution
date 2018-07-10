package app.player

import com.google.gson.Gson
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

class PlayerDao {

    val gson = Gson()

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


    fun delete(id: Int) {
        players.remove(id)
    }

}