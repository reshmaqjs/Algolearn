#include<stdio.h>
int binary(int arr[],int max,int min,int r)
{
if(max>=min)
{
int mid=(max+min)/2;
if(arr[mid]==r)
{return mid;}
else if(arr[mid]>r)
{return binary(arr,mid-1,min,r);}
else
{return binary(arr,max,mid+1,r);}
}
return -1;
}
int main()
{
int n,x,i,k;
printf("enter size of arrray \n");
scanf("%d",&k);
n=k-1;
int arr[k];
printf("enter numbers in ascending order \n");
for(i=0;i<k;i++)
{scanf("%d",&arr[i]);}
printf("enter a number to search \n");
scanf("%d",&x);
int result= binary(arr,n-1,0,x);
if(result==-1)
{printf("element not present");}
else
{printf("element is present at index %d",result+1);}
return 0;
}
