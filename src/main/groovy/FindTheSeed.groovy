/**
 * Created by Memn on 23.04.2017.
 */
class FindTheSeed {
    static void main(String[] args) {
        def scanner = new Scanner(System.in)
        def n = scanner.nextInt()
        def k = scanner.nextInt()
        def funcs = new HashMap()
        def coefficients = new HashMap()
        for (int i = 0; i < n; i++)
            funcs.put(k-i , scanner.nextInt())
        for (int i = 0; i < n; i++)
            coefficients.put(i,scanner.nextInt())
        fillSeeds2Func(funcs,coefficients,n,k)

    }

    static void fillSeeds2Func(HashMap funcs, HashMap coefficients, int n, int k) {
//        f(k) = c(i)*f(k-i)
        for (int i = k-n ; i >= 0 ; i--) {
            funcs.put(i,)
        }
    }
}
