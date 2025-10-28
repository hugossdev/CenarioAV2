public class Main {
    public static void main(String[] args) {
        int[][] M_Metro = AnaliseRedeMetro.construirMatrizMetro();
        AnaliseRedeMetro.imprimirMatriz("Matriz do Metrô", M_Metro);

        boolean reflexiva = AnaliseRedeMetro.isReflexiva(M_Metro);
        boolean simetrica = AnaliseRedeMetro.isSimetrica(M_Metro);
        boolean assimetrica = AnaliseRedeMetro.isAssimetrica(M_Metro);
        boolean antissimetrica = AnaliseRedeMetro.isAntissimetrica(M_Metro);
        boolean transitiva = AnaliseRedeMetro.isTransitiva(M_Metro);

        System.out.println("\n--- CLASSIFICAÇÃO DA RELAÇÃO ---");
        System.out.println("Reflexiva: " + (reflexiva ? "Sim" : "Não"));
        System.out.println("Simétrica: " + (simetrica ? "Sim" : "Não"));
        System.out.println("Assimétrica: " + (assimetrica ? "Sim" : "Não"));
        System.out.println("Antissimétrica: " + (antissimetrica ? "Sim" : "Não"));
        System.out.println("Transitiva: " + (transitiva ? "Sim" : "Não"));

        if (!reflexiva) AnaliseRedeMetro.imprimirMatriz("Fecho Reflexivo", AnaliseRedeMetro.fechoReflexivo(M_Metro));
        if (!simetrica) AnaliseRedeMetro.imprimirMatriz("Fecho Simétrico", AnaliseRedeMetro.fechoSimetrico(M_Metro));
        if (!transitiva) AnaliseRedeMetro.imprimirMatriz("Fecho Transitivo", AnaliseRedeMetro.fechoTransitivo(M_Metro));

        int[][] M_Onibus = {
                {0, 1, 0, 0, 0, 1},
                {1, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 1},
                {1, 0, 0, 1, 1, 0}
        };

        AnaliseRedeMetro.imprimirMatriz("Matriz de Ônibus", M_Onibus);

        int[][] M_Composicao = AnaliseRedeMetro.composicaoBooleana(M_Metro, M_Onibus);
        AnaliseRedeMetro.imprimirMatriz("Composição Metrô ∘ Ônibus", M_Composicao);
    }
}


