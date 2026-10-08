class Solution {

    int countOfTeams(int k, int[] arr) {

        long totalPlayers = 0;

        for (int x : arr) {
            totalPlayers += x;
        }

        // Maximum possible teams
        long low = 0;
        long high = totalPlayers / k;

        long answer = 0;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (canMakeTeams(mid, k, arr)) {

                answer = mid;
                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }

        return (int) answer;
    }

    private boolean canMakeTeams(long teams, int k, int[] arr) {

        long available = 0;
        long required = teams * k;

        for (int x : arr) {

            available += Math.min((long) x, teams);

            if (available >= required) {
                return true;
            }
        }

        return false;
    }
}