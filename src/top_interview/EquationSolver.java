package top_interview;

public class EquationSolver {

    /**
     * @列主元高斯消去法
     */
    static float a[][];
    static float b[];
    static float x[];
    static int n;
    static int n2; //记录换行的次数  
    public static void Elimination(){  //消元  
//        PrintA();
        for(int k=0;k<n;k++)
        {
            Wrap(k);
            for(int i=k+1;i<n;i++)
            {
                float l=a[i][k]/a[k][k];
                a[i][k]=0.0f;
                for(int j=k+1;j<n;j++)
                    a[i][j]=a[i][j]-l*a[k][j];
                b[i]=b[i]-l*b[k];
            }
//            System.out.println("第"+k+"次消元后：");
//            PrintA();
        }

    }
    public static void Back()//回代  
    {
        x[n-1]=b[n-1]/a[n-1][n-1];
        for(int i=n-2;i>=0;i--)
            x[i]=(b[i]-jisuan(i))/a[i][i];
    }
    public static float jisuan(int i){
        float he=0.0f;
        for(int j=i;j<=n-1;j++)
            he=he+x[j]*a[i][j];
        return he;
    }
    public static void Wrap(int k){//换行  
        float max=Math.abs(a[k][k]);
        int n1=k;                   //记住要交换的行  
        for(int i=k+1;i<n;i++)     //找到要交换的行  
        {
            if(Math.abs(a[i][k])>max){
                n1=i;
                max=Math.abs(a[i][k]);
            }
        }
        if(n1!=k)
        {
            n2++;
            System.out.println("当k="+k+"时,要交换的行是："+k+"和"+n1);
            for(int j=k;j<n;j++)  //交换a的行
            {
                float x1;
                x1=a[k][j];
                a[k][j]=a[n1][j];
                a[n1][j]=x1;
            }
            float b1;   //交换b的行
            b1=b[k];
            b[k]=b[n1];
            b[n1]=b1;
            System.out.println("交换后：");
            PrintA();
        }
    }
    public static void Determinant(){//求行列式  
        float DM=1.0f;
        for(int i=0;i<n;i++)
        {
            float a2=a[i][i];
            DM=DM*a2;
        }
        float n3=(float)n2;
        DM= (float) (DM*Math.pow(-1.0, n3));
        System.out.println("该方程组的系数行列式：det A = "+DM);
    }
    public static void PrintA(){//输出增广矩阵  
        System.out.println("增广矩阵为：");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                System.out.print(a[i][j]+"    ");
            System.out.print(b[i]+"    ");
            System.out.print("\n");
        }
    }
    public static void Print(){//输出方程的根  
        System.out.println("方程组的根为：");
        for(int i=0;i<n;i++)
            System.out.println("x"+i+" = "+x[i]);
    }
    public static float[] getV(float[][] M) {
        n = M.length;
        x=new float[n];

        a = M;
        for (int i = 0; i < a.length; i++) {
            a[i][i] -= 1;
        }
        for (int i = 0; i < a[0].length; i++) {
            a[0][i] = 1;
        }
        b = new float[]{1, 0, 0};
        Elimination();
        Back();
        return x;
    }
    public static void main(String[] args) {
        //Scanner as=new Scanner(System.in);  
//        System.out.println("输入方程组的元数：");
        //n=as.nextInt();  
        n=3;
        a=new float[n][n];
        b=new float[n];
        x=new float[n];

        float inputA[][] = {{1,1,1},{0.5f,-1,1},{0.5f,0,-1}};
        a = inputA;

        float inputB[] = {1,0,0};
        b = inputB;

        float inputX[] = {1,1};

//        System.out.println("输入方程组的系数矩阵a：");
////        for(int i=1;i<=n;i++)
////          for(int j=1;j<=n;j++)
////              a[i][j]=as.nextDouble();
//        System.out.println("输入方程组矩阵b：");
////        for(int i=1;i<=n;i++)
////          b[i]=as.nextDouble();
//        Elimination();
//        Back();
        getV(inputA);
        Print();
        Determinant();
    }
}