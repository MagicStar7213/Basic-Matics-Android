package com.micromatic.basicmatics.data

import java.io.File

class Language(filesDir: File) {
    val props = Settings(filesDir)

    val ES = mapOf(
        "divide_string" to " Dividir",
        "divider_string" to "Resto de Divisi\u00f3n",
        "mtpl_string" to "Multiplicar",
        "rest_string" to "Restar",
        "sume_string" to "Sumar",
        "calc_string" to "Calcular",
        "general_string" to "General",
        "custom_string" to "Personalizaci\u00f3n",
        "settings_string" to "Ajustes",
        "aprox_string" to "Resultado aproximado",
        "english" to "Ingl\u00e9s",
        "spanish" to "Español"
    )
    val EN = mapOf(
        "divide_string" to "Divide",
        "divider_string" to "Division Rest",
        "mtpl_string" to "Multiply",
        "rest_string" to "Subtract",
        "sume_string" to "Add",
        "calc_string" to "Calculate",
        "general_string" to "General",
        "custom_string" to "Customization",
        "settings_string" to "Settings",
        "aprox_string" to "Aproximated result",
        "english" to "English",
        "spanish" to "Spanish",
    )

    fun getLang(): Map<String, String> {
        return when (props.lang) {
            "es" -> ES
            else -> EN
        }
    }

    fun setLang(lang: String) {
        props.lang = lang
    }

    fun selectLang(lang: Int) {
        when (lang) {
            1 -> setLang("es")
            else -> setLang("en")
        }
    }
}