package hello

object SongsDetails {

    val songsData : Map<String, GamePlanModel>

    init {
        val sg:StepsGenerator = StepsGenerator()
        val shmekalachMap = hashMapOf("name" to GamePlanModel("name", "file.mp4", 100, 100, sg.getArrowsList(10)),
                "babyboy" to GamePlanModel("babyboy", "babyboy.mp4", 249, 659, sg.getArrowsList(377)),
                "partyrock" to GamePlanModel("partyrock", "partyrock.mp4", 264, 461, sg.getArrowsList(572)))
        songsData = HashMap(shmekalachMap)
    }

    fun getSong(name : String) : GamePlanModel? {
        return songsData.get(name);
    }
}