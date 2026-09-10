/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // int low = 1;
        // int high = n;

        // while (low < high) {

        //     int mid = low + (high - low) / 2;

        //     if (isBadVersion(mid)) {
        //         high = mid;      // first bad is at mid or before
        //     } else {
        //         low = mid + 1;   // first bad is after mid
        //     }
        // }

        // return low;

int ans=0;
int s=1;
int e=n;
while(s<=e){
    int mid=s+(e-s)/2;
    if(isBadVersion(mid)){
        ans=mid;
        e=mid-1;
    }
    else{
        s=mid+1;
    }
}
return ans;
 }
}

