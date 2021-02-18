 
 



public class OriginalScore implements GameScore{
    private int inicial;
    public OriginalScore(){
        inicial=100;
    }

    /**
    *Calcula el score dependiendo de la cantidad de letras incorrectas.
    *@param correctCount cantidad de corectas
    *@param incorrectoCount cantidad de incorrectas
    *@param log longitud de la palabra
    *@pre incorrectCount = 1
    *@pos retornar el score
    */
    public int calculateScore(int correctCount ,int incoretCount,int log){
        while (inicial != 0){
            if(incoretCount == 1 ){
                inicial -=10;
            }    
        }
        return inicial;

    }
    public int  getScore(){
        return inicial;
    }
}        
        
