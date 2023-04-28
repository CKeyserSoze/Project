#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <dirent.h>
#include <string.h>
#include <conio.h>

// Check whether the operating system is linux or windows
#if defined(_WIN32) || defined(_WIN64)
    const int os = 0;
#else
#ifdef __linux
    const int os = 1;
#endif
#endif

struct kayit{
    int ogrenciNumarasi;
    int dersKodu;
    int puan;
};

struct binaryData{
    int data1;
    int data2;
};

// Clears the console
void clearConsole(){
    if(os == 0){
        system("cls"); // Console clear function for windows
    }else if(os == 1){
        system("clear"); // Console clear function for linux
    }
}

void exitOption(){
    printf("\nAna menuye donmek icin ESC basiniz.");
    while(1){
        int getKeyboardInput = getch();
        if(getKeyboardInput == 27){
            clearConsole();
            displayMainMenu();
        }
    }
}

int binarySearch(int array[], int first, int last, int search)
{
    while (first <= last) {
        int middle = (first+last) / 2;
        if(array[middle] < search){
            first = middle + 1;
        }else if(array[middle] == search){
            return middle;
        }else {
            last = middle - 1;
        }
    }

    return -1;
}

void updateData(){
    int ogrenciNo;
    int ogrNoCtr[201];
    int offsetCtr[201];
    int ogrNoDelete[20];
    int ogrDersDelete[20];
    int ogrPtsDelete[20];

    printf("Kaydi guncellenecek olan ogrencinin numarasini giriniz: ");
    scanf("%d", &ogrenciNo);

    clearConsole();

    FILE * indexFile = fopen("indeksdosyasi.txt", "r");

    int ogrenciCounter = 0;
    int ogrNo, offsetTemp;
    while(fscanf(indexFile, "%d;%d\n", &ogrNo, &offsetTemp) == 2){
        offsetCtr[ogrenciCounter] = offsetTemp;
        ogrNoCtr[ogrenciCounter] = ogrNo;
        ogrenciCounter++;
    }

    int outcome;
    int offset[100];
    int counter = 0;
    while((outcome = binarySearch(ogrNoCtr, 0, ogrenciCounter - 1, ogrenciNo)) != -1){
        offset[counter] = offsetCtr[outcome];
        if(outcome == 0 && (ogrenciCounter - 1) == 0){
            ogrNoCtr[0] = -1;
            offsetCtr[0] = -1;
        }else {
            for(int i = outcome;i < ogrenciCounter - 1;i++)
            {
                ogrNoCtr[i] = ogrNoCtr[i + 1];
                offsetCtr[i] = offsetCtr[i + 1];
            }
        }
        ogrenciCounter--;
        counter++;
    }

    FILE * dataFile = fopen("veridosyasi", "rb");

    if(dataFile == NULL){
        printf("Veri dosyasi acilamadi.\n");
        fclose(indexFile);
        return;
    }

    for(int i = 0;i < counter;i++){
        struct kayit ogrK;
        fseek(dataFile, offset[i], SEEK_SET); // SEEK_SET is the position from where the offset is added
        if(fread(&ogrK, sizeof(struct kayit), 1, dataFile) == 1){
            printf("%d - Ogrenci Numarasi: %4d | Ders Numarasi: %4d | Ders Notu: %4d\n", i+1, ogrK.ogrenciNumarasi, ogrK.dersKodu, ogrK.puan);
            ogrNoDelete[i+1] = ogrK.ogrenciNumarasi;
            ogrDersDelete[i+1] = ogrK.dersKodu;
            ogrPtsDelete[i+1] = ogrK.puan;
        }
    }
    fclose(dataFile);
    fclose(indexFile);

    if(counter == 0){
        printf("Veri bulunamadi.\n");
    }else {
        int deleteDataIndex;
        printf("\nGuncellenecek veri numarasini giriniz: ");
        scanf("%d", &deleteDataIndex);

        int updatePts;
        clearConsole();
        printf("Eski puan = %d \n", ogrPtsDelete[deleteDataIndex]);
        printf("Yeni puan = ");
        scanf("%d", &updatePts);

        FILE * tempFile = fopen("temp", "wb");
        FILE * dataFile = fopen("veridosyasi", "rb");

        struct kayit ogrK;
        while(fread(&ogrK, sizeof(struct kayit), 1, dataFile) == 1){
            if(ogrK.ogrenciNumarasi == ogrNoDelete[deleteDataIndex] && ogrK.dersKodu == ogrDersDelete[deleteDataIndex]){
                ogrK.puan = updatePts;
            }
            fwrite(&ogrK, sizeof(struct kayit), 1, tempFile);
        }

        fclose(tempFile);
        fclose(dataFile);

        // Replace veridosyasi with temporary file
        remove("veridosyasi");
        rename("temp", "veridosyasi");

        clearConsole();
        printf("Veri guncellendi.\n");

        indexFileUpdate();
    }
}

void indexFileUpdate(){
    int snc[201];
    int sncSorted[201];
    int so[201];
    int soSorted[201];
    struct kayit kayitCtr;

    // Read the data file
    FILE * dataFile = fopen("veridosyasi", "rb");

    int count = 0;
    while(fread(&kayitCtr, sizeof(struct kayit), 1, dataFile) == 1){
        so[count] = ftell(dataFile) - sizeof(kayitCtr);
        snc[count] = kayitCtr.ogrenciNumarasi;
        count++;
    }

    // Sort the numbers in ascending order
    int newIndex = 0;
    for(int i = 0;i < count;i++){
         for(int x = 0;x < count;x++){
            if(snc[i] > snc[x]){
                newIndex++;
            }
        }

        while(sncSorted[newIndex] == snc[i]){
                newIndex++;
        }

        sncSorted[newIndex] = snc[i];
        soSorted[newIndex] = so[i];

        newIndex = 0;
    }

    FILE * indexFile = fopen("indeksdosyasi.txt", "w");

    for(int i = 0;i < count;i++){
        fprintf(indexFile, "%d;%d\n", sncSorted[i], soSorted[i]);
    }

    fclose(dataFile);
    fclose(indexFile);
}

#define SIZE_TEMP 50

void deleteData(){
    int ogrenciNo;
    int ogrNoCtr[201];
    int offsetCtr[201];
    int ogrNoDelete[20];
    int ogrDersDelete[20];

    printf("Kaydi silinecek olan ogrencinin numarasini giriniz: ");
    scanf("%d", &ogrenciNo);

    clearConsole();

    FILE * indexFile = fopen("indeksdosyasi.txt", "r");

    int ogrenciCounter = 0;
    int ogrNo, offsetTemp;
    while(fscanf(indexFile, "%d;%d\n", &ogrNo, &offsetTemp) == 2){
        offsetCtr[ogrenciCounter] = offsetTemp;
        ogrNoCtr[ogrenciCounter] = ogrNo;
        ogrenciCounter++;
    }

    int outcome;
    int offset[100];
    int counter = 0;
    while((outcome = binarySearch(ogrNoCtr, 0, ogrenciCounter - 1, ogrenciNo)) != -1){
        offset[counter] = offsetCtr[outcome];
        if(outcome == 0 && (ogrenciCounter - 1) == 0){
            ogrNoCtr[0] = -1;
            offsetCtr[0] = -1;
        }else {
            for(int i = outcome;i < ogrenciCounter - 1;i++)
            {
                ogrNoCtr[i] = ogrNoCtr[i + 1];
                offsetCtr[i] = offsetCtr[i + 1];
            }
        }
        ogrenciCounter--;
        counter++;
    }

    FILE * dataFile = fopen("veridosyasi", "rb");

    if(dataFile == NULL){
        printf("Veri dosyasi acilamadi.\n");
        fclose(indexFile);
        return;
    }

    for(int i = 0;i < counter;i++){
        struct kayit ogrK;
        fseek(dataFile, offset[i], SEEK_SET); // SEEK_SET is the position from where the offset is added
        if(fread(&ogrK, sizeof(struct kayit), 1, dataFile) == 1){
            printf("%d - Ogrenci Numarasi: %4d | Ders Numarasi: %4d | Ders Notu: %4d\n", i+1, ogrK.ogrenciNumarasi, ogrK.dersKodu, ogrK.puan);
            ogrNoDelete[i+1] = ogrK.ogrenciNumarasi;
            ogrDersDelete[i+1] = ogrK.dersKodu;
        }
    }

    fclose(dataFile);
    fclose(indexFile);

    if(counter == 0){
        printf("Veri bulunamadi.\n");
    }else {
        int deleteDataIndex;
        printf("\nSilinecek veri numarasini giriniz: ");
        scanf("%d", &deleteDataIndex);

        FILE * tempFile = fopen("temp", "wb");
        FILE * dataFile = fopen("veridosyasi", "rb");

        struct kayit ogrK;
        while(fread(&ogrK, sizeof(struct kayit), 1, dataFile) == 1){
            if(!(ogrK.ogrenciNumarasi == ogrNoDelete[deleteDataIndex] && ogrK.dersKodu == ogrDersDelete[deleteDataIndex])){
                fwrite(&ogrK, sizeof(struct kayit), 1, tempFile);
            }
        }

        fclose(tempFile);
        fclose(dataFile);

        // Replace veridosyasi with temporary file
        remove("veridosyasi");
        rename("temp", "veridosyasi");

        clearConsole();
        printf("Veri silindi.\n");

        indexFileUpdate();
    }
}

void findData(){
    int ogrenciNo;
    int ogrNoCtr[201];
    int offsetCtr[201];

    printf("Bulunacak ogrencinin numarasini giriniz: ");
    scanf("%d", &ogrenciNo);

    clearConsole();

    FILE * indexFile = fopen("indeksdosyasi.txt", "r");

    if(indexFile == NULL){
        printf("Indeks dosyasi acilamadi.");
    }else {
        int ogrenciCounter = 0;
        int ogrNo, offsetTemp;
        while(fscanf(indexFile, "%d;%d\n", &ogrNo, &offsetTemp) == 2){
            offsetCtr[ogrenciCounter] = offsetTemp;
            ogrNoCtr[ogrenciCounter] = ogrNo;
            ogrenciCounter++;
        }

        int outcome;
        int offset[100];
        int counter = 0;
        while((outcome = binarySearch(ogrNoCtr, 0, ogrenciCounter - 1, ogrenciNo)) != -1){
            offset[counter] = offsetCtr[outcome];
            if(outcome == 0 && (ogrenciCounter - 1) == 0){
                ogrNoCtr[0] = -1;
                offsetCtr[0] = -1;
            }else {
                for(int i = outcome;i < ogrenciCounter - 1;i++)
                {
                    ogrNoCtr[i] = ogrNoCtr[i + 1];
                    offsetCtr[i] = offsetCtr[i + 1];
                }
            }
            ogrenciCounter--;
            counter++;
        }

        if(counter == 0){
            printf("Veri bulunamadi.\n");
        }else {
            printf("%d numarali ogrenci ile ilgili veriler: \n\n", ogrenciNo);
            FILE * dataFile = fopen("veridosyasi", "rb");

            if(dataFile == NULL){
                printf("Veri dosyasi acilamadi.\n");
            }else {
                for(int i = 0;i < counter;i++){
                    struct kayit ogrK;
                    fseek(dataFile, offset[i], SEEK_SET); // SEEK_SET is the position from where the offset is added
                    if(fread(&ogrK, sizeof(struct kayit), 1, dataFile) == 1){
                        printf("Ogrenci Numarasi: %4d | Ders Numarasi: %4d | Ders Notu: %4d\n", ogrK.ogrenciNumarasi, ogrK.dersKodu, ogrK.puan);
                    }
                }
                fclose(dataFile);
            }
            fclose(indexFile);
        }

    }
}

void deleteIndexFile(){
    clearConsole();

    if(remove("indeksdosyasi.txt") == 0){
        printf("Indeks dosyasi silindi.\n");
    }else {
        printf("Indeks dosyasi silinemedi.\n");
    }
}

void insertNewData(){
    int ogrenciNumarasi, dersNumarasi, dersNot;

    printf("Ogrenci Numarasi: ");
    scanf("%d", &ogrenciNumarasi);

    printf("Ders Numarasi: ");
    scanf("%d", &dersNumarasi);

    printf("Ders Notu: ");
    scanf("%d", &dersNot);

    struct kayit ogrenciKayit;
    ogrenciKayit.ogrenciNumarasi = ogrenciNumarasi;
    ogrenciKayit.dersKodu = dersNumarasi;
    ogrenciKayit.puan = dersNot;

    FILE * dataFile = fopen("veridosyasi", "a");
    fwrite(&ogrenciKayit, sizeof(struct kayit), 1, dataFile);
    fclose(dataFile);

    printf("\nYeni veri eklendi.\n");

    indexFileUpdate();
}

void showDataFile(){
    printf("Veri dosyasi icerigi: \n\n");

    FILE * dataFile = fopen("veridosyasi", "rb");

    if(dataFile == NULL){
        printf("Veri dosyasi bulunamadi.\n");
    }else{
        struct kayit ogrK;
        while(fread(&ogrK, sizeof(struct kayit), 1, dataFile) == 1){
            printf("Ogrenci Numarasi: %4d | Ders Numarasi: %4d | Ders Notu: %4d\n", ogrK.ogrenciNumarasi, ogrK.dersKodu, ogrK.puan);
        }
        fclose(dataFile);
    }
}

void showIndexFile(){
    FILE * indexFile = fopen("indeksdosyasi.txt", "r");

    if(indexFile == NULL){
        printf("Indeks dosyasi acilamadi.\n");
    }else {
        printf("Indeks dosyasi icerigi: \n\n");

        int ogrNo, index;
        while(fscanf(indexFile, "%d;%d\n", &ogrNo, &index) == 2){
            printf("Ogrenci Numarasi = %4d | Offset = %4d\n", ogrNo, index);
        }

        fclose(indexFile);
    }
}

void createIndexFile(){
    indexFileUpdate();

    printf("Indeks dosyasi olusturuldu.\n");
}

void displayMainMenu(){
    printf("1 - Indeks Dosyasi Olustur\n2 - Kayit Ekle\n3 - Kayit Bul\n4 - Kayit Sil\n5 - Kayit Guncelle\n6 - Veri Dosyasini Goster\n7 - Indeks Dosyasini Goster\n8 - Indeks Dosyasini Sil\n");

    int selection;

    printf("Seciniz: ");
    scanf("%d", &selection);

    clearConsole();
    switch(selection){
        case 1:
            createIndexFile();
            break;
        case 2:
            insertNewData();
            break;
        case 3:
            findData();
            break;
        case 4:
            deleteData();
            break;
        case 5:
            updateData();
            break;
        case 6:
            showDataFile();
            break;
        case 7:
            showIndexFile();
            break;
        case 8:
            deleteIndexFile();
            break;
        default:
            displayMainMenu();
    }
    exitOption();
}

int main()
{
    displayMainMenu();

    return 0;
}
