
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        String start = arriveAlice.compareTo(arriveBob) > 0
                       ? arriveAlice : arriveBob;

        String end = leaveAlice.compareTo(leaveBob) < 0
                     ? leaveAlice : leaveBob;

        if (start.compareTo(end) > 0) {
            return 0;
        }

        String[] parts1 = start.split("-");
        String[] parts2 = end.split("-");

        int startDay = Integer.parseInt(parts1[0]) * 100
                       + Integer.parseInt(parts1[1]);

        int endDay = Integer.parseInt(parts2[0]) * 100
                     + Integer.parseInt(parts2[1]);

        int count = 0;

        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        int startMonth = Integer.parseInt(parts1[0]);
        int startDate = Integer.parseInt(parts1[1]);

        int endMonth = Integer.parseInt(parts2[0]);
        int endDate = Integer.parseInt(parts2[1]);

        for (int month = startMonth; month <= endMonth; month++) {
            int first = (month == startMonth) ? startDate : 1;
            int last = (month == endMonth) ? endDate : daysInMonth[month - 1];

            count += last - first + 1;
        }

        return count;
    }
}
