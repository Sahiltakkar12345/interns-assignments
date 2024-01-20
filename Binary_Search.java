import java.util.*;
public class Binary_Search {

	public static void main(String[] args) {
	Scanner s=new Scanner(System.in);	
	System.out.println("enter the size of an array");
	int size=s.nextInt();
	int arr[]=new int[size];
	System.out.println("enter the array element");
	for(int i=0;i<size;i++)
	{
	    arr[i]=s.nextInt();
	}
		System.out.println("enter value u wnat to search");
		int value=s.nextInt();
		int index=sort(arr,value);
		if(index!=-1)
		{
			System.out.println("Element "+value+" is found at index "+index);
		}
		else
		{
			System.out.println("value Not found");
		}
	}
	static int sort(int[] arr,int value)
	{
		int res=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>=arr[j])
				{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		res=Search(arr,arr.length-1,value);
		return res;
	}
	static int Search(int[] arr,int size,int value)
	{
		int first=0;
		int last=size;
		int mid=0;
		while(first<=last)
		{
			mid=(first+last)/2;
			if(arr[mid]==value)
				return mid;
			else if(arr[mid]<value)
				first=mid+1;
			else
				last=mid-1;
		}
		return -1;
	}
}