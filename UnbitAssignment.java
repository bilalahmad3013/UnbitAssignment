public class basicProblems {
  
	 public static void helper(int ind, int[] arr, int target, List <List<Integer>> ans, List <Integer> check) {
	        if (target == 0) {
	            ans.add(new ArrayList < > (check));
	            return;
	        }
	        for (int i = ind; i < arr.length; i++) {
	            if (i > ind && arr[i] == arr[i - 1]) continue;
	            if (arr[i] > target) break;
	            check.add(arr[i]);
	            helper(i + 1, arr, target-arr[i],ans,check);
	            check.remove(check.size()-1);
	        }
	    }
	    public static List<List< Integer >> findMultiple(int[] arr, int k) {
	        List < List < Integer >> ans = new ArrayList < > ();
	        Arrays.sort(arr);
	        helper(0, arr, k, ans, new ArrayList < > ());
	        return ans;
	    }   
  
	public static ArrayList<ArrayList<Integer>> getPair(int arr[],int k){
		Arrays.sort(arr);
		//This is basic two pointer approach to get pairs
		//I dont consider duplicacy pairs
		
		int i=0;
		int j=arr.length-1;		
				
		ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
			
		while(i<j) {
			if(arr[i]+arr[j]==k) {
				ArrayList<Integer> pair=new ArrayList<>();
				pair.add(arr[i]);
				pair.add(arr[j]);
				ans.add(pair);
				i++;
				j--;
			}
			else if(arr[i]+arr[j] > k) {
				j--;
			}
			else {
				i++;
			}
		}
		
		return ans;
	}
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter the length of the array");
                    int n=sc.nextInt();
        
        // Creating the array.
        
                int arr[]=new int[n];
                for(int i=0;i<arr.length;i++) {
        	int b=i+1;
        	
        	//Taking Input
        	
        	System.out.println("Enter the "+ b +"th element");
        	int a=sc.nextInt();
        	arr[i]=a;
        }
	  
        System.out.println("Enter Target");
        int k=sc.nextInt();
	
	// function calling to get pair 
	
	ArrayList<ArrayList<Integer>> smallans=getPair(arr,k);
	
	//calculating size
	
	int size=smallans.size()*2;
	int newArr[]=new int[size];
	int l=0;

	// creating new Array to finds subarray sum up to 2k 
	
	
		
	for(int i=0;i<smallans.size();i++) {
		newArr[l]=smallans.get(i).get(0);
		l++;
		newArr[l]=(smallans.get(i).get(1));
		l++;
		
	}
	
	Arrays.sort(newArr);
	

	//Now the challenge is to find subarrays sum up to 2k , so I will solve this question using recurssion.
	
     //last function call
	 List<List<Integer>> ans =findMultiple(newArr,2*k);
		for(int r=0;r<ans.size();r++) {
		List<Integer> x=ans.get(r);
		for(int s=0;s<x.size();s++) {
			System.out.print(x.get(s)+" ");
		}
		System.out.println();
	}
	
	}
}

