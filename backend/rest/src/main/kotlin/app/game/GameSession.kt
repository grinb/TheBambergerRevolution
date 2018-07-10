package app.game

data class GameSession(var id: Int, var gameId: Int, var playerId:Int, var score:Int, var startTime:Long);