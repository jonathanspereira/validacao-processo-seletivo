package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
        for( String candidato: candidatos){
           
            entrandoEmContato(candidato);
        }
        
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuatentando = true;
        boolean atendeu = false;
        
        do{
            atendeu= atender();
            continuatentando = !atendeu;
            if (continuatentando) {
                tentativasRealizadas++;
            }else System.out.println("Contato realizado com sucesso!");

        }while( continuatentando && tentativasRealizadas < 3);
        
        if(atendeu)
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + "º tentativa.");
        else
            System.out.println("Não conseguimos contato com " + candidato + ", numero maximo de tentativas (" + tentativasRealizadas + ") realizadas.");
    }

    //método auxiliar
	static boolean atender() {
		return new Random().nextInt(3)==1;	
	}


    static void imprimindoSelecionados(){
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
        
        for(String candidato: candidatos){
            System.out.println("O candidato selecionado foi " + candidato);
        }
        
    }   

    static void selecaoCandidatos(){
        // Array com a lista de candidatos
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","MONICA","FABRICIO","MIRELA","DANIELA","JORGE"};

        int candidadosSelecionados = 0;
        int candidadosAtual = 0;
        double salarioBase = 2000.0;

        while (candidadosSelecionados < 5 && candidadosAtual < candidatos.length) {
            String candidado = candidatos[candidadosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidado + " solicitou este valor de salairo " + salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " +candidado+" foi selecionado para a vaga");
            }
            candidadosAtual++;
        }

    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static void analisarCandidato(double salarioPretendido) {

        double salarioBase = 2000.0;

        if(salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato.");
        }else if (salarioBase == salarioPretendido){
            System.out.println("Ligar para o candidato com contra proposta");            
        }else{
            System.out.println("Aguardando o resultado dos demais candidados");
        }
    }
}
