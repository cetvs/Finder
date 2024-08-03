package com.finder.chat.data

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializer
import java.sql.Date

class ChatWebsocketMapper {

    private val dateSerializer: JsonSerializer<Date> = JsonSerializer { src, _, _ ->
        JsonPrimitive(src.time)
    }

    private val dateDeserializer: JsonDeserializer<Date> = JsonDeserializer { json, _, _ ->
        Date(json.asJsonPrimitive.asLong)
    }

    private fun String.fromJsonToChatMessage(): ChatMessage {
        val gson = GsonBuilder()
            .registerTypeAdapter(Date::class.java, dateSerializer)
            .registerTypeAdapter(Date::class.java, dateDeserializer)
            .create()

        return gson.fromJson(this, ChatMessage::class.java)
    }

    fun mapToChatMessage(messageText: String) : ChatMessage {
        return messageText.fromJsonToChatMessage()
    }
}
