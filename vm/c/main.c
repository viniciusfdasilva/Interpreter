#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define true 1
#define false 0

static void clearScreen(){
    printf("\033[H\033[2J");
} 

static void readFile(){
    //char* line = (char*)malloc(1000*sizeof(char));

    clearScreen();

 //   while(true){
 //       printf("> \n");
//
 //       scanf("",line);
 //   }
 //   
}

static void readPrompt(){
    //char* line = (char*)malloc(1000*sizeof(char));

    clearScreen();

 //   while(true){
 //       printf("> \n");
//
 //       scanf("",line);
 //   }
 //   
}

int main(int argc, char** argv){
    if(argc > 1){
        readFile();
    }else{
        readPrompt();
    }
}