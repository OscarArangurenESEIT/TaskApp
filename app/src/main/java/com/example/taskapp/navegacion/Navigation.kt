package com.example.taskapp.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.taskapp.pantallas.PantallaInicio
import com.example.taskapp.pantallas.PantallaAgregarTarea

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            PantallaInicio(
                onAddTask = { navController.navigate("add") },
                onTaskClick = { taskId -> navController.navigate("detail/$taskId") }
            )
        }
        composable("add") {
            PantallaAgregarTarea(
                onBack = { navController.popBackStack() }
            )
        }
        composable(
            route = "detail/{taskId}",
            arguments = listOf(navArgument("taskId") { type = NavType.LongType })
        ) { backStackEntry ->
            PantallaDetalle(
                taskId = backStackEntry.arguments?.getLong("taskId") ?: 0L,
                onBack = { navController.popBackStack() }
            )
        }
    }
}