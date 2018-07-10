package hello

data class GamePlanModel(val name: String,
                    val fileName: String,
                    val lenght: Int,
                    val frequency: Int,
                    val plan: List<String>)