import com.example.Game

model {
    List<Game> gameList
}

xmlDeclaration()
games {
    gameList.each {
        game(
            name: it.name,
            minPlayers: it.minPlayers,
            maxPlayers: it.maxPlayers,
        )
    }
}
