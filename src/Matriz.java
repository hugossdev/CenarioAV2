//// https://gemini.google.com/share/85d41f96dbce
//// https://chatgpt.com/share/68f28dfc-08f0-8001-b2a9-0d21938d557d
//// https://chatgpt.com/share/68f2960f-75cc-800c-8af9-d5a43375db88
//
//public class Matriz {
//    static int[][] matriz = {
//            // Av, Ce, Pr, Pa, Sh, Te
//            {1, 1, 0, 0, 0, 0}, // Avenida
//            {1, 1, 1, 0, 1, 0}, // Centro
//            {0, 1, 1, 0, 0, 0}, // Praça
//            {0, 1, 0, 1, 0, 0}, // Parque
//            {0, 0, 0, 0, 1, 1}, // Shopping
//            {0, 0, 0, 1, 0, 1}  // Terminal
//    };
//
//    static String[] estacoes = {"Avenida", "Centro", "Praça", "Parque", "Shopping", "Terminal"};
//
//    public static void main(String[] args) {
//        exibirMatriz();
//        verificarPropriedades();
//    }
//
//    public static void exibirMatriz() {
//        System.out.println("=== Matriz de Adjacência - Projeto 4 ===");
//        System.out.print("        ");
//        for (String estacao : estacoes) System.out.printf("%-12s", estacao);
//        System.out.println();
//
//        for (int i = 0; i < matriz.length; i++) {
//            System.out.printf("%-10s", estacoes[i]);
//            for (int j = 0; j < matriz[i].length; j++) {
//                System.out.printf("%-12d", matriz[i][j]);
//            }
//            System.out.println();
//        }
//    }
//
//    public static void verificarPropriedades() {
//        System.out.println("\n=== Classificações ===");
//        System.out.println("Reflexiva: " + (ehReflexiva() ? "Sim" : "Não"));
//        System.out.println("Simétrica: " + (ehSimetrica() ? "Sim" : "Não"));
//        System.out.println("Antissimétrica: " + (ehAntissimetrica() ? "Sim" : "Não"));
//        System.out.println("Assimétrica: " + (ehAssimetrica() ? "Sim" : "Não"));
//        System.out.println("Transitiva: " + (ehTransitiva() ? "Sim" : "Não"));
//    }
//
//    public static boolean ehReflexiva() {
//        for (int i = 0; i < matriz.length; i++) {
//            if (matriz[i][i] != 1) return false;
//        }
//        return true;
//    }
//
//    public static boolean ehSimetrica() {
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz.length; j++) {
//                if (matriz[i][j] != matriz[j][i]) return false;
//            }
//        }
//        return true;
//    }
//
//    public static boolean ehAntissimetrica() {
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz.length; j++) {
//                if (i != j && matriz[i][j] == 1 && matriz[j][i] == 1) return false;
//            }
//        }
//        return true;
//    }
//
//    public static boolean ehAssimetrica() {
//        if (!ehAntissimetrica()) return false;
//        for (int i = 0; i < matriz.length; i++) {
//            if (matriz[i][i] == 1) return false;
//        }
//        return true;
//    }
//
//    public static boolean ehTransitiva() {
//        int n = matriz.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matriz[i][j] == 1) {
//                    for (int k = 0; k < n; k++) {
//                        if (matriz[j][k] == 1 && matriz[i][k] != 1) return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
//}
