package hello
import spark.Spark.*

val KotlinHelloString : String = "Hello from Kotlin!"

fun getHelloStringFromJava() : String {
    return "JavaHello.JavaHelloString!!";
}

fun main(args: Array<String>) {
    get("/hello") { req, res -> "Hello World" }
}
