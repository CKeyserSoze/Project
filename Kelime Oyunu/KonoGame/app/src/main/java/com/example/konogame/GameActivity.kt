package com.example.konogame
import android.content.Context
import android.content.Intent
import java.io.BufferedReader
import java.io.InputStreamReader
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.core.content.ContextCompat
import org.w3c.dom.Text
import java.io.File
import java.io.IOException
import java.util.Timer
import java.util.TimerTask

class GameActivity : AppCompatActivity(){
    var flag = 0
    var chosenword = ""
    var chosenwordcount = 0
    var wrongSelection = 0

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_screen)
        //Buttonların click methodlarını ayarlamak için sütun sütun tanımlanması
        val button = findViewById<ToggleButton>(R.id.toggleButton)
        val button9 = findViewById<ToggleButton>(R.id.toggleButton9)
        val button17 = findViewById<ToggleButton>(R.id.toggleButton17)
        val button25 = findViewById<ToggleButton>(R.id.toggleButton25)
        val button33 = findViewById<ToggleButton>(R.id.toggleButton33)
        val button41 = findViewById<ToggleButton>(R.id.toggleButton41)
        val button49 = findViewById<ToggleButton>(R.id.toggleButton49)
        val button57 = findViewById<ToggleButton>(R.id.toggleButton57)
        val button65 = findViewById<ToggleButton>(R.id.toggleButton65)
        val button73 = findViewById<ToggleButton>(R.id.toggleButton73)

        val button2 = findViewById<ToggleButton>(R.id.toggleButton2)
        val button10 = findViewById<ToggleButton>(R.id.toggleButton10)
        val button18 = findViewById<ToggleButton>(R.id.toggleButton18)
        val button26 = findViewById<ToggleButton>(R.id.toggleButton26)
        val button34 = findViewById<ToggleButton>(R.id.toggleButton34)
        val button42 = findViewById<ToggleButton>(R.id.toggleButton42)
        val button50 = findViewById<ToggleButton>(R.id.toggleButton50)
        val button58 = findViewById<ToggleButton>(R.id.toggleButton58)
        val button66 = findViewById<ToggleButton>(R.id.toggleButton66)
        val button74 = findViewById<ToggleButton>(R.id.toggleButton74)

        val button3 = findViewById<ToggleButton>(R.id.toggleButton3)
        val button11 = findViewById<ToggleButton>(R.id.toggleButton11)
        val button19 = findViewById<ToggleButton>(R.id.toggleButton19)
        val button27 = findViewById<ToggleButton>(R.id.toggleButton27)
        val button35 = findViewById<ToggleButton>(R.id.toggleButton35)
        val button43 = findViewById<ToggleButton>(R.id.toggleButton43)
        val button51 = findViewById<ToggleButton>(R.id.toggleButton51)
        val button59 = findViewById<ToggleButton>(R.id.toggleButton59)
        val button67 = findViewById<ToggleButton>(R.id.toggleButton67)
        val button75 = findViewById<ToggleButton>(R.id.toggleButton75)

        val button4 = findViewById<ToggleButton>(R.id.toggleButton4)
        val button12 = findViewById<ToggleButton>(R.id.toggleButton12)
        val button20 = findViewById<ToggleButton>(R.id.toggleButton20)
        val button28 = findViewById<ToggleButton>(R.id.toggleButton28)
        val button36 = findViewById<ToggleButton>(R.id.toggleButton36)
        val button44 = findViewById<ToggleButton>(R.id.toggleButton44)
        val button52 = findViewById<ToggleButton>(R.id.toggleButton52)
        val button60 = findViewById<ToggleButton>(R.id.toggleButton60)
        val button68 = findViewById<ToggleButton>(R.id.toggleButton68)
        val button76 = findViewById<ToggleButton>(R.id.toggleButton76)

        val button5 = findViewById<ToggleButton>(R.id.toggleButton5)
        val button13 = findViewById<ToggleButton>(R.id.toggleButton13)
        val button21 = findViewById<ToggleButton>(R.id.toggleButton21)
        val button29 = findViewById<ToggleButton>(R.id.toggleButton29)
        val button37 = findViewById<ToggleButton>(R.id.toggleButton37)
        val button45 = findViewById<ToggleButton>(R.id.toggleButton45)
        val button53 = findViewById<ToggleButton>(R.id.toggleButton53)
        val button61 = findViewById<ToggleButton>(R.id.toggleButton61)
        val button69 = findViewById<ToggleButton>(R.id.toggleButton69)
        val button77 = findViewById<ToggleButton>(R.id.toggleButton77)

        val button6 = findViewById<ToggleButton>(R.id.toggleButton6)
        val button14 = findViewById<ToggleButton>(R.id.toggleButton14)
        val button22 = findViewById<ToggleButton>(R.id.toggleButton22)
        val button30 = findViewById<ToggleButton>(R.id.toggleButton30)
        val button38 = findViewById<ToggleButton>(R.id.toggleButton38)
        val button46 = findViewById<ToggleButton>(R.id.toggleButton46)
        val button54 = findViewById<ToggleButton>(R.id.toggleButton54)
        val button62 = findViewById<ToggleButton>(R.id.toggleButton62)
        val button70 = findViewById<ToggleButton>(R.id.toggleButton70)
        val button78 = findViewById<ToggleButton>(R.id.toggleButton78)

        val button7 = findViewById<ToggleButton>(R.id.toggleButton7)
        val button15 = findViewById<ToggleButton>(R.id.toggleButton15)
        val button23 = findViewById<ToggleButton>(R.id.toggleButton23)
        val button31 = findViewById<ToggleButton>(R.id.toggleButton31)
        val button39 = findViewById<ToggleButton>(R.id.toggleButton39)
        val button47 = findViewById<ToggleButton>(R.id.toggleButton47)
        val button55 = findViewById<ToggleButton>(R.id.toggleButton55)
        val button63 = findViewById<ToggleButton>(R.id.toggleButton63)
        val button71 = findViewById<ToggleButton>(R.id.toggleButton71)
        val button79 = findViewById<ToggleButton>(R.id.toggleButton79)

        val button8 = findViewById<ToggleButton>(R.id.toggleButton8)
        val button16 = findViewById<ToggleButton>(R.id.toggleButton16)
        val button24 = findViewById<ToggleButton>(R.id.toggleButton24)
        val button32 = findViewById<ToggleButton>(R.id.toggleButton32)
        val button40 = findViewById<ToggleButton>(R.id.toggleButton40)
        val button48 = findViewById<ToggleButton>(R.id.toggleButton48)
        val button56 = findViewById<ToggleButton>(R.id.toggleButton56)
        val button64 = findViewById<ToggleButton>(R.id.toggleButton64)
        val button72 = findViewById<ToggleButton>(R.id.toggleButton72)
        val button80 = findViewById<ToggleButton>(R.id.toggleButton80)


        //Tuşların listeye atılması
        var buttons = listOf<ToggleButton>(button,button2,button3,button4,button5,button6,button7,button8,button9,
            button10,button11,button12,button13,button14,button15,button16,button17,button18,button19,
            button20, button21,button22,button23,button24,button25,button26,button27,button28,button29,
            button30,button31, button32,button33,button34,button35,button36,button37,button38,button39,
            button40,button41,button42, button43,button44,button45,button46,button47,button48,button49,
            button50,button51,button52,button53, button54,button55,button56,button57,button58,button59,
            button60,button61,button62,button63,button64,button65,button66,button67,button68,button69,
            button70,button71,button72,button73,button74,button75,button76,button77,button78,button79,button80)
        //Oyun başladığında 3 satır doldurma
        if(flag == 0) {
            satirdoldurma()
            satirdoldurma()
            satirdoldurma()
        }

        val textfield = findViewById<TextView>(R.id.textView)
        //KELİME BUTONLARININ İŞLEMLERİ
        //Buttonlar togglebutton olduğundan 1 veya 0 olmasına göre bu butonların
        // üstündeki harflerle farklı kontroller yapılır
        //button.isSelected == 0 olduğunda harfi seçip kelime textiview in
        //içine ekler butonu seçilmiş yapar rengini değiştirir
        //button.isSelected == 1 olduğunda harfi textview dan siler butonu seçilmemiş yapar rengini değiştirir.
        buttons.forEachIndexed { index, toggleButton ->
            toggleButton.setOnClickListener{
                if (toggleButton.isSelected == false)
                {
                    if(chosenwordcount > 18)
                    {}
                    else {
                        textfield.text = textfield.text.toString()+toggleButton.text.toString()
                        if (chosenwordcount == 17 && toggleButton.text.toString() != ""){
                            toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.purple7))
                            chosenwordcount = chosenwordcount + 1
                            toggleButton.isSelected = true
                        }
                        if (chosenwordcount == 16 && toggleButton.text.toString() != ""){
                            toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.purple6))
                            chosenwordcount = chosenwordcount + 1
                            toggleButton.isSelected = true
                        }
                        if (chosenwordcount == 15 && toggleButton.text.toString() != ""){
                            toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.purple5))
                            chosenwordcount = chosenwordcount + 1
                            toggleButton.isSelected = true
                        }
                        if (chosenwordcount == 14 && toggleButton.text.toString() != ""){
                            toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.purple4))
                            chosenwordcount = chosenwordcount + 1
                            toggleButton.isSelected = true
                        }
                        if (chosenwordcount == 13 && toggleButton.text.toString() != ""){
                            toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.purple3))
                            chosenwordcount = chosenwordcount + 1
                            toggleButton.isSelected = true
                        }
                        if (chosenwordcount == 12 && toggleButton.text.toString() != ""){
                            toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.purple2))
                            chosenwordcount = chosenwordcount + 1
                            toggleButton.isSelected = true
                        }
                        if (chosenwordcount == 11 && toggleButton.text.toString() != ""){
                            toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.purple_200))
                            chosenwordcount = chosenwordcount + 1
                            toggleButton.isSelected = true
                        }
                        if (chosenwordcount == 10 && toggleButton.text.toString() != ""){
                            toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.purple1))
                            chosenwordcount = chosenwordcount + 1
                            toggleButton.isSelected = true
                        }
                        if (chosenwordcount == 9 && toggleButton.text.toString() != ""){
                            toggleButton.setBackgroundColor(Color.MAGENTA)
                            chosenwordcount = chosenwordcount + 1
                            toggleButton.isSelected = true
                        }
                        if (chosenwordcount == 8 && toggleButton.text.toString() != ""){
                            toggleButton.setBackgroundColor(Color.TRANSPARENT)
                            chosenwordcount = chosenwordcount + 1
                            toggleButton.isSelected = true
                        }
                        if (chosenwordcount == 7 && toggleButton.text.toString() != "") {
                            toggleButton.setBackgroundColor(Color.BLUE)
                            chosenwordcount = chosenwordcount + 1
                            toggleButton.isSelected = true
                        }
                        if (chosenwordcount == 6 && toggleButton.text.toString() != "") {
                            toggleButton.setBackgroundColor(Color.CYAN)
                            chosenwordcount = chosenwordcount + 1
                            toggleButton.isSelected = true
                        }
                        if (chosenwordcount == 5 && toggleButton.text.toString() != "") {
                            toggleButton.setBackgroundColor(Color.YELLOW)
                            chosenwordcount = chosenwordcount + 1
                            toggleButton.isSelected = true
                        }
                        if (chosenwordcount == 4 && toggleButton.text.toString() != "") {
                            toggleButton.setBackgroundColor(Color.DKGRAY)
                            chosenwordcount = chosenwordcount + 1
                            toggleButton.isSelected = true
                        }
                        if (chosenwordcount == 3 && toggleButton.text.toString() != "") {
                            toggleButton.setBackgroundColor(Color.GRAY)
                            chosenwordcount = chosenwordcount + 1
                            toggleButton.isSelected = true
                        }
                        if (chosenwordcount == 2 && toggleButton.text.toString() != "") {
                            toggleButton.setBackgroundColor(Color.GREEN)
                            chosenwordcount = chosenwordcount + 1
                            toggleButton.isSelected = true
                        }
                        if (chosenwordcount == 1 && toggleButton.text.toString() != "") {
                            toggleButton.setBackgroundColor(Color.RED)
                            chosenwordcount = chosenwordcount + 1
                            toggleButton.isSelected = true
                        }
                        if (chosenwordcount == 0 && toggleButton.text.toString() != "") {
                            toggleButton.setBackgroundColor(Color.LTGRAY)
                            chosenwordcount = chosenwordcount + 1
                            toggleButton.isSelected = true
                        }
                        chosenword = textfield.text.toString()
                    }
                }
                else if(toggleButton.isSelected == true)
                {
                    val backgroundColor = (toggleButton.background.current as? ColorDrawable)?.color

                    if(backgroundColor == Color.LTGRAY && chosenwordcount == 1){
                        toggleButton.isSelected = false
                        toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                        chosenword = removeCharAt(chosenword,0)
                        textfield.text = chosenword
                        chosenwordcount--
                    }
                    if(backgroundColor == Color.RED && chosenwordcount == 2){
                        toggleButton.isSelected = false
                        toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                        chosenword = removeCharAt(chosenword,1)
                        textfield.text = chosenword
                        chosenwordcount--
                    }
                    if(backgroundColor == Color.GREEN && chosenwordcount == 3){
                        toggleButton.isSelected = false
                        toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                        chosenword = removeCharAt(chosenword,2)
                        textfield.text = chosenword
                        chosenwordcount--
                    }
                    if(backgroundColor == Color.GRAY && chosenwordcount == 4){
                        toggleButton.isSelected = false
                        toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                        chosenword = removeCharAt(chosenword,3)
                        textfield.text = chosenword
                        chosenwordcount--
                    }
                    if(backgroundColor == Color.DKGRAY && chosenwordcount == 5){
                        toggleButton.isSelected = false
                        toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                        chosenword = removeCharAt(chosenword,4)
                        textfield.text = chosenword
                        chosenwordcount--
                    }
                    if(backgroundColor == Color.YELLOW && chosenwordcount == 6){
                        toggleButton.isSelected = false
                        toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                        chosenword = removeCharAt(chosenword,5)
                        textfield.text = chosenword
                        chosenwordcount--
                    }
                    if(backgroundColor == Color.CYAN && chosenwordcount == 7){
                        toggleButton.isSelected = false
                        toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                        chosenword = removeCharAt(chosenword,6)
                        textfield.text = chosenword
                        chosenwordcount--
                    }
                    if(backgroundColor == Color.BLUE && chosenwordcount == 8){
                        toggleButton.isSelected = false
                        toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                        chosenword = removeCharAt(chosenword,7)
                        textfield.text = chosenword
                        chosenwordcount--
                    }
                    if(backgroundColor == Color.TRANSPARENT && chosenwordcount == 9){
                        toggleButton.isSelected = false
                        toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                        chosenword = removeCharAt(chosenword,8)
                        textfield.text = chosenword
                        chosenwordcount--
                    }
                    if(backgroundColor == Color.MAGENTA && chosenwordcount == 10){
                        toggleButton.isSelected = false
                        toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                        chosenword = removeCharAt(chosenword,9)
                        textfield.text = chosenword
                        chosenwordcount--
                    }
                    if(backgroundColor == ContextCompat.getColor(this,R.color.purple1) && chosenwordcount == 11){
                        toggleButton.isSelected = false
                        toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                        chosenword = removeCharAt(chosenword,10)
                        textfield.text = chosenword
                        chosenwordcount--
                    }
                    if(backgroundColor == ContextCompat.getColor(this,R.color.purple_200) && chosenwordcount == 12){
                        toggleButton.isSelected = false
                        toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                        chosenword = removeCharAt(chosenword,11)
                        textfield.text = chosenword
                        chosenwordcount--
                    }
                    if(backgroundColor == ContextCompat.getColor(this,R.color.purple2) && chosenwordcount == 13){
                        toggleButton.isSelected = false
                        toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                        chosenword = removeCharAt(chosenword,12)
                        textfield.text = chosenword
                        chosenwordcount--
                    }
                    if(backgroundColor == ContextCompat.getColor(this,R.color.purple3) && chosenwordcount == 14){
                        toggleButton.isSelected = false
                        toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                        chosenword = removeCharAt(chosenword,13)
                        textfield.text = chosenword
                        chosenwordcount--
                    }
                    if(backgroundColor == ContextCompat.getColor(this,R.color.purple4) && chosenwordcount == 15){
                        toggleButton.isSelected = false
                        toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                        chosenword = removeCharAt(chosenword,14)
                        textfield.text = chosenword
                        chosenwordcount--
                    }
                    if(backgroundColor == ContextCompat.getColor(this,R.color.purple5) && chosenwordcount == 16){
                        toggleButton.isSelected = false
                        toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                        chosenword = removeCharAt(chosenword,15)
                        textfield.text = chosenword
                        chosenwordcount--
                    }
                    if(backgroundColor == ContextCompat.getColor(this,R.color.purple6) && chosenwordcount == 17){
                        toggleButton.isSelected = false
                        toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                        chosenword = removeCharAt(chosenword,16)
                        textfield.text = chosenword
                        chosenwordcount--
                    }
                    if(backgroundColor == ContextCompat.getColor(this,R.color.purple7) && chosenwordcount == 18){
                        toggleButton.isSelected = false
                        toggleButton.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                        chosenword = removeCharAt(chosenword,17)
                        textfield.text = chosenword
                        chosenwordcount--
                    }
                }
            }
        }
    }
    //Rastgele harfleri sütunların üstünden en üstüne koyan fonksiyon
    fun singleletterdrop(){
        val button = findViewById<ToggleButton>(R.id.toggleButton)
        val button9 = findViewById<ToggleButton>(R.id.toggleButton9)
        val button17 = findViewById<ToggleButton>(R.id.toggleButton17)
        val button25 = findViewById<ToggleButton>(R.id.toggleButton25)
        val button33 = findViewById<ToggleButton>(R.id.toggleButton33)
        val button41 = findViewById<ToggleButton>(R.id.toggleButton41)
        val button49 = findViewById<ToggleButton>(R.id.toggleButton49)
        val button57 = findViewById<ToggleButton>(R.id.toggleButton57)
        val button65 = findViewById<ToggleButton>(R.id.toggleButton65)
        val button73 = findViewById<ToggleButton>(R.id.toggleButton73)

        val button2 = findViewById<ToggleButton>(R.id.toggleButton2)
        val button10 = findViewById<ToggleButton>(R.id.toggleButton10)
        val button18 = findViewById<ToggleButton>(R.id.toggleButton18)
        val button26 = findViewById<ToggleButton>(R.id.toggleButton26)
        val button34 = findViewById<ToggleButton>(R.id.toggleButton34)
        val button42 = findViewById<ToggleButton>(R.id.toggleButton42)
        val button50 = findViewById<ToggleButton>(R.id.toggleButton50)
        val button58 = findViewById<ToggleButton>(R.id.toggleButton58)
        val button66 = findViewById<ToggleButton>(R.id.toggleButton66)
        val button74 = findViewById<ToggleButton>(R.id.toggleButton74)

        val button3 = findViewById<ToggleButton>(R.id.toggleButton3)
        val button11 = findViewById<ToggleButton>(R.id.toggleButton11)
        val button19 = findViewById<ToggleButton>(R.id.toggleButton19)
        val button27 = findViewById<ToggleButton>(R.id.toggleButton27)
        val button35 = findViewById<ToggleButton>(R.id.toggleButton35)
        val button43 = findViewById<ToggleButton>(R.id.toggleButton43)
        val button51 = findViewById<ToggleButton>(R.id.toggleButton51)
        val button59 = findViewById<ToggleButton>(R.id.toggleButton59)
        val button67 = findViewById<ToggleButton>(R.id.toggleButton67)
        val button75 = findViewById<ToggleButton>(R.id.toggleButton75)

        val button4 = findViewById<ToggleButton>(R.id.toggleButton4)
        val button12 = findViewById<ToggleButton>(R.id.toggleButton12)
        val button20 = findViewById<ToggleButton>(R.id.toggleButton20)
        val button28 = findViewById<ToggleButton>(R.id.toggleButton28)
        val button36 = findViewById<ToggleButton>(R.id.toggleButton36)
        val button44 = findViewById<ToggleButton>(R.id.toggleButton44)
        val button52 = findViewById<ToggleButton>(R.id.toggleButton52)
        val button60 = findViewById<ToggleButton>(R.id.toggleButton60)
        val button68 = findViewById<ToggleButton>(R.id.toggleButton68)
        val button76 = findViewById<ToggleButton>(R.id.toggleButton76)

        val button5 = findViewById<ToggleButton>(R.id.toggleButton5)
        val button13 = findViewById<ToggleButton>(R.id.toggleButton13)
        val button21 = findViewById<ToggleButton>(R.id.toggleButton21)
        val button29 = findViewById<ToggleButton>(R.id.toggleButton29)
        val button37 = findViewById<ToggleButton>(R.id.toggleButton37)
        val button45 = findViewById<ToggleButton>(R.id.toggleButton45)
        val button53 = findViewById<ToggleButton>(R.id.toggleButton53)
        val button61 = findViewById<ToggleButton>(R.id.toggleButton61)
        val button69 = findViewById<ToggleButton>(R.id.toggleButton69)
        val button77 = findViewById<ToggleButton>(R.id.toggleButton77)

        val button6 = findViewById<ToggleButton>(R.id.toggleButton6)
        val button14 = findViewById<ToggleButton>(R.id.toggleButton14)
        val button22 = findViewById<ToggleButton>(R.id.toggleButton22)
        val button30 = findViewById<ToggleButton>(R.id.toggleButton30)
        val button38 = findViewById<ToggleButton>(R.id.toggleButton38)
        val button46 = findViewById<ToggleButton>(R.id.toggleButton46)
        val button54 = findViewById<ToggleButton>(R.id.toggleButton54)
        val button62 = findViewById<ToggleButton>(R.id.toggleButton62)
        val button70 = findViewById<ToggleButton>(R.id.toggleButton70)
        val button78 = findViewById<ToggleButton>(R.id.toggleButton78)

        val button7 = findViewById<ToggleButton>(R.id.toggleButton7)
        val button15 = findViewById<ToggleButton>(R.id.toggleButton15)
        val button23 = findViewById<ToggleButton>(R.id.toggleButton23)
        val button31 = findViewById<ToggleButton>(R.id.toggleButton31)
        val button39 = findViewById<ToggleButton>(R.id.toggleButton39)
        val button47 = findViewById<ToggleButton>(R.id.toggleButton47)
        val button55 = findViewById<ToggleButton>(R.id.toggleButton55)
        val button63 = findViewById<ToggleButton>(R.id.toggleButton63)
        val button71 = findViewById<ToggleButton>(R.id.toggleButton71)
        val button79 = findViewById<ToggleButton>(R.id.toggleButton79)

        val button8 = findViewById<ToggleButton>(R.id.toggleButton8)
        val button16 = findViewById<ToggleButton>(R.id.toggleButton16)
        val button24 = findViewById<ToggleButton>(R.id.toggleButton24)
        val button32 = findViewById<ToggleButton>(R.id.toggleButton32)
        val button40 = findViewById<ToggleButton>(R.id.toggleButton40)
        val button48 = findViewById<ToggleButton>(R.id.toggleButton48)
        val button56 = findViewById<ToggleButton>(R.id.toggleButton56)
        val button64 = findViewById<ToggleButton>(R.id.toggleButton64)
        val button72 = findViewById<ToggleButton>(R.id.toggleButton72)
        val button80 = findViewById<ToggleButton>(R.id.toggleButton80)

        //HARF KÜMESİNİ AYARLAMA VE RASTGELELİK SAĞLAMA
        val harfler = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZAEIİOÖUÜ".toCharArray()
        //val harfler = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ".toCharArray()
        val random = IntArray(8)
        for (i in (0..7)) {
            random[i] = (0..65).random()
        }
        val randomrow = (0..7).random()
        //BUTONLARA SATIR BOYUNCA RASTGELE HARF ATAMA
        if(button.text.equals("") && randomrow == 0) {
            button.text = harfler[random[0]].toString()
            button.textOn = harfler[random[0]].toString()
            button.textOff = harfler[random[0]].toString()
        }
        if(button2.text.equals("") && randomrow == 1) {
            button2.text = harfler[random[1]].toString()
            button2.textOn = harfler[random[1]].toString()
            button2.textOff = harfler[random[1]].toString()
        }
        if(button3.text.equals("") && randomrow == 2) {
            button3.text = harfler[random[2]].toString()
            button3.textOn = harfler[random[2]].toString()
            button3.textOff = harfler[random[2]].toString()
        }
        if(button4.text.equals("") && randomrow == 3) {
            button4.text = harfler[random[3]].toString()
            button4.textOn = harfler[random[3]].toString()
            button4.textOff = harfler[random[3]].toString()
        }
        if(button5.text.equals("") && randomrow == 4) {
            button5.text = harfler[random[4]].toString()
            button5.textOn = harfler[random[4]].toString()
            button5.textOff = harfler[random[4]].toString()
        }
        if(button6.text.equals("") && randomrow == 5) {
            button6.text = harfler[random[5]].toString()
            button6.textOn = harfler[random[5]].toString()
            button6.textOff = harfler[random[5]].toString()
        }
        if(button7.text.equals("") && randomrow == 6) {
            button7.text = harfler[random[6]].toString()
            button7.textOn = harfler[random[6]].toString()
            button7.textOff = harfler[random[6]].toString()
        }
        if(button8.text.equals("") && randomrow == 7) {
            button8.text = harfler[random[7]].toString()
            button8.textOn = harfler[random[7]].toString()
            button8.textOff = harfler[random[7]].toString()
        }
    }
    // 3 yanlış yapılınca sütunların üstüne rastgele harf dolduran fonksiyon
    fun rowdrop(){
        val button = findViewById<ToggleButton>(R.id.toggleButton)
        val button2 = findViewById<ToggleButton>(R.id.toggleButton2)
        val button3 = findViewById<ToggleButton>(R.id.toggleButton3)
        val button4 = findViewById<ToggleButton>(R.id.toggleButton4)
        val button5 = findViewById<ToggleButton>(R.id.toggleButton5)
        val button6 = findViewById<ToggleButton>(R.id.toggleButton6)
        val button7 = findViewById<ToggleButton>(R.id.toggleButton7)
        val button8 = findViewById<ToggleButton>(R.id.toggleButton8)

        //HARF KÜMESİNİ AYARLAMA VE RASTGELELİK SAĞLAMA
        val harfler = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZAEIİOÖUÜ".toCharArray()
        //val harfler = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ".toCharArray()
        val random = IntArray(8)
        for (i in (0..7)) {
            random[i] = (0..65).random()
        }
        val randomrow = (0..7).random()
        //BUTONLARA SATIR BOYUNCA RASTGELE HARF ATAMA
        if(button.text.equals("")) {
            button.text = harfler[random[0]].toString()
            button.textOn = harfler[random[0]].toString()
            button.textOff = harfler[random[0]].toString()
        }
        if(button2.text.equals("")) {
            button2.text = harfler[random[1]].toString()
            button2.textOn = harfler[random[1]].toString()
            button2.textOff = harfler[random[1]].toString()
        }
        if(button3.text.equals("")) {
            button3.text = harfler[random[2]].toString()
            button3.textOn = harfler[random[2]].toString()
            button3.textOff = harfler[random[2]].toString()
        }
        if(button4.text.equals("")) {
            button4.text = harfler[random[3]].toString()
            button4.textOn = harfler[random[3]].toString()
            button4.textOff = harfler[random[3]].toString()
        }
        if(button5.text.equals("")) {
            button5.text = harfler[random[4]].toString()
            button5.textOn = harfler[random[4]].toString()
            button5.textOff = harfler[random[4]].toString()
        }
        if(button6.text.equals("")) {
            button6.text = harfler[random[5]].toString()
            button6.textOn = harfler[random[5]].toString()
            button6.textOff = harfler[random[5]].toString()
        }
        if(button7.text.equals("")) {
            button7.text = harfler[random[6]].toString()
            button7.textOn = harfler[random[6]].toString()
            button7.textOff = harfler[random[6]].toString()
        }
        if(button8.text.equals("")) {
            button8.text = harfler[random[7]].toString()
            button8.textOn = harfler[random[7]].toString()
            button8.textOff = harfler[random[7]].toString()
        }

    }
    //Timer hazırlama ve başlatma
    //Bu fonksiyon aynı timer bittikten sonra veya herhangi sütun
    //dolduğunda oyunun bitimini gösteren aktiviteyi çağırır
    //Rastgele harfleri oluşturma fonksiyonu ontick fonksiyonunun
    //içinde oluşturulur böylece harfler kayarak iner
    fun initTimer(view: View){
        val timercancelled = false
        val textview3 = findViewById<TextView>(R.id.textView3)
        val text2 = findViewById<TextView>(R.id.textView2)
        val counter = object : CountDownTimer(190000,1000) {
            override fun onTick(i: Long) {
                textview3.text = "${i / 1000}sn"
                if(text2.text.toString().toInt()>50){
                    if(i.toInt() % 2 == 0){
                        singleletterdrop()
                    }
                }
                if (wrongSelection >= 3){
                    rowdrop()
                    wrongSelection = 0
                }
                else if(i.toInt() % 4 == 0){
                    singleletterdrop()
                }
                val button = findViewById<ToggleButton>(R.id.toggleButton)
                val button2 = findViewById<ToggleButton>(R.id.toggleButton2)
                val button3 = findViewById<ToggleButton>(R.id.toggleButton3)
                val button4 = findViewById<ToggleButton>(R.id.toggleButton4)
                val button5 = findViewById<ToggleButton>(R.id.toggleButton5)
                val button6 = findViewById<ToggleButton>(R.id.toggleButton6)
                val button7 = findViewById<ToggleButton>(R.id.toggleButton7)
                val button8 = findViewById<ToggleButton>(R.id.toggleButton8)

                reversekontrol()
                if(button.text != "" || button2.text != "" || button3.text != "" ||
                    button4.text != "" || button5.text != "" || button6.text != "" ||
                    button7.text != "" || button8.text != "")
                {
                    cancel()
                    button.text = ""
                    button2.text = ""
                    button3.text = ""
                    button4.text = ""
                    button5.text = ""
                    button6.text = ""
                    button7.text = ""
                    button8.text = ""
                    val texts = findViewById<TextView>(R.id.textView2)
                    val puan = texts.text.toString()
                    val intent = Intent(this@GameActivity,Process::class.java)
                    intent.putExtra("puantext",puan)
                    startActivity(intent)
                }

                else {
                }
            }
            override fun onFinish() {
                textview3.text = "Oyun Bitti"
                val puantext = findViewById<TextView>(R.id.textView2).toString()
                val intent = Intent(this@GameActivity,Process::class.java)
                intent.putExtra("puantext",puantext)
                startActivity(intent)

            }
        }
        counter.start()
    }
    //Kelime seçildikten sonra tıklanan kelime kontrol tuşu
    //text dosyasından kontrol yapıp doğru çıkarsa ona göre işlem yapar
    fun wordkontrol(view: View) {
        dkontol()
    }
    fun dkontol() {
        val textView2 = findViewById<TextView>(R.id.textView2)
        val context : Context = this
        val assetManager = context.assets
        val stringBuilder = java.lang.StringBuilder()
        val textview = findViewById<TextView>(R.id.textView)
        var foundflag = 0
        if(chosenword.isNotEmpty())
        {
            chosenword=chosenword
            try{
                val inputStream = assetManager.open("kelime_listesi.txt")
                val inputStreamReader = InputStreamReader(inputStream)
                val bufferedReader = BufferedReader(inputStreamReader)
                var listebe = mutableListOf<String>()
                var line: String? = bufferedReader.readLine()
                while (line != null)
                {
                        stringBuilder.append(line)
                        line = bufferedReader.readLine()
                        listebe.add(line)
                }
                for(kelime in listebe){

                    if(chosenword == kelime) {

                        val button = findViewById<ToggleButton>(R.id.toggleButton)
                        val button9 = findViewById<ToggleButton>(R.id.toggleButton9)
                        val button17 = findViewById<ToggleButton>(R.id.toggleButton17)
                        val button25 = findViewById<ToggleButton>(R.id.toggleButton25)
                        val button33 = findViewById<ToggleButton>(R.id.toggleButton33)
                        val button41 = findViewById<ToggleButton>(R.id.toggleButton41)
                        val button49 = findViewById<ToggleButton>(R.id.toggleButton49)
                        val button57 = findViewById<ToggleButton>(R.id.toggleButton57)
                        val button65 = findViewById<ToggleButton>(R.id.toggleButton65)
                        val button73 = findViewById<ToggleButton>(R.id.toggleButton73)

                        val button2 = findViewById<ToggleButton>(R.id.toggleButton2)
                        val button10 = findViewById<ToggleButton>(R.id.toggleButton10)
                        val button18 = findViewById<ToggleButton>(R.id.toggleButton18)
                        val button26 = findViewById<ToggleButton>(R.id.toggleButton26)
                        val button34 = findViewById<ToggleButton>(R.id.toggleButton34)
                        val button42 = findViewById<ToggleButton>(R.id.toggleButton42)
                        val button50 = findViewById<ToggleButton>(R.id.toggleButton50)
                        val button58 = findViewById<ToggleButton>(R.id.toggleButton58)
                        val button66 = findViewById<ToggleButton>(R.id.toggleButton66)
                        val button74 = findViewById<ToggleButton>(R.id.toggleButton74)

                        val button3 = findViewById<ToggleButton>(R.id.toggleButton3)
                        val button11 = findViewById<ToggleButton>(R.id.toggleButton11)
                        val button19 = findViewById<ToggleButton>(R.id.toggleButton19)
                        val button27 = findViewById<ToggleButton>(R.id.toggleButton27)
                        val button35 = findViewById<ToggleButton>(R.id.toggleButton35)
                        val button43 = findViewById<ToggleButton>(R.id.toggleButton43)
                        val button51 = findViewById<ToggleButton>(R.id.toggleButton51)
                        val button59 = findViewById<ToggleButton>(R.id.toggleButton59)
                        val button67 = findViewById<ToggleButton>(R.id.toggleButton67)
                        val button75 = findViewById<ToggleButton>(R.id.toggleButton75)

                        val button4 = findViewById<ToggleButton>(R.id.toggleButton4)
                        val button12 = findViewById<ToggleButton>(R.id.toggleButton12)
                        val button20 = findViewById<ToggleButton>(R.id.toggleButton20)
                        val button28 = findViewById<ToggleButton>(R.id.toggleButton28)
                        val button36 = findViewById<ToggleButton>(R.id.toggleButton36)
                        val button44 = findViewById<ToggleButton>(R.id.toggleButton44)
                        val button52 = findViewById<ToggleButton>(R.id.toggleButton52)
                        val button60 = findViewById<ToggleButton>(R.id.toggleButton60)
                        val button68 = findViewById<ToggleButton>(R.id.toggleButton68)
                        val button76 = findViewById<ToggleButton>(R.id.toggleButton76)

                        val button5 = findViewById<ToggleButton>(R.id.toggleButton5)
                        val button13 = findViewById<ToggleButton>(R.id.toggleButton13)
                        val button21 = findViewById<ToggleButton>(R.id.toggleButton21)
                        val button29 = findViewById<ToggleButton>(R.id.toggleButton29)
                        val button37 = findViewById<ToggleButton>(R.id.toggleButton37)
                        val button45 = findViewById<ToggleButton>(R.id.toggleButton45)
                        val button53 = findViewById<ToggleButton>(R.id.toggleButton53)
                        val button61 = findViewById<ToggleButton>(R.id.toggleButton61)
                        val button69 = findViewById<ToggleButton>(R.id.toggleButton69)
                        val button77 = findViewById<ToggleButton>(R.id.toggleButton77)

                        val button6 = findViewById<ToggleButton>(R.id.toggleButton6)
                        val button14 = findViewById<ToggleButton>(R.id.toggleButton14)
                        val button22 = findViewById<ToggleButton>(R.id.toggleButton22)
                        val button30 = findViewById<ToggleButton>(R.id.toggleButton30)
                        val button38 = findViewById<ToggleButton>(R.id.toggleButton38)
                        val button46 = findViewById<ToggleButton>(R.id.toggleButton46)
                        val button54 = findViewById<ToggleButton>(R.id.toggleButton54)
                        val button62 = findViewById<ToggleButton>(R.id.toggleButton62)
                        val button70 = findViewById<ToggleButton>(R.id.toggleButton70)
                        val button78 = findViewById<ToggleButton>(R.id.toggleButton78)

                        val button7 = findViewById<ToggleButton>(R.id.toggleButton7)
                        val button15 = findViewById<ToggleButton>(R.id.toggleButton15)
                        val button23 = findViewById<ToggleButton>(R.id.toggleButton23)
                        val button31 = findViewById<ToggleButton>(R.id.toggleButton31)
                        val button39 = findViewById<ToggleButton>(R.id.toggleButton39)
                        val button47 = findViewById<ToggleButton>(R.id.toggleButton47)
                        val button55 = findViewById<ToggleButton>(R.id.toggleButton55)
                        val button63 = findViewById<ToggleButton>(R.id.toggleButton63)
                        val button71 = findViewById<ToggleButton>(R.id.toggleButton71)
                        val button79 = findViewById<ToggleButton>(R.id.toggleButton79)

                        val button8 = findViewById<ToggleButton>(R.id.toggleButton8)
                        val button16 = findViewById<ToggleButton>(R.id.toggleButton16)
                        val button24 = findViewById<ToggleButton>(R.id.toggleButton24)
                        val button32 = findViewById<ToggleButton>(R.id.toggleButton32)
                        val button40 = findViewById<ToggleButton>(R.id.toggleButton40)
                        val button48 = findViewById<ToggleButton>(R.id.toggleButton48)
                        val button56 = findViewById<ToggleButton>(R.id.toggleButton56)
                        val button64 = findViewById<ToggleButton>(R.id.toggleButton64)
                        val button72 = findViewById<ToggleButton>(R.id.toggleButton72)
                        val button80 = findViewById<ToggleButton>(R.id.toggleButton80)

                        var buttons = listOf<ToggleButton>(button,button2,button3,button4,button5,button6,button7,button8,button9,
                            button10,button11,button12,button13,button14,button15,button16,button17,button18,button19,
                            button20, button21,button22,button23,button24,button25,button26,button27,button28,button29,
                            button30,button31, button32,button33,button34,button35,button36,button37,button38,button39,
                            button40,button41,button42, button43,button44,button45,button46,button47,button48,button49,
                            button50,button51,button52,button53, button54,button55,button56,button57,button58,button59,
                            button60,button61,button62,button63,button64,button65,button66,button67,button68,button69,
                            button70,button71,button72,button73,button74,button75,button76,button77,button78,button79,button80)
                        for (button in buttons) {
                            if (button.isSelected == true) {
                                button.text = ""
                                button.textOff = ""
                                button.textOn = ""
                                button.isSelected = false
                                button.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                            }
                        }

                        totalkontrol()
                        val textView = findViewById<TextView>(R.id.textView)
                        textView.text = ""
                        //Puan Hesaplama Alanı

                        val puanlar = hashMapOf<Char, Int>( // Harf-puan eşleştirmelerini tutan bir HashMap
                            'A' to 1, 'B' to 3, 'C' to 4, 'Ç' to 4, 'D' to 3, 'E' to 1, 'F' to 7, 'G' to 5, 'Ğ' to 8,
                            'H' to 5, 'ı' to 2, 'i' to 1, 'J' to 10, 'K' to 1, 'L' to 1, 'M' to 2, 'N' to 1,
                            'O' to 2, 'Ö' to 7, 'P' to 5, 'R' to 1, 'S' to 2, 'Ş' to 4, 'T' to 1, 'U' to 2,
                            'Ü' to 3, 'V' to 7, 'Y' to 3, 'Z' to 4
                        )

                        var toplamPuan = 0 // Toplam puanı tutmak için bir değişken

                        var wordd = kelime.uppercase()
                        // Kelimeyi döngüye alarak harf puanlarını hesapla
                        for (harf in wordd) {
                             // Harfi büyük harfe çevir (puanlar HashMap'i büyük harfle tanımlanmış)
                            if (puanlar.containsKey(harf)) { // Eğer harf puanlar HashMap'inde bulunuyorsa
                                toplamPuan += puanlar[harf]!! // Harf puanını toplamPuana ekle
                            }
                        }
                        toplamPuan = toplamPuan+textView2.text.toString().toInt()
                        chosenword = ""
                        chosenwordcount = 0
                        //var puan = textView2.text.toString().toInt()+puanhesaplama(chosenword)
                        textView2.text = toplamPuan.toString()
                        foundflag++
                    }
                }
                if(foundflag == 0)
                {
                    wrongSelection++
                }
                val button = findViewById<ToggleButton>(R.id.toggleButton)
                val button9 = findViewById<ToggleButton>(R.id.toggleButton9)
                val button17 = findViewById<ToggleButton>(R.id.toggleButton17)
                val button25 = findViewById<ToggleButton>(R.id.toggleButton25)
                val button33 = findViewById<ToggleButton>(R.id.toggleButton33)
                val button41 = findViewById<ToggleButton>(R.id.toggleButton41)
                val button49 = findViewById<ToggleButton>(R.id.toggleButton49)
                val button57 = findViewById<ToggleButton>(R.id.toggleButton57)
                val button65 = findViewById<ToggleButton>(R.id.toggleButton65)
                val button73 = findViewById<ToggleButton>(R.id.toggleButton73)

                val button2 = findViewById<ToggleButton>(R.id.toggleButton2)
                val button10 = findViewById<ToggleButton>(R.id.toggleButton10)
                val button18 = findViewById<ToggleButton>(R.id.toggleButton18)
                val button26 = findViewById<ToggleButton>(R.id.toggleButton26)
                val button34 = findViewById<ToggleButton>(R.id.toggleButton34)
                val button42 = findViewById<ToggleButton>(R.id.toggleButton42)
                val button50 = findViewById<ToggleButton>(R.id.toggleButton50)
                val button58 = findViewById<ToggleButton>(R.id.toggleButton58)
                val button66 = findViewById<ToggleButton>(R.id.toggleButton66)
                val button74 = findViewById<ToggleButton>(R.id.toggleButton74)

                val button3 = findViewById<ToggleButton>(R.id.toggleButton3)
                val button11 = findViewById<ToggleButton>(R.id.toggleButton11)
                val button19 = findViewById<ToggleButton>(R.id.toggleButton19)
                val button27 = findViewById<ToggleButton>(R.id.toggleButton27)
                val button35 = findViewById<ToggleButton>(R.id.toggleButton35)
                val button43 = findViewById<ToggleButton>(R.id.toggleButton43)
                val button51 = findViewById<ToggleButton>(R.id.toggleButton51)
                val button59 = findViewById<ToggleButton>(R.id.toggleButton59)
                val button67 = findViewById<ToggleButton>(R.id.toggleButton67)
                val button75 = findViewById<ToggleButton>(R.id.toggleButton75)

                val button4 = findViewById<ToggleButton>(R.id.toggleButton4)
                val button12 = findViewById<ToggleButton>(R.id.toggleButton12)
                val button20 = findViewById<ToggleButton>(R.id.toggleButton20)
                val button28 = findViewById<ToggleButton>(R.id.toggleButton28)
                val button36 = findViewById<ToggleButton>(R.id.toggleButton36)
                val button44 = findViewById<ToggleButton>(R.id.toggleButton44)
                val button52 = findViewById<ToggleButton>(R.id.toggleButton52)
                val button60 = findViewById<ToggleButton>(R.id.toggleButton60)
                val button68 = findViewById<ToggleButton>(R.id.toggleButton68)
                val button76 = findViewById<ToggleButton>(R.id.toggleButton76)

                val button5 = findViewById<ToggleButton>(R.id.toggleButton5)
                val button13 = findViewById<ToggleButton>(R.id.toggleButton13)
                val button21 = findViewById<ToggleButton>(R.id.toggleButton21)
                val button29 = findViewById<ToggleButton>(R.id.toggleButton29)
                val button37 = findViewById<ToggleButton>(R.id.toggleButton37)
                val button45 = findViewById<ToggleButton>(R.id.toggleButton45)
                val button53 = findViewById<ToggleButton>(R.id.toggleButton53)
                val button61 = findViewById<ToggleButton>(R.id.toggleButton61)
                val button69 = findViewById<ToggleButton>(R.id.toggleButton69)
                val button77 = findViewById<ToggleButton>(R.id.toggleButton77)

                val button6 = findViewById<ToggleButton>(R.id.toggleButton6)
                val button14 = findViewById<ToggleButton>(R.id.toggleButton14)
                val button22 = findViewById<ToggleButton>(R.id.toggleButton22)
                val button30 = findViewById<ToggleButton>(R.id.toggleButton30)
                val button38 = findViewById<ToggleButton>(R.id.toggleButton38)
                val button46 = findViewById<ToggleButton>(R.id.toggleButton46)
                val button54 = findViewById<ToggleButton>(R.id.toggleButton54)
                val button62 = findViewById<ToggleButton>(R.id.toggleButton62)
                val button70 = findViewById<ToggleButton>(R.id.toggleButton70)
                val button78 = findViewById<ToggleButton>(R.id.toggleButton78)

                val button7 = findViewById<ToggleButton>(R.id.toggleButton7)
                val button15 = findViewById<ToggleButton>(R.id.toggleButton15)
                val button23 = findViewById<ToggleButton>(R.id.toggleButton23)
                val button31 = findViewById<ToggleButton>(R.id.toggleButton31)
                val button39 = findViewById<ToggleButton>(R.id.toggleButton39)
                val button47 = findViewById<ToggleButton>(R.id.toggleButton47)
                val button55 = findViewById<ToggleButton>(R.id.toggleButton55)
                val button63 = findViewById<ToggleButton>(R.id.toggleButton63)
                val button71 = findViewById<ToggleButton>(R.id.toggleButton71)
                val button79 = findViewById<ToggleButton>(R.id.toggleButton79)

                val button8 = findViewById<ToggleButton>(R.id.toggleButton8)
                val button16 = findViewById<ToggleButton>(R.id.toggleButton16)
                val button24 = findViewById<ToggleButton>(R.id.toggleButton24)
                val button32 = findViewById<ToggleButton>(R.id.toggleButton32)
                val button40 = findViewById<ToggleButton>(R.id.toggleButton40)
                val button48 = findViewById<ToggleButton>(R.id.toggleButton48)
                val button56 = findViewById<ToggleButton>(R.id.toggleButton56)
                val button64 = findViewById<ToggleButton>(R.id.toggleButton64)
                val button72 = findViewById<ToggleButton>(R.id.toggleButton72)
                val button80 = findViewById<ToggleButton>(R.id.toggleButton80)

                var buttons = listOf<ToggleButton>(button,button2,button3,button4,button5,button6,button7,button8,button9,
                    button10,button11,button12,button13,button14,button15,button16,button17,button18,button19,
                    button20, button21,button22,button23,button24,button25,button26,button27,button28,button29,
                    button30,button31, button32,button33,button34,button35,button36,button37,button38,button39,
                    button40,button41,button42, button43,button44,button45,button46,button47,button48,button49,
                    button50,button51,button52,button53,button54,button55,button56,button57,button58,button59,
                    button60,button61,button62,button63,button64,button65,button66,button67,button68,button69,
                    button70,button71,button72,button73,button74,button75,button76,button77,button78,button79,button80)
                for (button in buttons) {
                    if (button.isSelected == true) {
                        button.isSelected = false
                        button.setBackgroundColor(ContextCompat.getColor(this, R.color.white))

                    }
                }
                chosenword = ""
                chosenwordcount = 0
                textview.text = ""

                bufferedReader.close()
                inputStreamReader.close()
                inputStream.close()
            }catch(e:IOException){
                e.printStackTrace()
            }
        }
    }
    //Kelime yazısını temizleme tuşu
    fun cleanup(view: View) {
        val puantext = findViewById<TextView>(R.id.textView3).toString()
        intent = Intent(this@GameActivity,Process::class.java)
        intent.putExtra("puantext",puantext)
        startActivity(intent)

        val button = findViewById<ToggleButton>(R.id.toggleButton)
        val button9 = findViewById<ToggleButton>(R.id.toggleButton9)
        val button17 = findViewById<ToggleButton>(R.id.toggleButton17)
        val button25 = findViewById<ToggleButton>(R.id.toggleButton25)
        val button33 = findViewById<ToggleButton>(R.id.toggleButton33)
        val button41 = findViewById<ToggleButton>(R.id.toggleButton41)
        val button49 = findViewById<ToggleButton>(R.id.toggleButton49)
        val button57 = findViewById<ToggleButton>(R.id.toggleButton57)
        val button65 = findViewById<ToggleButton>(R.id.toggleButton65)
        val button73 = findViewById<ToggleButton>(R.id.toggleButton73)

        val button2 = findViewById<ToggleButton>(R.id.toggleButton2)
        val button10 = findViewById<ToggleButton>(R.id.toggleButton10)
        val button18 = findViewById<ToggleButton>(R.id.toggleButton18)
        val button26 = findViewById<ToggleButton>(R.id.toggleButton26)
        val button34 = findViewById<ToggleButton>(R.id.toggleButton34)
        val button42 = findViewById<ToggleButton>(R.id.toggleButton42)
        val button50 = findViewById<ToggleButton>(R.id.toggleButton50)
        val button58 = findViewById<ToggleButton>(R.id.toggleButton58)
        val button66 = findViewById<ToggleButton>(R.id.toggleButton66)
        val button74 = findViewById<ToggleButton>(R.id.toggleButton74)

        val button3 = findViewById<ToggleButton>(R.id.toggleButton3)
        val button11 = findViewById<ToggleButton>(R.id.toggleButton11)
        val button19 = findViewById<ToggleButton>(R.id.toggleButton19)
        val button27 = findViewById<ToggleButton>(R.id.toggleButton27)
        val button35 = findViewById<ToggleButton>(R.id.toggleButton35)
        val button43 = findViewById<ToggleButton>(R.id.toggleButton43)
        val button51 = findViewById<ToggleButton>(R.id.toggleButton51)
        val button59 = findViewById<ToggleButton>(R.id.toggleButton59)
        val button67 = findViewById<ToggleButton>(R.id.toggleButton67)
        val button75 = findViewById<ToggleButton>(R.id.toggleButton75)

        val button4 = findViewById<ToggleButton>(R.id.toggleButton4)
        val button12 = findViewById<ToggleButton>(R.id.toggleButton12)
        val button20 = findViewById<ToggleButton>(R.id.toggleButton20)
        val button28 = findViewById<ToggleButton>(R.id.toggleButton28)
        val button36 = findViewById<ToggleButton>(R.id.toggleButton36)
        val button44 = findViewById<ToggleButton>(R.id.toggleButton44)
        val button52 = findViewById<ToggleButton>(R.id.toggleButton52)
        val button60 = findViewById<ToggleButton>(R.id.toggleButton60)
        val button68 = findViewById<ToggleButton>(R.id.toggleButton68)
        val button76 = findViewById<ToggleButton>(R.id.toggleButton76)

        val button5 = findViewById<ToggleButton>(R.id.toggleButton5)
        val button13 = findViewById<ToggleButton>(R.id.toggleButton13)
        val button21 = findViewById<ToggleButton>(R.id.toggleButton21)
        val button29 = findViewById<ToggleButton>(R.id.toggleButton29)
        val button37 = findViewById<ToggleButton>(R.id.toggleButton37)
        val button45 = findViewById<ToggleButton>(R.id.toggleButton45)
        val button53 = findViewById<ToggleButton>(R.id.toggleButton53)
        val button61 = findViewById<ToggleButton>(R.id.toggleButton61)
        val button69 = findViewById<ToggleButton>(R.id.toggleButton69)
        val button77 = findViewById<ToggleButton>(R.id.toggleButton77)

        val button6 = findViewById<ToggleButton>(R.id.toggleButton6)
        val button14 = findViewById<ToggleButton>(R.id.toggleButton14)
        val button22 = findViewById<ToggleButton>(R.id.toggleButton22)
        val button30 = findViewById<ToggleButton>(R.id.toggleButton30)
        val button38 = findViewById<ToggleButton>(R.id.toggleButton38)
        val button46 = findViewById<ToggleButton>(R.id.toggleButton46)
        val button54 = findViewById<ToggleButton>(R.id.toggleButton54)
        val button62 = findViewById<ToggleButton>(R.id.toggleButton62)
        val button70 = findViewById<ToggleButton>(R.id.toggleButton70)
        val button78 = findViewById<ToggleButton>(R.id.toggleButton78)

        val button7 = findViewById<ToggleButton>(R.id.toggleButton7)
        val button15 = findViewById<ToggleButton>(R.id.toggleButton15)
        val button23 = findViewById<ToggleButton>(R.id.toggleButton23)
        val button31 = findViewById<ToggleButton>(R.id.toggleButton31)
        val button39 = findViewById<ToggleButton>(R.id.toggleButton39)
        val button47 = findViewById<ToggleButton>(R.id.toggleButton47)
        val button55 = findViewById<ToggleButton>(R.id.toggleButton55)
        val button63 = findViewById<ToggleButton>(R.id.toggleButton63)
        val button71 = findViewById<ToggleButton>(R.id.toggleButton71)
        val button79 = findViewById<ToggleButton>(R.id.toggleButton79)

        val button8 = findViewById<ToggleButton>(R.id.toggleButton8)
        val button16 = findViewById<ToggleButton>(R.id.toggleButton16)
        val button24 = findViewById<ToggleButton>(R.id.toggleButton24)
        val button32 = findViewById<ToggleButton>(R.id.toggleButton32)
        val button40 = findViewById<ToggleButton>(R.id.toggleButton40)
        val button48 = findViewById<ToggleButton>(R.id.toggleButton48)
        val button56 = findViewById<ToggleButton>(R.id.toggleButton56)
        val button64 = findViewById<ToggleButton>(R.id.toggleButton64)
        val button72 = findViewById<ToggleButton>(R.id.toggleButton72)
        val button80 = findViewById<ToggleButton>(R.id.toggleButton80)

        var buttons = listOf<ToggleButton>(button,button2,button3,button4,button5,button6,button7,button8,button9,
            button10,button11,button12,button13,button14,button15,button16,button17,button18,button19,
            button20, button21,button22,button23,button24,button25,button26,button27,button28,button29,
            button30,button31, button32,button33,button34,button35,button36,button37,button38,button39,
            button40,button41,button42, button43,button44,button45,button46,button47,button48,button49,
            button50,button51,button52,button53, button54,button55,button56,button57,button58,button59,
            button60,button61,button62,button63,button64,button65,button66,button67,button68,button69,
            button70,button71,button72,button73,button74,button75,button76,button77,button78,button79,button80)

        chosenword = ""
        chosenwordcount = 0
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = ""
        for (button in buttons)
        {
            if(button.isSelected == true) {
                button.isSelected = false
                button.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
            }
        }
    }
    //Tuşlarla seçilen harfleri geriye almak için fonksiyon
    fun removeCharAt(str: String, index: Int): String {
        val stringBuilder = StringBuilder(str)
        stringBuilder.deleteCharAt(index)
        return stringBuilder.toString()
    }
    //Oyun akışını yukarı aşağı kaymayı sağlamak için
    //yukarı aşağı kontrol fonksiyonları içeren fonksiyon
    fun totalkontrol() {
        reversekontrol()
        reversekontrol()
        reversekontrol()
        kontrol()
        kontrol()
        kontrol()
        val button = findViewById<ToggleButton>(R.id.toggleButton)
    }
    //Aşağıdan yukarı kayma kontrol mekanizması
    fun reversekontrol(){
        val button = findViewById<ToggleButton>(R.id.toggleButton)
        val button9 = findViewById<ToggleButton>(R.id.toggleButton9)
        val button17 = findViewById<ToggleButton>(R.id.toggleButton17)
        val button25 = findViewById<ToggleButton>(R.id.toggleButton25)
        val button33 = findViewById<ToggleButton>(R.id.toggleButton33)
        val button41 = findViewById<ToggleButton>(R.id.toggleButton41)
        val button49 = findViewById<ToggleButton>(R.id.toggleButton49)
        val button57 = findViewById<ToggleButton>(R.id.toggleButton57)
        val button65 = findViewById<ToggleButton>(R.id.toggleButton65)
        val button73 = findViewById<ToggleButton>(R.id.toggleButton73)

        val button2 = findViewById<ToggleButton>(R.id.toggleButton2)
        val button10 = findViewById<ToggleButton>(R.id.toggleButton10)
        val button18 = findViewById<ToggleButton>(R.id.toggleButton18)
        val button26 = findViewById<ToggleButton>(R.id.toggleButton26)
        val button34 = findViewById<ToggleButton>(R.id.toggleButton34)
        val button42 = findViewById<ToggleButton>(R.id.toggleButton42)
        val button50 = findViewById<ToggleButton>(R.id.toggleButton50)
        val button58 = findViewById<ToggleButton>(R.id.toggleButton58)
        val button66 = findViewById<ToggleButton>(R.id.toggleButton66)
        val button74 = findViewById<ToggleButton>(R.id.toggleButton74)

        val button3 = findViewById<ToggleButton>(R.id.toggleButton3)
        val button11 = findViewById<ToggleButton>(R.id.toggleButton11)
        val button19 = findViewById<ToggleButton>(R.id.toggleButton19)
        val button27 = findViewById<ToggleButton>(R.id.toggleButton27)
        val button35 = findViewById<ToggleButton>(R.id.toggleButton35)
        val button43 = findViewById<ToggleButton>(R.id.toggleButton43)
        val button51 = findViewById<ToggleButton>(R.id.toggleButton51)
        val button59 = findViewById<ToggleButton>(R.id.toggleButton59)
        val button67 = findViewById<ToggleButton>(R.id.toggleButton67)
        val button75 = findViewById<ToggleButton>(R.id.toggleButton75)

        val button4 = findViewById<ToggleButton>(R.id.toggleButton4)
        val button12 = findViewById<ToggleButton>(R.id.toggleButton12)
        val button20 = findViewById<ToggleButton>(R.id.toggleButton20)
        val button28 = findViewById<ToggleButton>(R.id.toggleButton28)
        val button36 = findViewById<ToggleButton>(R.id.toggleButton36)
        val button44 = findViewById<ToggleButton>(R.id.toggleButton44)
        val button52 = findViewById<ToggleButton>(R.id.toggleButton52)
        val button60 = findViewById<ToggleButton>(R.id.toggleButton60)
        val button68 = findViewById<ToggleButton>(R.id.toggleButton68)
        val button76 = findViewById<ToggleButton>(R.id.toggleButton76)

        val button5 = findViewById<ToggleButton>(R.id.toggleButton5)
        val button13 = findViewById<ToggleButton>(R.id.toggleButton13)
        val button21 = findViewById<ToggleButton>(R.id.toggleButton21)
        val button29 = findViewById<ToggleButton>(R.id.toggleButton29)
        val button37 = findViewById<ToggleButton>(R.id.toggleButton37)
        val button45 = findViewById<ToggleButton>(R.id.toggleButton45)
        val button53 = findViewById<ToggleButton>(R.id.toggleButton53)
        val button61 = findViewById<ToggleButton>(R.id.toggleButton61)
        val button69 = findViewById<ToggleButton>(R.id.toggleButton69)
        val button77 = findViewById<ToggleButton>(R.id.toggleButton77)

        val button6 = findViewById<ToggleButton>(R.id.toggleButton6)
        val button14 = findViewById<ToggleButton>(R.id.toggleButton14)
        val button22 = findViewById<ToggleButton>(R.id.toggleButton22)
        val button30 = findViewById<ToggleButton>(R.id.toggleButton30)
        val button38 = findViewById<ToggleButton>(R.id.toggleButton38)
        val button46 = findViewById<ToggleButton>(R.id.toggleButton46)
        val button54 = findViewById<ToggleButton>(R.id.toggleButton54)
        val button62 = findViewById<ToggleButton>(R.id.toggleButton62)
        val button70 = findViewById<ToggleButton>(R.id.toggleButton70)
        val button78 = findViewById<ToggleButton>(R.id.toggleButton78)

        val button7 = findViewById<ToggleButton>(R.id.toggleButton7)
        val button15 = findViewById<ToggleButton>(R.id.toggleButton15)
        val button23 = findViewById<ToggleButton>(R.id.toggleButton23)
        val button31 = findViewById<ToggleButton>(R.id.toggleButton31)
        val button39 = findViewById<ToggleButton>(R.id.toggleButton39)
        val button47 = findViewById<ToggleButton>(R.id.toggleButton47)
        val button55 = findViewById<ToggleButton>(R.id.toggleButton55)
        val button63 = findViewById<ToggleButton>(R.id.toggleButton63)
        val button71 = findViewById<ToggleButton>(R.id.toggleButton71)
        val button79 = findViewById<ToggleButton>(R.id.toggleButton79)

        val button8 = findViewById<ToggleButton>(R.id.toggleButton8)
        val button16 = findViewById<ToggleButton>(R.id.toggleButton16)
        val button24 = findViewById<ToggleButton>(R.id.toggleButton24)
        val button32 = findViewById<ToggleButton>(R.id.toggleButton32)
        val button40 = findViewById<ToggleButton>(R.id.toggleButton40)
        val button48 = findViewById<ToggleButton>(R.id.toggleButton48)
        val button56 = findViewById<ToggleButton>(R.id.toggleButton56)
        val button64 = findViewById<ToggleButton>(R.id.toggleButton64)
        val button72 = findViewById<ToggleButton>(R.id.toggleButton72)
        val button80 = findViewById<ToggleButton>(R.id.toggleButton80)

        if(button73.text.isEmpty()) { button73.text = button65.text
            button73.textOff = button65.textOff
            button73.textOn = button65.textOn
            button65.textOn = ""
            button65.textOff = ""
            button65.text = "" }
        if(button65.text.isEmpty()) { button65.text = button57.text
            button65.textOff = button57.textOff
            button65.textOn = button57.textOn
            button57.textOn = ""
            button57.textOff = ""
            button57.text = "" }
        if(button57.text.isEmpty()) { button57.text = button49.text
            button57.textOff = button49.textOff
            button57.textOn = button49.textOn
            button49.textOn = ""
            button49.textOff = ""
            button49.text = "" }
        if(button49.text.isEmpty()) { button49.text = button41.text
            button49.textOff = button41.textOff
            button49.textOn = button41.textOn
            button41.textOn = ""
            button41.textOff = ""
            button41.text = "" }
        if(button41.text.isEmpty()) { button41.text = button33.text
            button41.textOff = button33.textOff
            button41.textOn = button33.textOn
            button33.textOn = ""
            button33.textOff = ""
            button33.text = "" }
        if(button33.text.isEmpty()) { button33.text = button25.text
            button33.textOff = button25.textOff
            button33.textOn = button25.textOn
            button25.textOn = ""
            button25.textOff = ""
            button25.text = "" }
        if(button25.text.isEmpty()) { button25.text = button17.text
            button25.textOff = button17.textOff
            button25.textOn = button17.textOn
            button17.textOn = ""
            button17.textOff = ""
            button17.text = "" }
        if(button17.text.isEmpty()) { button17.text = button9.text
            button17.textOff = button9.textOff
            button17.textOn = button9.textOn
            button9.textOn = ""
            button9.textOff = ""
            button9.text = "" }
        if(button9.text.isEmpty()) { button9.text = button.text
            button9.textOff = button.textOff
            button9.textOn = button.textOn
            button.textOn = ""
            button.textOff = ""
            button.text = "" }

        if(button74.text.isEmpty()) { button74.text = button66.text
            button74.textOff = button66.textOff
            button74.textOn = button66.textOn
            button66.textOn = ""
            button66.textOff = ""
            button66.text = "" }
        if(button66.text.isEmpty()) { button66.text = button58.text
            button66.textOff = button58.textOff
            button66.textOn = button58.textOn
            button58.textOn = ""
            button58.textOff = ""
            button58.text = "" }
        if(button58.text.isEmpty()) { button58.text = button50.text
            button58.textOff = button50.textOff
            button58.textOn = button50.textOn
            button50.textOn = ""
            button50.textOff = ""
            button50.text = "" }
        if(button50.text.isEmpty()) { button50.text = button42.text
            button50.textOff = button42.textOff
            button50.textOn = button42.textOn
            button42.textOn = ""
            button42.textOff = ""
            button42.text = "" }
        if(button42.text.isEmpty()) { button42.text = button34.text
            button42.textOff = button34.textOff
            button42.textOn = button34.textOn
            button34.textOn = ""
            button34.textOff = ""
            button34.text = "" }
        if(button34.text.isEmpty()) { button34.text = button26.text
            button34.textOff = button26.textOff
            button34.textOn = button26.textOn
            button26.textOn = ""
            button26.textOff = ""
            button26.text = "" }
        if(button26.text.isEmpty()) { button26.text = button18.text
            button26.textOff = button18.textOff
            button26.textOn = button18.textOn
            button18.textOn = ""
            button18.textOff = ""
            button18.text = "" }
        if(button18.text.isEmpty()) { button18.text = button10.text
            button18.textOff = button10.textOff
            button18.textOn = button10.textOn
            button10.textOn = ""
            button10.textOff = ""
            button10.text = "" }
        if(button10.text.isEmpty()) { button10.text = button2.text
            button10.textOff = button2.textOff
            button10.textOn = button2.textOn
            button2.textOn = ""
            button2.textOff = ""
            button2.text = "" }

        if(button75.text.isEmpty()) { button75.text = button67.text
            button75.textOff = button67.textOff
            button75.textOn = button67.textOn
            button67.textOn = ""
            button67.textOff = ""
            button67.text = "" }
        if(button67.text.isEmpty()) { button67.text = button59.text
            button67.textOff = button59.textOff
            button67.textOn = button59.textOn
            button59.textOn = ""
            button59.textOff = ""
            button59.text = "" }
        if(button59.text.isEmpty()) { button59.text = button51.text
            button59.textOff = button51.textOff
            button59.textOn = button51.textOn
            button51.textOn = ""
            button51.textOff = ""
            button51.text = "" }
        if(button51.text.isEmpty()) { button51.text = button43.text
            button51.textOff = button43.textOff
            button51.textOn = button43.textOn
            button43.textOn = ""
            button43.textOff = ""
            button43.text = "" }
        if(button43.text.isEmpty()) { button43.text = button35.text
            button43.textOff = button35.textOff
            button43.textOn = button35.textOn
            button35.textOn = ""
            button35.textOff = ""
            button35.text = "" }
        if(button35.text.isEmpty()) { button35.text = button27.text
            button35.textOff = button27.textOff
            button35.textOn = button27.textOn
            button27.textOn = ""
            button27.textOff = ""
            button27.text = "" }
        if(button27.text.isEmpty()) { button27.text = button19.text
            button27.textOff = button19.textOff
            button27.textOn = button19.textOn
            button19.textOn = ""
            button19.textOff = ""
            button19.text = "" }
        if(button19.text.isEmpty()) { button19.text = button11.text
            button19.textOff = button11.textOff
            button19.textOn = button11.textOn
            button11.textOn = ""
            button11.textOff = ""
            button11.text = "" }
        if(button11.text.isEmpty()) { button11.text = button3.text
            button11.textOff = button3.textOff
            button11.textOn = button3.textOn
            button3.textOn = ""
            button3.textOff = ""
            button3.text = "" }

        if(button76.text.isEmpty()) { button76.text = button68.text
            button76.textOff = button68.textOff
            button76.textOn = button68.textOn
            button68.textOn = ""
            button68.textOff = ""
            button68.text = "" }
        if(button68.text.isEmpty()) { button68.text = button60.text
            button68.textOff = button60.textOff
            button68.textOn = button60.textOn
            button60.textOn = ""
            button60.textOff = ""
            button60.text = "" }
        if(button60.text.isEmpty()) { button60.text = button52.text
            button60.textOff = button52.textOff
            button60.textOn = button52.textOn
            button52.textOn = ""
            button52.textOff = ""
            button52.text = "" }
        if(button52.text.isEmpty()) { button52.text = button44.text
            button52.textOff = button44.textOff
            button52.textOn = button44.textOn
            button44.textOn = ""
            button44.textOff = ""
            button44.text = "" }
        if(button44.text.isEmpty()) { button44.text = button36.text
            button44.textOff = button36.textOff
            button44.textOn = button36.textOn
            button36.textOn = ""
            button36.textOff = ""
            button36.text = "" }
        if(button36.text.isEmpty()) { button36.text = button28.text
            button36.textOff = button28.textOff
            button36.textOn = button28.textOn
            button28.textOn = ""
            button28.textOff = ""
            button28.text = "" }
        if(button28.text.isEmpty()) { button28.text = button20.text
            button28.textOff = button20.textOff
            button28.textOn = button20.textOn
            button20.textOn = ""
            button20.textOff = ""
            button20.text = "" }
        if(button20.text.isEmpty()) { button20.text = button12.text
            button20.textOff = button12.textOff
            button20.textOn = button12.textOn
            button12.textOn = ""
            button12.textOff = ""
            button12.text = "" }
        if(button12.text.isEmpty()) { button12.text = button4.text
            button12.textOff = button4.textOff
            button12.textOn = button4.textOn
            button4.textOn = ""
            button4.textOff = ""
            button4.text = "" }

        if(button77.text.isEmpty()) { button77.text = button69.text
            button77.textOff = button69.textOff
            button77.textOn = button69.textOn
            button69.textOn = ""
            button69.textOff = ""
            button69.text = "" }
        if(button69.text.isEmpty()) { button69.text = button61.text
            button69.textOff = button61.textOff
            button69.textOn = button61.textOn
            button61.textOn = ""
            button61.textOff = ""
            button61.text = "" }
        if(button61.text.isEmpty()) { button61.text = button53.text
            button61.textOff = button53.textOff
            button61.textOn = button53.textOn
            button53.textOn = ""
            button53.textOff = ""
            button53.text = "" }
        if(button53.text.isEmpty()) { button53.text = button45.text
            button53.textOff = button45.textOff
            button53.textOn = button45.textOn
            button45.textOn = ""
            button45.textOff = ""
            button45.text = "" }
        if(button45.text.isEmpty()) { button45.text = button37.text
            button45.textOff = button37.textOff
            button45.textOn = button37.textOn
            button37.textOn = ""
            button37.textOff = ""
            button37.text = "" }
        if(button37.text.isEmpty()) { button37.text = button29.text
            button37.textOff = button29.textOff
            button37.textOn = button29.textOn
            button29.textOn = ""
            button29.textOff = ""
            button29.text = "" }
        if(button29.text.isEmpty()) { button29.text = button21.text
            button29.textOff = button21.textOff
            button29.textOn = button21.textOn
            button21.textOn = ""
            button21.textOff = ""
            button21.text = "" }
        if(button21.text.isEmpty()) { button21.text = button13.text
            button21.textOff = button13.textOff
            button21.textOn = button13.textOn
            button13.textOn = ""
            button13.textOff = ""
            button13.text = "" }
        if(button13.text.isEmpty()) { button13.text = button5.text
            button13.textOff = button5.textOff
            button13.textOn = button5.textOn
            button5.textOn = ""
            button5.textOff = ""
            button5.text = "" }

        if(button78.text.isEmpty()) { button78.text = button70.text
            button78.textOff = button70.textOff
            button78.textOn = button70.textOn
            button70.textOn = ""
            button70.textOff = ""
            button70.text = "" }
        if(button70.text.isEmpty()) { button70.text = button62.text
            button70.textOff = button62.textOff
            button70.textOn = button62.textOn
            button62.textOn = ""
            button62.textOff = ""
            button62.text = "" }
        if(button62.text.isEmpty()) { button62.text = button54.text
            button62.textOff = button54.textOff
            button62.textOn = button54.textOn
            button54.textOn = ""
            button54.textOff = ""
            button54.text = "" }
        if(button54.text.isEmpty()) { button54.text = button46.text
            button54.textOff = button46.textOff
            button54.textOn = button46.textOn
            button46.textOn = ""
            button46.textOff = ""
            button46.text = "" }
        if(button46.text.isEmpty()) { button46.text = button38.text
            button46.textOff = button38.textOff
            button46.textOn = button38.textOn
            button38.textOn = ""
            button38.textOff = ""
            button38.text = "" }
        if(button38.text.isEmpty()) { button38.text = button30.text
            button38.textOff = button30.textOff
            button38.textOn = button30.textOn
            button30.textOn = ""
            button30.textOff = ""
            button30.text = "" }
        if(button30.text.isEmpty()) { button30.text = button22.text
            button30.textOff = button22.textOff
            button30.textOn = button22.textOn
            button22.textOn = ""
            button22.textOff = ""
            button22.text = "" }
        if(button22.text.isEmpty()) { button22.text = button14.text
            button22.textOff = button14.textOff
            button22.textOn = button14.textOn
            button14.textOn = ""
            button14.textOff = ""
            button14.text = "" }
        if(button14.text.isEmpty()) { button14.text = button6.text
            button14.textOff = button6.textOff
            button14.textOn = button6.textOn
            button6.textOn = ""
            button6.textOff = ""
            button6.text = "" }

        if(button79.text.isEmpty()) { button79.text = button71.text
            button79.textOff = button71.textOff
            button79.textOn = button71.textOn
            button71.textOn = ""
            button71.textOff = ""
            button71.text = "" }
        if(button71.text.isEmpty()) { button71.text = button63.text
            button71.textOff = button63.textOff
            button71.textOn = button63.textOn
            button63.textOn = ""
            button63.textOff = ""
            button63.text = "" }
        if(button63.text.isEmpty()) { button63.text = button55.text
            button63.textOff = button55.textOff
            button63.textOn = button55.textOn
            button55.textOn = ""
            button55.textOff = ""
            button55.text = "" }
        if(button55.text.isEmpty()) { button55.text = button47.text
            button55.textOff = button47.textOff
            button55.textOn = button47.textOn
            button47.textOn = ""
            button47.textOff = ""
            button47.text = "" }
        if(button47.text.isEmpty()) { button47.text = button39.text
            button47.textOff = button39.textOff
            button47.textOn = button39.textOn
            button39.textOn = ""
            button39.textOff = ""
            button39.text = "" }
        if(button39.text.isEmpty()) { button39.text = button31.text
            button39.textOff = button31.textOff
            button39.textOn = button31.textOn
            button31.textOn = ""
            button31.textOff = ""
            button31.text = "" }
        if(button31.text.isEmpty()) { button31.text = button23.text
            button31.textOff = button23.textOff
            button31.textOn = button23.textOn
            button23.textOn = ""
            button23.textOff = ""
            button23.text = "" }
        if(button23.text.isEmpty()) { button23.text = button15.text
            button23.textOff = button15.textOff
            button23.textOn = button15.textOn
            button15.textOn = ""
            button15.textOff = ""
            button15.text = "" }
        if(button15.text.isEmpty()) { button15.text = button7.text
            button15.textOff = button7.textOff
            button15.textOn = button7.textOn
            button7.textOn = ""
            button7.textOff = ""
            button7.text = "" }

        if(button80.text.isEmpty()) { button80.text = button72.text
            button80.textOff = button72.textOff
            button80.textOn = button72.textOn
            button72.textOn = ""
            button72.textOff = ""
            button72.text = "" }
        if(button72.text.isEmpty()) { button72.text = button64.text
            button72.textOff = button64.textOff
            button72.textOn = button64.textOn
            button64.textOn = ""
            button64.textOff = ""
            button64.text = "" }
        if(button64.text.isEmpty()) { button64.text = button56.text
            button64.textOff = button56.textOff
            button64.textOn = button56.textOn
            button56.textOn = ""
            button56.textOff = ""
            button56.text = "" }
        if(button56.text.isEmpty()) { button56.text = button48.text
            button56.textOff = button48.textOff
            button56.textOn = button48.textOn
            button48.textOn = ""
            button48.textOff = ""
            button48.text = "" }
        if(button48.text.isEmpty()) { button48.text = button40.text
            button48.textOff = button40.textOff
            button48.textOn = button40.textOn
            button40.textOn = ""
            button40.textOff = ""
            button40.text = "" }
        if(button40.text.isEmpty()) { button40.text = button32.text
            button40.textOff = button32.textOff
            button40.textOn = button32.textOn
            button32.textOn = ""
            button32.textOff = ""
            button32.text = "" }
        if(button32.text.isEmpty()) { button32.text = button24.text
            button32.textOff = button24.textOff
            button32.textOn = button24.textOn
            button24.textOn = ""
            button24.textOff = ""
            button24.text = "" }
        if(button24.text.isEmpty()) { button24.text = button16.text
            button24.textOff = button16.textOff
            button24.textOn = button16.textOn
            button16.textOn = ""
            button16.textOff = ""
            button16.text = "" }
        if(button16.text.isEmpty()) { button16.text = button8.text
            button16.textOff = button8.textOff
            button16.textOn = button8.textOn
            button8.textOn = ""
            button8.textOff = ""
            button8.text = "" }
    }
    //Yukarıdan aşağı kayma kontrol mekanizması
    fun kontrol(){
        val button = findViewById<ToggleButton>(R.id.toggleButton)
        val button9 = findViewById<ToggleButton>(R.id.toggleButton9)
        val button17 = findViewById<ToggleButton>(R.id.toggleButton17)
        val button25 = findViewById<ToggleButton>(R.id.toggleButton25)
        val button33 = findViewById<ToggleButton>(R.id.toggleButton33)
        val button41 = findViewById<ToggleButton>(R.id.toggleButton41)
        val button49 = findViewById<ToggleButton>(R.id.toggleButton49)
        val button57 = findViewById<ToggleButton>(R.id.toggleButton57)
        val button65 = findViewById<ToggleButton>(R.id.toggleButton65)
        val button73 = findViewById<ToggleButton>(R.id.toggleButton73)

        val button2 = findViewById<ToggleButton>(R.id.toggleButton2)
        val button10 = findViewById<ToggleButton>(R.id.toggleButton10)
        val button18 = findViewById<ToggleButton>(R.id.toggleButton18)
        val button26 = findViewById<ToggleButton>(R.id.toggleButton26)
        val button34 = findViewById<ToggleButton>(R.id.toggleButton34)
        val button42 = findViewById<ToggleButton>(R.id.toggleButton42)
        val button50 = findViewById<ToggleButton>(R.id.toggleButton50)
        val button58 = findViewById<ToggleButton>(R.id.toggleButton58)
        val button66 = findViewById<ToggleButton>(R.id.toggleButton66)
        val button74 = findViewById<ToggleButton>(R.id.toggleButton74)

        val button3 = findViewById<ToggleButton>(R.id.toggleButton3)
        val button11 = findViewById<ToggleButton>(R.id.toggleButton11)
        val button19 = findViewById<ToggleButton>(R.id.toggleButton19)
        val button27 = findViewById<ToggleButton>(R.id.toggleButton27)
        val button35 = findViewById<ToggleButton>(R.id.toggleButton35)
        val button43 = findViewById<ToggleButton>(R.id.toggleButton43)
        val button51 = findViewById<ToggleButton>(R.id.toggleButton51)
        val button59 = findViewById<ToggleButton>(R.id.toggleButton59)
        val button67 = findViewById<ToggleButton>(R.id.toggleButton67)
        val button75 = findViewById<ToggleButton>(R.id.toggleButton75)

        val button4 = findViewById<ToggleButton>(R.id.toggleButton4)
        val button12 = findViewById<ToggleButton>(R.id.toggleButton12)
        val button20 = findViewById<ToggleButton>(R.id.toggleButton20)
        val button28 = findViewById<ToggleButton>(R.id.toggleButton28)
        val button36 = findViewById<ToggleButton>(R.id.toggleButton36)
        val button44 = findViewById<ToggleButton>(R.id.toggleButton44)
        val button52 = findViewById<ToggleButton>(R.id.toggleButton52)
        val button60 = findViewById<ToggleButton>(R.id.toggleButton60)
        val button68 = findViewById<ToggleButton>(R.id.toggleButton68)
        val button76 = findViewById<ToggleButton>(R.id.toggleButton76)

        val button5 = findViewById<ToggleButton>(R.id.toggleButton5)
        val button13 = findViewById<ToggleButton>(R.id.toggleButton13)
        val button21 = findViewById<ToggleButton>(R.id.toggleButton21)
        val button29 = findViewById<ToggleButton>(R.id.toggleButton29)
        val button37 = findViewById<ToggleButton>(R.id.toggleButton37)
        val button45 = findViewById<ToggleButton>(R.id.toggleButton45)
        val button53 = findViewById<ToggleButton>(R.id.toggleButton53)
        val button61 = findViewById<ToggleButton>(R.id.toggleButton61)
        val button69 = findViewById<ToggleButton>(R.id.toggleButton69)
        val button77 = findViewById<ToggleButton>(R.id.toggleButton77)

        val button6 = findViewById<ToggleButton>(R.id.toggleButton6)
        val button14 = findViewById<ToggleButton>(R.id.toggleButton14)
        val button22 = findViewById<ToggleButton>(R.id.toggleButton22)
        val button30 = findViewById<ToggleButton>(R.id.toggleButton30)
        val button38 = findViewById<ToggleButton>(R.id.toggleButton38)
        val button46 = findViewById<ToggleButton>(R.id.toggleButton46)
        val button54 = findViewById<ToggleButton>(R.id.toggleButton54)
        val button62 = findViewById<ToggleButton>(R.id.toggleButton62)
        val button70 = findViewById<ToggleButton>(R.id.toggleButton70)
        val button78 = findViewById<ToggleButton>(R.id.toggleButton78)

        val button7 = findViewById<ToggleButton>(R.id.toggleButton7)
        val button15 = findViewById<ToggleButton>(R.id.toggleButton15)
        val button23 = findViewById<ToggleButton>(R.id.toggleButton23)
        val button31 = findViewById<ToggleButton>(R.id.toggleButton31)
        val button39 = findViewById<ToggleButton>(R.id.toggleButton39)
        val button47 = findViewById<ToggleButton>(R.id.toggleButton47)
        val button55 = findViewById<ToggleButton>(R.id.toggleButton55)
        val button63 = findViewById<ToggleButton>(R.id.toggleButton63)
        val button71 = findViewById<ToggleButton>(R.id.toggleButton71)
        val button79 = findViewById<ToggleButton>(R.id.toggleButton79)

        val button8 = findViewById<ToggleButton>(R.id.toggleButton8)
        val button16 = findViewById<ToggleButton>(R.id.toggleButton16)
        val button24 = findViewById<ToggleButton>(R.id.toggleButton24)
        val button32 = findViewById<ToggleButton>(R.id.toggleButton32)
        val button40 = findViewById<ToggleButton>(R.id.toggleButton40)
        val button48 = findViewById<ToggleButton>(R.id.toggleButton48)
        val button56 = findViewById<ToggleButton>(R.id.toggleButton56)
        val button64 = findViewById<ToggleButton>(R.id.toggleButton64)
        val button72 = findViewById<ToggleButton>(R.id.toggleButton72)
        val button80 = findViewById<ToggleButton>(R.id.toggleButton80)

        if(button9.text.isEmpty()) { button9.text = button.text
            button9.textOff = button.textOff
            button9.textOn = button.textOn
            button.textOn = ""
            button.textOff = ""
            button.text = "" }
        if(button17.text.isEmpty()) { button17.text = button9.text
            button17.textOff = button9.textOff
            button17.textOn = button9.textOn
            button9.textOn = ""
            button9.textOff = ""
            button9.text = "" }
        if(button25.text.isEmpty()) { button25.text = button17.text
            button25.textOff = button17.textOff
            button25.textOn = button17.textOn
            button17.textOn = ""
            button17.textOff = ""
            button17.text = "" }
        if(button33.text.isEmpty()) { button33.text = button25.text
            button33.textOff = button25.textOff
            button33.textOn = button25.textOn
            button25.textOn = ""
            button25.textOff = ""
            button25.text = "" }
        if(button41.text.isEmpty()) { button41.text = button33.text
            button41.textOff = button33.textOff
            button41.textOn = button33.textOn
            button33.textOn = ""
            button33.textOff = ""
            button33.text = "" }
        if(button49.text.isEmpty()) { button49.text = button41.text
            button49.textOff = button41.textOff
            button49.textOn = button41.textOn
            button41.textOn = ""
            button41.textOff = ""
            button41.text = "" }
        if(button57.text.isEmpty()) { button57.text = button49.text
            button57.textOff = button49.textOff
            button57.textOn = button49.textOn
            button49.textOn = ""
            button49.textOff = ""
            button49.text = "" }
        if(button65.text.isEmpty()) { button65.text = button57.text
            button65.textOff = button57.textOff
            button65.textOn = button57.textOn
            button57.textOn = ""
            button57.textOff = ""
            button57.text = "" }
        if(button73.text.isEmpty()) { button73.text = button65.text
            button73.textOff = button65.textOff
            button73.textOn = button65.textOn
            button65.textOn = ""
            button65.textOff = ""
            button65.text = "" }

        if(button10.text.isEmpty()) { button10.text = button2.text
            button10.textOff = button2.textOff
            button10.textOn = button2.textOn
            button2.textOn = ""
            button2.textOff = ""
            button2.text = "" }
        if(button18.text.isEmpty()) { button18.text = button10.text
            button18.textOff = button10.textOff
            button18.textOn = button10.textOn
            button10.textOn = ""
            button10.textOff = ""
            button10.text = "" }
        if(button26.text.isEmpty()) { button26.text = button18.text
            button26.textOff = button18.textOff
            button26.textOn = button18.textOn
            button18.textOn = ""
            button18.textOff = ""
            button18.text = "" }
        if(button34.text.isEmpty()) { button34.text = button26.text
            button34.textOff = button26.textOff
            button34.textOn = button26.textOn
            button26.textOn = ""
            button26.textOff = ""
            button26.text = "" }
        if(button42.text.isEmpty()) { button42.text = button34.text
            button42.textOff = button34.textOff
            button42.textOn = button34.textOn
            button34.textOn = ""
            button34.textOff = ""
            button34.text = "" }
        if(button50.text.isEmpty()) { button50.text = button42.text
            button50.textOff = button42.textOff
            button50.textOn = button42.textOn
            button42.textOn = ""
            button42.textOff = ""
            button42.text = "" }
        if(button58.text.isEmpty()) { button58.text = button50.text
            button58.textOff = button50.textOff
            button58.textOn = button50.textOn
            button50.textOn = ""
            button50.textOff = ""
            button50.text = "" }
        if(button66.text.isEmpty()) { button66.text = button58.text
            button66.textOff = button58.textOff
            button66.textOn = button58.textOn
            button58.textOn = ""
            button58.textOff = ""
            button58.text = "" }
        if(button74.text.isEmpty()) { button74.text = button66.text
            button74.textOff = button66.textOff
            button74.textOn = button66.textOn
            button66.textOn = ""
            button66.textOff = ""
            button66.text = "" }

        if(button11.text.isEmpty()) { button11.text = button3.text
            button11.textOff = button3.textOff
            button11.textOn = button3.textOn
            button3.textOn = ""
            button3.textOff = ""
            button3.text = "" }
        if(button19.text.isEmpty()) { button19.text = button11.text
            button19.textOff = button11.textOff
            button19.textOn = button11.textOn
            button11.textOn = ""
            button11.textOff = ""
            button11.text = "" }
        if(button27.text.isEmpty()) { button27.text = button19.text
            button27.textOff = button19.textOff
            button27.textOn = button19.textOn
            button19.textOn = ""
            button19.textOff = ""
            button19.text = "" }
        if(button35.text.isEmpty()) { button35.text = button27.text
            button35.textOff = button27.textOff
            button35.textOn = button27.textOn
            button27.textOn = ""
            button27.textOff = ""
            button27.text = "" }
        if(button43.text.isEmpty()) { button43.text = button35.text
            button43.textOff = button35.textOff
            button43.textOn = button35.textOn
            button35.textOn = ""
            button35.textOff = ""
            button35.text = "" }
        if(button51.text.isEmpty()) { button51.text = button43.text
            button51.textOff = button43.textOff
            button51.textOn = button43.textOn
            button43.textOn = ""
            button43.textOff = ""
            button43.text = "" }
        if(button59.text.isEmpty()) { button59.text = button51.text
            button59.textOff = button51.textOff
            button59.textOn = button51.textOn
            button51.textOn = ""
            button51.textOff = ""
            button51.text = "" }
        if(button67.text.isEmpty()) { button67.text = button59.text
            button67.textOff = button59.textOff
            button67.textOn = button59.textOn
            button59.textOn = ""
            button59.textOff = ""
            button59.text = "" }
        if(button75.text.isEmpty()) { button75.text = button67.text
            button75.textOff = button67.textOff
            button75.textOn = button67.textOn
            button67.textOn = ""
            button67.textOff = ""
            button67.text = "" }

        if(button12.text.isEmpty()) { button12.text = button4.text
            button12.textOff = button4.textOff
            button12.textOn = button4.textOn
            button4.textOn = ""
            button4.textOff = ""
            button4.text = "" }
        if(button20.text.isEmpty()) { button20.text = button12.text
            button20.textOff = button12.textOff
            button20.textOn = button12.textOn
            button12.textOn = ""
            button12.textOff = ""
            button12.text = "" }
        if(button28.text.isEmpty()) { button28.text = button20.text
            button28.textOff = button20.textOff
            button28.textOn = button20.textOn
            button20.textOn = ""
            button20.textOff = ""
            button20.text = "" }
        if(button36.text.isEmpty()) { button36.text = button28.text
            button36.textOff = button28.textOff
            button36.textOn = button28.textOn
            button28.textOn = ""
            button28.textOff = ""
            button28.text = "" }
        if(button44.text.isEmpty()) { button44.text = button36.text
            button44.textOff = button36.textOff
            button44.textOn = button36.textOn
            button36.textOn = ""
            button36.textOff = ""
            button36.text = "" }
        if(button52.text.isEmpty()) { button52.text = button44.text
            button52.textOff = button44.textOff
            button52.textOn = button44.textOn
            button44.textOn = ""
            button44.textOff = ""
            button44.text = "" }
        if(button60.text.isEmpty()) { button60.text = button52.text
            button60.textOff = button52.textOff
            button60.textOn = button52.textOn
            button52.textOn = ""
            button52.textOff = ""
            button52.text = "" }
        if(button68.text.isEmpty()) { button68.text = button60.text
            button68.textOff = button60.textOff
            button68.textOn = button60.textOn
            button60.textOn = ""
            button60.textOff = ""
            button60.text = "" }
        if(button76.text.isEmpty()) { button76.text = button68.text
            button76.textOff = button68.textOff
            button76.textOn = button68.textOn
            button68.textOn = ""
            button68.textOff = ""
            button68.text = "" }

        if(button13.text.isEmpty()) { button13.text = button5.text
            button13.textOff = button5.textOff
            button13.textOn = button5.textOn
            button5.textOn = ""
            button5.textOff = ""
            button5.text = "" }
        if(button21.text.isEmpty()) { button21.text = button13.text
            button21.textOff = button13.textOff
            button21.textOn = button13.textOn
            button13.textOn = ""
            button13.textOff = ""
            button13.text = "" }
        if(button29.text.isEmpty()) { button29.text = button21.text
            button29.textOff = button21.textOff
            button29.textOn = button21.textOn
            button21.textOn = ""
            button21.textOff = ""
            button21.text = "" }
        if(button37.text.isEmpty()) { button37.text = button29.text
            button37.textOff = button29.textOff
            button37.textOn = button29.textOn
            button29.textOn = ""
            button29.textOff = ""
            button29.text = "" }
        if(button45.text.isEmpty()) { button45.text = button37.text
            button45.textOff = button37.textOff
            button45.textOn = button37.textOn
            button37.textOn = ""
            button37.textOff = ""
            button37.text = "" }
        if(button53.text.isEmpty()) { button53.text = button45.text
            button53.textOff = button45.textOff
            button53.textOn = button45.textOn
            button45.textOn = ""
            button45.textOff = ""
            button45.text = "" }
        if(button61.text.isEmpty()) { button61.text = button53.text
            button61.textOff = button53.textOff
            button61.textOn = button53.textOn
            button53.textOn = ""
            button53.textOff = ""
            button53.text = "" }
        if(button69.text.isEmpty()) { button69.text = button61.text
            button69.textOff = button61.textOff
            button69.textOn = button61.textOn
            button61.textOn = ""
            button61.textOff = ""
            button61.text = "" }
        if(button77.text.isEmpty()) { button77.text = button69.text
            button77.textOff = button69.textOff
            button77.textOn = button69.textOn
            button69.textOn = ""
            button69.textOff = ""
            button69.text = "" }

        if(button14.text.isEmpty()) { button14.text = button6.text
            button14.textOff = button6.textOff
            button14.textOn = button6.textOn
            button6.textOn = ""
            button6.textOff = ""
            button6.text = "" }
        if(button22.text.isEmpty()) { button22.text = button14.text
            button22.textOff = button14.textOff
            button22.textOn = button14.textOn
            button14.textOn = ""
            button14.textOff = ""
            button14.text = "" }
        if(button30.text.isEmpty()) { button30.text = button22.text
            button30.textOff = button22.textOff
            button30.textOn = button22.textOn
            button22.textOn = ""
            button22.textOff = ""
            button22.text = "" }
        if(button38.text.isEmpty()) { button38.text = button30.text
            button38.textOff = button30.textOff
            button38.textOn = button30.textOn
            button30.textOn = ""
            button30.textOff = ""
            button30.text = "" }
        if(button46.text.isEmpty()) { button46.text = button38.text
            button46.textOff = button38.textOff
            button46.textOn = button38.textOn
            button38.textOn = ""
            button38.textOff = ""
            button38.text = "" }
        if(button54.text.isEmpty()) { button54.text = button46.text
            button54.textOff = button46.textOff
            button54.textOn = button46.textOn
            button46.textOn = ""
            button46.textOff = ""
            button46.text = "" }
        if(button62.text.isEmpty()) { button62.text = button54.text
            button62.textOff = button54.textOff
            button62.textOn = button54.textOn
            button54.textOn = ""
            button54.textOff = ""
            button54.text = "" }
        if(button70.text.isEmpty()) { button70.text = button62.text
            button70.textOff = button62.textOff
            button70.textOn = button62.textOn
            button62.textOn = ""
            button62.textOff = ""
            button62.text = "" }
        if(button78.text.isEmpty()) { button78.text = button70.text
            button78.textOff = button70.textOff
            button78.textOn = button70.textOn
            button70.textOn = ""
            button70.textOff = ""
            button70.text = "" }

        if(button15.text.isEmpty()) { button15.text = button7.text
            button15.textOff = button7.textOff
            button15.textOn = button7.textOn
            button7.textOn = ""
            button7.textOff = ""
            button7.text = "" }
        if(button23.text.isEmpty()) { button23.text = button15.text
            button23.textOff = button15.textOff
            button23.textOn = button15.textOn
            button15.textOn = ""
            button15.textOff = ""
            button15.text = "" }
        if(button31.text.isEmpty()) { button31.text = button23.text
            button31.textOff = button23.textOff
            button31.textOn = button23.textOn
            button23.textOn = ""
            button23.textOff = ""
            button23.text = "" }
        if(button39.text.isEmpty()) { button39.text = button31.text
            button39.textOff = button31.textOff
            button39.textOn = button31.textOn
            button31.textOn = ""
            button31.textOff = ""
            button31.text = "" }
        if(button47.text.isEmpty()) { button47.text = button39.text
            button47.textOff = button39.textOff
            button47.textOn = button39.textOn
            button39.textOn = ""
            button39.textOff = ""
            button39.text = "" }
        if(button55.text.isEmpty()) { button55.text = button47.text
            button55.textOff = button47.textOff
            button55.textOn = button47.textOn
            button47.textOn = ""
            button47.textOff = ""
            button47.text = "" }
        if(button63.text.isEmpty()) { button63.text = button55.text
            button63.textOff = button55.textOff
            button63.textOn = button55.textOn
            button55.textOn = ""
            button55.textOff = ""
            button55.text = "" }
        if(button71.text.isEmpty()) { button71.text = button63.text
            button71.textOff = button63.textOff
            button71.textOn = button63.textOn
            button63.textOn = ""
            button63.textOff = ""
            button63.text = "" }
        if(button79.text.isEmpty()) { button79.text = button71.text
            button79.textOff = button71.textOff
            button79.textOn = button71.textOn
            button71.textOn = ""
            button71.textOff = ""
            button71.text = "" }

        if(button16.text.isEmpty()) { button16.text = button8.text
            button16.textOff = button8.textOff
            button16.textOn = button8.textOn
            button8.textOn = ""
            button8.textOff = ""
            button8.text = "" }
        if(button24.text.isEmpty()) { button24.text = button16.text
            button24.textOff = button16.textOff
            button24.textOn = button16.textOn
            button16.textOn = ""
            button16.textOff = ""
            button16.text = "" }
        if(button32.text.isEmpty()) { button32.text = button24.text
            button32.textOff = button24.textOff
            button32.textOn = button24.textOn
            button24.textOn = ""
            button24.textOff = ""
            button24.text = "" }
        if(button40.text.isEmpty()) { button40.text = button32.text
            button40.textOff = button32.textOff
            button40.textOn = button32.textOn
            button32.textOn = ""
            button32.textOff = ""
            button32.text = "" }
        if(button48.text.isEmpty()) { button48.text = button40.text
            button48.textOff = button40.textOff
            button48.textOn = button40.textOn
            button40.textOn = ""
            button40.textOff = ""
            button40.text = "" }
        if(button56.text.isEmpty()) { button56.text = button48.text
            button56.textOff = button48.textOff
            button56.textOn = button48.textOn
            button48.textOn = ""
            button48.textOff = ""
            button48.text = "" }
        if(button64.text.isEmpty()) { button64.text = button56.text
            button64.textOff = button56.textOff
            button64.textOn = button56.textOn
            button56.textOn = ""
            button56.textOff = ""
            button56.text = "" }
        if(button72.text.isEmpty()) { button72.text = button64.text
            button72.textOff = button64.textOff
            button72.textOn = button64.textOn
            button64.textOn = ""
            button64.textOff = ""
            button64.text = "" }
        if(button80.text.isEmpty()) { button80.text = button72.text
            button80.textOff = button72.textOff
            button80.textOn = button72.textOn
            button72.textOn = ""
            button72.textOff = ""
            button72.text = "" }
    }
    //Oyun başladığında 3 satır doldurma fonskiyonu
    fun satirdoldurma(){

        val button = findViewById<ToggleButton>(R.id.toggleButton)
        val button9 = findViewById<ToggleButton>(R.id.toggleButton9)
        val button17 = findViewById<ToggleButton>(R.id.toggleButton17)
        val button25 = findViewById<ToggleButton>(R.id.toggleButton25)
        val button33 = findViewById<ToggleButton>(R.id.toggleButton33)
        val button41 = findViewById<ToggleButton>(R.id.toggleButton41)
        val button49 = findViewById<ToggleButton>(R.id.toggleButton49)
        val button57 = findViewById<ToggleButton>(R.id.toggleButton57)
        val button65 = findViewById<ToggleButton>(R.id.toggleButton65)
        val button73 = findViewById<ToggleButton>(R.id.toggleButton73)

        val button2 = findViewById<ToggleButton>(R.id.toggleButton2)
        val button10 = findViewById<ToggleButton>(R.id.toggleButton10)
        val button18 = findViewById<ToggleButton>(R.id.toggleButton18)
        val button26 = findViewById<ToggleButton>(R.id.toggleButton26)
        val button34 = findViewById<ToggleButton>(R.id.toggleButton34)
        val button42 = findViewById<ToggleButton>(R.id.toggleButton42)
        val button50 = findViewById<ToggleButton>(R.id.toggleButton50)
        val button58 = findViewById<ToggleButton>(R.id.toggleButton58)
        val button66 = findViewById<ToggleButton>(R.id.toggleButton66)
        val button74 = findViewById<ToggleButton>(R.id.toggleButton74)

        val button3 = findViewById<ToggleButton>(R.id.toggleButton3)
        val button11 = findViewById<ToggleButton>(R.id.toggleButton11)
        val button19 = findViewById<ToggleButton>(R.id.toggleButton19)
        val button27 = findViewById<ToggleButton>(R.id.toggleButton27)
        val button35 = findViewById<ToggleButton>(R.id.toggleButton35)
        val button43 = findViewById<ToggleButton>(R.id.toggleButton43)
        val button51 = findViewById<ToggleButton>(R.id.toggleButton51)
        val button59 = findViewById<ToggleButton>(R.id.toggleButton59)
        val button67 = findViewById<ToggleButton>(R.id.toggleButton67)
        val button75 = findViewById<ToggleButton>(R.id.toggleButton75)

        val button4 = findViewById<ToggleButton>(R.id.toggleButton4)
        val button12 = findViewById<ToggleButton>(R.id.toggleButton12)
        val button20 = findViewById<ToggleButton>(R.id.toggleButton20)
        val button28 = findViewById<ToggleButton>(R.id.toggleButton28)
        val button36 = findViewById<ToggleButton>(R.id.toggleButton36)
        val button44 = findViewById<ToggleButton>(R.id.toggleButton44)
        val button52 = findViewById<ToggleButton>(R.id.toggleButton52)
        val button60 = findViewById<ToggleButton>(R.id.toggleButton60)
        val button68 = findViewById<ToggleButton>(R.id.toggleButton68)
        val button76 = findViewById<ToggleButton>(R.id.toggleButton76)

        val button5 = findViewById<ToggleButton>(R.id.toggleButton5)
        val button13 = findViewById<ToggleButton>(R.id.toggleButton13)
        val button21 = findViewById<ToggleButton>(R.id.toggleButton21)
        val button29 = findViewById<ToggleButton>(R.id.toggleButton29)
        val button37 = findViewById<ToggleButton>(R.id.toggleButton37)
        val button45 = findViewById<ToggleButton>(R.id.toggleButton45)
        val button53 = findViewById<ToggleButton>(R.id.toggleButton53)
        val button61 = findViewById<ToggleButton>(R.id.toggleButton61)
        val button69 = findViewById<ToggleButton>(R.id.toggleButton69)
        val button77 = findViewById<ToggleButton>(R.id.toggleButton77)

        val button6 = findViewById<ToggleButton>(R.id.toggleButton6)
        val button14 = findViewById<ToggleButton>(R.id.toggleButton14)
        val button22 = findViewById<ToggleButton>(R.id.toggleButton22)
        val button30 = findViewById<ToggleButton>(R.id.toggleButton30)
        val button38 = findViewById<ToggleButton>(R.id.toggleButton38)
        val button46 = findViewById<ToggleButton>(R.id.toggleButton46)
        val button54 = findViewById<ToggleButton>(R.id.toggleButton54)
        val button62 = findViewById<ToggleButton>(R.id.toggleButton62)
        val button70 = findViewById<ToggleButton>(R.id.toggleButton70)
        val button78 = findViewById<ToggleButton>(R.id.toggleButton78)

        val button7 = findViewById<ToggleButton>(R.id.toggleButton7)
        val button15 = findViewById<ToggleButton>(R.id.toggleButton15)
        val button23 = findViewById<ToggleButton>(R.id.toggleButton23)
        val button31 = findViewById<ToggleButton>(R.id.toggleButton31)
        val button39 = findViewById<ToggleButton>(R.id.toggleButton39)
        val button47 = findViewById<ToggleButton>(R.id.toggleButton47)
        val button55 = findViewById<ToggleButton>(R.id.toggleButton55)
        val button63 = findViewById<ToggleButton>(R.id.toggleButton63)
        val button71 = findViewById<ToggleButton>(R.id.toggleButton71)
        val button79 = findViewById<ToggleButton>(R.id.toggleButton79)

        val button8 = findViewById<ToggleButton>(R.id.toggleButton8)
        val button16 = findViewById<ToggleButton>(R.id.toggleButton16)
        val button24 = findViewById<ToggleButton>(R.id.toggleButton24)
        val button32 = findViewById<ToggleButton>(R.id.toggleButton32)
        val button40 = findViewById<ToggleButton>(R.id.toggleButton40)
        val button48 = findViewById<ToggleButton>(R.id.toggleButton48)
        val button56 = findViewById<ToggleButton>(R.id.toggleButton56)
        val button64 = findViewById<ToggleButton>(R.id.toggleButton64)
        val button72 = findViewById<ToggleButton>(R.id.toggleButton72)
        val button80 = findViewById<ToggleButton>(R.id.toggleButton80)

        //HARF KÜMESİNİ AYARLAMA VE RASTGELELİK SAĞLAMA
        val harfler = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZAEIİOÖUÜ".toCharArray()
        //val harfler = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ".toCharArray()
        val random = IntArray(8)
        for (i in (0..7)) {
            random[i] = (0..65).random()
        }
        //BUTONLARA SATIR BOYUNCA RASTGELE HARF ATAMA
        if(button.text.equals("")) {
            button.text = harfler[random[0]].toString()
            button.textOn = harfler[random[0]].toString()
            button.textOff = harfler[random[0]].toString()
        }
        if(button2.text.equals("")) {
            button2.text = harfler[random[1]].toString()
            button2.textOn = harfler[random[1]].toString()
            button2.textOff = harfler[random[1]].toString()
        }
        if(button3.text.equals("")) {
            button3.text = harfler[random[2]].toString()
            button3.textOn = harfler[random[2]].toString()
            button3.textOff = harfler[random[2]].toString()
        }
        if(button4.text.equals("")) {
            button4.text = harfler[random[3]].toString()
            button4.textOn = harfler[random[3]].toString()
            button4.textOff = harfler[random[3]].toString()
        }
        if(button5.text.equals("")) {
            button5.text = harfler[random[4]].toString()
            button5.textOn = harfler[random[4]].toString()
            button5.textOff = harfler[random[4]].toString()
        }
        if(button6.text.equals("")) {
            button6.text = harfler[random[5]].toString()
            button6.textOn = harfler[random[5]].toString()
            button6.textOff = harfler[random[5]].toString()
        }
        if(button7.text.equals("")) {
            button7.text = harfler[random[6]].toString()
            button7.textOn = harfler[random[6]].toString()
            button7.textOff = harfler[random[6]].toString()
        }
        if(button8.text.equals("")) {
            button8.text = harfler[random[7]].toString()
            button8.textOn = harfler[random[7]].toString()
            button8.textOff = harfler[random[7]].toString()
        }


        if(button9.text.isEmpty()) { button9.text = button.text
            button9.textOff = button.textOff
            button9.textOn = button.textOn
            button.textOn = ""
            button.textOff = ""
            button.text = "" }
        if(button17.text.isEmpty()) { button17.text = button9.text
            button17.textOff = button9.textOff
            button17.textOn = button9.textOn
            button9.textOn = ""
            button9.textOff = ""
            button9.text = "" }
        if(button25.text.isEmpty()) { button25.text = button17.text
            button25.textOff = button17.textOff
            button25.textOn = button17.textOn
            button17.textOn = ""
            button17.textOff = ""
            button17.text = "" }
        if(button33.text.isEmpty()) { button33.text = button25.text
            button33.textOff = button25.textOff
            button33.textOn = button25.textOn
            button25.textOn = ""
            button25.textOff = ""
            button25.text = "" }
        if(button41.text.isEmpty()) { button41.text = button33.text
            button41.textOff = button33.textOff
            button41.textOn = button33.textOn
            button33.textOn = ""
            button33.textOff = ""
            button33.text = "" }
        if(button49.text.isEmpty()) { button49.text = button41.text
            button49.textOff = button41.textOff
            button49.textOn = button41.textOn
            button41.textOn = ""
            button41.textOff = ""
            button41.text = "" }
        if(button57.text.isEmpty()) { button57.text = button49.text
            button57.textOff = button49.textOff
            button57.textOn = button49.textOn
            button49.textOn = ""
            button49.textOff = ""
            button49.text = "" }
        if(button65.text.isEmpty()) { button65.text = button57.text
            button65.textOff = button57.textOff
            button65.textOn = button57.textOn
            button57.textOn = ""
            button57.textOff = ""
            button57.text = "" }
        if(button73.text.isEmpty()) { button73.text = button65.text
            button73.textOff = button65.textOff
            button73.textOn = button65.textOn
            button65.textOn = ""
            button65.textOff = ""
            button65.text = "" }

        if(button10.text.isEmpty()) { button10.text = button2.text
            button10.textOff = button2.textOff
            button10.textOn = button2.textOn
            button2.textOn = ""
            button2.textOff = ""
            button2.text = "" }
        if(button18.text.isEmpty()) { button18.text = button10.text
            button18.textOff = button10.textOff
            button18.textOn = button10.textOn
            button10.textOn = ""
            button10.textOff = ""
            button10.text = "" }
        if(button26.text.isEmpty()) { button26.text = button18.text
            button26.textOff = button18.textOff
            button26.textOn = button18.textOn
            button18.textOn = ""
            button18.textOff = ""
            button18.text = "" }
        if(button34.text.isEmpty()) { button34.text = button26.text
            button34.textOff = button26.textOff
            button34.textOn = button26.textOn
            button26.textOn = ""
            button26.textOff = ""
            button26.text = "" }
        if(button42.text.isEmpty()) { button42.text = button34.text
            button42.textOff = button34.textOff
            button42.textOn = button34.textOn
            button34.textOn = ""
            button34.textOff = ""
            button34.text = "" }
        if(button50.text.isEmpty()) { button50.text = button42.text
            button50.textOff = button42.textOff
            button50.textOn = button42.textOn
            button42.textOn = ""
            button42.textOff = ""
            button42.text = "" }
        if(button58.text.isEmpty()) { button58.text = button50.text
            button58.textOff = button50.textOff
            button58.textOn = button50.textOn
            button50.textOn = ""
            button50.textOff = ""
            button50.text = "" }
        if(button66.text.isEmpty()) { button66.text = button58.text
            button66.textOff = button58.textOff
            button66.textOn = button58.textOn
            button58.textOn = ""
            button58.textOff = ""
            button58.text = "" }
        if(button74.text.isEmpty()) { button74.text = button66.text
            button74.textOff = button66.textOff
            button74.textOn = button66.textOn
            button66.textOn = ""
            button66.textOff = ""
            button66.text = "" }

        if(button11.text.isEmpty()) { button11.text = button3.text
            button11.textOff = button3.textOff
            button11.textOn = button3.textOn
            button3.textOn = ""
            button3.textOff = ""
            button3.text = "" }
        if(button19.text.isEmpty()) { button19.text = button11.text
            button19.textOff = button11.textOff
            button19.textOn = button11.textOn
            button11.textOn = ""
            button11.textOff = ""
            button11.text = "" }
        if(button27.text.isEmpty()) { button27.text = button19.text
            button27.textOff = button19.textOff
            button27.textOn = button19.textOn
            button19.textOn = ""
            button19.textOff = ""
            button19.text = "" }
        if(button35.text.isEmpty()) { button35.text = button27.text
            button35.textOff = button27.textOff
            button35.textOn = button27.textOn
            button27.textOn = ""
            button27.textOff = ""
            button27.text = "" }
        if(button43.text.isEmpty()) { button43.text = button35.text
            button43.textOff = button35.textOff
            button43.textOn = button35.textOn
            button35.textOn = ""
            button35.textOff = ""
            button35.text = "" }
        if(button51.text.isEmpty()) { button51.text = button43.text
            button51.textOff = button43.textOff
            button51.textOn = button43.textOn
            button43.textOn = ""
            button43.textOff = ""
            button43.text = "" }
        if(button59.text.isEmpty()) { button59.text = button51.text
            button59.textOff = button51.textOff
            button59.textOn = button51.textOn
            button51.textOn = ""
            button51.textOff = ""
            button51.text = "" }
        if(button67.text.isEmpty()) { button67.text = button59.text
            button67.textOff = button59.textOff
            button67.textOn = button59.textOn
            button59.textOn = ""
            button59.textOff = ""
            button59.text = "" }
        if(button75.text.isEmpty()) { button75.text = button67.text
            button75.textOff = button67.textOff
            button75.textOn = button67.textOn
            button67.textOn = ""
            button67.textOff = ""
            button67.text = "" }

        if(button12.text.isEmpty()) { button12.text = button4.text
            button12.textOff = button4.textOff
            button12.textOn = button4.textOn
            button4.textOn = ""
            button4.textOff = ""
            button4.text = "" }
        if(button20.text.isEmpty()) { button20.text = button12.text
            button20.textOff = button12.textOff
            button20.textOn = button12.textOn
            button12.textOn = ""
            button12.textOff = ""
            button12.text = "" }
        if(button28.text.isEmpty()) { button28.text = button20.text
            button28.textOff = button20.textOff
            button28.textOn = button20.textOn
            button20.textOn = ""
            button20.textOff = ""
            button20.text = "" }
        if(button36.text.isEmpty()) { button36.text = button28.text
            button36.textOff = button28.textOff
            button36.textOn = button28.textOn
            button28.textOn = ""
            button28.textOff = ""
            button28.text = "" }
        if(button44.text.isEmpty()) { button44.text = button36.text
            button44.textOff = button36.textOff
            button44.textOn = button36.textOn
            button36.textOn = ""
            button36.textOff = ""
            button36.text = "" }
        if(button52.text.isEmpty()) { button52.text = button44.text
            button52.textOff = button44.textOff
            button52.textOn = button44.textOn
            button44.textOn = ""
            button44.textOff = ""
            button44.text = "" }
        if(button60.text.isEmpty()) { button60.text = button52.text
            button60.textOff = button52.textOff
            button60.textOn = button52.textOn
            button52.textOn = ""
            button52.textOff = ""
            button52.text = "" }
        if(button68.text.isEmpty()) { button68.text = button60.text
            button68.textOff = button60.textOff
            button68.textOn = button60.textOn
            button60.textOn = ""
            button60.textOff = ""
            button60.text = "" }
        if(button76.text.isEmpty()) { button76.text = button68.text
            button76.textOff = button68.textOff
            button76.textOn = button68.textOn
            button68.textOn = ""
            button68.textOff = ""
            button68.text = "" }

        if(button13.text.isEmpty()) { button13.text = button5.text
            button13.textOff = button5.textOff
            button13.textOn = button5.textOn
            button5.textOn = ""
            button5.textOff = ""
            button5.text = "" }
        if(button21.text.isEmpty()) { button21.text = button13.text
            button21.textOff = button13.textOff
            button21.textOn = button13.textOn
            button13.textOn = ""
            button13.textOff = ""
            button13.text = "" }
        if(button29.text.isEmpty()) { button29.text = button21.text
            button29.textOff = button21.textOff
            button29.textOn = button21.textOn
            button21.textOn = ""
            button21.textOff = ""
            button21.text = "" }
        if(button37.text.isEmpty()) { button37.text = button29.text
            button37.textOff = button29.textOff
            button37.textOn = button29.textOn
            button29.textOn = ""
            button29.textOff = ""
            button29.text = "" }
        if(button45.text.isEmpty()) { button45.text = button37.text
            button45.textOff = button37.textOff
            button45.textOn = button37.textOn
            button37.textOn = ""
            button37.textOff = ""
            button37.text = "" }
        if(button53.text.isEmpty()) { button53.text = button45.text
            button53.textOff = button45.textOff
            button53.textOn = button45.textOn
            button45.textOn = ""
            button45.textOff = ""
            button45.text = "" }
        if(button61.text.isEmpty()) { button61.text = button53.text
            button61.textOff = button53.textOff
            button61.textOn = button53.textOn
            button53.textOn = ""
            button53.textOff = ""
            button53.text = "" }
        if(button69.text.isEmpty()) { button69.text = button61.text
            button69.textOff = button61.textOff
            button69.textOn = button61.textOn
            button61.textOn = ""
            button61.textOff = ""
            button61.text = "" }
        if(button77.text.isEmpty()) { button77.text = button69.text
            button77.textOff = button69.textOff
            button77.textOn = button69.textOn
            button69.textOn = ""
            button69.textOff = ""
            button69.text = "" }

        if(button14.text.isEmpty()) { button14.text = button6.text
            button14.textOff = button6.textOff
            button14.textOn = button6.textOn
            button6.textOn = ""
            button6.textOff = ""
            button6.text = "" }
        if(button22.text.isEmpty()) { button22.text = button14.text
            button22.textOff = button14.textOff
            button22.textOn = button14.textOn
            button14.textOn = ""
            button14.textOff = ""
            button14.text = "" }
        if(button30.text.isEmpty()) { button30.text = button22.text
            button30.textOff = button22.textOff
            button30.textOn = button22.textOn
            button22.textOn = ""
            button22.textOff = ""
            button22.text = "" }
        if(button38.text.isEmpty()) { button38.text = button30.text
            button38.textOff = button30.textOff
            button38.textOn = button30.textOn
            button30.textOn = ""
            button30.textOff = ""
            button30.text = "" }
        if(button46.text.isEmpty()) { button46.text = button38.text
            button46.textOff = button38.textOff
            button46.textOn = button38.textOn
            button38.textOn = ""
            button38.textOff = ""
            button38.text = "" }
        if(button54.text.isEmpty()) { button54.text = button46.text
            button54.textOff = button46.textOff
            button54.textOn = button46.textOn
            button46.textOn = ""
            button46.textOff = ""
            button46.text = "" }
        if(button62.text.isEmpty()) { button62.text = button54.text
            button62.textOff = button54.textOff
            button62.textOn = button54.textOn
            button54.textOn = ""
            button54.textOff = ""
            button54.text = "" }
        if(button70.text.isEmpty()) { button70.text = button62.text
            button70.textOff = button62.textOff
            button70.textOn = button62.textOn
            button62.textOn = ""
            button62.textOff = ""
            button62.text = "" }
        if(button78.text.isEmpty()) { button78.text = button70.text
            button78.textOff = button70.textOff
            button78.textOn = button70.textOn
            button70.textOn = ""
            button70.textOff = ""
            button70.text = "" }

        if(button15.text.isEmpty()) { button15.text = button7.text
            button15.textOff = button7.textOff
            button15.textOn = button7.textOn
            button7.textOn = ""
            button7.textOff = ""
            button7.text = "" }
        if(button23.text.isEmpty()) { button23.text = button15.text
            button23.textOff = button15.textOff
            button23.textOn = button15.textOn
            button15.textOn = ""
            button15.textOff = ""
            button15.text = "" }
        if(button31.text.isEmpty()) { button31.text = button23.text
            button31.textOff = button23.textOff
            button31.textOn = button23.textOn
            button23.textOn = ""
            button23.textOff = ""
            button23.text = "" }
        if(button39.text.isEmpty()) { button39.text = button31.text
            button39.textOff = button31.textOff
            button39.textOn = button31.textOn
            button31.textOn = ""
            button31.textOff = ""
            button31.text = "" }
        if(button47.text.isEmpty()) { button47.text = button39.text
            button47.textOff = button39.textOff
            button47.textOn = button39.textOn
            button39.textOn = ""
            button39.textOff = ""
            button39.text = "" }
        if(button55.text.isEmpty()) { button55.text = button47.text
            button55.textOff = button47.textOff
            button55.textOn = button47.textOn
            button47.textOn = ""
            button47.textOff = ""
            button47.text = "" }
        if(button63.text.isEmpty()) { button63.text = button55.text
            button63.textOff = button55.textOff
            button63.textOn = button55.textOn
            button55.textOn = ""
            button55.textOff = ""
            button55.text = "" }
        if(button71.text.isEmpty()) { button71.text = button63.text
            button71.textOff = button63.textOff
            button71.textOn = button63.textOn
            button63.textOn = ""
            button63.textOff = ""
            button63.text = "" }
        if(button79.text.isEmpty()) { button79.text = button71.text
            button79.textOff = button71.textOff
            button79.textOn = button71.textOn
            button71.textOn = ""
            button71.textOff = ""
            button71.text = "" }

        if(button16.text.isEmpty()) { button16.text = button8.text
            button16.textOff = button8.textOff
            button16.textOn = button8.textOn
            button8.textOn = ""
            button8.textOff = ""
            button8.text = "" }
        if(button24.text.isEmpty()) { button24.text = button16.text
            button24.textOff = button16.textOff
            button24.textOn = button16.textOn
            button16.textOn = ""
            button16.textOff = ""
            button16.text = "" }
        if(button32.text.isEmpty()) { button32.text = button24.text
            button32.textOff = button24.textOff
            button32.textOn = button24.textOn
            button24.textOn = ""
            button24.textOff = ""
            button24.text = "" }
        if(button40.text.isEmpty()) { button40.text = button32.text
            button40.textOff = button32.textOff
            button40.textOn = button32.textOn
            button32.textOn = ""
            button32.textOff = ""
            button32.text = "" }
        if(button48.text.isEmpty()) { button48.text = button40.text
            button48.textOff = button40.textOff
            button48.textOn = button40.textOn
            button40.textOn = ""
            button40.textOff = ""
            button40.text = "" }
        if(button56.text.isEmpty()) { button56.text = button48.text
            button56.textOff = button48.textOff
            button56.textOn = button48.textOn
            button48.textOn = ""
            button48.textOff = ""
            button48.text = "" }
        if(button64.text.isEmpty()) { button64.text = button56.text
            button64.textOff = button56.textOff
            button64.textOn = button56.textOn
            button56.textOn = ""
            button56.textOff = ""
            button56.text = "" }
        if(button72.text.isEmpty()) { button72.text = button64.text
            button72.textOff = button64.textOff
            button72.textOn = button64.textOn
            button64.textOn = ""
            button64.textOff = ""
            button64.text = "" }
        if(button80.text.isEmpty()) { button80.text = button72.text
            button80.textOff = button72.textOff
            button80.textOn = button72.textOn
            button72.textOn = ""
            button72.textOff = ""
            button72.text = "" }
    }
}