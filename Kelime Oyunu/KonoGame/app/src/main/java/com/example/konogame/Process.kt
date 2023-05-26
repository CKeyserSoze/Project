package com.example.konogame

import android.content.Context
import android.os.Bundle
import android.os.Environment
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileInputStream
import java.io.FileWriter
import java.io.IOException
import java.io.InputStreamReader

class Process : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gameend)
        //Önceki aktiviteden gelen skoru ekrana yazdırır
        val skor = intent.getStringExtra("puantext").toString()
        val skortext = findViewById<TextView>(R.id.textView8)
        skortext.text = skortext.text.toString()+skor
        //LeaderBoard.txt dosyasını açar önceki skorları getirir
        val list = readFromFile()
        val textdw = findViewById<TextView>(R.id.textView7)
        textdw.text = list.toString()
        //Gelen skorlara yeni skoru da ekleyip dosyaya yazar
        writeToFile("LeaderBoard.txt",list,skor)
    }
    //External Storageda bulunan text dosyasını getirir içindeki skorları bir
    // listeye atar ve return olarak o listeyi döndürür
    fun readFromFile(): List<String> {
        val file = File(Environment.getExternalStorageDirectory(), "LeaderBoard.txt")
        var lines = mutableListOf<String>()
        if (file.exists()) {
            try {
                val inputStream = FileInputStream(file)
                val inputStreamReader = InputStreamReader(inputStream)
                val bufferedReader = BufferedReader(inputStreamReader)

                var line: String? = bufferedReader.readLine()
                lines.add(line.toString())
                while (bufferedReader.readLine().also { line = it } != null) {

                    lines.add(line!!)
                }

                bufferedReader.close()

            } catch (e: IOException) {
                e.printStackTrace()
            }
        } else {
        }
        return lines
    }
    //Girdi olarak text dosyasından okunan listeyi ve yeni skoru alır.
    // Yeni skoru listeye ekler o listeyi de text dosyasının üstüne yazar
    fun writeToFile(fileName: String,lines : List<String>,data:String) {


        val file = File(Environment.getExternalStorageDirectory(), fileName)

        try {
            val fw = FileWriter(file)
            val bw = BufferedWriter(fw)

            for(item in lines){
                bw.write(item)
                bw.newLine()
            }
            bw.write(data)
            bw.newLine()

            bw.close()
        }catch (e:IOException)
        {
            e.printStackTrace()
        }
        /*
        try {   for(line in lines)
        {
            file.writeText(line)
        }
                file.writeText(data)
        } catch (e: IOException) {
            e.printStackTrace()
        }

         */
}
}


