import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Stack;


public class Main {
    public static void main(String[] args) {
        // Questao 1
        System.out.println("Questao 1");
        System.out.println(questao1());
        System.out.println("---------");
        // Resposta Questao 1 : 91

        // Questao 2
        System.out.println("Questao 2");
        System.out.println(questao2(13)); // exemplo
        System.out.println("---------");


        // Questao 3

        Faturamento [] faturamentoMensal = new Faturamento[30];
        Gson gson = new Gson();
        try(FileReader reader = new FileReader("/Users/davimaia/Downloads/dados.json")){
            Type listType  = new TypeToken<List<Faturamento>>(){}.getType();
            List<Faturamento> lista = gson.fromJson(reader, listType);
            for (int i = 0; i < faturamentoMensal.length; i++) {
                faturamentoMensal[i] = lista.get(i);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Questao 3 ");
        questao3(faturamentoMensal);
        System.out.println("---------");


        // Questao 4
        String [] estadoBrasil = {"CE","RJ","SP","BA","MG"}; // Dados Teste
        Double [] faturamentosEstados = {1005.50,994.33,203.25,150.31,450.55}; // Dados Teste
        System.out.println("Questao 4");
        questao4(estadoBrasil,faturamentosEstados);
        System.out.println("---------");

        // Questao 5
        System.out.println("Questao 5");
        System.out.println(questao5("Alo"));
        System.out.println("---------");


    }

    public static int questao1(){
        int indice = 13;
        int soma = 0;
        int k = 0;

        while (k < indice){
            k = k + 1;
            soma = soma + k;
        }

        return soma;
    }
    public static String questao2(int numero){
        int elementoA = 1;
        int elementoP = 1;
        int elementoF = 0;
        while (elementoF != numero){
            elementoF = elementoA + elementoP;
            elementoA = elementoP;
            elementoP = elementoF;
            if (elementoF > numero){
                return "O numero " + numero + " não está presente na sequencia de fibonnacci";
            }
        }
        return "O numero " + numero + " está presente na sequencia de fibonnacci";
    }

    public static void questao3(Faturamento [] faturamento){
        double valorMax = 0;
        double valorMin = faturamento[0].getValor();
        double faturamentoMedioDiario = 0;
        int qtdDiasTotal = 0;
        int qtdDiasFaturamentoSuperior = 0;

        for (int i = 0; i < faturamento.length; i++){
            if (valorMax < faturamento[i].getValor()){
                valorMax = faturamento[i].getValor();
            }
            if (valorMin > faturamento[i].getValor() && faturamento[i].getValor() != 0.0){
                valorMin = faturamento[i].getValor();
            }
            faturamentoMedioDiario = faturamentoMedioDiario + faturamento[i].getValor();
            qtdDiasTotal++;
        }
        faturamentoMedioDiario = faturamentoMedioDiario / qtdDiasTotal;

        for (int i = 0; i < faturamento.length; i++){
            if (faturamento[i].getValor() > faturamentoMedioDiario){
                qtdDiasFaturamentoSuperior++;
            }
        }

        System.out.println("O maior valor de faturamento foi " + valorMax);
        System.out.println("O menor valor de faturamento foi " + valorMin);
        System.out.println("Número de dias onde o faturamento diário foi superior ao faturamento mensal " + qtdDiasFaturamentoSuperior);
    }

    public static void questao4(String [] estadosFaturamento, Double [] valoresFaturamento){
        double faturamentoTotal = 0;
        double [] percentualFaturamento = new double[valoresFaturamento.length];

        for (int i = 0; i < valoresFaturamento.length; i++){
            faturamentoTotal += valoresFaturamento[i];
        }
        for (int j = 0; j < valoresFaturamento.length; j++){
            percentualFaturamento[j] = valoresFaturamento[j] / faturamentoTotal;
        }
        for (int k = 0; k < valoresFaturamento.length; k++){
            System.out.println("Faturamento percentual do estado " + estadosFaturamento[k] + " = " + percentualFaturamento[k]*100);
        }

    }


    public static Stack questao5(String frase){
        Stack pilhaOrdemCorreta  = new Stack();
        Stack pilhaOrdemInversa = new Stack();
        for (int i = 0; i < frase.length(); i++){
            pilhaOrdemCorreta.push(frase.charAt(i));
        }
        while (!pilhaOrdemCorreta.empty()){
            pilhaOrdemInversa.push(pilhaOrdemCorreta.pop());
        }
        return pilhaOrdemInversa;
    }


}




