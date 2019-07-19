package offer;

/**
 * 实现pow(base, exponent)函数
 */
public class Question_16 {

    double power(double base, int exponent){

        double result = 0;

        if (base == 0.0 && exponent < 0) return 0.0;

        int absExponent = exponent;
        if (exponent < 0) {
            absExponent = -exponent;
        }
        result = powerUnsigned(base, absExponent);

        if (exponent < 0){
            result = 1 / result;
        }

        return result;
    }

    private double powerUnsigned(double base, int absExponent){

        double result = 1;
        for (int i = 1; i <= absExponent; i++) {
            result *= base;
        }
        return  result;
    }

    // 使用公式 a的n次幂 = a的n/2次幂 * a的n/2次幂   (n为偶数)
    //          a的n次幂 = a的(n-1)/2次幂 * a的(n-1)/2次幂 * a (n为奇数)
    double pow(double base, int absExponent){

        if (absExponent == 0) return 1;
        if (absExponent == 1) return base;

        double result = pow(base, absExponent >> 1);
        result *= result;
        if ((absExponent & 0x1) == 1) result *= base;

        return result;
    }
}
