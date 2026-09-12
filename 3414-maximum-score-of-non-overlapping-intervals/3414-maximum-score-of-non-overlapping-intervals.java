import java.util.*;

class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

       
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[3], b[3]);
        });

        
        long[][] dp = new long[n + 1][5];

        
        List<Integer>[][] paths = new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                paths[i][k] = new ArrayList<>();
            }
        }

        
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = i - 1;
            int ans = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                
                if (arr[mid][1] < arr[i][0]) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            prev[i] = ans;
        }

        for (int i = 1; i <= n; i++) {

            int idx = i - 1;

            
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = dp[i - 1][k];
                paths[i][k] = new ArrayList<>(paths[i - 1][k]);
            }

        
            for (int k = 1; k <= 4; k++) {

                int p = prev[idx] + 1;

                long newScore =
                    dp[p][k - 1] + arr[idx][2];

                List<Integer> newPath =
                    new ArrayList<>(paths[p][k - 1]);

                newPath.add(arr[idx][3]);

                Collections.sort(newPath);

                if (newScore > dp[i][k] ||
                    (newScore == dp[i][k] &&
                     isLexicographicallySmaller(newPath,
                                                paths[i][k]))) {

                    dp[i][k] = newScore;
                    paths[i][k] = newPath;
                }
            }
        }

       
        List<Integer> answer = new ArrayList<>();

        for (int k = 0; k <= 4; k++) {
            if (dp[n][k] > dp[n][answer.size()] ||
                (dp[n][k] == dp[n][answer.size()] &&
                 isLexicographicallySmaller(paths[n][k],
                                            answer))) {

                answer = paths[n][k];
            }
        }

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private boolean isLexicographicallySmaller(
            List<Integer> a,
            List<Integer> b) {

        int len = Math.min(a.size(), b.size());

        for (int i = 0; i < len; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}