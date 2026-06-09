package com.example.taskapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val description: String = "",
    val priority: Int = 1,
    val isCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val dueDate: Long? = null,        // fecha límite en milisegundos
    val dueTime: String = "",         // hora en formato "HH:mm"
    val hasReminder: Boolean = false  // si tiene recordatorio
)