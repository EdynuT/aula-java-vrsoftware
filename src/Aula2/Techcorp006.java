// Tarefa de casa do professor

public class Techcorp006{
    public static void main(String[] args){
        System.out.println("\nRelatótios Trimestrais");

        for (int departamento = 1; departamento <= 4; departamento++){
            
            System.out.println("=====================================");

            for (int trimestre = 1; trimestre <= 4; trimestre++){
                if (departamento == 1){
                    System.out.print("Departamento TI");
                } 
                else if (departamento == 2){
                    System.out.print("Departamento RH");
                } 
                else if (departamento == 3){
                    System.out.print("Departamento Financeiro");
                } 
                else {
                    System.out.print("Departamento Marketing");
                }

                System.out.println(" - Trimestre " + trimestre);
            }
        }
        System.out.println("=====================================\n");
    }
}
