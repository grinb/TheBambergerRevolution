package app

import app.game.GameManager
import app.player.PlayerDao
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import spark.Request
import spark.Spark.*

fun main(args: Array<String>) {

    exception(Exception::class.java) { e, req, res -> e.printStackTrace() }

    val playerDao = PlayerDao()
    val gameManager = GameManager()
    val gson = Gson()


    path("/bamberger") {

        get("/player") { req, res ->
            res.type("application/json")
            jacksonObjectMapper().writeValueAsString(playerDao.players)
        }

        get("/player/:id") { req, res ->
//            res.type("application/json")
            playerDao.findById(req.params("id").toInt())
        }

//        get("/email/:email") { req, res ->
//            playerDao.findByEmail(req.params("email"))
//        }

        post("/player") { req, res ->
//            req.body()
            res.status(201)
            res.type("application/json")
            return@post gson.toJson(playerDao.save(req.body()))

        }

//        patch("/update/:id") { req, res ->
//            playerDao.update(
//                    id = req.params("id").toInt(),
//                    name = req.qp("name"),
//                    email = req.qp("email")
//            )
//            "ok"
//        }

        delete("/player/:id") { req, res ->
            playerDao.delete(req.params("id").toInt())
            "ok"
        }
/////////////////////////////////////////////////////////////////////////////////

        post("/session") { req, res ->

            res.status(201)
            res.type("application/json")
            return@post gson.toJson(gameManager.create(req.qp("id").toInt()))

        }

        get("/session/:id") { req, res ->
            res.status(200)
            res.type("application/json")
            return@get gson.toJson(gameManager.findSessionById(req.params("id").toInt()))
        }

    }

    playerDao.players.forEach(::println)

}

fun Request.qp(key: String): String = this.queryParams(key) //adds .qp alias for .queryParams on Request object
