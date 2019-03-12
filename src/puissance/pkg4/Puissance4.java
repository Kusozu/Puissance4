
package puissance.pkg4;

import java.util.Scanner;

public class Puissance4 {
    final static int HAUTEUR = 6;
    final static int LONGUEUR = 7;
    final static int LIGNE_DU_BAS = HAUTEUR -1;
    static char[][] plateau = new char[HAUTEUR][LONGUEUR];
    static Scanner scanner = new Scanner(System.in);
        
    public static void main(String[] args){
        
        creationPlateau();       
        System.out.println("Choisit une colonne entre 0 et 6");                       
        printPlateau();
        
        boolean aGagné = false;

       
        while(!aGagné){
            
            tourX();
            printPlateau();
           
            if(verifX()){
                aGagné = true; 
                break; 
            }
           
            tourO();
            printPlateau();

            if(verifO()){
                aGagné = true;
                break;
            }
        }
                                                      
    }
    
    public static void creationPlateau(){           //Création du plateau de jeu
        for (int h = 0; h < HAUTEUR; h += 1) {
            for (int l = 0; l < LONGUEUR; l += 1) {
                plateau[h][l] = '_';
            }
        }
    }
    
    public static void printPlateau(){              //Imprime le plateau
        for(int h = 0; h < HAUTEUR; h++){
            for(int l = 0; l < LONGUEUR; l++){
                System.out.print(plateau[h][l] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void tourX(){                    
        
        System.out.println("Au tour du joueur X");
        int colonne = scanner.nextInt();
        int compteur = 1;
        
        while(true){
            if(colonne > LONGUEUR - 1){
                System.out.println("Tu t'es trompé de valeur !");
                break;
            }
            
            if(plateau[LIGNE_DU_BAS][colonne] == '_'){
                plateau[LIGNE_DU_BAS][colonne] = 'X';
                break;
            }else if(plateau[LIGNE_DU_BAS][colonne] == 'X' || plateau[LIGNE_DU_BAS][colonne] == 'O'){
                if(plateau[LIGNE_DU_BAS - compteur][colonne] == '_'){
                    plateau[LIGNE_DU_BAS - compteur][colonne] = 'X';
                break;
                }
            }
            compteur++;
            if(HAUTEUR - compteur == 0){
                System.out.println("La colonne est remplie");
                break;
            }           
        }
    }
    
    public static void tourO(){
        int compteur = 1;
        System.out.println("Au tour du joueur O");
        int colonne = scanner.nextInt();
        
        while(true){
            if(colonne > LONGUEUR){
                System.out.println("Tu t'es trompé de valeur !");
                break;
            }
            
            if(plateau[LIGNE_DU_BAS][colonne] == '_'){
                plateau[LIGNE_DU_BAS][colonne] = 'O';
                break;
            }else if(plateau[LIGNE_DU_BAS][colonne] == 'X' || plateau[LIGNE_DU_BAS][colonne] == 'O'){
                if(plateau[LIGNE_DU_BAS - compteur][colonne] == '_'){
                    plateau[LIGNE_DU_BAS - compteur][colonne] = 'O';
                break;
                }
            }
            compteur++;
            if(HAUTEUR - compteur == 0){
                System.out.println("La colonne est remplie");
                break;
            }
        }
    }
    
    public static boolean victoireXHorizontal(){
       
        boolean aGagné = false;
        int compteur = 0;
       
        while(!aGagné){
           for(int h = 0; h < HAUTEUR; h++){
               for(int l = 0; l < LONGUEUR; l++){
                   if(plateau[h][l] == 'X'){
                       compteur++;
                   }else{
                       compteur = 0;
                   }
                   if(compteur >= 4){
                       System.out.println("Joueur X gagne!");
                       aGagné = true;
                   }
               }
           }
           break;
       }
       return aGagné;
    }
    
    public static boolean victoireOHorizontal(){
        
        boolean aGagné = false;
        int compteur = 0;
       
        while(!aGagné){
           for(int h = 0; h < HAUTEUR; h++){
               for(int l = 0; l < LONGUEUR; l++){
                   if(plateau[h][l] == 'O'){
                       compteur++;
                   }else{
                       compteur = 0;
                   }
                   if(compteur >= 4){
                       System.out.println("Joueur O gagne!");
                       aGagné = true;
                   }
               }
           }
           break;
       }
       return aGagné;
    }
    
    public static boolean victoireXVertical(){
        
        boolean aGagné = false;
        int compteur = 0;
        
        while(!aGagné){
            for(int l = 0; l < LONGUEUR; l++){
                for(int h = 0; h < HAUTEUR; h++){
                    if(plateau[h][l] == 'X'){
                        compteur++;
                    }else{
                        compteur = 0;
                    }
                    if(compteur >= 4){
                        System.out.println("Le joueur X gagne !");
                        aGagné = true;
                    }
                }
            }
            break;
        }
        return aGagné;
    }
    
    public static boolean victoireOVertical(){
                
        boolean aGagné = false;
        int compteur = 0;
        
        while(!aGagné){
            for(int l = 0; l < LONGUEUR; l++){
                for(int h = 0; h < HAUTEUR; h++){
                    if(plateau[h][l] == 'O'){
                        compteur++;
                    }else{
                        compteur = 0;
                    }
                    if(compteur >= 4){
                        System.out.println("Le joueur O gagne !");
                        aGagné = true;
                    }
                }
            }
            break;
        }
        return aGagné;
    }
    
    public static boolean victoireXDiagonaleNOSE(){
    
        boolean aGagné = false;
        int compteur = 0;
        int compteurColonne = 1;
        int compteurLigne = 1;
        boolean verif = false;
        
        while(!aGagné){
            for(int l = 0; l < LONGUEUR; l++){
                for(int h = 0; h < HAUTEUR; h++){
                    if(plateau[h][l] == 'X'){
                        compteur++;
                        verif = true;
                        while(verif){
                            if(l + compteurColonne <= LONGUEUR - 1 && h + compteurLigne <= HAUTEUR - 1){
                                if(plateau[h + compteurLigne][l + compteurColonne] == 'X'){
                                    compteur++;
                                }
                            }
                            compteurColonne++;
                            compteurLigne++;
                            
                            if(compteurColonne == LONGUEUR - 1 || compteurLigne == HAUTEUR -1){
                                verif = false;
                                break;
                            }
                            if(compteur >= 4){
                                System.out.println("Joueur X gagne !");
                                verif = false;
                                aGagné = true;
                                break;
                            }                            
                        }
                    }  
                    if(compteur >= 4){
                        aGagné = true;
                        break;
                    }
                    compteur = 0;
                    compteurColonne = 1;
                    compteurLigne = 1;
                }
            }
            break;
        }
        return aGagné;
    }
    
    public static boolean victoireODiagonaleNOSE(){
        
        boolean aGagné = false;
        int compteur = 0;
        int compteurColonne = 1;
        int compteurLigne = 1;
        boolean verif = false;
        
        while(!aGagné){
            for(int x = 0; x < LONGUEUR; x++){
                for(int y = 0; y < HAUTEUR; y++){
                    if(plateau[y][x] == 'O'){
                        compteur++;
                        verif = true;
                        while(verif){
                            if(x + compteurColonne <= LONGUEUR - 1 && y + compteurLigne <= HAUTEUR - 1){
                                if(plateau[y + compteurLigne][x + compteurColonne] == 'O'){
                                    compteur++;
                                }
                            }
                            compteurColonne++;
                            compteurLigne++;
                            
                            if(compteurColonne == LONGUEUR - 1 || compteurLigne == HAUTEUR -1){
                                verif = false;
                                break;
                            }
                            if(compteur >= 4){
                                System.out.println("Joueur O gagne !");
                                verif = false;
                                aGagné = true;
                                break;
                            }                            
                        }
                    }  
                    if(compteur >= 4){
                        aGagné = true;
                        break;
                    }
                    compteur = 0;
                    compteurColonne = 1;
                    compteurLigne = 1;
                }
            }
            break;
        }
        return aGagné;
    }
    
    public static boolean victoireXDiagonaleNESO(){
        
        boolean aGagné = false;
        int compteur = 0;
        int compteurColonne = 1;
        int compteurLigne = 1;
        boolean verif = false;
        
        while(!aGagné){
            for(int l = 0; l < LONGUEUR; l++){
                for(int h = 0; h < HAUTEUR; h++){
                    if(plateau[h][l] == 'X'){
                        compteur++;
                        verif = true;
                        while(verif){
                            if(h - compteurColonne >=0 && l - compteurLigne >= 0){
                                if(plateau[h - compteurLigne][l - compteurColonne] == 'X'){
                                    compteur++;
                                }
                            }
                            compteurColonne++;
                            compteurLigne++;
                            
                            if(compteurColonne == LONGUEUR - 1 || compteurLigne == HAUTEUR -1){
                                verif = false;
                                break;
                            }
                            if(compteur >= 4){
                                System.out.println("Joueur X gagne !");
                                verif = false;
                                aGagné = true;
                                break;
                            }                            
                        }
                    }  
                    if(compteur >= 4){
                        aGagné = true;
                        break;
                    }
                    compteur = 0;
                    compteurColonne = 1;
                    compteurLigne = 1;
                }
            }
            break;
        }
        return aGagné;
    }
    
    public static boolean victoireODiagonaleNESO(){
        
        boolean aGagné = false;
        int compteur = 0;
        int compteurColonne = 1;
        int compteurLigne = 1;
        boolean verif = false;
        
        while(!aGagné){
            for(int l = 0; l < LONGUEUR; l++){
                for(int h = 0; h < HAUTEUR; h++){
                    if(plateau[h][l] == 'O'){
                        compteur++;
                        verif = true;
                        while(verif){
                            if(h - compteurColonne >=0 && l - compteurLigne >= 0){
                                if(plateau[h - compteurLigne][l - compteurColonne] == 'O'){
                                    compteur++;
                                }
                            }
                            compteurColonne++;
                            compteurLigne++;
                            
                            if(compteurColonne == LONGUEUR - 1 || compteurLigne == HAUTEUR -1){
                                verif = false;
                                break;
                            }
                            if(compteur >= 4){
                                System.out.println("Joueur O gagne !");
                                verif = false;
                                aGagné = true;
                                break;
                            }                            
                        }
                    }  
                    if(compteur >= 4){
                        aGagné = true;
                        break;
                    }
                    compteur = 0;
                    compteurColonne = 1;
                    compteurLigne = 1;
                }
            }
            break;
        }
        return aGagné;
    }
    
    public static boolean verifX(){
        
        return victoireXDiagonaleNESO() || victoireXDiagonaleNOSE() || victoireXHorizontal() || victoireXVertical();
    }

    public static boolean verifO(){
        
        return victoireODiagonaleNESO() || victoireODiagonaleNOSE() || victoireOHorizontal() || victoireOVertical();
    }                 
}


    
    
//A faire: check pour les diagonales /