#include<stdio.h>
int main()
{int i,j,small,p,t;
printf("enter number of elements\n");
scanf("%d",&t);
printf("enter%d elements\n",t);
int array[t];
for(i=0;i<t;i++)
{scanf("%d",&array[i]);}
printf("array before sorting\n");
for(i=0;i<t;i++)
{printf("%d\t",array[i]);}
for(j=0;j<t;j++)
{small=array[j];
for(i=j;i<t;i++)
{if(array[i]<small)
{small=array[i];}}
for(i=0;i<t;i++)
{if(array[i]==small)
{array[i]=array[j];
array[j]=small;}}
array[j]=small;}
printf("\narray after sorting\n");
for(i=0;i<t;i++)
{printf("%d\t",array[i]);}}
