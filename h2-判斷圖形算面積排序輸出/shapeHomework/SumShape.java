public class SumShape { //計算全部圖形面積總和
    public static double sum(Shape2D[] list) {
        double sum = 0;
        for (int i = 0; i < list.length; i++) 
            sum += list[i].area();
        return sum; //回傳全部圖形面積總和
    }
}