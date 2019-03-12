
package puissance.pkg4;

import java.util.Scanner;

public class Puissance4 {
    static int hauteur = 6;
    static int longueur = 7;
    static int LigneDuBas = hauteur -1;
    static char[][] plateau = new char[hauteur][longueur];
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
        for (int h = 0; h < hauteur; h += 1) {
            for (int l = 0; l < longueur; l += 1) {
                plateau[h][l] = '_';
            }
        }
    }
    
    public static void printPlateau(){              //Imprime le plateau
        for(int h = 0; h < hauteur; h++){
            for(int l = 0; l < longueur; l++){
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
            if(colonne > longueur - 1){
                System.out.println("Tu t'es trompé de valeur !");
                break;
            }
            
            if(plateau[LigneDuBas][colonne] == '_'){
                plateau[LigneDuBas][colonne] = 'X';
                break;
            }else if(plateau[LigneDuBas][colonne] == 'X' || plateau[LigneDuBas][colonne] == 'O'){
                if(plateau[LigneDuBas - compteur][colonne] == '_'){
                    plateau[LigneDuBas - compteur][colonne] = 'X';
                break;
                }
            }
            compteur++;
            if(hauteur - compteur == 0){
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
            if(colonne > longueur){
                System.out.println("Tu t'es trompé de valeur !");
                break;
            }
            
            if(plateau[LigneDuBas][colonne] == '_'){
                plateau[LigneDuBas][colonne] = 'O';
                break;
            }else if(plateau[LigneDuBas][colonne] == 'X' || plateau[LigneDuBas][colonne] == 'O'){
                if(plateau[LigneDuBas - compteur][colonne] == '_'){
                    plateau[LigneDuBas - compteur][colonne] = 'O';
                break;
                }
            }
            compteur++;
            if(hauteur - compteur == 0){
                System.out.println("La colonne est remplie");
                break;
            }
        }
    }
    
    public static boolean victoireXHorizontal(){
       
        boolean aGagné = false;
        int compteur = 0;
       
        while(!aGagné){
           for(int h = 0; h < hauteur; h++){
               for(int l = 0; l < longueur; l++){
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
           for(int h = 0; h < hauteur; h++){
               for(int l = 0; l < longueur; l++){
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
            for(int l = 0; l < longueur; l++){
                for(int h = 0; h < hauteur; h++){
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
            for(int l = 0; l < longueur; l++){
                for(int h = 0; h < hauteur; h++){
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
            for(int l = 0; l < longueur; l++){
                for(int h = 0; h < hauteur; h++){
                    if(plateau[h][l] == 'X'){
                        compteur++;
                        verif = true;
                        while(verif){
                            if(l + compteurColonne <= longueur - 1 && h + compteurLigne <= hauteur - 1){
                                if(plateau[h + compteurLigne][l + compteurColonne] == 'X'){
                                    compteur++;
                                }
                            }
                            compteurColonne++;
                            compteurLigne++;
                            
                            if(compteurColonne == longueur - 1 || compteurLigne == hauteur -1){
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
            for(int x = 0; x < longueur; x++){
                for(int y = 0; y < hauteur; y++){
                    if(plateau[y][x] == 'O'){
                        compteur++;
                        verif = true;
                        while(verif){
                            if(x + compteurColonne <= longueur - 1 && y + compteurLigne <= hauteur - 1){
                                if(plateau[y + compteurLigne][x + compteurColonne] == 'O'){
                                    compteur++;
                                }
                            }
                            compteurColonne++;
                            compteurLigne++;
                            
                            if(compteurColonne == longueur - 1 || compteurLigne == hauteur -1){
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
            for(int l = 0; l < longueur; l++){
                for(int h = 0; h < hauteur; h++){
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
                            
                            if(compteurColonne == longueur - 1 || compteurLigne == hauteur -1){
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
            for(int l = 0; l < longueur; l++){
                for(int h = 0; h < hauteur; h++){
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
                            
                            if(compteurColonne == longueur - 1 || compteurLigne == hauteur -1){
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