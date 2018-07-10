package hello

data class GamePlanModel(val name: String,
                    val url: java.net.URL,
                    val lenght: Int,
                    val frequency: Int,
                    val plan: List<String>)