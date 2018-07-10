package app

import app.user.PlayerDao
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import spark.Request
import spark.Spark.*

fun main(args: Array<String>) {

    exception(Exception::class.java) { e, req, res -> e.printStackTrace() }

    val playerDao = PlayerDao()
    val gson = Gson()


    path("/player") {

        get("") { req, res ->
            res.type("application/json")
            jacksonObjectMapper().writeValueAsString(playerDao.players)
        }

        get("/:id") { req, res ->
//            res.type("application/json")
            playerDao.findById(req.params("id").toInt())
        }

//        get("/email/:email") { req, res ->
//            playerDao.findByEmail(req.params("email"))
//        }

        post("") { req, res ->
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

        delete("/delete/:id") { req, res ->
            playerDao.delete(req.params("id").toInt())
            "ok"
        }

    }

    playerDao.players.forEach(::println)

}

fun Request.qp(key: String): String = this.queryParams(key) //adds .qp alias for .queryParams on Request object
