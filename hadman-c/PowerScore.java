import java.lang.Math;
public class PowerScore implements GameScore{
    private int inicial;
    public PowerScore(){
        inicial=0;
    }
    /**
    *Calcula el score dependiendo de la cantidad de letras correctas exponencialmente.
    *@param correctCount cantidad de corectas
    *@param incorrectoCount cantidad de incorrectas
    *@param log longitud de la palabra
    *@pre correctCoun > 1 || incorrectCount = 1
    *@pos retornar el score
    */
    public int calculateScore(int correctCount ,int incoretCount,int log){
        boolean termino = true;
        int cont=0;
        while (termino!=false){
            if(cont==log){
               termino=false;
            }
            else if(incoretCount == 1){
                 inicial -=8;
            }
            else if (correctCount==1){
                cont++;
                double n = Math.pow(5,cont);
                inicial += n;
                termino=false;
                if(inicial>500){
                inicial=500;}
                
            }
             return inicial;
        }
        return inicial;
    }   
}     