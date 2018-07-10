package hello
import spark.Spark.*

fun getHelloStringFromJava() : String {
    return "JavaHello.JavaHelloString!!";
}

fun main(args: Array<String>) {
    get("/hello") { req, res ->
        JavaHello.getHelloStringFromJava()

    }

    get("/game-model") { req, res ->
        JsonConvertor.convertToJson(SongsDetails.getSong(req.queryParams("name")))
    }


}