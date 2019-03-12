
package puissance.pkg4;

import java.util.Scanner;

public class Puissance4 {
    static int hauteur = 6;
    static int longueur = 7;
    static int LigneDuBas = hauteur -1;
    static String[][] plateau = new String[hauteur][longueur];
    static Scanner scanner = new Scanner(System.in);
        
    public static void main(String[] args){
        
        CreationPlateau();       
        System.out.println("Choisit une colonne entre 0 et 6");                       
        PrintPlateau();
        
        boolean indicateur = true;

       
        while(indicateur){
            
            TourX();
            PrintPlateau();
           
            if(!VerifX()){
                indicateur = false; 
                break; 
            }
           
            TourO();
            PrintPlateau();

            if(!VerifO()){
                indicateur = false;
                break;
            }
        }
                                                      
    }
    
    public static void CreationPlateau(){           //Création du plateau de jeu
        for (int h = 0; h < hauteur; h += 1) {
            for (int l = 0; l < longueur; l += 1) {
                plateau[h][l] = "_ ";
            }
        }
    }
    
    public static void PrintPlateau(){              //Imprime le plateau
        for(int h = 0; h < hauteur; h++){
            for(int l = 0; l < longueur; l++){
                System.out.print(plateau[h][l]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void TourX(){                    
        
        System.out.println("Au tour du joueur X");
        int colonne = scanner.nextInt();
        int compteur = 1;
        
        while(true){
            if(colonne > longueur - 1){
                System.out.println("Tu t'es trompé de valeur !");
                break;
            }
            
            if(plateau[LigneDuBas][colonne] == "_ "){
                plateau[LigneDuBas][colonne] = "X ";
                break;
            }else if(plateau[LigneDuBas][colonne] == "X " || plateau[LigneDuBas][colonne] == "O "){
                if(plateau[LigneDuBas - compteur][colonne] == "_ "){
                    plateau[LigneDuBas - compteur][colonne] = "X ";
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
    
    public static void TourO(){
        int compteur = 1;
        System.out.println("Au tour du joueur O");
        int colonne = scanner.nextInt();
        
        while(true){
            if(colonne > longueur){
                System.out.println("Tu t'es trompé de valeur !");
                break;
            }
            
            if(plateau[LigneDuBas][colonne] == "_ "){
                plateau[LigneDuBas][colonne] = "O ";
                break;
            }else if(plateau[LigneDuBas][colonne] == "X " || plateau[LigneDuBas][colonne] == "O "){
                if(plateau[LigneDuBas - compteur][colonne] == "_ "){
                    plateau[LigneDuBas - compteur][colonne] = "O ";
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
    
    public static boolean VictoireXHorizontal(){
       
        boolean indicateur = true;
        int compteur = 0;
       
        while(indicateur){
           for(int h = 0; h < hauteur; h++){
               for(int l = 0; l < longueur; l++){
                   if(plateau[h][l] == "X "){
                       compteur++;
                   }else{
                       compteur = 0;
                   }
                   if(compteur >= 4){
                       System.out.println("Joueur X gagne!");
                       indicateur = false;
                   }
               }
           }
           break;
       }
       return indicateur;
    }
    
    public static boolean VictoireOHorizontal(){
        
        boolean indicateur = true;
        int compteur = 0;
       
        while(indicateur){
           for(int h = 0; h < hauteur; h++){
               for(int l = 0; l < longueur; l++){
                   if(plateau[h][l] == "O "){
                       compteur++;
                   }else{
                       compteur = 0;
                   }
                   if(compteur >= 4){
                       System.out.println("Joueur O gagne!");
                       indicateur = false;
                   }
               }
           }
           break;
       }
       return indicateur;
    }
    
    public static boolean VictoireXVertical(){
        
        boolean indicateur = true;
        int compteur = 0;
        
        while(indicateur){
            for(int l = 0; l < longueur; l++){
                for(int h = 0; h < hauteur; h++){
                    if(plateau[h][l] == "X "){
                        compteur++;
                    }else{
                        compteur = 0;
                    }
                    if(compteur >= 4){
                        System.out.println("Le joueur X gagne !");
                        indicateur = false;
                    }
                }
            }
            break;
        }
        return indicateur;
    }
    
    public static boolean VictoireOVertical(){
                
        boolean indicateur = true;
        int compteur = 0;
        
        while(indicateur){
            for(int l = 0; l < longueur; l++){
                for(int h = 0; h < hauteur; h++){
                    if(plateau[h][l] == "O "){
                        compteur++;
                    }else{
                        compteur = 0;
                    }
                    if(compteur >= 4){
                        System.out.println("Le joueur O gagne !");
                        indicateur = false;
                    }
                }
            }
            break;
        }
        return indicateur;
    }
    
    public static boolean VictoireXDiagonaleNOSE(){
    
        boolean indicateur = true;
        int compteur = 0;
        int compteurColonne = 1;
        int compteurLigne = 1;
        boolean verif = false;
        
        while(indicateur){
            for(int l = 0; l < longueur; l++){
                for(int h = 0; h < hauteur; h++){
                    if(plateau[h][l] == "X "){
                        compteur++;
                        verif = true;
                        while(verif){
                            if(l + compteurColonne <= longueur - 1 && h + compteurLigne <= hauteur - 1){
                                if(plateau[h + compteurLigne][l + compteurColonne] == "X "){
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
                                indicateur = false;
                                break;
                            }                            
                        }
                    }  
                    if(compteur >= 4){
                        indicateur = false;
                        break;
                    }
                    compteur = 0;
                    compteurColonne = 1;
                    compteurLigne = 1;
                }
            }
            break;
        }
        return indicateur;
    }
    
    public static boolean VictoireODiagonaleNOSE(){
        
        boolean indicateur = true;
        int compteur = 0;
        int compteurColonne = 1;
        int compteurLigne = 1;
        boolean verif = false;
        
        while(indicateur){
            for(int l = 0; l < longueur; l++){
                for(int h = 0; h < hauteur; h++){
                    if(plateau[h][l] == "O "){
                        compteur++;
                        verif = true;
                        while(verif){
                            if(l + compteurColonne <= longueur - 1 && h + compteurLigne <= hauteur - 1){
                                if(plateau[h + compteurLigne][l + compteurColonne] == "O "){
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
                                indicateur = false;
                                break;
                            }                            
                        }
                    }  
                    if(compteur >= 4){
                        indicateur = false;
                        break;
                    }
                    compteur = 0;
                    compteurColonne = 1;
                    compteurLigne = 1;
                }
            }
            break;
        }
        return indicateur;
    }
    
    public static boolean VictoireXDiagonaleNESO(){
        
        boolean indicateur = true;
        int compteur = 0;
        int compteurColonne = 1;
        int compteurLigne = 1;
        boolean verif = false;
        
        while(indicateur){
            for(int l = 0; l < longueur; l++){
                for(int h = 0; h < hauteur; h++){
                    if(plateau[h][l] == "X "){
                        compteur++;
                        verif = true;
                        while(verif){
                            if(h - compteurColonne >=0 && l - compteurLigne >= 0){
                                if(plateau[h + compteurLigne][l - compteurColonne] == "X "){
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
                                indicateur = false;
                                break;
                            }                            
                        }
                    }  
                    if(compteur >= 4){
                        indicateur = false;
                        break;
                    }
                    compteur = 0;
                    compteurColonne = 1;
                    compteurLigne = 1;
                }
            }
            break;
        }
        return indicateur;
    }
    
    public static boolean VictoireODiagonaleNESO(){
        
        boolean indicateur = true;
        int compteur = 0;
        int compteurColonne = 1;
        int compteurLigne = 1;
        boolean verif = false;
        
        while(indicateur){
            for(int l = 0; l < longueur; l++){
                for(int h = 0; h < hauteur; h++){
                    if(plateau[h][l] == "O "){
                        compteur++;
                        verif = true;
                        while(verif){
                            if(h - compteurColonne >=0 && l - compteurLigne >= 0){
                                if(plateau[h + compteurLigne][l - compteurColonne] == "O "){
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
                                indicateur = false;
                                break;
                            }                            
                        }
                    }  
                    if(compteur >= 4){
                        indicateur = false;
                        break;
                    }
                    compteur = 0;
                    compteurColonne = 1;
                    compteurLigne = 1;
                }
            }
            break;
        }
        return indicateur;
    }
    
    public static boolean VerifX(){
        
        boolean indicateur = true;
        
        if(!VictoireXHorizontal()|| !VictoireXVertical()|| !VictoireXDiagonaleNOSE()|| !VictoireXDiagonaleNESO()){
            indicateur = false;
        }
        return indicateur;
    }

    public static boolean VerifO(){
        
        boolean indicateur = true;
       
        if(!VictoireOHorizontal() || !VictoireOVertical() || !VictoireODiagonaleNOSE()|| !VictoireODiagonaleNESO()){
            indicateur = false;
        }
        return indicateur;
    }
}


    
    
//A faire: check pour les diagonales /