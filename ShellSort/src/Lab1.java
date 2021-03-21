import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class Lab1 {
    static int n,m;
    public static void main (String[] arg){
        Scanner in = new Scanner(System.in);
        //вводим парметры массива
        System.out.print("Input strings: ");
        n = in.nextInt();
        System.out.print("Input columns: ");
        m = in.nextInt();
        //создаем массив
        int [][]mas=new int[n][m];
        //заполняем его рандомными числами
        Random r = new Random();
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                mas[i][j]=r.nextInt(100) + 1;
            }
        }
        //сортруем массссив по строкам при помощи сортировки шелла
        System.out.println("Shel's sort:");
        long before = System.nanoTime();//засекаем время начала
        for (int i = 0; i<n;i++){
            int[] arr = new int [m];
            for (int j=0;j<m;j++){
                arr[j]=mas[i][j];//записываем в новый массив текущую строку исзодного
            }
            ShellSort(m, arr);//сортируем
            //System.out.println(Arrays.toString(arr));
        }
        long after = System.nanoTime();//засекаем время завершения работы
        System.out.println("Время исполнения = " + (after - before) + " наноскунд");
        //сортировка по-умолчанию
        System.out.println("Defolt sort:");
        before = System.nanoTime();;
        for (int i = 0; i<n;i++){
            int[] arr = new int [m];//создаем новый массив для строки
            for (int j=0;j<m;j++){
                arr[j]=mas[i][j];//заполняем его
            }
            Arrays.sort(arr);//сортировка по умолчанию
            //System.out.println(Arrays.toString(arr));
        }
        after = System.nanoTime();
        System.out.println("Время исполнения = " + (after - before) + " наносекунд");
    }

    public static void ShellSort(int n, int mass[])
    {
        //получает на вход длину строки и текущую строку массива
        int i, j, step;
        int tmp;
        for (step = n / 2; step > 0; step /= 2)//берем шаг в пол массива, затем уменьшаем его в два раза
            for (i = step; i < n; i++)//берем элемнт массива
            {
                tmp = mass[i];
                for (j = i; j >= step; j -= step)//берем другой элемнет на расстоянии шага
                {
                    if (tmp < mass[j - step])
                        mass[j] = mass[j - step];
                    else
                        break;//если не нужно их менять местами, то переходим к новой "паре"
                }
                mass[j] = tmp;
            }
    }
}
