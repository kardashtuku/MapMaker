public class Main
{
    public static int WIDTH = 50;
    public static int HEIGHT = 50;
    public static int PARAMETERS = 7;
    public static void main(String[] args)
    {
        float[][][] map = new float[HEIGHT][WIDTH][PARAMETERS];
        for (int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++){
                for  (int k = 0; k < 4; k++){
                    map[i][j][k] = (float) Math.round(Math.random() * 300) / 100;
                    //map[i][j][k] = (float) Math.random();
                }
                map[i][j][4] = Math.round(Math.abs(((map[i][j][1] + map[i][j][2] +  map[i][j][3]) / 3.0F) -1.5F) * 100) / 100.0F;
                map[i][j][5] = 0.0F;
            }
        }
        // index:0 = Seed
        // index:1 = Elevation
        // index:2 = Temperature
        // index:3 = Humidity
        // index:4 = Habitability
        // index:5 = Polity
        seediate(map,4);
        printMap(map, 3);
    }
    public static float[][][] seediate(float[][][] map, int howmuch)
    {
        for  (int i = 0; i < HEIGHT; i++){
            for  (int j = 0; j < WIDTH; j++){
                int y = 1;
                int x = 1;
                int ny = 1;
                int nx = 1;
                if(i == 0)
                {
                    ny = 0;
                }
                if (i == HEIGHT - 1)
                {
                    y = 0;
                }
                if (j == 0)
                {
                    nx = 0;
                }
                if (j == WIDTH - 1)
                {
                    x = 0;
                }
                for   (int k = 0; k < 4; k++){
                    for (int l = 0; l < howmuch; l++){
                        map[i][j][6] = Math.round(((map[i][j][k] + map[i][j + x][k] * x + map[i + y][j][k] * y + map[i - ny][j][k] * ny + map[i][j - nx][k] * nx) / (1+x+y+nx+ny)) * 100) / 100.0F;
                    }
                    map[i][j][k] = map[i][j][6];
                }
            }
        }
        return map;
    }
    public static void printMap(float[][][] map, int index)
    {
        String printedOne = "";
        for  (int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++){
                if(map[i][j][index] < 0.5F){
                    System.out.print("\u001B[48;5;230m"+"   "+"\u001B[0m");
                } else if (map[i][j][index] < 0.5F){
                    System.out.print("\u001B[48;5;106m"+"   "+"\u001B[0m");
                }  else if (map[i][j][index] < 1.0F){
                    System.out.print("\u001B[48;5;64m"+"   "+"\u001B[0m");
                }  else if (map[i][j][index] < 1.5F){
                    System.out.print("\u001B[48;5;46m"+"   "+"\u001B[0m");
                }  else if (map[i][j][index] < 2.0F){
                    System.out.print("\u001B[48;5;34m"+"   "+"\u001B[0m");
                }  else if (map[i][j][index] < 2.5F){
                    System.out.print("\u001B[48;5;28m"+"   "+"\u001B[0m");
                } else {
                    System.out.print("\u001B[48;5;22m"+"   "+"\u001B[0m");
                }
            }
            System.out.println();
        }
    }
}
