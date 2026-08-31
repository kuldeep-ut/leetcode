/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = null;
        List<Integer> minimaStore = new ArrayList<>();
        List<Integer> maximaStore = new ArrayList<>();
        int cnt = 0;
        while (head.next != null) {
            cnt++;
            if (prev != null && prev.val < head.val && head.val > head.next.val) {
                maximaStore.add(cnt);
            } else if (prev != null && prev.val > head.val && head.val < head.next.val) {
                maximaStore.add(cnt);
            }
            prev = head;
            head = head.next;
        }
        System.out.println(maximaStore);
        int ans[] = {-1, -1};
        if(maximaStore.isEmpty() || maximaStore.size() == 1) {
            return ans;
        }
        Collections.sort(maximaStore);
        int n = maximaStore.size();
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i<n; i++){
            minDiff = Math.min(Math.abs(maximaStore.get(i) - maximaStore.get(i-1)), minDiff);
        }
        ans[0] = minDiff;
        ans[1] = maximaStore.get(n-1) - maximaStore.get(0);
        return ans;
    }
}