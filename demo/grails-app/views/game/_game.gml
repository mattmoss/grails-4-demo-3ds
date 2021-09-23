import com.example.Game

model {
    Game game
}

xmlDeclaration()
game {
    name game.name
    minPlayers game.minPlayers
    maxPlayers game.maxPlayers
    source this.g.link(url: 'https://boardgamegeek.com')
}
