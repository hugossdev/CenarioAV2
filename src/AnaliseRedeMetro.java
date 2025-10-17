// https://chatgpt.com/share/68f2a309-8954-8001-8b71-feeb103fcea6
public class AnaliseRedeMetro {

    private static final String[] ESTACOES = {"Avenida", "Centro", "Praça", "Parque", "Shopping", "Terminal"};

    // ---------- FASE 1: CONSTRUÇÃO DA MATRIZ DE ADJACÊNCIA ----------
    public static int[][] construirMatrizMetro() {
        return new int[][]{
                {1, 1, 0, 0, 0, 0}, // Avenida
                {1, 1, 1, 0, 1, 0}, // Centro
                {0, 1, 1, 0, 0, 0}, // Praça
                {0, 1, 0, 1, 0, 0}, // Parque
                {0, 0, 0, 0, 1, 1}, // Shopping
                {0, 0, 0, 1, 0, 1}  // Terminal
        };
    }

    // ---------- FUNÇÕES DE APOIO ----------
    public static void imprimirMatriz(String titulo, int[][] M) {
        System.out.println("\n--- " + titulo + " ---");
        System.out.print("        ");
        for (String e : ESTACOES) System.out.printf("%-8s", e.substring(0, Math.min(6, e.length())));
        System.out.println();
        for (int i = 0; i < M.length; i++) {
            System.out.printf("%-8s", ESTACOES[i].substring(0, Math.min(ESTACOES[i].length(), 6)));
            for (int j : M[i]) System.out.printf("%-8d", j);
            System.out.println();
        }
    }

    // ---------- FASE 2: CLASSIFICAÇÃO DAS RELAÇÕES ----------
    public static boolean isReflexiva(int[][] M) {
        for (int i = 0; i < M.length; i++) if (M[i][i] == 0) return false;
        return true;
    }

    public static boolean isSimetrica(int[][] M) {
        for (int i = 0; i < M.length; i++)
            for (int j = i + 1; j < M.length; j++)
                if (M[i][j] != M[j][i]) return false;
        return true;
    }

    public static boolean isAssimetrica(int[][] M) {
        for (int i = 0; i < M.length; i++)
            if (M[i][i] == 1) return false; // Assimétrica exige diagonal = 0
        for (int i = 0; i < M.length; i++)
            for (int j = 0; j < M.length; j++)
                if (M[i][j] == 1 && M[j][i] == 1) return false;
        return true;
    }

    public static boolean isAntissimetrica(int[][] M) {
        for (int i = 0; i < M.length; i++)
            for (int j = 0; j < M.length; j++)
                if (i != j && M[i][j] == 1 && M[j][i] == 1) return false;
        return true;
    }

    public static boolean isTransitiva(int[][] M) {
        int N = M.length;
        for (int i = 0; i < N; i++)
            for (int k = 0; k < N; k++) {
                boolean caminho2 = false;
                for (int j = 0; j < N; j++)
                    if (M[i][j] == 1 && M[j][k] == 1) { caminho2 = true; break; }
                if (caminho2 && M[i][k] == 0) return false;
            }
        return true;
    }

    // ---------- FASE 2: FECHOS ----------
    public static int[][] fechoReflexivo(int[][] M) {
        int[][] R = copiarMatriz(M);
        for (int i = 0; i < R.length; i++) R[i][i] = 1;
        return R;
    }

    public static int[][] fechoSimetrico(int[][] M) {
        int N = M.length;
        int[][] R = copiarMatriz(M);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (M[i][j] == 1 || M[j][i] == 1) R[i][j] = R[j][i] = 1;
        return R;
    }

    public static int[][] fechoTransitivo(int[][] M) {
        int N = M.length;
        int[][] R = copiarMatriz(M);
        for (int k = 0; k < N; k++)
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    if (R[i][k] == 1 && R[k][j] == 1) R[i][j] = 1;
        return R;
    }

    // ---------- FASE 3: COMPOSIÇÃO DAS RELAÇÕES ----------
    public static int[][] composicaoBooleana(int[][] A, int[][] B) {
        int N = A.length;
        int[][] C = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++)
                    if (A[i][k] == 1 && B[k][j] == 1) { C[i][j] = 1; break; }
        return C;
    }

    // ---------- FUNÇÃO AUXILIAR ----------
    public static int[][] copiarMatriz(int[][] M) {
        int[][] copia = new int[M.length][M.length];
        for (int i = 0; i < M.length; i++)
            System.arraycopy(M[i], 0, copia[i], 0, M.length);
        return copia;
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {
        int[][] M_Metro = construirMatrizMetro();
        imprimirMatriz("Matriz do Metrô", M_Metro);

        boolean reflexiva = isReflexiva(M_Metro);
        boolean simetrica = isSimetrica(M_Metro);
        boolean assimetrica = isAssimetrica(M_Metro);
        boolean antissimetrica = isAntissimetrica(M_Metro);
        boolean transitiva = isTransitiva(M_Metro);

        System.out.println("\n--- CLASSIFICAÇÃO DA RELAÇÃO ---");
        System.out.println("Reflexiva: " + (reflexiva ? "Sim" : "Não"));
        System.out.println("Simétrica: " + (simetrica ? "Sim" : "Não"));
        System.out.println("Assimétrica: " + (assimetrica ? "Sim" : "Não"));
        System.out.println("Antissimétrica: " + (antissimetrica ? "Sim" : "Não"));
        System.out.println("Transitiva: " + (transitiva ? "Sim" : "Não"));

        // Exibir fechos se alguma propriedade for falsa
        if (!reflexiva) imprimirMatriz("Fecho Reflexivo", fechoReflexivo(M_Metro));
        if (!simetrica) imprimirMatriz("Fecho Simétrico", fechoSimetrico(M_Metro));
        if (!transitiva) imprimirMatriz("Fecho Transitivo", fechoTransitivo(M_Metro));

        // ---------- FASE 3: COMPOSIÇÃO COM MATRIZ DE ÔNIBUS ----------
        int[][] M_Onibus = {
                {0, 1, 0, 0, 0, 1},
                {1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1},
                {0, 1, 0, 1, 0, 0}
        };

        imprimirMatriz("Matriz de Ônibus", M_Onibus);

        int[][] M_Composicao = composicaoBooleana(M_Metro, M_Onibus);
        imprimirMatriz("Composição Metrô ∘ Ônibus", M_Composicao);

        System.out.println("\n--- ANÁLISE DE MOBILIDADE ---");
        System.out.println("A composição Metrô ∘ Ônibus mostra quais estações podem ser alcançadas ");
        System.out.println("a partir de uma estação de metrô seguida de uma conexão direta de ônibus.");
        System.out.println("Ou seja, representa a integração completa entre os dois sistemas.");
    }
}
