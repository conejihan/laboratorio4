  



public class BonusScore implements GameScore{
    private int inicial;
    public BonusScore(){
        inicial=0;
    }
    
    /**
    *Calcula el score dependiendo de la cantidad de letras correctas.
    *@param correctCount cantidad de corectas
    *@param incorrectoCount cantidad de incorrectas
    *@param log longitud de la palabra
    *@pre correctCoun = 1 || incorrectCount = 1
    *@pos retornar el score
    *Nota: Cambiar la condicion para perder
    */
    public int calculateScore(int correctCount ,int incoretCount,int log){
        while (inicial != 100){
            if(incoretCount == 1 ){
                inicial -=10;
            }else if (correctCount==1){
                inicial += 5;
            }
        }
        return inicial;    
                }        

}



