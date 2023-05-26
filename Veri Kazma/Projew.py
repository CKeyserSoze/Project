from gettext import find
from multiprocessing.sharedctypes import Value
from bson import List
from numpy import safe_eval
import requests
from bs4 import BeautifulSoup
import pandas as pd
import urllib.request
import re
import pymongo
                        #Creating Database
myclient = pymongo.MongoClient("mongodb://localhost:27017/")
mydb = myclient["mydatabase"]
                        #Creating Collection
mycol = mydb["Computershb"]
                        #Clearing collection
#x = mycol.delete_many({})
#print(x.deleted_count," Kadar Veri Silindi")
                        #Database için listeler
List_of_Marka = []
List_of_PCmodel = []
List_of_isletim = []
List_of_islemcitipi = []
List_of_islemcinesil = []
List_of_RAM = []
List_of_diskboyutu = []
List_of_diskturu = []
List_of_ekranboyutu = []
List_of_Ratings = []
List_of_Fiyat = []
List_of_site = []
List_of_links = []

                        #Hepsiburada Verileri

p=1
while p<=10:

    headers={'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.102 Safari/537.36 OPR/90.0.4480.117'}
    r = requests.get("https://www.hepsiburada.com/laptop-notebook-dizustu-bilgisayarlar-c-98?ib=t&sayfa="+str(p)+"",headers=headers)
    soup = BeautifulSoup(r.content,"lxml")

    hb1 = soup.find("div",attrs={"class":"productListContent-pXUkO4iHa51o_17CBibU"})
    hb2 = hb1.find("ul",attrs={"class":"productListContent-frGrtf5XrVXRwJ05HUfU productListContent-rEYj2_8SETJUeqNhyzSm"})
    hb3 = hb2.find_all("li",attrs={"class":"productListContent-zAP0Y5msy8OHn5z7T_K_"})
    for detaylar in hb3:
        link_sonu=detaylar.a.get("href")
        link_basi="https://hepsiburada.com/"
        link=link_basi + link_sonu
        
        if link_sonu.startswith("https://adservice"):
            continue

        else:
      #      print(link)
            
            r1 = requests.get(link,headers=headers)
            soup1 = BeautifulSoup(r1.content,"lxml")
            brand = soup1.find("span",attrs={"class":"brand-name"}).text.strip()
     #       print("Bilgisayarın Markası:",brand)
            
            information = soup1.find("h1",attrs={"data-bind":"markupText: 'productName', event: {mouseup: handleMouseUpForProductName}"}).text.strip()
    #        print("Bilgisayarın Açıklaması:",information)
            
            newPrice = soup1.find("span",attrs={"data-bind":"markupText:'currentPriceBeforePoint'"}).text.strip()
   #         print("Bilgisayarın fiyatı:",newPrice,"TL")
            totalprice = newPrice+" TL"
            
            
            try:
                detaylı1=soup1.find("table",attrs={"class":"data-list tech-spec"}).findAll("tr")
            except:
                print("Bilgisayarın teknik özellikleri girilmemiş\n")
                continue
            tempoisletim = 0
            tempoislemcitipi = 0
            tempoislemcinesil = 0
            tempoRAM = 0
            tempodiskturu = 0
            tempodiskkapasite = 0
            tempoekranboyutu = 0
            for detaylarr in detaylı1:
                özellik=detaylarr.th.text.strip()
                S2=str(özellik)
                ##print(özellik)

                if(S2=='İşletim Sistemi'):
                    işletim_sistemi=detaylarr.find("td").get_text().strip()
                    if(işletim_sistemi=='Yok (Free Dos)'):
               #         print("işletim Sistemi:Free Dos")
                        List_of_isletim.append("FreeDos")
                        tempoisletim += 1
                    elif(işletim_sistemi=='Yok'):
              #          print("İşletim Sistemi:Free Dos")
                        List_of_isletim.append("FreeDos")
                        tempoisletim += 1
                    elif(işletim_sistemi=='FreeDos'):
             #           print("İşletim Sistemi:Free Dos")
                        List_of_isletim.append("FreeDos")
                        tempoisletim += 1
                    elif(işletim_sistemi=='Freedos'):
            #            print("İşletim Sistemi:Free Dos")
                        List_of_isletim.append("FreeDos")
                        tempoisletim += 1
                    elif(işletim_sistemi=='FreeDOS'):
           #             print("İşletim Sistemi:Free Dos") 
                        List_of_isletim.append("FreeDos")
                        tempoisletim += 1
                    else:
          #              print("İşletim Sistemi: ",işletim_sistemi)
                        List_of_isletim.append(işletim_sistemi)
                        tempoisletim += 1
                elif(S2=='İşlemci Tipi'):
                    işlemci_tipi=detaylarr.find("td").get_text().strip()
         #           print("İşlemci Tipi:",işlemci_tipi)
                    List_of_islemcitipi.append(işlemci_tipi)
                    tempoislemcitipi += 1
                elif(S2=='İşlemci Nesli'):
                    işlemci_nesli=detaylarr.find("td").get_text().strip()
        #            print("İşlemci Nesli:",işlemci_nesli)
                    List_of_islemcinesil.append(işlemci_nesli)
                    tempoislemcinesil += 1
                elif(S2=='Ram (Sistem Belleği)'):
                    ram=detaylarr.find("td").get_text().strip()
       #             print("Ram (Sistem Belleği):",ram)
                    List_of_RAM.append(ram)
                    tempoRAM += 1
                elif(S2=='Harddisk Kapasitesi'):
                    hard_disk=detaylarr.find("td").get_text().strip()
      #              print("Hard Disk Kapasitesi:",hard_disk)                   
                elif(S2=='SSD Kapasitesi'):
                    ssd_kapasitesi=detaylarr.find("td").get_text().strip()
                    if(ssd_kapasitesi=='Yok'):
     #                   print("Disk Türü:HDD")
                        List_of_diskturu.append("HDD")
                        List_of_diskboyutu.append(ssd_kapasitesi)
                        tempodiskturu += 1
                        tempodiskkapasite += 1
                    else:
    #                    print("SSD Kapasitesi:",ssd_kapasitesi)
                        List_of_diskboyutu.append(ssd_kapasitesi)
   #                     print("Disk Türü:SSD")
                        List_of_diskturu.append("SSD")
                        tempodiskkapasite += 1
                        tempodiskturu += 1
                elif(S2=='Ekran Boyutu'):
                    ekran_boyutu=detaylarr.find("td").get_text().strip()    
  #                  print("Ekran Boyutu:",ekran_boyutu)
                    List_of_ekranboyutu.append(ekran_boyutu)
                    tempoekranboyutu += 1
 #       print("Site:HEPSİBURADA")
        try:
            puan=soup1.find("span",attrs={"class":"rating-star"}).text.strip()
  #          print("Bilgisayarın Puanı:",puan)
            List_of_Ratings.append(puan)
        except:
 #           print("Bilgisayarın değerlendirmesi yok.")
            List_of_Ratings.append("0")
        List_of_Fiyat.append(totalprice)
        List_of_PCmodel.append(information)
        List_of_Marka.append(brand)
        List_of_links.append(link)
        List_of_site.append("HEPSİBURADA")
        if(tempoekranboyutu == 0 or tempodiskkapasite == 0 or tempodiskturu == 0 or tempoislemcinesil == 0 or tempoislemcitipi == 0 or tempoisletim == 0 or tempoRAM == 0):
            if(tempoRAM == 1):
                value = len(List_of_RAM)-1
                List_of_RAM.pop(value)
            if(tempodiskkapasite == 1):
                value = len(List_of_diskboyutu)-1
                List_of_diskboyutu.pop(value)
            if(tempodiskturu == 1):
                value = len(List_of_diskturu)-1
                List_of_diskturu.pop(value)
            if(tempoislemcinesil == 1):
                value = len(List_of_islemcinesil)-1
                List_of_islemcinesil.pop(value)
            if(tempoislemcitipi == 1):
                value = len(List_of_islemcitipi)-1
                List_of_islemcitipi.pop(value)
            if(tempoekranboyutu == 1):
                value = len(List_of_ekranboyutu)-1
                List_of_ekranboyutu.pop(value)
            if(tempoisletim == 1):
                value = len(List_of_isletim)-1
                List_of_isletim.pop(value)
            value1 = List_of_Marka(value1)
            List_of_Marka.pop(value1)
            List_of_Fiyat.pop(value1)
            List_of_links.pop(value1)
            List_of_PCmodel.pop(value1)
            List_of_Ratings.pop(value1)
            List_of_site.pop(value1)
        if(tempodiskkapasite == 2):
            value = len(List_of_diskboyutu)-1
            List_of_diskboyutu.pop(value)
        if(tempodiskturu == 2):
            value = len(List_of_diskturu)-1
            List_of_diskturu.pop(value)
        if(tempoekranboyutu == 2):
            value = len(List_of_ekranboyutu)-1
            List_of_ekranboyutu.pop(value)
        if(tempoislemcinesil == 2):
            value = len(List_of_islemcinesil)-1
            List_of_islemcinesil.pop(value)
        if(tempoislemcitipi == 2):
            value = len(List_of_islemcitipi)-1
            List_of_islemcitipi.pop(value)
        if(tempoisletim == 2):
            value = len(List_of_isletim)-1
            List_of_isletim.pop(value)
        if(tempoRAM == 2):
            value = len(List_of_RAM)-1
            List_of_RAM.pop(value)
        print(tempoekranboyutu,tempodiskkapasite,tempodiskturu,tempoislemcinesil,tempoislemcitipi,tempoisletim,tempoRAM)
        image=soup1.find("img",attrs={"class":"product-image"})
        #print(len(List_of_Marka),len(List_of_PCmodel),len(List_of_isletim),)
    print("Sayfa Bitti ",len(List_of_Marka)," Toplam ürün alındı.")
#        print(image['src'])
#        print("\n")
    p+=1

size1 = len(List_of_Marka)
print(len(List_of_Marka))
print(len(List_of_PCmodel))
print(len(List_of_isletim))
print(len(List_of_islemcitipi))
print(len(List_of_islemcinesil))
print(len(List_of_RAM))
print(len(List_of_diskboyutu))
print(len(List_of_diskturu))
print(len(List_of_ekranboyutu))
print(len(List_of_Fiyat))
print(len(List_of_site))
print(len(List_of_links))
print("Hepsiburadad bitti")
i=0
for i in range(0,size1):
    data = {"Marka":List_of_Marka[i],"Model":List_of_PCmodel[i],"İşletim Sistemi":List_of_isletim[i],"İşlemci Modeli":List_of_islemcitipi[i],"İşlemci Nesli":List_of_islemcinesil[i],"RAM":List_of_RAM[i],"Disk Boyutu":List_of_diskboyutu[i],"Disk Türü":List_of_diskturu[i],"Ekran Boyutu":List_of_ekranboyutu[i],"Puan":List_of_Ratings[i],"Fiyat":List_of_Fiyat[i],"Site":List_of_site[i],"Urun Linki":List_of_links[i]}
    mycol.insert_one(data)

                                #Trendyol Verileri
pa=1

mycol = mydb["Computerstr"]

while pa<=10:
    headers={'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.102 Safari/537.36 OPR/90.0.4480.117'}
    r = requests.get("https://www.trendyol.com/sr?q=notebook+bilgisayar&qt=notebook+bilgisayar&st=notebook+bilgisayar&lc=103108&os=1&pi="+str(pa)+"",headers=headers)
    soup = BeautifulSoup(r.content,"lxml")


    ty1 = soup.find("div",attrs={"class":"prdct-cntnr-wrppr"})
    ty2 = ty1.find_all("div",attrs={"class":"p-card-wrppr with-campaign-view"})
    for detaylar in ty2:
        link_sonu=detaylar.a.get("href")
        link_basi="https://trendyol.com/"
        link=link_basi+link_sonu

        if link_sonu.startswith("https://adservice"):
            continue

        else:
     #       print(link)
            List_of_links.append(link)
            r1 = requests.get(link,headers=headers)
            soup1 = BeautifulSoup(r1.content,"lxml")
            brand1=soup1.find("div",attrs={"class":"pr-in-cn"})
            brand2=brand1.find_all("h1",attrs={"class":"pr-new-br"})
            print("Trendyol Test")
            try:
                for marka in brand2:
                    markas=marka.a.get_text
                    S=str(markas)                  
                    start='">'
                    end='</a>'
                    markalar=((S.split(start))[1].split(end)[0])
 #                   print("Bilgisayarın Markası:",markalar)
                    List_of_Marka.append(markalar)
            except:
                marka2=soup1.find("h1",attrs={"class":"pr-new-br"}).text.strip()
  #              print("Bilgisayarın Markası:",marka2)
                List_of_Marka.append(marka2)
                
            information=brand1.find("h1",attrs={"class":"pr-new-br"}).find("span").text.strip()
   #         print("Bilgisayarın Açıklaması: ",information)
            List_of_PCmodel.append(information)
            price=soup1.find("span",attrs={"class":"prc-dsc"}).text.strip()
    #        print("Bilgisayarın fiyatı: ",price)
            List_of_Fiyat.append(price)
            
            try:                
                detaylı1=soup1.find("ul",attrs={"class":"detail-attr-container"}).findAll("li",attrs={"class":"detail-attr-item"})
            except:
                print("Bilgisayarın teknik özellikleri girilmemiş\n")
                continue
            tempoisletim = 0
            tempoislemcitipi = 0
            tempoislemcinesil = 0
            tempoRAM = 0
            tempodiskturu = 0
            tempodiskkapasite = 0
            tempoekranboyutu = 0
            for detaylarr in detaylı1:
                özellik=detaylarr.find("span").text.strip()
                S2=str(özellik)
                
                if(S2=='İşletim Sistemi'):
                    işletim_sistemi=detaylarr.find("b").text.strip()
                    if(işletim_sistemi=='Yok (Free Dos)'):
        #                print("işletim Sistemi: Free Dos")
                        List_of_isletim.append("FreeDos")
                        tempoisletim +=1 
                    elif(işletim_sistemi=='Yok'):
       #                 print("İşletim Sistemi: Free Dos")
                        List_of_isletim.append("FreeDos")
                        tempoisletim +=1 
                    elif(işletim_sistemi=='FreeDos'):
      #                  print("İşletim Sistemi: Free Dos")
                        List_of_isletim.append("FreeDos")
                        tempoisletim +=1 
                    elif(işletim_sistemi=='Freedos'):
     #                   print("İşletim Sistemi: Free Dos")
                        List_of_isletim.append("FreeDos")
                        tempoisletim +=1 
                    elif(işletim_sistemi=='FreeDOS'):
    #                    print("İşletim Sistemi: Free Dos")    
                        List_of_isletim.append("FreeDos")        
                        tempoisletim +=1       
                    else:
   #                     print("İşletim Sistemi: ",işletim_sistemi)
                        List_of_isletim.append(işletim_sistemi)
                        tempoisletim +=1 
                elif(S2=='İşlemci Tipi'):
                    işlemci_tipi=detaylarr.find("b").text.strip()
  #                  print("İşlemci Tipi:",işlemci_tipi)
                    List_of_islemcitipi.append(işlemci_tipi)
                    tempoislemcitipi += 1
                elif(S2=='İşlemci Nesli'):
                    işlemci_nesli=detaylarr.find("b").text.strip()
 #                   print("İşlemci Nesli:",işlemci_nesli)
                    List_of_islemcinesil.append(işlemci_nesli)
                    tempoislemcinesil += 1
                elif(S2=='Ram (Sistem Belleği)'):
                    ram=detaylarr.find("b").text.strip()
#                    print("Ram (Sistem Belleği):",ram)
                    List_of_RAM.append(ram)
                    tempoRAM += 1
                elif(S2=='Harddisk Kapasitesi'):
                    hard_disk=detaylarr.find("b").text.strip()
            #        print("Hard Disk Kapasitesi:",hard_disk)                  
                elif(S2=='SSD Kapasitesi'):
                    ssd_kapasitesi=detaylarr.find("b").text.strip()
                    if(ssd_kapasitesi=='Yok'):
           #             print("Disk Türü:HDD")
                        List_of_diskturu.append("HDD")
                        List_of_diskboyutu.append(ssd_kapasitesi)
                        tempodiskturu += 1
                        tempodiskkapasite += 1
                    else:
          #              print("SSD Kapasitesi:",ssd_kapasitesi)
         #               print("Disk Türü:SSD")
                        List_of_diskturu.append("SSD")
                        List_of_diskboyutu.append(ssd_kapasitesi)
                        tempodiskturu += 1
                        tempodiskkapasite += 1
                elif(S2=='Ekran Boyutu'):
                    ekran_boyutu=detaylarr.find("b").text.strip()    
                    #print("Ekran Boyutu: ",ekran_boyutu)
                    List_of_ekranboyutu.append(ekran_boyutu)
                    tempoekranboyutu += 1
                
                

        #print("Site:TRENDYOL")
        List_of_Ratings.append("0")
        List_of_site.append("TRENDYOL")
        image=soup1.find("img",attrs={"class":"detail-section-img"})
        #print(image['src'])
        #print("\n")
        if(tempoekranboyutu == 0 or tempodiskkapasite == 0 or tempodiskturu == 0 or tempoislemcinesil == 0 or tempoislemcitipi == 0 or tempoisletim == 0 or tempoRAM == 0):
            if(tempoRAM == 1):
                value = len(List_of_RAM)-1
                List_of_RAM.pop(value)
            if(tempodiskkapasite == 1):
                value = len(List_of_diskboyutu)-1
                List_of_diskboyutu.pop(value)
            if(tempodiskturu == 1):
                value = len(List_of_diskturu)-1
                List_of_diskturu.pop(value)
            if(tempoislemcinesil == 1):
                value = len(List_of_islemcinesil)-1
                List_of_islemcinesil.pop(value)
            if(tempoislemcitipi == 1):
                value = len(List_of_islemcitipi)-1
                List_of_islemcitipi.pop(value)
            if(tempoekranboyutu == 1):
                value = len(List_of_ekranboyutu)-1
                List_of_ekranboyutu.pop(value)
            if(tempoisletim == 1):
                value = len(List_of_isletim)-1
                List_of_isletim.pop(value)
            value1 = len(List_of_Marka)-1
            List_of_Marka.pop(value1)
            List_of_Fiyat.pop(value1)
            List_of_links.pop(value1)
            List_of_PCmodel.pop(value1)
            List_of_Ratings.pop(value1)
            List_of_site.pop(value1)
        if(tempodiskkapasite == 2):
            value = len(List_of_diskboyutu)-1
            List_of_diskboyutu.pop(value)
        if(tempodiskturu == 2):
            value = len(List_of_diskturu)-1
            List_of_diskturu.pop(value)
        if(tempoekranboyutu == 2):
            value = len(List_of_ekranboyutu)-1
            List_of_ekranboyutu.pop(value)
        if(tempoislemcinesil == 2):
            value = len(List_of_islemcinesil)-1
            List_of_islemcinesil.pop(value)
        if(tempoislemcitipi == 2):
            value = len(List_of_islemcitipi)-1
            List_of_islemcitipi.pop(value)
        if(tempoisletim == 2):
            value = len(List_of_isletim)-1
            List_of_isletim.pop(value)
        if(tempoRAM == 2):
            value = len(List_of_RAM)-1
            List_of_RAM.pop(value)
        print(tempoekranboyutu,tempodiskkapasite,tempodiskturu,tempoislemcinesil,tempoislemcitipi,tempoisletim,tempoRAM)
    print("Sayfa Bitti ",len(List_of_Marka)," Toplam ürün alındı.")
    pa+=1

size2 = len(List_of_Marka)
print(len(List_of_Marka))
print(len(List_of_PCmodel))
print(len(List_of_isletim))
print(len(List_of_islemcitipi))
print(len(List_of_islemcinesil))
print(len(List_of_RAM))
print(len(List_of_diskboyutu))
print(len(List_of_diskturu))
print(len(List_of_ekranboyutu))
print(len(List_of_Fiyat))
print(len(List_of_site))
print(len(List_of_links))
print("Trendyold bitti")
for i in range(size1,size2):
    data = {"Marka":List_of_Marka[i],"Model":List_of_PCmodel[i],"İşletim Sistemi":List_of_isletim[i],"İşlemci Modeli":List_of_islemcitipi[i],"İşlemci Nesli":List_of_islemcinesil[i],"RAM":List_of_RAM[i],"Disk Boyutu":List_of_diskboyutu[i],"Disk Türü":List_of_diskturu[i],"Ekran Boyutu":List_of_ekranboyutu[i],"Puan":List_of_Ratings[i],"Fiyat":List_of_Fiyat[i],"Site":List_of_site[i],"Urun Linki":List_of_links[i]}
    mycol.insert_one(data)
mycol = mydb["Computersvatan"]


                                    #Vatan Computer Verileri
page_number=1
while page_number<=10:

    url = "https://www.vatanbilgisayar.com/notebook/?page="+str(page_number)
    req = requests.get(url)
    Soup = BeautifulSoup(req.content,"lxml")
    computers = Soup.find_all("div",attrs={"class","product-list product-list--list-page"})

    for computer in computers:
        Url_of_computer = computer.find("div",attrs={"class","product-list__image-safe"}).a.get("href")
        Url_of_computer ="https://www.vatanbilgisayar.com"+Url_of_computer
#        print(Url_of_computer)
        List_of_links.append(Url_of_computer)
        request = requests.get(Url_of_computer)
        Soup_computer = BeautifulSoup(request.content,"lxml")

                                  #Marka Bulma
        Mark_finder = Soup_computer.find("ul",attrs={"class","breadcrumb"})
        Marka_finder = Mark_finder.find_all("li")                        
        i=0
        for marka in Marka_finder:
            if i == 3 :
                Marka = marka.a.text
 #               print("Bilgisayarın Markası:",Marka)
                List_of_Marka.append(Marka)
            i += 1

        #Model_of_computer = computer.find("div",attrs={"class","product-list__product-name"}).h3.text
        #print("Bilgisayarın Açıklaması: ",Model_of_computer)
        
        Price_of_computer = computer.find("div",attrs={"class","product-list__cost"}).span.text
  #      print("Bilgisayarın Fiyatı: ",Price_of_computer)
        List_of_Fiyat.append(Price_of_computer)
                                #Model Bulma
        
        Model_finder = Soup_computer.find("ul",attrs={"class","breadcrumb"})
        Model_finder = Model_finder.find_all("li")                        
        i=0
        for model in Model_finder:
            if i == 4 :
                Model2 = model.a.text
   #             print(Model2)
                List_of_PCmodel.append(Model2)
            i += 1

                                #Puan Bulma
        Rank = Soup_computer.find("div",attrs={"class","rank-star"}).span.get("style")
        Rank = Rank.strip().replace("width: ","")
        Rank = Rank.replace(";","")
    #    print("Bilgisayarın Puanı: ",Rank)
        List_of_Ratings.append(Rank)
        #Özellikleri Bulma
        tablolar = Soup_computer.find_all("table",attrs={"class":"product-table"})
        Marka = Soup_computer.find_all("ul")

        tempoisletim = 0
        tempoislemcitipi = 0
        tempoislemcinesil = 0
        tempoRAM = 0
        tempodiskturu = 0
        tempodiskkapasite = 0
        tempoekranboyutu = 0
        for tablo in tablolar:
            tempo = 0
            titles = tablo.find_all("tr")
            for title in titles:
                attr_title = title.td.text
                attr_data = title.p.text
                
                #print(attr_title,attr_str)
                if "İşletim" in attr_title:
                    if(attr_data=='Yok (Free Dos)'):
     #                   print("işletim Sistemi:Free Dos")
                        List_of_isletim.append("FreeDos")
                        tempoisletim += 1
                    elif(attr_data=='Yok'):
      #                  print("İşletim Sistemi:Free Dos")
                        List_of_isletim.append("FreeDos")
                        tempoisletim += 1
                    elif(attr_data=='FreeDos'):
       #                 print("İşletim Sistemi:Free Dos")
                        List_of_isletim.append("FreeDos")
                        tempoisletim += 1
                    elif(attr_data=='FreeDOS'):
        #                print("İşletim Sistemi:Free Dos")
                        List_of_isletim.append("FreeDos")
                        tempoisletim += 1
                    elif(attr_data=='Freedos'):
         #               print("İşletim Sistemi:Free Dos")   
                        List_of_isletim.append("FreeDos") 
                        tempoisletim += 1
                    else:
          #              print("İşletim Sistemi:",attr_data)
                        List_of_isletim.append(attr_data)
                        tempoisletim += 1
                elif "İşlemci Marka" in attr_title:
                    if tempo == 0:     
           #             print("İşlemci Modeli:",attr_data)
                        List_of_islemcitipi.append(attr_data)
                        tempoislemcitipi += 1
                        tempo =+1
                elif "İşlemci Nesli" in attr_title:
            #        print("İşlemci Nesli:",attr_data)
                    List_of_islemcinesil.append(attr_data)
                    tempoislemcinesil += 1
                elif "Ram (Sistem Belleği)" in attr_title:
                    if tempo == 0:  
             #           print("Ram(Sistem Belleği):",attr_data)
                        List_of_RAM.append(attr_data)
                        tempo +=1
                        tempoRAM += 1
                elif "Disk Kapasitesi" in attr_title:
              #      print("Disk Kapasitesi:",attr_data)
                    List_of_diskboyutu.append(attr_data)
                    tempodiskkapasite += 1
                elif "Disk Türü" in attr_title:
               #     print("Disk Türü:",attr_data)
                    List_of_diskturu.append(attr_data)
                    tempodiskturu += 1
                elif "Ekran Boyutu" in attr_title:
       #             print("Ekran Boyutu:",attr_data)
                    List_of_ekranboyutu.append(attr_data)
                    tempoekranboyutu += 1
#        print("Site:VATAN COMPUTER")
        List_of_site.append("VATAN COMPUTER")
        #if(len(List_of_Marka)!=len(List_of_ekranboyutu)):
        #    print()
        #    value = len(List_of_Marka)
        #    List_of_ekranboyutu.pop(value)
        if(tempoekranboyutu == 0 or tempodiskkapasite == 0 or tempodiskturu == 0 or tempoislemcinesil == 0 or tempoislemcitipi == 0 or tempoisletim == 0 or tempoRAM == 0):
            if(tempoRAM == 1):
                value = len(List_of_RAM)-1
                List_of_RAM.pop(value)
            if(tempodiskkapasite == 1):
                value = len(List_of_diskboyutu)-1
                List_of_diskboyutu.pop(value)
            if(tempodiskturu == 1):
                value = len(List_of_diskturu)-1
                List_of_diskturu.pop(value)
            if(tempoislemcinesil == 1):
                value = len(List_of_islemcinesil)-1
                List_of_islemcinesil.pop(value)
            if(tempoislemcitipi == 1):
                value = len(List_of_islemcitipi)-1
                List_of_islemcitipi.pop(value)
            if(tempoekranboyutu == 1):
                value = len(List_of_ekranboyutu)-1
                List_of_ekranboyutu.pop(value)
            if(tempoisletim == 1):
                value = len(List_of_isletim)-1
                List_of_isletim.pop(value)
            value1 = len(List_of_Marka)-1
            List_of_Marka.pop(value1)
            List_of_Fiyat.pop(value1)
            List_of_links.pop(value1)
            List_of_PCmodel.pop(value1)
            List_of_Ratings.pop(value1)
            List_of_site.pop(value1)
        if(tempodiskkapasite == 2):
            value = len(List_of_diskboyutu)-1
            List_of_diskboyutu.pop(value)
        if(tempodiskturu == 2):
            value = len(List_of_diskturu)-1
            List_of_diskturu.pop(value)
        if(tempoekranboyutu == 2):
            value = len(List_of_ekranboyutu)-1
            List_of_ekranboyutu.pop(value)
        if(tempoislemcinesil == 2):
            value = len(List_of_islemcinesil)-1
            List_of_islemcinesil.pop(value)
        if(tempoislemcitipi == 2):
            value = len(List_of_islemcitipi)-1
            List_of_islemcitipi.pop(value)
        if(tempoisletim == 2):
            value = len(List_of_isletim)-1
            List_of_isletim.pop(value)
        if(tempoRAM == 2):
            value = len(List_of_RAM)-1
            List_of_RAM.pop(value)
        print(tempoekranboyutu,tempodiskkapasite,tempodiskturu,tempoislemcinesil,tempoislemcitipi,tempoisletim,tempoRAM)
    print("Sayfa Bitti ",len(List_of_Marka)," Toplam ürün alındı.")
 #       print("\n")   
    page_number+=1

size3 = len(List_of_Marka)
print(len(List_of_Marka))
print(len(List_of_PCmodel))
print(len(List_of_isletim))
print(len(List_of_islemcitipi))
print(len(List_of_islemcinesil))
print(len(List_of_RAM))
print(len(List_of_diskboyutu))
print(len(List_of_diskturu))
print(len(List_of_ekranboyutu))
print(len(List_of_Fiyat))
print(len(List_of_site))
print(len(List_of_links))
print("Vatan bitti")
for i in range(size2,size3):
    data = {"Marka":List_of_Marka[i],"Model":List_of_PCmodel[i],"İşletim Sistemi":List_of_isletim[i],"İşlemci Modeli":List_of_islemcitipi[i],"İşlemci Nesli":List_of_islemcinesil[i],"RAM":List_of_RAM[i],"Disk Boyutu":List_of_diskboyutu[i],"Disk Türü":List_of_diskturu[i],"Ekran Boyutu":List_of_ekranboyutu[i],"Puan":List_of_Ratings[i],"Fiyat":List_of_Fiyat[i],"Site":List_of_site[i],"Urun Linki":List_of_links[i]}
    mycol.insert_one(data)

                                #N11 Verileri
mycol = mydb["ComputersN11"]

sayfa_no=1
while sayfa_no<=10:
    url ="https://www.n11.com/bilgisayar/dizustu-bilgisayar?q=notebook&pg=" + str(sayfa_no) 
    r = requests.get(url)
    Soup = BeautifulSoup(r.content,"lxml")
    urunler = Soup.find_all("li",attrs={"class":"column"})

    for urun in urunler:
        Link = urun.a.get("href") 
#        print(Link)
        Name = urun.a.get("title")
 #       print("Bilgisayarın Açıklaması:",Name)
        Price = urun.find("div",{"class":"priceContainer"}).span.text.strip()
  #      print("Bilgisayarın Fiyatı:",Price)
          
        try:
            urun_r = requests.get(Link)
        except Exception:
   #         print("Urun detayı alınamadı")
            continue
        List_of_links.append(Link)
        List_of_Fiyat.append(Price)
        urun_soup = BeautifulSoup(urun_r.content,"lxml")
        urun_puan = urun_soup.find("strong",attrs={"class","ratingScore"}).text
    #    print("Bilgisayarın Puanı:",urun_puan)
        List_of_Ratings.append(urun_puan)
        urunattr = urun_soup.find_all("li",attrs={"class":"unf-prop-list-item"})
        tempoisletim = 0
        tempoislemcitipi = 0
        tempoislemcinesil = 0
        tempoRAM = 0
        tempodiskturu = 0
        tempodiskkapasite = 0
        tempoekranboyutu = 0
        tempomarka = 0
        tempomodel = 0
        for attr in urunattr:
            attr_title = attr.find("p",attrs={"class":"unf-prop-list-title"}).text.strip()
            attr_str = attr.find("p",attrs={"class":"unf-prop-list-prop"}).text.strip()

            if "Marka" in attr_title:
     #           print("Marka:",attr_str)
                List_of_Marka.append(attr_str)
                tempomarka += 1
            elif attr_title == "Model":
      #          print("Bilgisayarın Modeli:",attr_str)
                List_of_PCmodel.append(attr_str)
                tempomodel += 1
            elif attr_title =="İşlemci Modeli":
       #         print("İşlemci Modeli:",attr_str)
                List_of_islemcinesil.append(attr_str)
                tempoislemcinesil += 1
            elif "İşletim" in attr_title:
                if(attr_str=='Yok (Free Dos)'):
        #            print("işletim Sistemi:Free Dos")
                    List_of_isletim.append("FreeDos")
                    tempoisletim += 1
                elif(attr_str=='Yok'):
         #           print("İşletim Sistemi:Free Dos")
                    List_of_isletim.append("FreeDos")
                    tempoisletim += 1
                elif(attr_str=='FreeDos'):
          #          print("İşletim Sistemi:Free Dos")
                    List_of_isletim.append("FreeDos")
                    tempoisletim += 1
                elif(attr_str=='FreeDOS'):
           #         print("İşletim Sistemi:Free Dos")
                    List_of_isletim.append("FreeDos")
                    tempoisletim += 1
                elif(attr_str=='Freedos'):
            #        print("İşletim Sistemi:Free Dos")
                    List_of_isletim.append("FreeDos")
                    tempoisletim += 1
                else:
             #       print("İşletim Sistemi:",attr_str) 
                    List_of_isletim.append(attr_str)
                    tempoisletim += 1
            elif attr_title == "İşlemci":
         #       print("İşlemci Tipi:",attr_str)
                List_of_islemcitipi.append(attr_str)
                tempoislemcitipi += 1
            elif "Bellek Kapasitesi" in attr_title:
         #       print("RAM Kapasitesi:",attr_str)
                List_of_RAM.append(attr_str)
                tempoRAM += 1
            elif "Disk Kapasitesi" in attr_title:
         #       print("Disk Kapasistesi:",attr_str)
                List_of_diskboyutu.append(attr_str)
                tempodiskkapasite += 1
            elif "Disk Türü" in attr_title:
          #      print("Disk Türü:",attr_str)
                List_of_diskturu.append(attr_str)
                tempodiskturu += 1
            elif "Ekran Boyutu" in attr_title:
           #     print("Ekran Boyutu:",attr_str)
                List_of_ekranboyutu.append(attr_str)
                tempoekranboyutu += 1
        List_of_site.append("N11")
        
        #if(len(List_of_diskturu)!=len(List_of_Marka)):
        #    print(Link)
        #    List_of_diskturu.append("SSD")
        if(tempomodel == 0 or tempomarka == 0 or tempoekranboyutu == 0 or tempodiskturu == 0 or tempodiskkapasite == 0 or tempoislemcinesil == 0 or tempoislemcitipi == 0 or tempoisletim == 0 or tempoRAM == 0):
            if(tempoRAM == 1):
                value = len(List_of_RAM)-1
                List_of_RAM.pop(value)
            if(tempodiskkapasite == 1):
                value = len(List_of_diskboyutu)-1
                List_of_diskboyutu.pop(value)
            if(tempoislemcinesil == 1):
                value = len(List_of_islemcinesil)-1
                List_of_islemcinesil.pop(value)
            if(tempoislemcitipi == 1):
                value = len(List_of_islemcitipi)-1
                List_of_islemcitipi.pop(value)
            if(tempodiskturu == 1):
                value = len(List_of_diskturu)-1
                List_of_diskturu.pop(value)
            if(tempoekranboyutu == 1):
                value = len(List_of_ekranboyutu)-1
                List_of_ekranboyutu.pop(value)
            if(tempoisletim == 1):
                value = len(List_of_isletim)-1
                List_of_isletim.pop(value)
            if(tempomarka == 1):
                value = len(List_of_Marka)-1
                List_of_Marka.pop(value)
            if(tempomodel == 1):
                value = len(List_of_PCmodel)-1
                List_of_PCmodel.pop(value)
            value1 = len(List_of_Fiyat)-1
            List_of_Fiyat.pop(value1)
            List_of_links.pop(value1)
            List_of_Ratings.pop(value1)
            List_of_site.pop(value1)
        if(tempodiskkapasite == 2):
            value = len(List_of_diskboyutu)-1
            List_of_diskboyutu.pop(value)
        if(tempodiskturu == 2):
            value = len(List_of_diskturu)-1
            List_of_diskturu.pop(value)
        if(tempoekranboyutu == 2):
            value = len(List_of_ekranboyutu)-1
            List_of_ekranboyutu.pop(value)
        if(tempoislemcinesil == 2):
            value = len(List_of_islemcinesil)-1
            List_of_islemcinesil.pop(value)
        if(tempoislemcitipi == 2):
            value = len(List_of_islemcitipi)-1
            List_of_islemcitipi.pop(value)
        if(tempoisletim == 2):
            value = len(List_of_isletim)-1
            List_of_isletim.pop(value)
        if(tempoRAM == 2):
            value = len(List_of_RAM)-1
            List_of_RAM.pop(value)
        print(tempoekranboyutu,tempodiskkapasite,tempodiskturu,tempoislemcinesil,tempoislemcitipi,tempoisletim,tempoRAM)
                   
     #   print("Site: N11")
    
      #  print("\n")  
    print(url)
    print("Sayfa Bitti ",len(List_of_Marka)," Toplam ürün alındı.")
    sayfa_no+=1

                            #Tüm verileri databasedeki koleksiyona atma
size4=len(List_of_Marka)
print(len(List_of_Marka))
print(len(List_of_PCmodel))
print(len(List_of_isletim))
print(len(List_of_islemcitipi))
print(len(List_of_islemcinesil))
print(len(List_of_RAM))
print(len(List_of_diskboyutu))
print(len(List_of_diskturu))
print(len(List_of_ekranboyutu))
print(len(List_of_Fiyat))
print(len(List_of_site))
print(len(List_of_links))
print("N11 bitti")
for i in range(size3,size4):
    data = {"Marka":List_of_Marka[i],"Model":List_of_PCmodel[i],"İşletim Sistemi":List_of_isletim[i],"İşlemci Modeli":List_of_islemcitipi[i],"İşlemci Nesli":List_of_islemcinesil[i],"RAM":List_of_RAM[i],"Disk Boyutu":List_of_diskboyutu[i],"Disk Türü":List_of_diskturu[i],"Ekran Boyutu":List_of_ekranboyutu[i],"Puan":List_of_Ratings[i],"Fiyat":List_of_Fiyat[i],"Site":List_of_site[i],"Urun Linki":List_of_links[i]}
    mycol.insert_one(data)

