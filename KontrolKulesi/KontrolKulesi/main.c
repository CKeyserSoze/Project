#include <stdio.h>
#include <stdlib.h>
#include <time.h> 
void setinput(){
    int ucakid[50];
    int ucakprty[50];
    int hourrequest[50];

    FILE *fpointer;

    fpointer=fopen("input.txt","r");

    int tempucakid;
    int tempucakprty;
    int temphourrequest;
    int counter=0;
    fseek(fpointer,43,SEEK_SET);
    while(fgetc(fpointer)!=EOF)
    {
        fscanf(fpointer,"%d %d %d",&tempucakprty,&tempucakid,&temphourrequest);
        ucakprty[counter]=tempucakprty;
        ucakid[counter]=tempucakid;
        hourrequest[counter]=temphourrequest;
        counter++;

    }
    fclose(fpointer);


    for(int i=0;i<counter;i++)
    {
        for(int j=1;j<counter;j++){
            if(hourrequest[j] < hourrequest[j-1]){
                int temphour=hourrequest[j];
                hourrequest[j]=hourrequest[j-1];
                hourrequest[j-1]=temphour;
                int tempid=ucakid[j];
                ucakid[j]=ucakid[j-1];
                ucakid[j-1]=tempid;
                int tempprty=ucakprty[j];
                ucakprty[j]=ucakprty[j-1];
                ucakprty[j-1]=tempprty;
            }
        }
    }
    addToQueues(ucakprty,ucakid,hourrequest,counter);
}

void sortbypriority(int *idinqueue,int *prtyinqueue,int *hourinqueue,int *delays,int size){

    int temp=0;
    for(int i=0;i<size;i++)
    {
        if(delays[i]==3)
        {
                int temphour=hourinqueue[i];
                hourinqueue[i]=hourinqueue[0];
                hourinqueue[0]=temphour;
                int tempprty=prtyinqueue[i];
                prtyinqueue[i]=prtyinqueue[0];
                prtyinqueue[0]=tempprty;
                int tempid=idinqueue[i];
                idinqueue[i]=idinqueue[0];
                idinqueue[0]=tempid;
                int tempdelay=delays[i];
                delays[i]=delays[0];
                delays[0]=tempdelay;
                temp++;
                printf("Acil inis gereken ucak belirlendi:%d \n",idinqueue[0]);
                break;
        }
    }

    for(int i=0;i<size;i++)
    {
        for(int j=1+temp;j<size;j++){
            if(prtyinqueue[j] < prtyinqueue[j-1]){
                int temphour=hourinqueue[j];
                hourinqueue[j]=hourinqueue[j-1];
                hourinqueue[j-1]=temphour;
                int tempid=idinqueue[j];
                idinqueue[j]=idinqueue[j-1];
                idinqueue[j-1]=tempid;
                int tempdelay=delays[j];
                delays[j]=delays[j-1];
                delays[j-1]=tempdelay;
                int tempprty=prtyinqueue[j];
                prtyinqueue[j]=prtyinqueue[j-1];
                prtyinqueue[j-1]=tempprty;
            }
        }
    }
}
void addToQueues(int *priority,int *ucakid,int *hours,int planenumbers){

    int delays[10]={0};
    int idinqueue[10];
    int prtyinqueue[10];
    int hourinqueue[10];
    int queuehead=0;
    int planesinqueue=0;

    FILE *fp=fopen("output.txt","w");
        fprintf(fp,"oncelik_id ucak_id talep_edilen_inis_saati inis_saati gecikme_suresi kalkis_saati\n");

    for(int i=1;i<=24;i++){
        printf("--SAAT %d:00--\n",i);
        for(int j=planesinqueue;j<planenumbers;j++){
            if(hours[j]==i)
            {
                idinqueue[planesinqueue]=ucakid[j];
                prtyinqueue[planesinqueue]=priority[j];
                hourinqueue[planesinqueue]=hours[j];
                planesinqueue++;
            }
        }

        int landingplaneid;
        sortbypriority(idinqueue,prtyinqueue,hourinqueue,delays,planesinqueue);
        if(planesinqueue!=0)
        {
        printf("Inis yapacak ucagin id si:%d\n",idinqueue[0]);
        landingplaneid=idinqueue[0];
        }
        if(planesinqueue==0) continue;

        if(i!=24)
            fprintf(fp,"%d\t%d\t%d\t%d\t%d\t%d\n",prtyinqueue[0],idinqueue[0],hourinqueue[0],i,delays[0],i+1);
        else
            fprintf(fp,"%d\t%d\t%d\t%d\t%d\t%d\n",prtyinqueue[0],idinqueue[0],hourinqueue[0],i,delays[0],1);


        planesinqueue=resetqueue(idinqueue,prtyinqueue,hourinqueue,delays,planesinqueue);
        printf("kuyruktaki bekleyen ucak sayisi:%d\n\n",planesinqueue);

        for(int i=0;i<planesinqueue;i++)
            printf("%d %d %d Gecikme suresi:%dSaat\n",prtyinqueue[i],idinqueue[i],hourinqueue[i],delays[i]);
        for(int i=0;i<planesinqueue;i++){
            if(delays[i]==4)
            {
                printf("%d ID'sine sahip ucak %d ID'sine sahip ucagin acil inisi sebebiyle inis izniniz iptal edildi.Sabiha Gokcen Havalimanina gidiniz!\n",idinqueue[i],landingplaneid);
                for(int j=i;j<planesinqueue;j++){
                    hourinqueue[j]=hourinqueue[j+1];
                    idinqueue[j]=idinqueue[j+1];
                    delays[j]=delays[j+1];
                    prtyinqueue[j]=prtyinqueue[j+1];
                }
                planesinqueue--;
                i--;
            }
        }
    printf("\n\n");
    }
    if(planesinqueue!=0)
    {   printf("Asagidaki ucaklar bir sonraki gune kalmistir:\n\n");
        for(int i=0;i<planesinqueue;i++)
        {
                printf("%d %d %d\n",prtyinqueue[i],idinqueue[i],hourinqueue[i]);
        }
    }
    _sleep(3);
    fclose(fp);
    displayoutput();
}
int resetqueue(int *idinqueue,int *prtyinqueue,int *hourinqueue,int *delays,int planenumbers){
    for(int i=0;i<planenumbers;i++)
    {
        prtyinqueue[i]=prtyinqueue[i+1];
        idinqueue[i]=idinqueue[i+1];
        hourinqueue[i]=hourinqueue[i+1];
        delays[i]=delays[i+1];
    }
    planenumbers--;
    if(planenumbers==0){
        for(int i=0;i<10;i++)
            delays[i]=0;
    }
    else
        {
        for(int i=0;i<planenumbers;i++)
            delays[i]++;
        }
    return planenumbers;
}
void displayoutput(){

    char displayline[120];
    FILE *displaypoint=fopen("output.txt","r");
    fgets(displayline,120,displaypoint);
    printf("%s\n",displayline);
    int priority;
    int ucakid;
    int hourrequest;
    int landhour;
    int delay;
    int flytime;

    while(fscanf(displaypoint,"%d %d %d %d %d %d",&priority,&ucakid,&hourrequest,&landhour,&delay,&flytime)==6){
        printf("%d\t%d\t%d\t%d\t%d\t%d\n",priority,ucakid,hourrequest,landhour,delay,flytime);
    }
}
int main()
{
    int selection;
    printf("Metin belgesindeki inputlari girmek icin 1 e basin.\n");
    scanf("%d",&selection);
    if(selection==1){
        setinput();
        _sleep(1);
    }
    else
        printf("Program calistirilmadi.");
        _sleep(1);
    return 0;
}
