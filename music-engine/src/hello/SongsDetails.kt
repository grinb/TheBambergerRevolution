package hello

object SongsDetails {

    val songsData : Map<String, GamePlanModel>

    init {
        val sg:StepsGenerator = StepsGenerator()
        val shmekalachMap = hashMapOf("name" to GamePlanModel("name",java.net.URL("http://www.google.com"), 100, 100, sg.getArrowsList(10)))
        songsData = HashMap(shmekalachMap)
    }

    fun getSong(name : String) : GamePlanModel? {
        return songsData.get(name);
    }
}