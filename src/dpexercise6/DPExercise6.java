package dpexercise6;

import java.util.HashMap;

/**
 * v(n)=1+v(n-V(v(n-1)))
 * v(1)=1
 **/

public class DPExercise6 {

    public static void main(String[] args) {
        int cont = 40;
        System.out.println("Memoization: ");
        for (int i = 1; i <= cont; i++) {
            System.out.print(memo(i) + " ");
        }
        System.out.println("\nTabulation: ");
        for (int i = 1; i <= cont; i++) {
            System.out.print(tabulation(i) + " ");
        }
    }
    
    private static int tabulation(int n){
        int[] vector = new int[n+1];
        vector[0] = 0;
        vector[1] = 1;
        
        for(int i = 2; i <= n; i++){
            vector[i] = 1+vector[i-vector[vector[i-1]]];
        }                
        
        return vector[n];
    }

    private static int memo(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return v(n, map);
    }
    
    private static int v(int n, HashMap<Integer,Integer> map){
        if(map.containsKey(n)){
            return map.get(n);
        }
        
        if(n == 1) return 1;
        
        int result = 1 + v(n-v(v(n-1, map), map), map);
        
        map.put(n, result);
        
        return result;
    }
}
