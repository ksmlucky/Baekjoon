import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2178 {

    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            for (int j = 0; j < M; j++) {
                maze[i][j] = a.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(maze[N-1][M-1]);

    }

    public static void bfs(int a, int b){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a,b});

        while(!q.isEmpty()){
            int now[] = q.poll();
            visited[a][b] = true;

            for(int i = 0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(x >= 0 && y >= 0 && x < N && y < M){
                    if(maze[x][y] != 0 && !visited[x][y]){
                        q.offer(new int[] {x,y});
                        visited[x][y] = true;
                        maze[x][y] = maze[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }
}
