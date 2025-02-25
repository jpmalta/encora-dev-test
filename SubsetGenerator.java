import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class SubsetGenerator {

    /**
     * A função abaixo faz o seguinte:
     * - Recebe o conjunto A como argumento.
     * - Gera todos os subconjuntos de A.
     * - Para isso, usa uma técnica de bitmasking onde cada número em binário representa um subconjunto.
     * - Adiciona todos os subconjuntos gerados em uma lista e retorna a lista no final.
     */
    public static List<Set<Integer>> getSubSets(Set<Integer> A) {
        List<Set<Integer>> result = new ArrayList<>();
        Integer[] elements = A.toArray(new Integer[0]); // Converte o conjunto em um array para acesso fácil
        
        // O número total de subconjuntos é 2^n, onde n é o número de elementos em A
        int totalSubsets = (1 << elements.length); // Equivalente a 2^n
        
        // Loop para gerar cada subconjunto possível
        for (int mask = 0; mask < totalSubsets; mask++) {
            Set<Integer> subset = new HashSet<>();
            
            // A cada iteração, a máscara decide quais elementos estarão no subconjunto
            for (int i = 0; i < elements.length; i++) {
                // Verifica se o bit i está ativado na máscara
                if ((mask & (1 << i)) != 0) {
                    subset.add(elements[i]); // Adiciona o elemento no subconjunto
                }
            }
            result.add(subset); // Adiciona o subconjunto gerado na lista
        }

        return result;
    }

    public static void main(String[] args) {
        // Conjunto de entrada
        Set<Integer> inputSet = new HashSet<>();
        inputSet.add(1);
        inputSet.add(2);
        inputSet.add(3);

        // Chama a função para obter os subconjuntos
        List<Set<Integer>> subsets = getSubSets(inputSet);

        // Imprime todos os subconjuntos gerados
        for (Set<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
