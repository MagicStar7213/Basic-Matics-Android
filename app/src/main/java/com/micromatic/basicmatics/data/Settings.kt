package com.micromatic.basicmatics.data

import java.io.*
import java.util.*

class Settings(dir: File) {
    private val file = File(dir.path + "/bsm.properties")
    private val prop = Properties()

    private var `in`: FileInputStream = FileInputStream(file)
    private var out: FileOutputStream = FileOutputStream(file)

    @kotlin.jvm.Throws(IOException::class)
    fun create() {
        file.createNewFile()
    }
    fun keyExists(key: String): Boolean {
        load()
        return prop.containsKey(key)
    }

    var aprox: Boolean
        get() {
            try {
                load()
            } catch (io: IOException) {
                io.printStackTrace()
            }
            return java.lang.Boolean.parseBoolean(prop.getProperty("aprox"))
        }
        set(key) {
            try {
                load()
                out = FileOutputStream(file)
                if (prop.containsKey("aprox"))
                    prop.setProperty("aprox", key.toString())
                else
                    prop["aprox"] = key
                prop.store(out, null)
                out.close()
            } catch (io: IOException) {
                io.printStackTrace()
            }
        }

    var lang: String
        get() {
            try {
                load()
            } catch (io: IOException) {
                io.printStackTrace()
            }
            return prop.getProperty("lang")
        }
        set(key) {
            try {
                load()
                out = FileOutputStream(file)
                if (prop.containsKey("lang"))
                    prop.setProperty("lang", key)
                else
                    prop["lang"] = key
                prop.store(out, null)
                out.close()
            } catch (io: IOException) {
                io.printStackTrace()
            }
        }

    var os: String
        get() {
            try {
                load()
            } catch (io: IOException) {
                io.printStackTrace()
            }
            return prop.getProperty("os")
        }
        set(key) {
            try {
                load()
                out = FileOutputStream(file)
                if (prop.containsKey("os"))
                    prop.setProperty("os", key)
                else
                    prop["os"] = key
                prop.store(out, null)
                out.close()
            } catch (io: IOException) {
                io.printStackTrace()
            }
        }

    private fun load() {
        prop.load(`in`)
        `in`.close()
    }
}