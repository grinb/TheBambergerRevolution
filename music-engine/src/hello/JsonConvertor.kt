package hello

import com.google.gson.GsonBuilder

object JsonConvertor {

    fun convertToJson(obj: GamePlanModel?): String {
        val gson = GsonBuilder().setPrettyPrinting().create()
        val jsonObj: String = gson.toJson(obj)
        return jsonObj
    }
}