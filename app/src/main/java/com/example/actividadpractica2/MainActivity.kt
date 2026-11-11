
package com.example.actividadpractica2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Datos del estudiante
        val nombreEstudiante: String = "Juan Sebastian Gil"
        val carrera: String = "Ingenieria de Sistemas"
        val asignatura: String = "Programacion para Dispositivos Moviles"

        // Notas de los tres cortes
        var notaCorte1: Double = 4.2
        var notaCorte2: Double = 3.5
        var notaCorte3: Double? = null

        // Operador Elvis
        val notaFinal3: Double = notaCorte3 ?: 0.0

        // Calcular promedio
        val promedio = calcularPromedio(
            notaCorte1,
            notaCorte2,
            notaFinal3
        )

        // Generar reporte
        val reporte = generarReporte(
            nombreEstudiante,
            carrera,
            asignatura,
            notaCorte1,
            notaCorte2,
            notaFinal3,
            promedio
        )

        // Mostrar resultado en pantalla
        val textoResultado = findViewById<TextView>(R.id.datos)
        textoResultado.text = reporte
    }
}

// Funcion para calcular promedio
fun calcularPromedio(
    n1: Double,
    n2: Double,
    n3: Double
): Double = (n1 + n2 + n3) / 3

// Funcion para generar reporte
fun generarReporte(
    estudiante: String,
    carrera: String,
    materia: String,
    n1: Double,
    n2: Double,
    n3: Double,
    promedio: Double
): String {

    val estado = if (promedio >= 3.0) {
        "APROBADO"
    } else {
        "REPROBADO"
    }

    return """
        REPORTE DEL ESTUDIANTE

        Estudiante: $estudiante
        Carrera: $carrera
        Asignatura: $materia

        Nota corte 1: $n1
        Nota corte 2: $n2
        Nota corte 3: $n3

        Promedio: ${String.format("%.2f", promedio)}

        Estado: $estado
    """.trimIndent()
}
