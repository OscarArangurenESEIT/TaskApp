package com.example.taskapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val title: String,
    val description: String = "",
    val priority: Int = 1,        // 1=Low  2=Medium  3=High
    val isCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)