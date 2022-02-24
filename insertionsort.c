
#include <stdio.h>
int main()
{int array[5],i,j,p,small;
printf ("enter 5 values \n");
for (i=0;i<5;i++)
{
  scanf("%d",&array[i]) ;
}
printf ("before sorting \n");
for (i=0;i<5;i++)
{
  printf("%d \t",array[i]) ;
}
for(i=0;i<4;i++)
{
  if(array[i+1]<array[i])
  {
    small=array[i+1];
    array[i+1]=array[i];
    array[i]=small;
    for(j=i;j>0;j--)
    {
      if(array[j]<array[j-1])
      { p=array[j];
        array[j]=array[j-1];
        array[j-1]=p;
      }
    }
   } 
}
printf ("\n after sorting ascending order\n") ;
for(i=0;i<5;i++)
{
  printf ("%d \t",array[i]);
}
}



