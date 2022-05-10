//Program to check if subset in array exists whose sum is Equal to target

//Recursive + Memoise Solution 
public class SubsetSumEqualstoTarget{
    public static void main(String[] args){

        int arr[] = {1,2,3,4};
        int n  = 4;
        int target = 8;

        Boolean dp[][] = new Boolean[n][target+1];

      

        if(subsetSumUtil(arr,n-1,target,dp))
            System.out.println("Subset with sum equals target present in arr");
        else
            System.out.println("No Subset with sum equals target present in arr");

    }

    private static boolean subsetSumUtil(int arr[],int n,int target,Boolean dp[][]){

        if(target==0)
            return true;

        if(n==0)
            return arr[n]==target;

        //check for all subsequences
        if(dp[n][target]!= null)
            return dp[n][target];

        boolean exclude = subsetSumUtil(arr,n-1,target,dp);
        boolean include = false;

        if(arr[n]<=target)
            include = subsetSumUtil(arr,n-1,target-arr[n],dp);

        return dp[n][target] = include || exclude;

        


    }
}