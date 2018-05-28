//Аргументы к заданию 2
double epsilon = 0.05; // > 0

//Аргументы к заданию 3
double a = 1.6;  
double b = 3.0; // b > a
double h = 0.1; // h > 0

//Аргументы к заданию 4
double[] A = {1.3, 1.2,  6.4, 18.6,
             -9.4,  6.3,  10,  4.2};

//Аргументы к заданию 5
int M = 6; //размер желаемой квадратной матрицы ( 0 < M < 21)



//================================================================================================
    void Task2(double eps)
    {
        System.out.println("Задание 2.");
        if (eps <= 0){ 
	 	System.out.println("epsilon должно быть > 0!");
		return;
	}
	int n = (int) (Math.sqrt(1.0 / eps)); //  - 1 + 1;
        if (n == 0) n = 1;
        System.out.println("Наименьшее n равно: " + n);
        for (int i = 1; i <= n; i++) System.out.println("a_" + i + " = " + 1 / (double) ((i + 1) * (i + 1)));
        System.out.println();
    }
//------------------------------------------------------------------------------------------------
    void Task3(double a, double b, double h)
    {
        System.out.println("Задание 3.");
        if (a >= b) {
            System.out.println("a должно быть меньше b!");
            return;
        }
        if (h <= 0) {
            System.out.println("h должно быть > 0!");
            return;
        }

        for (double x = a; x <= b; x += h)
            System.out.println(x + "\t\t" + (Math.tan(2 * x) - 3));
            System.out.println();
    }

//------------------------------------------------------------------------------------------------
    void Task4(double[] a)
    {
        System.out.println("Задание 4.");
        int L = a.length;
        if ((L % 2)!=0) {
            System.out.println("длина a должна быть четной!");
            return;
        }

        double max = a[0]+a[L-1];
        for (int i = 1; i < L/2; i++) {
            if (a[i]+a[L-1-i] > max) max = a[i]+a[L-1-i];
        }
        System.out.println("Ответ: " + max);
        System.out.println();
    }
//------------------------------------------------------------------------------------------------
    import java.util.Arrays;
    void Task5(int M)
    {
        System.out.println("Задание 5.");
        if (M <0) {
            System.out.println("Размер матрицы не может быть отрицательным!");
            return ;
        }
        if (M >20 ) {
            System.out.println("Слишком большой размер матрицы! (М<21)");
            return;
        }
        if (M==0) return;


        int[][] mat = new int[M][M];
        for (int i = 0; i < M; i++) {
            mat[i][i] = 1;
            mat[M-i-1][i] = 1;
        }
        for(int i=0; i<M; i++)  System.out.println(Arrays.toString( mat[i] ));
    }
//------------------------------------------------------------------------------------------------

Task2(epsilon);
Task3(a, b, h);
Task4(A);
Task5(M);


