package com.example.konogame

import android.os.Bundle
import android.os.Environment
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileReader
import java.io.IOException
import java.io.InputStreamReader

class get:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.leaderboard)
        val text = findViewById<TextView>(R.id.textView10)
        val list = readFromFile()
        for(skor in list)
        {
            text.text = text.text.toString()+"\n"+skor
        }
    }
    fun readFromFile(): List<String> {
        val file = File(Environment.getExternalStorageDirectory(), "LeaderBoard.txt") // Create a File object for the external storage file
        var lines = mutableListOf<String>()
        if (file.exists()) {
            // File exists, read its contents
            try {
                val inputStream = FileInputStream(file) // Create an input stream to read from the file
                val inputStreamReader = InputStreamReader(inputStream) // Create an input stream reader to read characters from the input stream
                val bufferedReader = BufferedReader(inputStreamReader) // Create a buffered reader to read text from the input stream reader

                val stringBuilder = StringBuilder()
                var line: String? = bufferedReader.readLine()
                lines.add(line.toString())
                while (bufferedReader.readLine().also { line = it } != null) {
                    // Add the line to the list
                    lines.add(line!!)
                }

                val fileContents = stringBuilder.toString() // Get the complete contents of the file as a string
                bufferedReader.close() // Close the buffered reader

                // Do something with the file contents, e.g., display in a TextView
                // textView.text = fileContents

            } catch (e: IOException) {
                e.printStackTrace()
            }
        } else {
            // File does not exist, handle accordingly
        }
        return lines
    }
}