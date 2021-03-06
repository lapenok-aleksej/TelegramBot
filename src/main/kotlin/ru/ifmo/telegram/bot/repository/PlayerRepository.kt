package ru.ifmo.telegram.bot.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.ifmo.telegram.bot.entity.Game
import ru.ifmo.telegram.bot.entity.Player

@Repository
interface PlayerRepository : CrudRepository<Player, Long> {
    fun findByChatId(chatId: Long): Player?
    fun findByName(name: String): Player?
    fun findByGame(game: Game): MutableSet<Player>
}